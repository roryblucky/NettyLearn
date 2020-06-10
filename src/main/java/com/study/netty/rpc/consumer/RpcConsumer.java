package com.study.netty.rpc.consumer;

import com.study.netty.rpc.api.IRpcHelloService;
import com.study.netty.rpc.consumer.proxy.RpcProxy;

public class RpcConsumer {
    public static void main(String[] args) {
        IRpcHelloService rpcHelloService = RpcProxy.create(IRpcHelloService.class);
        System.out.println(rpcHelloService.hello("Rory"));
    }
}
