<%-- 
    Document   : studentList
    Created on : 2020-04-20, 14:44:14
    Author     : Maikeru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Java Web - laboratorium 5</title>
        <style>
        table, th, td {
          border: 1px solid black;
        }
        </style>
    </head>
    <body>
        <table border:1>
            <tr>
                <th>Imię</th>
                <th>Nazwisko</th>
                <th>Email</th>
            </tr>
            <c:forEach items="${sessionScope.lista_studentow}" var="student">
                <tr>
                    <td>${student.getFirstName()}</td>
                    <td>${student.getLastName()}</td>
                    <td>${student.getEmail()}</td>   
                </tr>
            </c:forEach>
        </table>
                
        <form action='/lab5v2/studentList' method='post'>
            Dodaj studenta:<br>
            Imię:<input type='text' name='s_imie'><br>
            Nazwisko:<input type='text' name='s_nazwisko'><br>
            Email:<input type='text' name='s_email'><br>
            <input type='submit'>
        </form>
                
        <h1>Licznik wejść na stronę: ${sessionScope.licznik}</h1>
    </body>
</html>
