<%-- 
    Document   : PaymentSucces
    Created on : 26-mei-2015, 14:16:20
    Author     : jeffrey
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Test.WinkelWagen"%>
<jsp:include page="Masterpage_final.jsp"></jsp:include>
<%@include file="TaalSettings.jsp" %>
<%@include file="TaalToggle.jsp" %>
<!DOCTYPE html>
<html lang="${language}">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Bootstrap Core CSS -->
        <link href="CSS/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="CSS/thumbnail-gallery.css" rel="stylesheet">

        <link href="CSS/justified-nav.css" rel="stylesheet">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- <title>JSP Page</title> -->
    </head>
    <body>
           <div class="container">  
        <div style="width:430px;font-size:11px;color:#333333;font-family:Trebuchet MS,Verdana,Arial,Helvetica,sans-serif;">
        
        
        
        
  <p>
      Dear <h3><%=session.getAttribute("Name")+","%></h3>
  <h2 class="form-signin-heading"><fmt:message key="PaymentSucces_Thanks"/></h2>
  
  <table style="font-size:11px;color:#333333;font-family:Trebuchet MS,Verdana,Arial,Helvetica,sans-serif;" cellspacing="4" width="420">
    <tbody>
        <%
        Test.CustomerFactuur cust = new Test.CustomerFactuur();
        double totaal=0;    
       
        
        ArrayList<Test.WinkelWagenItem> itemlist =  cust.OrdersList(request.getParameter("BestellingID"));
        for(Test.WinkelWagenItem pd : itemlist)
        {
        session.setAttribute("valuta", pd.getValuta());
        %>

        <tr><td width="200"><div align="left"><b><%=pd.getProductnaam() %> &nbsp;&nbsp;</b></div></td>
            <td width="202"><%=Math.round(pd.getPrijs()*pd.getAantal()* 100.0)/ 100.0%><%=session.getAttribute("valuta")%></td></tr>
        
        <%
        totaal=totaal+(pd.getPrijs() * pd.getAantal());
        }
            %>
                       
    
    <tr>
      <td width="200"><div align="left"><b>&nbsp;</b></div></td>
      <td width="202"><hr align="left" color="#cccccc" noshade="" size="1" width="180"></td>
    </tr>
    <tr>
      <td width="200"><div style="font-size:18px;" align="left"><b><fmt:message key="PaymentSucces_Totaal"/>:</b></div></td>
     <td width="202"><span style="font-size:18px;"><%=Math.round(totaal *100.0)/100.0%><%=session.getAttribute("valuta")%></span></td>
    </tr>  
    <tr>
      <td width="200">&nbsp;</td>
      <td width="202">&nbsp;</td>
    </tr>
    <tr>
      <td width="200"><div align="left"><b><fmt:message key="PaymentSucces_Betalingsinfo"/>:</b></div></td>
      <td width="202">&nbsp;</td>
    </tr>
    <tr>
<td width="200"><div align="left"><b>PayPal&nbsp;&nbsp;</b></div></td><td width="202"><%=Math.round(totaal*100.0)/100.0%><%=session.getAttribute("valuta")%></td>    </tr>
    <tr>
        <% Test.CustomerOrders customerorders = new Test.CustomerOrders();
%>
      <td width="200"><div align="left"><b> <%= customerorders.getOrderDatum(request.getParameter("BestellingID")) %> </b></div></td>
      <td id="Datum" width="202"></td>
    </tr>
    
  </tbody></table>
  
  </p>
  <p>
        Fotowinkel <br>
        Netherlands<br>
	M.bakirci@student.fontys.nl<br>
  </p>
</div>
           </div>
    </body>
</html>

