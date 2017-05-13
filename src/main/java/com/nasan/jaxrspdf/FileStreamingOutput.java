/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nasan.jaxrspdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;

/**
 *
 * @author Nasan
 */
public class FileStreamingOutput implements StreamingOutput {

    private InputStream input;

    public FileStreamingOutput(File file) {
        try {
            this.input = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileStreamingOutput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void write(OutputStream output)
            throws IOException, WebApplicationException {
        try {
            int bytes;
            while ((bytes = input.read()) != -1) {
                output.write(bytes);
            }
        } catch (Exception e) {
            throw new WebApplicationException(e);
        } finally {
            if (output != null) output.close();
            if (input != null) input.close();
        }
    }

}