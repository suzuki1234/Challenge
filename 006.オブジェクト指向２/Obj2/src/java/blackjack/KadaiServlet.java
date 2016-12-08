/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author suzuki
 */
public class KadaiServlet extends HttpServlet {

    
    
    
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet KadaiServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>ブラックジャック</h1>");
            

            //ディーラーとユーザーのインスタンス用意
            Dealer d = new Dealer();
            User u = new User();
            
            //初期配布
            d.setCard(d.deal());
            out.println("ディーラーの初手合計：");
            out.println(String.valueOf(d.open()));
            out.println("<br>");
            
            u.setCard(d.deal());
            out.println("プレイヤーの初手合計：");
            out.println(String.valueOf(u.open()));
            out.println("<br>");
            out.println("<br>");
            
//            勝負の履歴を表示する
            int check=0;
            out.println("【勝負履歴】<br>");
            while(u.checkSum() && d.checkSum()){
                
                if(u.open() <= d.open() ){
                    u.setCard(d.hit());
                    out.println("ディーラー：プレイヤー");
                    out.println(String.valueOf(d.open()));
                    out.println("：");
                    out.println(String.valueOf(u.open()));
                    out.println("<br>");
                }
                
                //敗北条件
                if(u.open() > 21){
                    break;
                }
                //勝利条件
                if(u.open() > d.open() &&  d.open() >= 17){
                    break;
                }
                
                if(17 > d.open() ){
                    d.setCard(d.hit());
                    out.println("ディーラー：プレイヤー");
                    out.println(String.valueOf(d.open()));
                    out.println("：");
                    out.println(String.valueOf(u.open()));
                    out.println("<br>");
                }
            check++;//繰り返す回数をカウントする//デバッグ用
            if(check>100){
                out.println("<h1>100</h1>");
                break;
            }
            }
            out.println("<br>");
            
//           結果を表示する
            out.println("【最終結果】<br>");
            out.println("ディーラー：");
            out.println(String.valueOf(d.open()));
            out.println("プレイヤー：");
            out.println(String.valueOf(u.open()));
            out.println("<br>");
            
//            勝敗判定
            if(u.open() < 22 && d.open() <22){  
//            2人とも２１以下の場合
                
//                同点の場合
                if(u.open()==d.open()){
                    out.println("同点です。");

                }else{
//                    片方が２１に近い場合
                    if(u.open()<d.open()){
                        out.println("ディーラーの勝利です。");
                    }else{
                        out.println("<h1>プレイヤーの勝利です。</h1>");
                    }
                }
                
            }else{
                
//                片方が21を超えた場合
                if(u.open()>d.open()){
                    out.println("ディーラーの勝利です。");
                }else{
                    out.println("<h1>プレイヤーの勝利です。</h1>");
                } 
            }

            

            
            
            out.println("</body>");
            out.println("</html>");
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
