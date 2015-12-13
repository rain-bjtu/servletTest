package com.rain.svlt.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ReadCookies extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cookie = null;
		Cookie[] cookies = null;
		cookies = request.getCookies();

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		String title = "Reading Cookies Example";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 "
				+ "transitional//en\">\n";
		out.println(docType + "<html>\n" + "<head><title>" + title
				+ "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n");
		if (cookies != null) {
			out.println("<h2>Find Cookies name and value</h2>");
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				out.print("name: " + cookie.getName() + ", ");
				out.print("value: " + cookie.getValue() + " <br/>");
			}
		} else {
			out.println("<h2 class=\"tutheader\">Can't Find Cookies</h2>");
		}
		out.println("</body>");
		out.println("</html>");
	}
}
