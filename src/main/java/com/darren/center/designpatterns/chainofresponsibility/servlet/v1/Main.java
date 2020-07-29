package com.darren.center.designpatterns.chainofresponsibility.servlet.v1;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>tank-service</h3>
 * <p>模拟Servlet的Filter</p>
 *
 * request 123
 * response 321
 *
 * @author : Darren
 * @date : 2020年07月29日 20:17:48
 **/
public class Main{

    public static void main(String[] args) {
        Request request = new Request();
        request.str = "大家好:)，<script>，欢迎访问 mashibing.com ，大家都是996 ";
        Response response = new Response();
        response.str = "";

        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new HTMLFilter()).addFilter(new SensitiveFilter());

        filterChain.doFilter(request, response);
        System.out.println(request.str);
    }

}

class Request{

    String str;

}

class Response{

    String str;

}

interface Filter{
    boolean doFilter(Request request, Response response);
}

class HTMLFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response) {
        request.str = request.str.replace("<", "[")
                .replace(">", "]");
       return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response) {
        request.str = request.str.replace("996", "955");
        return true;
    }
}

class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>();

    public FilterChain addFilter(Filter filter){
        filters.add(filter);
        return this;
    }

    public boolean doFilter(Request request, Response response){

        for (Filter filter : filters) {
            filter.doFilter(request, response);
        }
        return false;
    }
}

