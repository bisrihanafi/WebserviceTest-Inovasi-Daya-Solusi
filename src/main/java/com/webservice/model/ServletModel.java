/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webservice.model;

import javax.servlet.http.HttpServlet;

/**
 * Bisri Hanafi bisrihanafi@designjaya.com
 *
 * Aug 22, 2025 5:15:14 PM
 *
 * @author HP
 */
public class ServletModel {

    private final HttpServlet httpServlet;
    private final String stringPath;
    private final String stringKeterangan;

    public ServletModel(HttpServlet httpServlet, String stringPath) {
        this(httpServlet, stringPath, "");
    }

    public ServletModel(HttpServlet httpServlet, String stringPath, String stringKeterangan) {
        this.httpServlet = httpServlet;
        this.stringPath = stringPath;
        this.stringKeterangan = stringKeterangan;
    }

    public HttpServlet getHttpServlet() {
        return httpServlet;
    }

    public String getStringPath() {
        return stringPath;
    }

    public String getStringKeterangan() {
        return stringKeterangan;
    }
    
}
