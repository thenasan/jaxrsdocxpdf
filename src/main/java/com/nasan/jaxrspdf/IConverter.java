/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nasan.jaxrspdf;

import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Nasan
 */
public interface IConverter {
    public void convertToPdf(InputStream inputStream,OutputStream outputStream);
}
