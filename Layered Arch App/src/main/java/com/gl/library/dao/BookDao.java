package com.gl.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.gl.library.beanorpojo.Book;
import com.gl.library.helper.ConnectToDB;

//persistence layer
public class BookDao {

	//JDBC API classes for data retrieval
	private Connection connection=null;
	private PreparedStatement statement=null;
	private ResultSet resultSet=null;
	ArrayList<Book> bookList=new ArrayList<Book>();
	private static String bookQry="select * from book";
	
	public ArrayList getBooks() throws ClassNotFoundException, SQLException{
		try {
			//Open the connection
			connection=ConnectToDB.createConnection();
			
			//Create statement
			statement=connection.prepareStatement(bookQry);
			
			//Get the result
			resultSet=statement.executeQuery();
			
			while(resultSet.next()) {
				int bookId;
				String bName;
				String author;
				float price;
				String dop;
				
				//Declare the pojo
				Book book=new Book();
				
				//Get the row details
				bookId=resultSet.getInt(1);
				bName=resultSet.getString(2);
				author=resultSet.getString(3);
				price=resultSet.getFloat(4);
				dop=resultSet.getString(5);
				
				//Set the pojo with retrieval values from the row
				book.setBookId(bookId);
				book.setbName(bName);
				book.setAuthor(author);
				book.setPrice(price);
				book.setDop(dop);
				
				//Add the book to bookList
				bookList.add(book);
			}	//End of the while loop
			
		} catch(SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {
			//Close connction 
			//Now data is in array list object no need to keep the connection opened
			ConnectToDB.closeConnection();
		}
		return bookList;
	}	//End of the getBook() method
}
