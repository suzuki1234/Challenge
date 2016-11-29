<%
//値を受け取る
	int kazu = Integer.valueOf(request.getParameter("param"));

//変数の定義
	String msg = "";
	int sosuu[] = {2,3,5,7};
	int ff = 0;
	int motokazu =kazu;

	while(ff!=4){
		ff=0;
		for(int i=0;i<=3;i++){
			if(kazu % sosuu[i] == 0){
				kazu = kazu/sosuu[i];
				msg = msg + String.valueOf(sosuu[i]) + " ";
			}else{
				ff = ff + 1;
			}


		}

	}

    out.println("元の数："+ motokazu);
    out.println("１桁の素因数：" +msg );
    out.println("その他：" + kazu);







%>
