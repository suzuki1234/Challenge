/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
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
            
            out.println("<h1>課題1</h1>");
                //いったんカレンダーに渡して生成
                Calendar cal = Calendar.getInstance();
                cal.set(2016,1,1,0,0,0);
                Date calpast = cal.getTime();
                
                //date型で表示
                out.print(calpast);
                out.print("<br>");
                
                //timestamp型で表示
                out.print(calpast.getTime());
                out.print("<br>");
 
             out.println("<h1>課題2</h1>");
                //Date型の値(現在時刻情報)の取得
                Date date = new Date();
            
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                String sdate = sdf.format(date);
                out.print(sdate);
                out.print("<br>");
  
            out.println("<h1>課題3</h1>");
                //いったんカレンダーに渡して生成
                Calendar cal2 = Calendar.getInstance();
                cal2.set(2016,11,4,10,0,0);
                Date calpast2 = cal2.getTime();

                //date型で表示
                out.print(calpast2);
                out.print("<br>");
                
                //timestamp型で表示
                out.print(calpast2.getTime());
                out.print("<br>");
            
            out.println("<h1>課題4</h1>");
                //いったんカレンダーに渡して生成　その１
                Calendar calA = Calendar.getInstance();
                calA.set(2015,1,1,0,0,0);
                Date calpastA = calA.getTime();
                
                //いったんカレンダーに渡して生成　その２
                Calendar calB = Calendar.getInstance();
                calB.set(2015,12,31,23,59,59);
                Date calpastB = calB.getTime();
                
                //long型に変換
                long dataA = calpastA.getTime();
                long dataB = calpastB.getTime();
                
                //差を表示
                out.print(dataB - dataA);
                out.print("<br>");
            
            out.println("<h1>課題5</h1>");
                // 文字列長
                String moji = "鈴木健吾";
                out.print("鈴木健吾<br>");
                out.print("文字数：");
                out.print(moji.length());
                out.print("バイト数：");
                out.print(moji.getBytes("UTF-8").length);
                out.print("<br>");
                
            out.println("<h1>課題6</h1>");
                // アドレス
                String ad ="never.odd.or.even.0000@gmail.com" ;
                out.print(ad);
                out.print("<br>");
                out.print(ad.substring(ad.indexOf("@")+1));
            
            out.println("<h1>課題7</h1>");
                //置換
                String mojiretu ="きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
                out.print("置換前：");
                out.print(mojiretu);
                out.print("<br>");
                mojiretu =mojiretu.replace("U", "う");
                mojiretu =mojiretu.replace("I", "い");
                out.print("置換後：");
                out.print(mojiretu);
                out.print("<br>");
                
            out.println("<h1>課題8</h1>");
                //同じ階層にあるファイルをオープン
                File txt = new File("test.txt");
                //追記モードでオブジェクト生成
                FileWriter fwa = new FileWriter(txt);
                //追記書き込み;
                fwa.write("私の名前は鈴木健吾です。\r");
                fwa.write("趣味はアナログゲームです。\r");
                fwa.write("よろしくお願いします。\r");               
                
                //追記クローズ
                fwa.close();
                

            out.println("<h1>課題9</h1>");
                //読み込みモードでオブジェクト生成
                FileReader fr = new FileReader(txt);
                //一行読み込みして表示
                try (//読み込み用にバッファリング(高速化)
                    BufferedReader br = new BufferedReader(fr)) {
                    //一行読み込みして表示
                        out.print(br.readLine());
                out.print("<br>");
                        out.print(br.readLine());
                out.print("<br>");
                        out.print(br.readLine());
                    //ファイルクローズ
                    fr.close();
                    }
            
            out.println("<h1>課題10</h1>");          
                char ch ='a';
                
                File logfile = new File("log.txt");

                //上書きモードでオブジェクト生成
                FileWriter fw = new FileWriter(logfile);
                //上書き書き込み
                Date dd =new Date();
                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                String sdate2 = sdf2.format(dd);
                fw.write(sdate2.toString());
                fw.write("  ---作業開始---\r");
                fw.write("実行内容：charの中身が大文字かチェックする。\r");
                fw.write("ch=" + ch + ":");
                if(Character.isUpperCase(ch)){
                    fw.write("大文字です。\r");
                }else{
                    fw.write("小文字です。\r");
                }
                Date dd2 =new Date();
                SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                String sdate3 = sdf3.format(dd);
                fw.write(sdate3.toString());
                fw.write("  ---作業終了---\r");
                //上書きクローズ
                fw.close();
                        
                String sss ;
                //読み込みモードでオブジェクト生成
                FileReader fr2 = new FileReader(logfile);
 
                //一行読み込みして表示
                try (//読み込み用にバッファリング(高速化)
                    BufferedReader br = new BufferedReader(fr2)) {
                        //一行読み込みして表示
                        while((sss =br.readLine()) != null){
                            out.print(sss);
                            out.print("<br>");
                        }
                        //ファイルクローズ
                        fr.close();
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
