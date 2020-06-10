package com.study.netty.tomcat;

import java.io.UnsupportedEncodingException;

public class BarServlet extends GPServlet {
    @Override
    public void doGet(GPRequest request, GPResponse response) {
        try {
            response.write("Bar servlet");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(GPRequest request, GPResponse response) {

    }
}
