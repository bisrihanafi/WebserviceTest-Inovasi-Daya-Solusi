/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webservice.model;

import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Bisri Hanafi bisrihanafi@designjaya.com
 *
 * Aug 22, 2025 5:15:14 PM
 *
 * @author HP
 */
public class BodyModel extends JSONCreator {

    private List<StatusModel> status = new ArrayList<>();
    private List<ItemModel> data = new ArrayList<>();

    public BodyModel setStatus(List<StatusModel> status) {
        this.status = status;
        return this;
    }

    public BodyModel setData(List<ItemModel> data) {
        this.data = data;
        return this;
    }

    /**
     *
     * @return JSONCreator
     */
    @Override
    public JsonObject toJSONCreator() {
        return this
                .put("status",this.status.stream().map(StatusModel::toJSONCreator).collect(Collectors.toList()))
                .put("data", this.data.stream().map(ItemModel::toJSONCreator).collect(Collectors.toList()))
                .build();
    }

}
