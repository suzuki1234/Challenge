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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author suzuki
 */
public class review extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
            // 受け取るパラメータの文字コード指定
            request.setCharacterEncoding("UTF-8");
            //POSTで送られてきた内容を得る
            String n = request.getParameter("txtName");
            String t = request.getParameter("txtTell");
            int a =Integer.parseUnsignedInt(request.getParameter("txtAge"));
            String b = request.getParameter("txtBirthday");
                        //DB必要３要素
            Connection db_con = null;
            PreparedStatement db_st =null;
            ResultSet db_data = null;
            
            try{
            //ドライバの指定
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //ログイン処理
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","suzuki","minorin");

            //実際の処理
            //IDの決定
            db_st = db_con.prepareStatement("select * from profiles");
            db_data = db_st.executeQuery(); //検索系で利用
            
            int id =1;
            int flag=0;
            for(int i=1; i<=100; i++){                
                db_data = db_st.executeQuery(); //検索系で利用
                while(db_data.next()){
                    if(i == db_data.getInt("profilesID")){
                     id ++;
                     flag =1;
                     break;
                    }
                }
                if(flag == 0){
                    break;
                }else{
                    flag=0;
                }
            }
            
            //データ入力
            db_st = db_con.prepareStatement("insert into profiles value(?,?,?,?,?)");
            db_st.setInt(1,id);                
            db_st.setString(2,n);                
            db_st.setString(3,t);                
            db_st.setInt(4,a);                
            db_st.setString(5,b);
            
            int s =db_st.executeUpdate();//更新系で利用
            
            //しっかりクローズしましょう
            db_con.close();
            //db_st.close(); 
           
            //リクエストスコープで送るためのクラスを生成
            SendClass sc = new SendClass(id,n,t,a,b);
            
            //実際にリクエストスコープへ送る
            request.setAttribute("senddata", sc);
            
            //フォワードでページ遷移
            RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/review2.jsp");
            rd.forward(request, response);
            
           
            //エラー処理
            }catch(Exception ex) {
                out.println("エラー");
            }finally{
                if(db_con != null){
                    try {
                        db_con.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(JdbcServlet.class.getName()).log(Level.SEVERE, null, ex);
                        out.println("エラー");

                    }
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
