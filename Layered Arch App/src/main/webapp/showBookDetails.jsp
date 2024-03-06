<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.ArrayList, com.gl.library.beanorpojo.Book" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<%
	ArrayList<Book> bookList=new ArrayList<Book>();
	bookList=(ArrayList<Book>)session.getAttribute("bookList");
	%>
	
	<table border='1'>
		<%
			for(Book book:bookList) {
		%>
		<tr>
			<td align="center"><%=book.getBookId()%></td>
			<td align="center"><%=book.getbName()%></td>
			<td align="center"><%=book.getAuthor()%></td>
			<td align="center"><%=book.getPrice()%></td>
			<td align="center"><%=book.getDop()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>