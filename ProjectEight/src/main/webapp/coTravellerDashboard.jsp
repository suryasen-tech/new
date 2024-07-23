<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Co-Traveller Dashboard</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
    <h2>Co-Traveller Dashboard</h2>
     <h2>Welcome, ${CoTraveller.name}!</h2>
    <p>Your email: ${CoTraveller.email}</p>
    <p>Your username: ${CoTraveller.username}</p>
    
    <form action="SearchTripServlet" method="post">
        <h3>Find a New Trip</h3>
        <label>Origin: </label>
        <input type="text" name="origin" required><br>
        <label>Destination: </label>
        <input type="text" name="destination" required><br>
        <label>Date: </label>
        <input type="date" name="date" required><br>
        <input type="submit" value="Search Trip">
    </form>
    <div id="tripSearchStatus"></div>
</body>
</html>