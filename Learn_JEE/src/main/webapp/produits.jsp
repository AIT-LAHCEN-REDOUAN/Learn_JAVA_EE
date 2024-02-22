<%--
  Created by IntelliJ IDEA.
  User: aitlh
  Date: 2/17/2024
  Time: 5:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="MVC_JDBC.web.ProduitModel" %>
<%@ page import="MVC_JDBC.metier.entities.Produit" %>
<%@ page import="java.util.List" %>






<html>
<head>
    <title>Title</title>
    
</head>
<body>

<div class="container col-md-10 col-md-offset-1">
    <div class="panel panel-primary">
        <div class="panel-heading">
            Recherche des Produits
        </div>
        <br>
        <form action="Chercher.do" method="get">
            <label>Mot Cle</label>
            <br>
            <input class="form-control" type="text" name="motCle"/>
            <br>
            <button type="submit" class="btn btn-primary">Chercher</button>
        </form>

        <table class="table table-stripped" >
            <tr>
                <th>ID</th>
                <th>Designation</th>
                <th>Prix</th>
                <th>Quantite</th>
            </tr>


            <%
                ProduitModel model = (ProduitModel) request.getAttribute("model");
                if (model != null) {
                    List<Produit> produits = model.getProduits();
                    if (produits != null) {
                        for (Produit produit : produits) {
            %>
            <tr>
                <td><%=produit.getId()%></td>
                <td><%= produit.getDesignation()%></td>
                <td><%= produit.getPrix()%></td>
                <td><%= produit.getQuantite()%></td>
            </tr>
            <%
                        }
                    }
                }
            %>
        </table>

    </div>

</div>




























<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

</body>
</html>
