package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/handle")
public class Middleware extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("in middlware");
		HttpSession session = req.getSession();
		sessionMethods(session);
		
		
//		if(session.getAttribute("Username") == null)
//		{
//			System.out.println("yes : middleware.java");
//			req.getRequestDispatcher("/login").forward(req, res);
//		}
//		else
		{
			PrintWriter output = res.getWriter();
			String op = req.getParameter("operation");
			
			if(op.equals("square"))
			{
				// SESSION/SET ATTRIBUTE
				// req.setAttribute("val", a+b);
				
				// REQUEST DISPATCHER
				RequestDispatcher rd = req.getRequestDispatcher("sq");
				rd.forward(req, res);
			}
			else req.getRequestDispatcher("add").forward(req, res);
		}
		
		

	}
	
	public void sessionMethods(HttpSession session)
	{
		
		LocalDateTime creationDate =
			    LocalDateTime.ofInstant(Instant.ofEpochMilli(session.getCreationTime()), ZoneId.systemDefault());
		
		LocalDateTime lastAccessDate =
			    LocalDateTime.ofInstant(Instant.ofEpochMilli(session.getLastAccessedTime()), ZoneId.systemDefault());
		
		
		// change exp. / inactive interval ( default = 3600s)
		session.setMaxInactiveInterval(10);
		
		session.setAttribute("sessionExp", false);
		
		
		String exp = session.getAttribute("sessionExp") == null ? "true" : "false";
		
		System.out.println("SesssionExpired: " + exp + ", Creation Time :"+ creationDate.toString() + ", Last Access Date: " + lastAccessDate.toString() + ", getMaxInActiveInterval: "+ session.getMaxInactiveInterval() + ", isNew: " + session.isNew() +  ", Id: "+ session.getId());
				
		
		
		
	}

}