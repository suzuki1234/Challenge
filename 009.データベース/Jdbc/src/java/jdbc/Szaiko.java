/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author suzuki
 */
public class Szaiko extends HttpServlet {

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
            
            
            //データベース準備３兄弟
            Connection db_con = null;
            PreparedStatement db_st =null;
            ResultSet db_data = null;
            //リクエストスコープへデータ転送用インスタンス作成用変数作成
            String name=null;
            int price=0,amount=0;
        
            
            //このサーブレットはユーザーからの入力をhiddenで受け取りその値により
            //処理を分岐させています。

            //hiddenからのデータ取得
            request.setCharacterEncoding("UTF-8");
            String act = request.getParameter("action");
            
            //nullチェック（スイッチ文にnullが入るとエラーになるようです。）
            if(act == null){
                out.print("不正アクセスエラー:null");
            }else{
                switch(act){
                    case "login":
                    //IDとPWを取得
                        String id = request.getParameter("id");
                        String pass = request.getParameter("pass");
                        int loginF =0;
                        
                        try{
                            //ドライバ準備とmysqlログイン
                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","suzuki","minorin");

                            //データベース上での処理（コマンド
                            db_st = db_con.prepareStatement("select  * from  zaikouser");    
                            //db_st.setString(1,name);                         
                            db_data = db_st.executeQuery(); //検索系で利用
                            //int s =db_st.executeUpdate();//更新系で利用
                            
                            //取得データの処理
                            while(db_data.next()){
                                if(db_data.getString("username").equals(id) && db_data.getString("userpass").equals(pass)){
                                    loginF=1;
                                    break;
                                }
                            }

                            //クローズは忘れずに行いましょう。
                            db_st.close();
                            db_con.close();
                                                  

                            //IDとPWが合っていたらホーム画面へ移動
                                if(loginF == 1){
                                    UserClass u = new UserClass(id, pass);
                                    HttpSession s =request.getSession();
                                    s.setAttribute("user",u );
                                    RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/zaiko/home.jsp");
                                    rd.forward(request, response);
                                }else{
                            //間違っていたらmiss画面へ移動
                                response.sendRedirect("./zaiko/miss.html");
                                }
                        
                        //途中でエラーが起きたらここへ
                        }catch (Exception ex) {
                            out.println("エラー"+ex);
                            //setmissへ移動
                            request.getRequestDispatcher("./WEB-INF/zaiko/setmiss.jsp").forward(request, response);
                                                        
                        }finally{
                            if(db_con != null){
                                try {
                                    db_con.close();
                                } catch (SQLException ex) {
                                    out.println("エラー");
                        }   }   }
                        break;
                    case "set":
                        try{
                            //入力の不備チェック
                            if(request.getParameter("name")==""||request.getParameter("price")==""||request.getParameter("kazu")==""){
                            //setmissへ移動
                                request.getRequestDispatcher("./WEB-INF/zaiko/setmiss.jsp").forward(request, response);
                                break;
                            }
                            
                            //GETPOSTで登録データを受け取る
                            name=request.getParameter("name");
                            price=Integer.parseUnsignedInt(request.getParameter("price"));
                            amount =Integer.parseUnsignedInt(request.getParameter("kazu"));
                            

                            
                            
                            //ドライバ準備とmysqlログイン
                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","suzuki","minorin");

                            //データベース上での処理（コマンド
                            db_st = db_con.prepareStatement("INSERT INTO zaikoproduct(productname,productprice,amount) value(?,?,?)");    
                            db_st.setString(1,name);
                            db_st.setInt(2,price);        
                            db_st.setInt(3,amount);                           
                            //db_data = db_st.executeQuery(); //検索系で利用
                            int s =db_st.executeUpdate();//更新系で利用


                            //クローズは忘れずに行いましょう。
                            db_st.close();
                            db_con.close();
                            
                            //リクエストスコープへデータ転送
                            request.getRequestDispatcher("./WEB-INF/zaiko/set.jsp").forward(request, response);
                        
                        //途中でエラーが起きたらここへ
                        }catch (Exception ex) {
                            out.println("エラー"+ex);
                            //setmissへ移動
                            request.getRequestDispatcher("./WEB-INF/zaiko/setmiss.jsp").forward(request, response);
                                                        
                        }finally{
                            if(db_con != null){
                                try {
                                    db_con.close();
                                } catch (SQLException ex) {
                                    out.println("エラー");
                        }   }   }
                         break;
                         
                    case "view":
                        try{
                        //リクエストスコープへデータ転送用インスタンス作成
                        ProductClass[] pc = new ProductClass[20];
                        for( int i = 0; i < 19; i++){
                            pc[i] = new ProductClass(name,price,amount);
                        }

                            //ドライバ準備とmysqlログイン
                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","suzuki","minorin");

                            //データベース上での処理（コマンド
                            db_st = db_con.prepareStatement("select * from zaikoproduct");    
                            //db_st.setInt(1,id);                           
                            db_data = db_st.executeQuery(); //検索系で利用
                            //int s =db_st.executeUpdate();//更新系で利用

                            //取得データの処理
                            int i=0;
                            while(db_data.next()){
                                if(db_data.getString("productname").equals("")){
                                    //商品名がない場合の処理（後で考えます
                                }else{
                                    pc[i].setName(db_data.getString("productname"));
                                    pc[i].setPrice(db_data.getInt("productprice"));
                                    pc[i].setAmount(db_data.getInt("amount"));   
                                }
                                i++;
                            }

                            //クローズは忘れずに行いましょう。
                            db_st.close();
                            db_con.close();
                            
                            //リクエストスコープへデータ転送
                            request.setAttribute("productdata", pc);
                            request.getRequestDispatcher("./WEB-INF/zaiko/view.jsp").forward(request, response);
                            
                        //途中でエラーが起きたらここへ
                        }catch (Exception ex) {
                            out.println("エラー"+ex);
                        }finally{
                            if(db_con != null){
                                try {
                                    db_con.close();
                                } catch (SQLException ex) {
                                    out.println("エラー");
                        }   }   }
                        break;
                        
                    case "logout":
                        out.print("logout");
                        HttpSession s =request.getSession();
                        s.invalidate();
                        response.sendRedirect("./zaiko/top.html");
                        break;
                    case "modoru":
                        request.getRequestDispatcher("./WEB-INF/zaiko/home.jsp").forward(request, response);
                        break;
                    default:
                        out.print("不正アクセスエラー:default");
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
