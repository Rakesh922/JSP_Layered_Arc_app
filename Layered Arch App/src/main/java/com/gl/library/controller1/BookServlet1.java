package com.gl.library.controller1;

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
 * Servlet implementation class BookServlet1
 */
public class BookServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
