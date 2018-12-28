<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Liste des arbitres</title>
 <link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
 <script src="../webjars/jquery/3.0.0/jquery.min.js" ></script>
</head>
<body>
 <div class="container">
  <h2>Liste des arbitres</h2>
  <table class="table table-striped">
   <thead>
    <tr>
     <th scope="row">Prénom</th>
     <th scope="row">Nom</th>
     <th scope="row">Age</th>
     <th scope="row">Taille</th>
     <th scope="row">Date de naissance</th>
     <th scope="row">Modifier</th>
     <th scope="row">Supprimer</th>
    </tr>
   </thead>
   <tbody>
    <c:forEach items="${arbitre_list }" var="arbitre" >
     <tr>
      <td>${arbitre.prenom }</td>
      <td>${arbitre.nom }</td>
      <td>${arbitre.age }</td>
      <td>${arbitre.taille } cm</td>
      <td>${arbitre.dateNaissance }</td>
      <td>
       <spring:url value="/arbitre/update/${arbitre.idArbitre }" var="updateURL" />
       <a class="btn btn-primary" href="${updateURL }" role="button">Modifier</a>
      </td>
      <td>
       <spring:url value="/arbitre/delete/${arbitre.idArbitre }" var="deleteURL" />
       <a class="btn btn-primary" href="${deleteURL }" role="button">Supprimer</a>
      </td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
  <spring:url value="/arbitre/add" var="addURL" />
  <a class="btn btn-primary" href="${addURL }" role="button">Ajouter</a>
 </div>
</body>
</html>