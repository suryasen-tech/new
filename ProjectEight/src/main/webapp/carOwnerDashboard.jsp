<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Car Owner Dashboard</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
    <h2>Car Owner Dashboard</h2>
     <h2>Welcome, ${carOwner.name}!</h2>
    <p>Your email: ${carOwner.email}</p>
    <p>Your username: ${carOwner.username}</p>
    <h3>Car Details</h3>
     <form action="CarOwnerServlet" method="post">
            <label for="ownerId">Owner ID:</label>
            <input type="text" id="ownerId" name="ownerId"><br><br>
            <label for="car_model">Car Model:</label>
            <input type="text" id="car_model" name="car_model"><br><br>
            <label for="car_number">Car Number:</label>
            <input type="text" id="car_number" name="car_number"><br><br>
            <input type="submit" value="Register Car">
        </form>
    <div id="carRegistrationStatus"></div>
    
    <form action="CreateTripServlet" method="post">
        <h3>Create a New Trip</h3>
        <label for="ownerId">Owner ID:</label>
            <input type="text" id="ownerId" name="ownerId"><br><br>
        <label>Origin: </label>
        <input type="text" name="origin" required><br>
        <label>Destination: </label>
        <input type="text" name="destination" required><br>
        <label>Date: </label>
        <input type="date" name="date" required><br>
        <input type="submit" value="Create Trip">
    </form>
    <div id="tripCreationStatus"></div>
</body>
</html>