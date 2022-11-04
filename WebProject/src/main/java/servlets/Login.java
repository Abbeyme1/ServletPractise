package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "Login", urlPatterns = "/login" , initParams = {
		
})
public class Login extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		PrintWriter o = res.getWriter();
		o.print("e");
		HttpSession session = req.getSession();
		req.setAttribute("Username", "username123");
	  
		req.getRequestDispatcher("/handle").forward(req, res);
		
	}
	
}
