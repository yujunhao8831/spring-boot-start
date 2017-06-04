package com.aidijing.common.filter;


import com.aidijing.common.util.LogUtils;
import com.aidijing.common.util.RequestUtils;
import org.apache.logging.log4j.ThreadContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 请求信息打印过滤器
 *
 * @author : 披荆斩棘
 * @date : 2017/1/17
 */
public class RequestLoggingFilter implements Filter {
    ///////////////////////////////////////////////////////////////////////////
    // 在log4j2.xml配置文件通过 %X{xxx} 获取 
    ///////////////////////////////////////////////////////////////////////////
    /** 该次请求的请求信息 */
    private static final String REQUEST_MESSAGE = "requestMessage";
    /** 用户ID */
    private static final String USER_ID         = "userId";
    /** 用户姓名 */
    private static final String USER_NAME       = "userName";


    @Override
    public void doFilter ( ServletRequest request, ServletResponse response, FilterChain chain ) throws IOException,
                                                                                                        ServletException {
        final BodyReaderWrapper wrapper  = new BodyReaderWrapper( ( HttpServletRequest ) request );
        final String            username = "用户名";
        ThreadContext.put( USER_ID, wrapper.getRequestedSessionId() );
        ThreadContext.put( USER_NAME, username );
        LogUtils.getLogger().info( RequestUtils.getRequestMessage( wrapper, USER_ID, username ) );
        chain.doFilter( wrapper, response );
        ThreadContext.clearAll();
    }

    @Override
    public void init ( FilterConfig filterConfig ) throws ServletException {
    }

    @Override
    public void destroy () {
    }

}
