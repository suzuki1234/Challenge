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
public class kadai12 extends HttpServlet {

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
            String a = request.getParameter("txtAge");
//            int a =Integer.parseUnsignedInt(request.getParameter("txtAge"));
            String b = request.getParameter("txtBirthday");

            //命令文の作成            
            String msg ="";
            
            if(n!=""){
                msg = msg+ "and name like \"%"+n+"%\" ";
            }
            if(t!=""){
                msg = msg+ "and tell like \"%"+t+"%\" ";
            }
            if(a!=""){
                msg = msg+ "and age = "+a+" ";
            }
            if(b!=""){
                msg = msg+ " and birthday like \"%"+b+"%\" ";
            }
            
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
            
            //データ入力
            db_st = db_con.prepareStatement("select * from profiles where name like \"%\" " + msg);
//            db_st.setString(1,n);                
//            db_st.setString(2,t);                
//            db_st.setInt(3,a);                  
//            db_st.setString(4,b);
            
            db_data = db_st.executeQuery(); //検索系で利用
             
           
            //リクエストスコープで送るためのクラスを生成
            SendClass[] sc = new SendClass[100];
            for( int i = 0; i < 99; i++){
                sc[i] = new SendClass();
            }
            
            int i=0;
            while(db_data.next()){
                sc[i].setId(db_data.getInt("profilesID"));
                sc[i].setName(db_data.getString("name"));
                sc[i].setTell(db_data.getString("tell"));
                sc[i].setAge(db_data.getInt("age"));
                sc[i].setBirthday(db_data.getString("birthday"));
                i++;
            }
            

            
            //実際にリクエストスコープへ送る
            request.setAttribute("senddata", sc);
            
            //フォワードでページ遷移
            RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/kadai12_2.jsp");
            rd.forward(request, response);
            
            //しっかりクローズしましょう
            db_con.close();
            db_st.close();
            
            //エラー処理
            }catch(Exception ex) {
                out.println("エラー"+ex);
            }finally{
                if(db_con != null){
                    try {
                        db_con.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(JdbcServlet.class.getName()).log(Level.SEVERE, null, ex);
                        out.println("sqlエラー");

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
