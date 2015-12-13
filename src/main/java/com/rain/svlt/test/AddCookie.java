package com.rain.svlt.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class AddCookie extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie firstName = new Cookie("first_name",
				request.getParameter("first_name"));
		Cookie lastName = new Cookie("last_name",
				request.getParameter("last_name"));

		firstName.setMaxAge(60 * 60 * 24);
		lastName.setMaxAge(60 * 60 * 24);

		response.addCookie(firstName);
		response.addCookie(lastName);

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		String title = "Set Cookies Example";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 "
				+ "transitional//en\">\n";
		out.println(docType + "<html>\n" + "<head><title>" + title
				+ "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n"
				+ "<h1 align=\"center\">" + title + "</h1>\n" + "<ul>\n"
				+ "  <li><b>firstName</b>: "
				+ request.getParameter("first_name") + "\n"
				+ "  <li><b>lastName</b>: " + request.getParameter("last_name")
				+ "\n" + "</ul>\n" + "</body></html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}