package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Counter")
public class Counter extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
   int cnt = 0;
   int totalLen;
   
   public void init() {
      cnt = 0;
      totalLen = 8;
   }
    
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   //기존의 숫자를 덮어쓰기만하면대니까 파일쓰는게 좋은데 DB가지고 연습을할거에요.
      cnt++;
      String cntStr = cnt + "";   //예137
      int cntLen = cntStr.length(); //3자리
      int zeroLen = totalLen - cntLen; //5
      
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<html>");
      out.println("   <body>");
      out.println("당신은 ");
            
      for (int i = 0; i < zeroLen; i++) {
         out.println("<img src=\"/basicservlet/img/0.PNG\">");
      }
      
      for(int i=0;i<cntLen;i++)
         out.println("<img src=\"/basicservlet/img/" + cntStr.charAt(i) + ".PNG\">");
   
      out.println("<br>번째 방문자입니다.");
      out.println("   </body>");
      out.println("</html>");
   }
}

