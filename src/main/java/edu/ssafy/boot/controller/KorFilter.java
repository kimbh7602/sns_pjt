package edu.ssafy.boot.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName="korfilter", value="/*", initParams = @WebInitParam(name="kor", value="utf-8"))
public class KorFilter implements Filter {
	String charset;
	public void init(FilterConfig fConfig) throws ServletException {
		charset = fConfig.getInitParameter("kor");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 전처리
		System.out.println("korea Filter 전처리");
		request.setCharacterEncoding(charset);
		chain.doFilter(request, response);
		// 후처리
		System.out.println("korea Filter 후처리");
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

}
