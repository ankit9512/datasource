package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.RegisterStudent;
import service.StudentService;
import service.StudentServiceInterface;


public class GlobalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		String option = request.getParameter("ac");
		if (option.equals("register")) {
			String name = request.getParameter("name");
			String pass = request.getParameter("pass");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			
			RegisterStudent rs=new RegisterStudent();
			
			rs.setName(name);
			rs.setAddress(address);
			rs.setEmail(email);
			rs.setPass(pass);

			StudentServiceInterface ss = StudentService
					        .createServiceObject("f");
			int i = ss.createProfileService(rs);

			if (i > 0) {
				out.println("profile created");
			} else {
				out.println("could not create profile");
			}
		}
		
		if (option.equals("login")) {
			
		}

		out.println("</body></html>");

	}

	}


