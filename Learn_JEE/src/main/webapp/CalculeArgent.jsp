<%@ page import="com.example.learn_jee.CreditModel" %><%--
  Created by IntelliJ IDEA.
  User: aitlh
  Date: 2/9/2024
  Time: 3:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="Css/style.css">
</head>
<body>

<div class="container">
    <form action="${pageContext.request.contextPath}/CalculerArgent" class="form-control" method="get">

        <label>Montant</label>
        <br>
        <br>
        <input type="text" class="form-control" name="Montant" placeholder="Entrer le Montant" value="<%= request.getAttribute("argent") != null ? ((CreditModel) request.getAttribute("argent")).getMontant() : "0" %>" />
        <br>
        <br>
        <label>Dure</label>
        <br>
        <br>
        <input type="text" class="form-control" name="Duree" placeholder="Entrer LA duree"  value="<%= request.getAttribute("argent") != null ? ((CreditModel) request.getAttribute("argent")).getDuree() : "0" %>" />
        <br>
        <br>
        <input class="btn btn-primary" class="form-input" type="Submit" value="Calculer" />
    </form>

    <label>
        Le Montant est :
        <%= request.getAttribute("argent") != null ? ((CreditModel) request.getAttribute("argent")).getMonsualite() : "0" %>
    </label>
</div>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>