/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webservice.model;

import com.google.gson.JsonObject;

/**
 * Bisri Hanafi bisrihanafi@designjaya.com
 *
 * Aug 22, 2025 3:20:37 PM
 *
 * @author HP
 * <hr>
 * <pre>
 *{
 * "id" : 1,
 * "name" : "FAILED"
 *}
 * </pre>
 *
 */
public class StatusModel extends JSONCreator {

    private int id;
    private String name;

    public StatusModel setId(int id) {
        this.id = id;
        return this;
    }

    public StatusModel setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public JsonObject toJSONCreator() {
        return this
                .put("id", this.id)
                .put("name", this.name)
                .build();
    }
}
