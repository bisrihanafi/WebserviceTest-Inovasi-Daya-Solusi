/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webservice.model;

import com.google.gson.JsonObject;

/**
 * Bisri Hanafi bisrihanafi@designjaya.com
 *
 * Aug 22, 2025 2:08:39 PM
 *
 * @author HP
 * <hr>
 * Data  <pre>
 *{
 * "id": 1372,
 * "productID": "10001",
 * "productName": "Test 1",
 * "amount": "1000",
 * "customerName": "abc",
 * "status": 0,
 * "transactionDate": "2022-07-10 11:14:52",
 * "createBy": "abc",
 * "createOn": "2022-07-10 11:14:52"
 *}
 * </pre>
 *
 */
public class ItemModel extends JSONCreator {

    private int id, status;
    private String productID, productName, amount, customerName, transactionDate, createBy, createOn;

    public ItemModel setId(int id) {
        this.id = id;
        return this;
    }

    public ItemModel setStatus(int status) {
        this.status = status;
        return this;
    }

    public ItemModel setProductID(String productID) {
        this.productID = productID;
        return this;
    }

    public ItemModel setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public ItemModel setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public ItemModel setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public ItemModel setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
        return this;
    }

    public ItemModel setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public ItemModel setCreateOn(String createOn) {
        this.createOn = createOn;
        return this;
    }

    /**
     *
     * @return JSONCreator
     */
    @Override
    public JsonObject toJSONCreator() {
        return this
                .put("id", this.id)
                .put("productID", this.productID)
                .put("productName", this.productName)
                .put("amount", this.amount)
                .put("customerName", this.customerName)
                .put("status", this.status)
                .put("transactionDate", this.transactionDate)
                .put("createBy", this.createBy)
                .put("createOn", this.createOn)
                .build();
    }

}
