<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="talen.Berichten" />
<!DOCTYPE html>
<html lang="${language}">
    <head>
        <link href="CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
        <div class="headerWidget" align="right">
        <form>
            <select id="language" name="language" onchange="submit()">
                <%
                    String a = session.getAttribute("language").toString();
                    if(a.contains("en")){
                %>
                <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                <option value="nl" ${language == 'nl' ? 'selected' : ''}>Nederlands</option>
                <%
                    }else{
                %>                
                <option value="nl" ${language == 'nl' ? 'selected' : ''}>Nederlands</option>
                <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                <%
                    }
                %>
            </select>
        </form>
        </div>
        </div>
    </body>
</html>