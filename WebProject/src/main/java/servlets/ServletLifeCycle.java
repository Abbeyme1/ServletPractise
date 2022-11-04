package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lifecycle")
public class ServletLifeCycle extends HttpServlet{

	static int counter = 0;
	
	public void init()
	{
		System.out.println("Init method");
	}
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		System.out.println("hey");
		counter++;
		
		
		// PRINTER
		PrintWriter output = res.getWriter();
			
		output.print("service method : count = "+ counter);
	}
	
	public void destroy()
	{
		System.out.println("destroyed");
	}
}
