<%
// 変数作成
	String sougaku = request.getParameter("param1");
    String kosuu = request.getParameter("param2");
    String syubetu = request.getParameter("param3");

//	int a =	Integer.valueOf(sougaku);
//	int b =	Integer.valueOf(kosuu);
	int c =	Integer.valueOf(syubetu);


// チェック
	if(c==1){
		out.println("雑貨");
		syubetu="雑貨";	
	}else{
		if(c==2){
			out.println("生鮮食品");
			syubetu="生鮮食品";	
		}else{
			if(c==3){
				out.println("その他");	
				syubetu="その他";
			}else{
				out.println("商品種別エラー");	
			}
		}
	}




%>

