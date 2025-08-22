/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservice.model;

import java.util.ArrayList;

/**
 * Bisri Hanafi bisrihanafi@designjaya.com
 *
 * Aug 22, 2025 5:15:14 PM
 *
 * @author HP
 */
public class Model_PathInfo {

    public class Data {

        private final String path, nama_class, info;

        public Data(String path, String nama_class, String info) {
            this.path = path;
            this.nama_class = nama_class;
            this.info = info;
        }

        public String getPath() {
            return path;
        }

        public String getNama_class() {
            return nama_class;
        }

        public String getInfo() {
            return info;
        }
        
    }
    public void add(String path, String nama_class, String info){
        Data data_one=new Data( path,  nama_class,  info);
        data.add(data_one);
    }
    protected ArrayList<Data> data=new ArrayList<>();

    public ArrayList<Data> getData() {
        return data;
    }
    
    
}
