/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webservice.model;

import javax.servlet.http.HttpServlet;

/**
 * Bisri Hanafi bisrihanafi@designjaya.com
 *
 * Create : Mar 10, 2025 2:59:36 PM
 *
 * @author bisri
 */
@SuppressWarnings("serial")
public abstract class ItemServices extends HttpServlet {

    protected int FLAG;

    public ItemServices(int FLAG) {
        this.FLAG = FLAG;
    }

}
