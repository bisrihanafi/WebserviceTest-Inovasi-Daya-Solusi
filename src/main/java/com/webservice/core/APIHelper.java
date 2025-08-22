/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservice.core;

import com.webservice.model.Model_PathInfo;

/**
 * Bisri Hanafi bisrihanafi@designjaya.com
 *
 * Aug 22, 2025 5:15:14 PM
 *
 * @author HP
 */
public class APIHelper {

    private static final Model_PathInfo modelView1 = new Model_PathInfo();

    public static void addPathsInfo(String path, String name_class, String info) {
        modelView1.add(path, name_class, info);
    }

}
