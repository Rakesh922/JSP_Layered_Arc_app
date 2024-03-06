package com.gl.library.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gl.library.beanorpojo.Book;
import com.gl.library.dao.BookDao;

/**
 * Servlet implementation class BookServlet
 * @author sangeeta jadhav
 *
 */
public class BookServlet extends HttpServlet {

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse))
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Book book=new Book();
		List<Book> bookList=new ArrayList<Book>();
		BookDao bookDao=new BookDao();
		
		HttpSession session=request.getSession();
		
		try {
			bookList=bookDao.getBooks(); //returns book list collection
		} catch(ClassNotFoundException|SQLException excp) {
			excp.printStackTrace();
			System.out.println(excp.getMessage());
		}
		
		session.setAttribute("bookList", bookList);	//collection object can be set as session
		
		RequestDispatcher reqDisp=request.getRequestDispatcher("/showBookDetails.jsp");
		reqDisp.forward(request, response);
	}
}
