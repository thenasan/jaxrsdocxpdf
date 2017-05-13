/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nasan.jaxrspdf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 *
 * @author Nasan
 */
public class DocxToPdf implements IConverter {

    @Override
    public void convertToPdf(InputStream inputStream, OutputStream outputStream) {
        try {
            XWPFDocument document = new XWPFDocument(inputStream);
            PdfOptions options = PdfOptions.create();
            PdfConverter.getInstance().convert(document, outputStream, options);
             
        } catch (IOException ex) {
            Logger.getLogger(DocxToPdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
