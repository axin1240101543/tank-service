package com.darren.center.designpatterns.chainofresponsibility.servlet.v4;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>tank-service</h3>
 * <p>模拟Servlet的Filter</p>
 *
 * request 123
 * response 321
 *
 * v3：在filterChain中处理加入位置的记录
 *     同时在filter中加入第三个参数
 *
 *     类似递归
 *
 * v4：完全模式Servlet中的FilterChain
 *     去掉Filter返回值
 *
 * @author : Darren
 * @date : 2020年07月29日 20:17:48
 **/
public class Main{

    public static void main(String[] args) {
        Request request = new Request();
        request.str = "大家好:)，<script>，欢迎访问 mashibing.com ，大家都是996 ";
        Response response = new Response();
        response.str = "response";

        FilterChain chain = new FilterChain();
        chain.addFilter(new HTMLFilter()).addFilter(new SensitiveFilter());

        chain.doFilter(request, response);
        System.out.println(request.str);
        System.out.println(response.str);
    }

}

class Request{

    String str;

}

class Response{

    String str;

}

interface Filter{
    void doFilter(Request request, Response response, FilterChain chain);
}

class HTMLFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.str = request.str.replace("<", "[")
                .replace(">", "]") + "HTMLFilter()";
        chain.doFilter(request, response);
        response.str += "--HTMLFilter";
    }
}

class SensitiveFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.str = request.str.replace("996", "955") + " SensitiveFilter()";
        chain.doFilter(request, response);
        response.str += "--SensitiveFilter";
    }
}

class FilterChain{
    List<Filter> filters = new ArrayList<>();
    int index = 0;

    public FilterChain addFilter(Filter filter){
        filters.add(filter);
        return this;
    }

    public void doFilter(Request request, Response response){

        if(index == filters.size()){
            return;
        }
        Filter filter = filters.get(index);
        index++;
        filter.doFilter(request, response, this);
    }
}

