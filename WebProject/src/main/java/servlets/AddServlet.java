package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Enumeration;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;





public class AddServlet extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		
		servletContext(req,res);
		
		 //FOR ERRROR : ARRAY INDEX OUT OF BOUND
//		int[] x = new int[2];
//		x[88] = 55;
		
		
		System.out.println("INFO: " + getServletInfo());
		
		String name = getServletConfig().getInitParameter("name");
		int a = Integer.parseInt(req.getParameter("num1"));
		int b = Integer.parseInt(req.getParameter("num2"));
		
		int add = a+b;
		
		
		// REQUEST DISPATCHER
//		RequestDispatcher rd = req.getRequestDispatcher("sq");
//		rd.forward(req, res);
		
		// REDIRECT
//		res.sendRedirect("//www.google.com");
		
		// 		QUERY MANUPULATION
//		res.sendRedirect("sub?val="+add);
		
		// 		HTTP SESSION
//		HttpSession session = req.getSession();
		
//		Enumeration<String> e = session.getAttributeNames();
//		
//		while(e.hasMoreElements())
//		{
//			System.out.println(e.nextElement());
//		}
//		session.setAttribute("val", add);
		
		
		//		COOKIES
		Cookie cookie = new Cookie("val", Integer.toString(add));
		res.addCookie(cookie);
		
		
		res.sendRedirect("sub");	
		
		
		// PRINTER
		PrintWriter output = res.getWriter();
		
		output.print("sum = " + add);	
		
		System.out.println(req.isUserInRole("abhay"));
//		System.out.println(req.isUserInRole("admin"));
		
		
		System.out.println();
		
		if(req.isUserInRole("abhay")) 
			output.print("\nAdmin: "+ name);	
		else 
			output.print("\nUser: "+ name);	
				
	}
	
	public void servletContext(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		// SERVLET CONTEXT
		ServletContext ctx = getServletContext();
		Enumeration<String> e = ctx.getInitParameterNames();
		
		System.out.println("----Param Names----");
		while(e.hasMoreElements())
		{
			System.out.println(e.nextElement());
		}
		System.out.println("-----");
		
		
		// 		SET ATTRIBUTES IN SERVLET CONTEXT
		ctx.setAttribute("Name" , "Servlet Context");
		System.out.println("Helpline:  " + ctx.getInitParameter("Helpline"));
		System.out.println("Helpline:  " + getServletConfig().getServletContext().getInitParameter("Helpline"));
		
		
		
		/// request dispatcher
		
//		RequestDispatcher r = ctx.getNamedDispatcher("Square");
//		r.forward(req, res);
	}
	
	
	public String getServletInfo()
	{
		return "author: Abhay";
	}

}
