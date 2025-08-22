/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webservice.database;

import com.webservice.model.ItemModel;
import com.webservice.model.StatusModel;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Bisri Hanafi bisrihanafi@designjaya.com
 *
 * Aug 22, 2025 5:15:14 PM
 *
 * @author HP
 */
public class DatabaseHelper {

    private static final BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/test-webservice-hanafi");
        dataSource.setUsername("user123");
        dataSource.setPassword("kopisoda007");

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        dataSource.setInitialSize(5);
        dataSource.setMaxTotal(20);
        dataSource.setMaxIdle(10);
        dataSource.setMinIdle(2);
        dataSource.setMaxWaitMillis(10000);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void getVersion(Connection koneksi) {
        String sql = "SELECT VERSION() AS VERSI";

        try (PreparedStatement pstmt = koneksi.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println(rs.getString("VERSI"));
                }
            }
        } catch (SQLException e) {
            System.err.println(e.toString());
        }

    }

    public static void saveDataTransaksi(Connection koneksi, String id, String productID, String productName, String amount, String customerName, String status, String transactionDate, String createBy, String createOn) {
        String sql = "INSERT INTO transactions (id, productID, productName, amount, customerName, status, transactionDate, createBy, createOn)  "
                + "VALUES(?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement pstmt = koneksi.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.setString(2, productID);
            pstmt.setString(3, productName);
            pstmt.setString(4, amount);
            pstmt.setString(5, customerName);
            pstmt.setString(6, status);
            pstmt.setString(7, transactionDate);
            pstmt.setString(8, createBy);
            pstmt.setString(9, createOn);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal menyimpan program: " + e.getMessage());
        }
    }

    public static void getDataTransaksi(Connection koneksi, List<ItemModel> list) {
        String sql = "SELECT id, productID, productName, amount, customerName, status, transactionDate, createBy, createOn FROM transactions";
        try (Statement stmt = koneksi.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(
                        new ItemModel()
                                .setId(rs.getInt("id"))
                                .setProductID(rs.getString("productID"))
                                .setProductName(rs.getString("productName"))
                                .setAmount(rs.getString("amount"))
                                .setCustomerName(rs.getString("customerName"))
                                .setStatus(rs.getInt("status"))
                                .setTransactionDate(rs.getString("transactionDate"))
                                .setCreateBy(rs.getString("createBy"))
                                .setCreateOn(rs.getString("createOn"))
                );
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengambil data: " + e.getMessage());
        }
    }

    public static void getDataStatus(Connection koneksi, List<StatusModel> list) {
        String sql = "SELECT id, name FROM status";
        try (Statement stmt = koneksi.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(
                        new StatusModel()
                                .setId(rs.getInt("id"))
                                .setName(rs.getString("name"))
                );
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengambil data: " + e.getMessage());
        }
    }
}
