/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nasan.jaxrspdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 * REST Web Service
 *
 * @author Nasan
 */
@Path("files")
public class FileResource {
    
    @POST
    @Path("/topdf")
    @Produces({"application/pdf"})
    @Consumes(MediaType.MULTIPART_FORM_DATA)    
    public Response toPdfResponse(
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail) {
        FileOutputStream output = null;
        try {
            String fileLocation = "e://" + fileDetail.getFileName().replaceAll("docx","pdf");
            output = new FileOutputStream(new File(fileLocation));
            IConverter converter = new DocxToPdf();
            converter.convertToPdf(uploadedInputStream, output);
            File pdf = new File(fileLocation);
            return Response.status(200).entity(new FileStreamingOutput(pdf)).build();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileResource.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return Response.status(Response.Status.EXPECTATION_FAILED).entity("").build();
    }
}
