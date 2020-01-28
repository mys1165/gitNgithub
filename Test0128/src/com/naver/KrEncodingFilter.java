package com.naver;
//인코딩필터 : 한글이 깨지지 않도록 잡아주는 필터이니 외우도록.
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/*") //한글깨지지 않게 ("/*") 써줄것
public class KrEncodingFilter implements Filter {

 
    public KrEncodingFilter() {
    }


	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		request.setCharacterEncoding("euc-kr"); //한글깨지지 않도록 해주는 request
		response.setContentType("text/html;charset=euc-kr");//한글깨지지 않도록 해주는 response
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
