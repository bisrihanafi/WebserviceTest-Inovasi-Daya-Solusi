/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webservice.services;

import com.webservice.model.ListModelAPI;




/**
 *
 * @author Hanafi
 */
public class Router {

    protected ListModelAPI item = new ListModelAPI();

    /**
     * Tempat inisialisasi path dan juga server service klas nya
     */
    public Router() {

        item
                .addServiceItem(new ServicePath(0), ServicePath.PATH)

                .printPathBefore()
                .returnThis();
    }

    public ListModelAPI getItems() {
        return item;
    }

}
