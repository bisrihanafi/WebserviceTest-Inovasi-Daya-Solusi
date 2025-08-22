/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.webservice.main;

import com.webservice.core.MainRunner;
import com.webservice.database.DatabaseHelper;
import java.sql.Connection;

/**
 *
 * @author HP
 */
public class WebserviceTest {
    
    static {
        
    }

    public static void main(String[] args) throws Exception {
        MainRunner.start(args);
        try(Connection koneksi=DatabaseHelper.getConnection()){
            DatabaseHelper.getVersion(koneksi);
        }
    }
}
