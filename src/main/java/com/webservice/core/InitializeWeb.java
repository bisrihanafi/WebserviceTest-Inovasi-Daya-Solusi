/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservice.core;

import com.webservice.model.ServletModel;
import java.net.BindException;
import java.util.EnumSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlets.CrossOriginFilter;


/**
 *
 * @author xuser
 */
public class InitializeWeb {

    private static Server server;
    private static Thread thread;

    public static boolean initWeb(ServletModel[] servlet, int port) {
        thread = new Thread() {
            @Override
            public void run() {
                int portLocal = port;
                int maxLoop = 10;
                for (int i = 0; i < maxLoop; i++) {
                    try {
                        server = new Server(portLocal);
                        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
                        for (ServletModel servlet1 : servlet) {
                            context.addServlet(new ServletHolder(servlet1.getHttpServlet()), servlet1.getStringPath());
                        }

                        server.setHandler(context);
                        // Menambahkan filter CORS
                        FilterHolder cors = context.addFilter(CrossOriginFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST));
                        cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*"); 
                        cors.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");
                        cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,POST,HEAD");
                        cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin");


                        server.start();
                        server.join();
                        break;
                    } catch (Exception ex) {
                        if (ex instanceof BindException) {
                            System.out.println("PORT " + portLocal + " TERPAKAI, Pindah menggunakan port : " + (portLocal + 1));
                        } else {
                            Logger.getLogger(InitializeWeb.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        portLocal++;
                        MainRunner.PORT = portLocal;
                        if (i == (maxLoop - 1)) {
                            System.exit(0);
                        }
                    }
                }
            }
        };
        thread.start();
        return true;
    }

    public static boolean initWeb(HttpServlet[] httpServlet, String[] path, int port) {
        thread = new Thread() {
            @Override
            public void run() {
                try {
                    server = new Server(port);
                    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
                    for (int i = 0; i < path.length; i++) {
                        context.addServlet(new ServletHolder(httpServlet[i]), path[i]);
                    }
                    server.setHandler(context);
                    server.start();
                    server.join();
                } catch (Exception ex) {
                    Logger.getLogger(InitializeWeb.class.getName()).log(Level.SEVERE, null, ex);
                    System.exit(0);
                }
            }
        };
        thread.start();
        return true;
    }

    public static boolean initWeb(HttpServlet httpServlet, String path, int port) {
        thread = new Thread() {
            @Override
            public void run() {
                try {
                    server = new Server(port);
                    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
                    context.addServlet(new ServletHolder(httpServlet), path);
                    server.setHandler(context);
                    server.start();
                    server.join();
                } catch (Exception ex) {
                    Logger.getLogger(InitializeWeb.class.getName()).log(Level.SEVERE, null, ex);
                    System.exit(0);
                }
            }
        };
        thread.start();
        return true;
    }

    public static boolean stopWeb() {
        try {
            server.stop();
            thread.stop();
        } catch (Exception ex) {
            Logger.getLogger(InitializeWeb.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
