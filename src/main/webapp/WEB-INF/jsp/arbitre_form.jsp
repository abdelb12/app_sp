<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Arbitre</title>
<link
	href="http://localhost:8080/webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script
	src="http://localhost:8080/webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="http://localhost:8080/webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<spring:url value="/arbitre/save" var="saveURL" />
		<h2>Arbitre</h2>
		<form:form modelAttribute="arbitreForm" method="post"
			action="${saveURL}" cssClass="form">
			<form:hidden path="idArbitre" />
			<div class="form-group">
				<lable for="prenom">Prénom</lable>
				<form:input path="prenom" cssClass="form-control" id="prenom" />
			</div>
			<div class="form-group">
				<lable for="nom">Nom</lable>
				<form:input path="nom" cssClass="form-control" id="nom" />
			</div>
			<div class="form-group">
				<lable for="age">Age</lable>
				<form:input path="age" cssClass="form-control" id="age" />
			</div>
			<div class="form-group">
				<lable for="taille">Taille</lable>
				<form:input path="taille" cssClass="form-control" id="taille" />
			</div>
			<div class="form-group">
				<lable for="dateNaissance">Date de naissance</lable>
				<form:input path="dateNaissance" cssClass="form-control" id="dateNaissance" />
			</div>
			<button type="submit" class="btn btn-primary">Enregistrer</button>
		</form:form>
	</div>
</body>
</html>