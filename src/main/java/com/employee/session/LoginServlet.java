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
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pout=response.getWriter();
		String name= request.getParameter("name");
		String pwd=request.getParameter("pwd");
//		RequestDispatcher rd=request.getRequestDispatcher("links.html");
//		rd.include(request, response);
		if(name.equals("admin")&&pwd.equals("12345")) {
			pout.append("<html><body> <h2>Welcome "+name+"</h2>");
			Cookie cookie=new Cookie("name", name);					
			response.addCookie(cookie);
			RequestDispatcher rd=request.getRequestDispatcher("links.html");
			RequestDispatcher rd1=request.getRequestDispatcher("empdata.html");
			rd.include(request, response);
			rd1.include(request, response);
		}
		else
		{
			pout.append("<html><body> <h2>You are not valid user!!</h2>");
		}
		pout.append("</body></html>");
	}

}
