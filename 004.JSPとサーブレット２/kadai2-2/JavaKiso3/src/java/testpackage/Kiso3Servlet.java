/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author suzuki
 */
public class Kiso3Servlet extends HttpServlet {

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
            out.println("<title>Servlet Kiso3Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>課題1</h1>");
            for(int i = 0; i<10;i++){
                    kadai1(out);
            }
            
            out.println("<h1>課題2</h1>");
            for(int i = 0; i<10;i++){
                kadai2(i,out);
            }
            
            out.println("<h1>課題3</h1>");
            out.println(kadai3(2,5,true));
            out.println(kadai3(2,7));
            out.println(kadai3(12));
            
            out.println("<h1>課題4</h1>");
            kadai4(out);
            
            out.println("<h1>課題5</h1>");
            kadai5(out);
            
            out.println("<h1>課題6</h1>");
            for(int i = 0; i<=2;i++){
            kadai6(i,out);
            }
            
            out.println("<h1>課題7</h1>");
            kadai7(out);
            
            out.println("<h1>課題8</h1>");
            kadai8(out);
            
            out.println("</body>");
            out.println("</html>");
        }
        


    }

    
    void kadai8(PrintWriter out){
        int limit = 2;
        
        String data[][]={{"田中","1/1","北海道"},{"佐藤","5/5",null},{"タオ","6/7","オーストラリア"}};
        
        for (int j =0; j<=2;j++ ){
            for (int i =0; i<=2;i++ ){
                if(data[j][2]==null){
                    continue;
                }
                out.println(data[j][i]);
            }
            if(j==limit-1){
                break;
            }
        }
    } 
    
    void kadai7(PrintWriter out){
        String data[][]={{"田中","1/1","北海道"},{"佐藤","5/5",null},{"タオ","6/7","オーストラリア"}};
        
        for (int j =0; j<=2;j++ ){
            for (int i =0; i<=2;i++ ){
                if(data[j][2]==null){
                    continue;
                }
                out.println(data[j][i]);
            }
        }
    }   
    void kadai6(int id , PrintWriter out){
        String data[][]={{"田中","1/1","北海道"},{"佐藤","5/5","茨木"},{"タオ","6/7","オーストラリア"}};
        for (int i =0; i<=2;i++ ){
            out.println(data[id][i]);
        }
    }
    
    void kadai5(PrintWriter out){
        String data[] = {"田中","1/1","北海道"};
        for (int i =0; i<=2;i++ ){
            out.println(data[i]);
        }
    }
    
    
    void kadai4(PrintWriter out){
        if(kadai4_1(out)){
            out.print("この処理は正しく実行できました");
        }else{
            out.print("正しく実行できませんでした");
        }
    }
    
    boolean kadai4_1(PrintWriter out){
        out.print("名前：鈴木健吾<br>");
        out.print("生年月日：5/11<br>");
        out.print("自己紹介：趣味は読書です。<br>");
        return true;
    }    
    
    String kadai3(Integer AAA, Integer BBB , boolean type) {
        int x=AAA*BBB;
        if(type){
            return String.valueOf(x);
        }else{
            return String.valueOf(x*x);
        }
    }
    String kadai3(Integer AAA, Integer BBB) {
        return kadai3(AAA,BBB,false);
    }    
    String kadai3(Integer AAA) {
        return kadai3(AAA,5,false);
    }    
    
    void kadai2(int n,PrintWriter out){
        if(n%2 == 0 ){
            out.print( String.valueOf(n) + "は偶数です。");
        }else{
            out.print( String.valueOf(n) + "は奇数です。");    
        }
    }

    void kadai1(PrintWriter out){
        out.print("名前：鈴木健吾<br>");
        out.print("生年月日：5/11<br>");
        out.print("自己紹介：趣味は読書です。<br>");
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
