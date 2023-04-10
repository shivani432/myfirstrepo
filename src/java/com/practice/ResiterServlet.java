
package com.practice;

import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ResiterServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
         out.println("<h2>welcome to resister servlet</h2>");
         
         String name =req.getParameter("user_name");
         String password =req.getParameter("user_password");
         String email =req.getParameter("user_email");
         String gender =req.getParameter("user_gender");
         String course =req.getParameter("user_course");
         
         String cond=req.getParameter("condition");
         if (cond!=null)
         {
            if(cond.equals("checked")){
                out.println("<h2> Name : " + name +"</h2>");
                out.println("<h2> password : " + password+"</h2>");
                out.println("<h2>Email : " + email +"</h2>");
                out.println("<h2> Gender : " + gender+"</h2>");
                out.println("<h2> course : " + course+"</h2>");
                
                //
                //jdbc
                // // saved db
                RequestDispatcher rd= req.getRequestDispatcher("success");
                rd.forward(req, res);
            }else
                    {
                        out.println("<h2>you have not excepted terms and condition</h2>");
                    }
         }
         else{
             out.println("<h2>you have not excepted terms and condition</h2>");
             
             //i want to include outpit of index.html
             
             //get the object of RequestDisptacher
             
             RequestDispatcher rd = req.getRequestDispatcher("index.html");
             
             //include
             
             rd.include(req, res);
         }
    }
}
