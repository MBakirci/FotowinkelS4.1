<%-- 
    Document   : ToggleTest
    Created on : 20-May-2015, 10:06:35
    Author     : Coen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%String currentURL = request.getServletPath();
            session.setAttribute("view", currentURL); %>
            
        <c:if test="${!empty language}">
        <fmt:setLocale value="${language}" scope="session" />
        </c:if>
            
        <div class="headerWidget">
            <%-- language selection widget --%>
            <c:choose>
                <%-- When user hasn't explicitly set language,render toggle according to browser's preferred locale --%>
                <c:when test= "${empty sessionScope['javax.servlet.jsp.jstl.fmt.locale.session']}">>
                    <c:choose>
                        <c:when test="${pageContext.request.locale.language ne 'nl'}">
                            english
                        </c:when>
                        <c:otherwise>
                            <c:url var="url" value="chooseLanguage">
                                <c:param name="language" value="en"/>
                            </c:url>
                            <div class="bubble"><a href="${url}">english</a></div>
                        </c:otherwise>
                    </c:choose> | 
                    <c:choose>
                        <c:when test="${pageContext.request.locale.language eq 'nl'}">
                            nederlands
                        </c:when>
                        <c:otherwise>
                            <c:url var="url" value="chooseLanguage">
                                <c:param name="language" value="nl"/>
                            </c:url>
                            <div class="bubble"><a href="${url}">nederlands</a></div>
                        </c:otherwise>
                    </c:choose>
                </c:when>
                            
                <%-- Otherwise, render widget according to the set locale --%>
                <c:otherwise>
                    <c:choose>
                        <c:when test="${sessionScope['javax.servlet.jsp.jstl.fmt.locale.session'] ne 'nl'}">
                            english
                        </c:when>
                        <c:otherwise>
                            <c:url var="url" value="chooseLanguage">
                                <c:param name="language" value="en"/>
                            </c:url>
                            <div class="bubble"><a href="${url}">english</a></div>
                        </c:otherwise>
                    </c:choose> | 
                    <c:choose>
                        <c:when test="${sessionScope['javax.servlet.jsp.jstl.fmt.locale.session'] eq 'nl'}">
                            nederlands
                        </c:when>
                        <c:otherwise>
                            <c:url var="url" value="chooseLanguage">
                                <c:param name="language" value="nl"/>
                            </c:url>
                            <div class="bubble"><a href="${url}">nederlands</a></div>
                        </c:otherwise>
                    </c:choose>
                </c:otherwise>
            </c:choose>
                                        
        </div> 
    </body>
</html>
