<%@ page import="com.academy.service.BookService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<html>
<head>
    <title>Title</title>
    <script>
        function test() {

        }
    </script>
</head>
    <body>
        <c:set var="bookService" value="BookService"></c:set>

        <c:if test='${fn:contains("Hello world", "hello")}'>
            contains
        </c:if>

        <c:forEach items="${requestScope.books}" var="book">
            <a href="http://localhost:8080/book?id=${book.id}"> ${book.title} </a>

            <c:choose>
                <c:when test="${book.year > 100 && book.year < 2000}">
                    антиквариат
                </c:when>
                <c:otherwise>
                    дешевка
                </c:otherwise>
            </c:choose>
            <br>
        </c:forEach>

        <input type="button" onclick="test()">
    </body>
</html>
