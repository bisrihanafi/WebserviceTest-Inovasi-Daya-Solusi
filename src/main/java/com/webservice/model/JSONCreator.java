/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webservice.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.Collection;
import java.util.Map;

public abstract class JSONCreator {

    private final JsonObject jsonObject;
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public JSONCreator() {
        this.jsonObject = new JsonObject();
    }

    // Basic types
    public JSONCreator put(String key, String value) {
        jsonObject.addProperty(key, value);
        return this;
    }

    public JSONCreator put(String key, Number value) {
        jsonObject.addProperty(key, value);
        return this;
    }

    public JSONCreator put(String key, Boolean value) {
        jsonObject.addProperty(key, value);
        return this;
    }

    public JSONCreator put(String key, Character value) {
        jsonObject.addProperty(key, value);
        return this;
    }

    // Nested JSON
    public JSONCreator put(String key, JSONCreator value) {
        jsonObject.add(key, value.build());
        return this;
    }

    // Collections
    public JSONCreator put(String key, Collection<?> value) {
        JsonArray array = new JsonArray();
        value.forEach(item -> {
            if (item instanceof String) {
                array.add((String) item);
            } else if (item instanceof Number) {
                array.add((Number) item);
            } else if (item instanceof Boolean) {
                array.add((Boolean) item);
            } else if (item instanceof Character) {
                array.add((Character) item);
            } else {
                array.add(gson.toJsonTree(item));
            }
        });
        jsonObject.add(key, array);
        return this;
    }

    // Arrays
    public JSONCreator put(String key, Object[] array) {
        JsonArray jsonArray = new JsonArray();
        for (Object item : array) {
            jsonArray.add(gson.toJsonTree(item));
        }
        jsonObject.add(key, jsonArray);
        return this;
    }

    // Map
    public JSONCreator put(String key, Map<?, ?> map) {
        JsonObject nestedObject = new JsonObject();
        map.forEach((k, v) -> nestedObject.add(k.toString(), gson.toJsonTree(v)));
        jsonObject.add(key, nestedObject);
        return this;
    }

    // Custom objects
    public JSONCreator put(String key, Object value) {
        jsonObject.add(key, gson.toJsonTree(value));
        return this;
    }

    // Null values
    public JSONCreator putNull(String key) {
        jsonObject.add(key, null);
        return this;
    }

    // Build final JSON
    public JsonObject build() {
        return jsonObject;
    }

    // Convert to string
    @Override
    public String toString() {
        return gson.toJson(jsonObject);
    }

    public abstract JsonObject toJSONCreator();

}
