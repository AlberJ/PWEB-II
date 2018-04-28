package br.edu.ifpb.pweb2.filtro;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName="FiltroA", urlPatterns = { "/a.do", "/b.do" }, dispatcherTypes = {  DispatcherType.REQUEST, DispatcherType.FORWARD })

public class FiltroA implements Filter {

	public FiltroA() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("FiltroA  pre-processamento...");
		chain.doFilter(request, response);
		System.out.println("FiltroA  pos-processamento...");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
