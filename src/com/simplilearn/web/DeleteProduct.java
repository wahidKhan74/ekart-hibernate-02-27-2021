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
import org.hibernate.Transaction;

import com.simplilearn.entity.EProduct;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/delete-product")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter  out = response.getWriter();
		response.sendRedirect("delete-product.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter  out = response.getWriter();
		
		try {
			// 1. load session factory
			SessionFactory factory = HibernateUtil.buildSessionFactory();
			
			// 2. create a session object
			Session session = factory.openSession();
			
			// 3. begin transaction 
			Transaction txt = session.beginTransaction();
			
			int id = Integer.parseInt(request.getParameter("id"));
		
			// 4. create entity object			
			EProduct product = new EProduct(id);
			
			// 5. delete entity object 
			session.delete(product);
			
			// 6. commit transaction
			txt.commit();
			
			session.close();
			
			out.print("<h1>Product is deleted successfully </h1>");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
