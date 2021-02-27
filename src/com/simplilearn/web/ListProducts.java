package com.simplilearn.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.entity.EProduct;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class ListProducts
 */
@WebServlet("/list-product")
public class ListProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter  out = response.getWriter();
		
		try {
			// 1. load session factory
			SessionFactory factory = HibernateUtil.buildSessionFactory();
			
			// 2. create a session object
			Session session = factory.openSession();
			
			// 3. read products
			
			List<EProduct> products = session.createQuery("from EProduct").list();
			
			out.print("<h1> Product List </h1>");
			
			out.print("<style> table,td,th {"
					+ " border: 2px solid red;"
					+ " padding: 10px"
					+ " }</style>");
			
			out.print("<table>");
			out.print("<tr>");
				out.print("<th> Product Id </th>");
				out.print("<th> Product Name </th>");
				out.print("<th> Product Price </th>");
				out.print("<th> Product CreatedAt </th>");
				out.print("<th> Product Modified </th>");
			out.print("</tr>");
			
			for(EProduct p : products) {
				out.print("<tr>");
					out.print("<td>"+ p.getId() +"</td>");
					out.print("<td>"+ p.getName() +"</td>");
					out.print("<td>"+ p.getPrice() +"</td>");
					out.print("<td>"+ p.getCreatedAt() +"</td>");
					out.print("<td>"+ p.getModifiedAt() +"</td>");
				out.print("</tr>");
			}
			out.print("</table>");
			
			session.close();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
