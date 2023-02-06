package com.employee.session;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//enclose HTML MARKUP Within Java Code
		PrintWriter pout=response.getWriter();
		RequestDispatcher rd=request.getRequestDispatcher("links.html");
		rd.include(request, response);
		pout.append("<html><body>");
		Cookie cookie[]=request.getCookies();
		if(cookie==null)
		{
			pout.append("<h2>You are logged out. <br> Please login first.</h2>");

		}else
		{
			String name=cookie[0].getValue();
			pout.append("<h2>Welcome to our wesite"+name+"</h2>");
			pout.append("<h2>your status is logged in</h2>");

		}
		pout.append("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
