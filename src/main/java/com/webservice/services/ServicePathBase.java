/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webservice.services;

import com.webservice.database.DatabaseHelper;
import com.webservice.model.BodyModel;
import com.webservice.model.ItemModel;
import com.webservice.model.ItemServices;
import com.webservice.model.StatusModel;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Bisri Hanafi bisrihanafi@designjaya.com
 *
 * Create : Mar 10, 2025 4:32:57 PM
 *
 * @author bisri
 */
public class ServicePathBase extends ItemServices {

    public ServicePathBase(int FLAG) {
        super(FLAG);
    }

    public static String PATH = "/*";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            try (Connection koneksi = DatabaseHelper.getConnection()) {
                List<ItemModel> dataList = new ArrayList<>();
                List<StatusModel> statusList = new ArrayList<>();

                DatabaseHelper.getDataTransaksi(koneksi, dataList);
                DatabaseHelper.getDataStatus(koneksi, statusList);

                BodyModel bodyModel = new BodyModel()
                        .setStatus(statusList)
                        .setData(dataList);

                String content = bodyModel.toJSONCreator().toString();

                response.setStatus(HttpServletResponse.SC_OK);
                response.setContentType("application/json");
                response.getWriter().println(content);
            }
        } catch (IOException | SQLException ex) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        } finally {
            response.getWriter().close();
        }
    }

}
