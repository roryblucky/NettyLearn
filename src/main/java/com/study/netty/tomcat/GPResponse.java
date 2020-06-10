package com.study.netty.tomcat;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;

import java.io.UnsupportedEncodingException;

public class GPResponse {

    private ChannelHandlerContext ctx;
    private HttpRequest request;

    public GPResponse(ChannelHandlerContext ctx, HttpRequest request) {
        this.ctx = ctx;
        this.request = request;
    }

    public void write(String out) throws UnsupportedEncodingException {
        try {
            if (out == null || "".equals(out)) {
                return;
            }

            FullHttpResponse response = new DefaultFullHttpResponse(
                    HttpVersion.HTTP_1_1,
                    HttpResponseStatus.OK,
                    Unpooled.wrappedBuffer(out.getBytes("UTF-8"))
            );

            response.headers().set("Content-Type", "text/html;");

            ctx.write(response);
        } finally {
            ctx.flush();
            ctx.close();
        }
    }
}
