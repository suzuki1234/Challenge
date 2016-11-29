<%
// 変数作成
	String sougaku = request.getParameter("param1");
    String kosuu = request.getParameter("param2");
    String syubetu = request.getParameter("param3");

	int a =	Integer.valueOf(sougaku);
	int b =	Integer.valueOf(kosuu);
//	int c =	Integer.valueOf(syubetu);


		out.println("総数：" + b + "コ");
		out.println("1個当たりの値段は"+a/b+"円です。");



%>

