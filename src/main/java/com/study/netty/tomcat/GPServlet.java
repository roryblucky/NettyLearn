package com.study.netty.tomcat;

public abstract class GPServlet {
    public void service(GPRequest request, GPResponse response){
        if ("GET".equals(request.getMethod())) {
            this.doGet(request, response);
        } else {
            this.doPost(request, response);
        }
    }

    public abstract void doGet(GPRequest request, GPResponse response);

    public abstract void doPost(GPRequest request, GPResponse response);
}
