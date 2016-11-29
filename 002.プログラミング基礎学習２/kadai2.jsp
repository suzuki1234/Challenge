<%
char st = 'あ';
String message = "";

	switch(st) {
        case 'A':
            message = "英語";
            break;
        case 'あ':
            message = "日本語";
            break;
        default:
            message = "";
            break;
    }
    out.println(message);

%>

