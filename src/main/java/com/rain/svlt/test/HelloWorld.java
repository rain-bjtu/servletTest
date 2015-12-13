package com.rain.svlt.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author rain
 * 
 */
@SuppressWarnings("serial")
public class HelloWorld extends HttpServlet {

	private String message;

	public void init() throws ServletException {
		// necessary init
		message = "Hello World";
	}

	/**
	 * @exception ServletException
	 *                , IOException
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response content
		response.setContentType("text/html");

		// real logical
		PrintWriter out = response.getWriter();
		out.println("<h1>" + message + "</h1>");
		throw new ServletException();
	}

	public void destroy() {
		// do nothing
	}
}