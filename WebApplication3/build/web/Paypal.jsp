<%-- 
    Document   : Paypal
    Created on : 24-mei-2015, 12:01:59
    Author     : jeffrey
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>JSP Page</title>
    </head>
    <body>
<!--    <script language="javascript">
        function Payment()
        {
            if(request.getattribute("return")!== null)
            {
            out.print("hoi");
            }
        }
            
        </script>-->


<!--    Paypal Test Account
        Email:      JantjeContantje@Sandbox.nl  
        Password:   Sandbox013-->

    <!--Paypal information-->
     <form name="_xclick" target="paypal" action="https://www.sandbox.paypal.com/us/cgi-bin/webscr" method="post" >
    <input type="hidden" name="cmd" value="_cart">
    <input type="hidden" name="upload" value="1">
    <input type="hidden" name="business" value="Townofsalem@Sandbox.nl">
    <input name="return" type="hidden" value="http://localhost:8080/PaypalTest/Paypal.jsp"  ><!-- Return URL -->
    <input name="cancel_return" type="hidden" value="http://localhost:8080/PaypalTest/Paypal.jsp"> <!-- Return URL on cancelling payment --> 
    <input type="hidden" name="no_shipping" value="0">
    <input type="hidden" name="no_note" value="1">
    <input type="hidden" name="currency_code" value="USD">
    <input type="hidden" name="lc" value="AU">
    <input type="hidden" name="bn" value="PP-BuyNowBF">
    <input type="hidden" name="rm" value="2">
    <!--Items will be shown in the shopping cart-->
    <!--TODO: Gather items from a list:-->
    <%  
    int productnummer=1;
    ArrayList<String> Productlist = new ArrayList<String>();
    Productlist.add("Book/0.01/2");
    Productlist.add("Cat/0.01/1");
                        
    for(String s : Productlist)
    {
    %>
    
    <input type="hidden" name="item_name_<%=productnummer%>" value=<%=s.substring(0,s.indexOf("/"))%>>  
    <input type="hidden" name="amount_<%=productnummer%>" value=<%=s.substring(s.indexOf("/")+1,s.lastIndexOf("/"))%>>
    <input type="hidden" name="quantity_<%=productnummer%>" value=<%=s.substring(s.lastIndexOf("/")+1)%>>
    
<!--<input type="hidden" name="item_name_1" value="HTML book">  
    <input type="hidden" name="amount_1" value="24.99">
    <input type="hidden" name="quantity_1" value="2">-->
    
<!--<input type="hidden" name="item_name_2" value="Cat">
    <input type="hidden" name="amount_2" value="19.99">
    <input type="hidden" name="quantity_2" value="2">-->
    <% productnummer++;
    
//  Check if form has been submitted (Check if paid)
    if("POST".equalsIgnoreCase(request.getMethod()))
    {
        out.print("Ik ben hier geweest");
    }
    }%>

    <input type="image" src="https://www.paypalobjects.com/en_US/i/btn/x-click-but6.gif" border="0" name="submit" alt="PayPal - The safer, easier way to pay online.">
<!--    <img alt="" border="0" src="https://www.paypal.com/en_AU/i/scr/pixel.gif" width="1" height="1">-->
    
    
</form>
        
    </body>
</html>
