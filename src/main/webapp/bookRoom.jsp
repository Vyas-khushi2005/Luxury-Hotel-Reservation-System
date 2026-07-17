<%@ page session="true" %>

<%
if(session.getAttribute("email")==null)
{
    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Room</title>

<link rel="stylesheet" href="css/style.css">

</head>
<body>

<div class="booking-page">

<div class="booking-card">

<h1>Luxury Hotel</h1>

<h2>Room Booking Form</h2>

<form action="book" method="post">

<input type="text"
name="userName"
placeholder="Enter Your Name"
required>

<select name="roomType">

<option>Standard Room - Rs 1500</option>

<option>Deluxe Room - Rs 3000</option>

<option>Suite Room - Rs 5000</option>

</select>

<label>Check In Date</label>

<input type="date"
name="checkIn"
required>

<label>Check Out Date</label>

<input type="date"
name="checkOut"
required>

<button type="submit">
Book Room
</button>

</form>

<br>

<a href="dashboard.jsp" class="back-link">
Back To Dashboard
</a>

</div>

</div>

</body>
</html>