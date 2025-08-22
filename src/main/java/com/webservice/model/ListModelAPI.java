/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webservice.model;

import com.webservice.core.APIHelper;
import java.util.ArrayList;
import javax.servlet.http.HttpServlet;

/**
 * Klas untuk menampung deretan pasangan server service dan path nya
 *
 * @author Hanafi
 */
public class ListModelAPI {

    protected ArrayList<ServletModel> items = new ArrayList<>();

    public ListModelAPI addServiceItem(HttpServlet servlet, String stringPath) {
        items.add(new ServletModel(servlet, stringPath));
        return this;
    }

    public ListModelAPI addServiceItem(HttpServlet servlet, String stringPath, String keterangan) {
        items.add(new ServletModel(servlet, stringPath, keterangan));
        return this;
    }

    public ServletModel[] getArrayServletModel() {
        ServletModel[] tmp=new ServletModel[items.size()];
        for (int i = 0 ; i<items.size();i++){
            tmp[i]=items.get(i);
        }
        return tmp;
    }

    public ListModelAPI returnThis() {
        return this;
    }

    public ListModelAPI printPathBefore() {
        ArrayList<String> stringList = new ArrayList<>();
        for (ServletModel i : items) {
            System.out.print(" - " + i.getStringPath());
            System.out.print(" -------->");
            System.out.println("\t" + i.getHttpServlet().toString().substring(i.getHttpServlet().toString().lastIndexOf('.')));
            if (stringList.indexOf(i.getStringPath()) < 0) {
                stringList.add(i.getStringPath());
            } else {
                System.err.println("DUPLIKAT PATH : " + i.getStringPath());
                System.exit(2);
            }
            APIHelper.addPathsInfo(i.getStringPath(), i.getHttpServlet().toString().substring(i.getHttpServlet().toString().lastIndexOf('.')), i.getStringKeterangan());
        }
        return this;
    }
}
