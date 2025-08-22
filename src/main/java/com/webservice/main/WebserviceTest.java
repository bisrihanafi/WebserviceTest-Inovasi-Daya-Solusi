/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.webservice.main;

import com.webservice.core.MainRunner;
import com.webservice.database.DatabaseHelper;
import java.sql.Connection;

/**
 * Bisri Hanafi bisrihanafi@designjaya.com
 *
 * Aug 22, 2025 5:15:14 PM
 *
 * @author HP
 */
public class WebserviceTest {
    
    static {
        
    }

    public static void main(String[] args) throws Exception {
        
        try(Connection koneksi=DatabaseHelper.getConnection()){
            DatabaseHelper.getVersion(koneksi);
            MainRunner.start(args);
        }
    }
}
