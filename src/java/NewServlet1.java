/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class NewServlet1 extends HttpServlet {
public void doPost(HttpServletRequest request,HttpServletResponse response)
throws ServletException, IOException {
String na = request.getParameter("uname");
String pass = request.getParameter("pass");
response.setContentType("text/html");
PrintWriter pw = response.getWriter();
pw.println("<B>The selected uname is: ");
pw.println(na+pass);
try{
Class.forName("org.apache.derby.jdbc.ClientDriver");
Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/may","may","may");
PreparedStatement ps=con.prepareStatement("insert into client values(?,?)");
ps.setString(1,na);
ps.setString(2,pass);
int j=ps.executeUpdate();
if(j>0)
    pw.print("you are successfully registered");
                 }

catch(Exception e)
                 {
                     System.out.println(e);
                 }
}
}