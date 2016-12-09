package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class kadai12_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>データ送信</h1>\n");
      out.write("        ");

        //<!--DB現在情報を表示-->
        Connection db_con = null;
        PreparedStatement db_st =null;
        ResultSet db_data = null;
        
        try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","suzuki","minorin");
        
        
        db_st = db_con.prepareStatement("select * from profiles");               
        db_data = db_st.executeQuery(); //検索系で利用
        
        
      out.write("\n");
      out.write("        \n");
      out.write("        <h3>現在のデータ</h3>\n");
      out.write("        <Table Border=\"1\" Bordercolor=\"#0F0\" Cellspacing=\"0\">\n");
      out.write("            <Tr>\n");
      out.write("            <Td>ID</Td><Td>名前</Td><Td>電話番号</Td><Td>年齢</Td><Td>誕生日</Td> </Tr>\n");
      out.write("            \n");
      out.write("        ");

        while(db_data.next()){
            out.print("<Tr>");
            out.print("<Td>");
            out.print(db_data.getString("profilesID"));
            out.print("</Td><Td>");
            out.print(db_data.getString("name"));
            out.print("</Td><Td>");
            out.print(db_data.getString("tell"));
            out.print("</Td><Td>");
            out.print(db_data.getString("age"));
            out.print("</Td><Td>");
            out.print(db_data.getString("birthday"));
            out.print("</Td>");
            out.print("</Tr>");
        }
        
        //データベースをクローズする。
        db_con.close();
        
        }catch (SQLException ex) {
            out.println("sqlエラー");
        }finally{
            if(db_con != null){
                try {
                    db_con.close();
                } catch (SQLException ex) {
                    out.println("エラー");
                    
                }
            }
        }
        
      out.write("\n");
      out.write("\n");
      out.write("            </Table>\n");
      out.write("        \n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <h3>検索フォーム</h3>\n");
      out.write("        <form action=\"./kadai12\" method=\"post\">\n");
      out.write("            <Table Border=\"1\" Bordercolor=\"#F00\" Cellspacing=\"0\">\n");
      out.write("            <Tr>\n");
      out.write("                <Td>名前</Td>       <Td><input type=\"text\" name=\"txtName\" value=\"\"></Td> </Tr>\n");
      out.write("            <Tr>\n");
      out.write("            <Td>電話番号</Td>   <Td><input type=\"text\" name=\"txtTell\" value=\"\"></Td> </Tr>\n");
      out.write("            <Tr>\n");
      out.write("            <Td>年齢</Td>       <Td><input type=\"text\" name=\"txtAge\" value=\"\"></Td> </Tr>\n");
      out.write("            <Tr>\n");
      out.write("            <Td>誕生日</Td>     <Td><input type=\"text\" name=\"txtBirthday\" value=\"\"></Td> </Tr>\n");
      out.write("            </Table>\n");
      out.write("            <input type=\"submit\" value=\"登録\">\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
