<%
int num = 2; String message = "";
    switch(num) {
        case 1:
            message = "one";
            break;
        case 2:
            message = "tow";
            break;
        default:
            message = "想定外";
            break;
    }
    out.println(message);

%>

