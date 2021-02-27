package com.simplilearn.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class IntializeSession
 */
@WebServlet("/init-session")
public class IntializeSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public IntializeSession() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter  out = response.getWriter();
		
		//hibernate operation to initialize connection
		
		try {
			// 1. load session factory
			SessionFactory factory = HibernateUtil.buildSessionFactory();
			
			// 2. create a session object
			Session session = factory.openSession();
			
			// 3. Print Session Response
			if(session != null) {
				out.print("<h1>Hibenrate Session is Opened !</h1>");
			}
			
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		out.print("InIt Request is Successfully Mapped !");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
