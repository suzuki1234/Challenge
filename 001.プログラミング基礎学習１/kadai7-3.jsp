<%
// 変数作成
	String sougaku = request.getParameter("param1");
    String kosuu = request.getParameter("param2");
    String syubetu = request.getParameter("param3");

	int a =	Integer.valueOf(sougaku);
//	int b =	Integer.valueOf(kosuu);
//	int c =	Integer.valueOf(syubetu);

//チェック
	if(a >= 5000){
		out.println(a+"円購入したので");
		out.println(a*0.05 + "円のポイントが付きます。");
	}else{
		if(a >= 3000){
			out.println(a+"円購入したので");
			out.println(a*0.04 + "円のポイントが付きます。");
		}else{
			out.println(a+"円の購入ではポイントは付きません。");
		}
	}




%>

