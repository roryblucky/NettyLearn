package com.study.netty.tomcat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpRequest;

import java.util.Map;

public class GPTomcatHandler extends ChannelInboundHandlerAdapter {
    private Map<String, GPServlet> servletMapping;


    public GPTomcatHandler(Map<String, GPServlet> servletMapping) {
        this.servletMapping = servletMapping;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof HttpRequest) {
            System.out.println("Hello");
            HttpRequest req = (HttpRequest) msg;

            GPRequest request = new GPRequest(ctx, req);
            GPResponse response = new GPResponse(ctx, req);

            String url = req.uri();

            if (this.servletMapping.containsKey(url)) {
                servletMapping.get(url).service(request, response);
            } else {
                response.write("404 - Not found");
            }
        }
    }

}
