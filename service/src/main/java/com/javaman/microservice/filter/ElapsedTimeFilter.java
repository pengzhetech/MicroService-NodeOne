package com.javaman.microservice.filter;



import com.alibaba.dubbo.common.Constants;

import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.RpcException;

/**
 * @author pengzhe
 * @date 2019-07-18 11:44
 */
@Activate(group = {Constants.CONSUMER})
public class ElapsedTimeFilter implements Filter {

    private static Logger log = LoggerFactory.getLogger(ElapsedTimeFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        long start = System.currentTimeMillis();
        RpcContext rpcContext = RpcContext.getContext();
        rpcContext.setAttachment("consumerKey", "我是来自Consumer的Value");
        Result result = invoker.invoke(invocation);
        long elapsed = System.currentTimeMillis() - start;
        log.warn("-----客户端接口调用耗时-----" + elapsed);
        return result;
    }
}
