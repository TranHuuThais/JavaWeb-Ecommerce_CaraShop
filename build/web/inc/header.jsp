<%-- 
    Document   : header
    Created on : Aug 23, 2024, 11:48:10 AM
    Author     : ACER
--%>

<%@page import="thai.dev.ShopServlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<header id="header">
    <a href="index.jsp"><img src="./assets/img/logo.png" class="logo" alt="Logo"></a>
    <ul id="navbar">
        <li><a class="active" href="index.jsp">Home</a></li>
        <li> 
            <a href="<%= request.getContextPath()%>/ShopServlet">Shop</a>
            <ul class="sub-menu">
                <c:forEach items="${categoryList}" var="category">
                    <li class="menu-item">
                        <a href="CategoryServlet?categoryId=${category.id}">${category.name}</a>
                    </li>
                </c:forEach>
            </ul>
        </li>
        <li><a href="<%= request.getContextPath()%>/BlogServlet">Blog</a></li>
        <li><a href="<%= request.getContextPath()%>/AboutServlet">About</a></li>
        <li><a href="<%= request.getContextPath()%>/ContactServlet">Contact</a></li>
        <li><a href="<%= request.getContextPath()%>/CartServlet"><i class="fa-solid fa-bag-shopping"></i></a></li>
        <li>
<!--     <a href="<%= request.getContextPath()%>/LoginServlet""><i class="fa-solid fa-user"></i></a>-->
            <c:if test="${sessionScope.user == null}">
                <a href="<%= request.getContextPath()%>/LoginServlet"> Login</a>
            </c:if>
            <c:if test="${sessionScope.user != null}">
                <a href="<%= request.getContextPath()%>/LogoutServlet">Logout</a>
            </c:if>
        </li>
    </ul>
</header>

