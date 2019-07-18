package com.javaman.microservice.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;

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
