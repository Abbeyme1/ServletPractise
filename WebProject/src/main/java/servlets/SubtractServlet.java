package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Enumeration;

import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;


//@WebServlet("/sub")

@WebServlet(name = "Subtract", urlPatterns = "/sub", description = "subtract servlet", initParams= {
@WebInitParam(name = "name", value="temp")
})
public class SubtractServlet extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{	
		
		sessionMethods(req.getSession());
		req.setAttribute("usernmame", "abc@123");
		
		Enumeration e = req.getAttributeNames();
		
		while(e.hasMoreElements())
		{
			Object o = e.nextElement();
			System.out.println(o + " = " + req.getAttribute(o.toString()));
		}
		
		int val = 0;
		
		
		// fetching data from session
//		val = (int) req.getSession().getAttribute("val");
		
		System.out.println("init param = "+ getServletConfig().getInitParameter("name"));
		
		// fetching cookies
		Cookie[] cookies = req.getCookies();
		
		for(Cookie c : cookies)
		{
			System.out.println("name: "  +c.getName() + ", comment: "+c.getComment() + ", domain: "+  c.getDomain()+ ", maxAge: " + c.getMaxAge() + ", path: "+ c.getPath());
			if(c.getName().equals("val")) val = Integer.parseInt(c.getValue());
			
		}
		
		PrintWriter output = res.getWriter();
			
		output.print("val = " + val);
	}
	
	public void sessionMethods(HttpSession session)
	{
		
		LocalDateTime creationDate =
			    LocalDateTime.ofInstant(Instant.ofEpochMilli(session.getCreationTime()), ZoneId.systemDefault());
		
		LocalDateTime lastAccessDate =
			    LocalDateTime.ofInstant(Instant.ofEpochMilli(session.getLastAccessedTime()), ZoneId.systemDefault());
		
		
		String exp = session.getAttribute("sessionExp") == null ? "true" : "false";
		
		System.out.println("SesssionExpired: " + exp + ", Creation Time :"+ creationDate.toString() + ", Last Access Date: " + lastAccessDate.toString() + ", getMaxInActiveInterval: "+ session.getMaxInactiveInterval() + ", isNew: " + session.isNew() +  ", Id: "+ session.getId());
				
		
	}
}
