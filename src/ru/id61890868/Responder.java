package ru.id61890868;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.jdbc.Driver;

import java.sql.*;

import ru.id61890868.CONST.*;

@WebServlet("/Responder")
public class Responder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
	
       
    public Responder() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String username = (String) request.getParameter("username");
		username = username.toUpperCase();
		response.getWriter().println(username);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		response.getWriter().println("notVoid");
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(baseAccess.basePath, baseAccess.baseLog, baseAccess.basePass);
            stmt = con.createStatement();
            rs = stmt.executeQuery(test.testReqToBase1);
            while (rs.next()) {
                //int count = rs.getInt(1);
                System.out.println("request completed");
                response.getWriter().println(rs.toString());
                
            }
 
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
        	response.getWriter().println("exc 0");
		} finally {
            try { con.close(); } catch(SQLException se) {
            	response.getWriter().println("exc 1");
            }
            try { stmt.close(); } catch(SQLException se) { 
            	response.getWriter().println("exc 2");
            }
            try { rs.close(); } catch(SQLException se) { 
            	response.getWriter().println("exc 3");
            }
        }
		
	}

}
