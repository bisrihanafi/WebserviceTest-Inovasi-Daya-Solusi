/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webservice.services;

import com.webservice.model.ListModelAPI;

/**
 * Bisri Hanafi bisrihanafi@designjaya.com
 *
 * Aug 22, 2025 5:15:14 PM
 *
 * @author HP
 */
public class Router {

    protected ListModelAPI item = new ListModelAPI();

    /**
     * Tempat inisialisasi path dan juga server service klas nya
     */
    public Router() {

        item
                .addServiceItem(new ServicePathBase(0), ServicePathBase.PATH)
                .addServiceItem(new ServicePathWithFilter(0), ServicePathWithFilter.PATH)
                .printPathBefore()
                .returnThis();
    }

    public ListModelAPI getItems() {
        return item;
    }

}
