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
public class kadai2 extends HttpServlet {

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
            //ageが30のデータを取得
            db_st = db_con.prepareStatement("insert into profiles value(?,?,?,?,?)");
            db_st.setInt(1,3);
            db_st.setString(2,"竹内 太郎");
            db_st.setString(3,"000-1234-5678");
            db_st.setInt(4,35);
            db_st.setString(5,"1999-12-31");
            
//            db_data = db_st.executeQuery(); //検索系で利用
            int a = db_st.executeUpdate();//更新系で利用
            
            out.println(String.valueOf(a));

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
