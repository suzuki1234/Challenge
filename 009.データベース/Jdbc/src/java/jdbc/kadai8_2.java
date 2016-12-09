/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author suzuki
 */
public class kadai8_2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Connection db_con = null;
        PreparedStatement db_st =null;
        ResultSet db_data = null;
        PrintWriter out = response.getWriter();
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","suzuki","minorin");
            
            // 受け取るパラメータの文字コード
            request.setCharacterEncoding("UTF-8");
            // データの受け取り
            String n = request.getParameter("txtName");

            db_st = db_con.prepareStatement("select * from profiles where name like ?");
            db_st.setString(1,"%"+n+"%");                
            db_data = db_st.executeQuery(); //検索系で利用
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet kadai8</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>検索結果</h1>");

            while(db_data.next()){
                out.print(db_data.getString("profilesID"));
                out.print("  ");
                out.print(db_data.getString("name"));
                out.print("  ");
                out.print(db_data.getString("tell"));
                out.print("  ");
                out.print(db_data.getString("age"));
                out.print("  ");
                out.print(db_data.getString("birthday"));
                out.print("<br>");
            }
            
            out.println("</body>");
            out.println("</html>");

            db_con.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JdbcServlet.class.getName()).log(Level.SEVERE, null, ex);
            out.println("エラー1");
        } catch (InstantiationException ex) {
            Logger.getLogger(JdbcServlet.class.getName()).log(Level.SEVERE, null, ex);
            out.println("エラー2");
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JdbcServlet.class.getName()).log(Level.SEVERE, null, ex);
            out.println("エラー3");
        } catch (SQLException ex) {
            Logger.getLogger(JdbcServlet.class.getName()).log(Level.SEVERE, null, ex);
            out.println("エラー4");
        }finally{
            if(db_con != null){
                try {
                    db_con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JdbcServlet.class.getName()).log(Level.SEVERE, null, ex);
                    out.println("エラー5");
                    
                }
                
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
