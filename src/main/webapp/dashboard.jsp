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
<title>Dashboard</title>

<link rel="stylesheet" href="css/style.css">

</head>
<body>

<!-- Navbar -->

<div class="navbar">

<div class="logo">
Luxury Hotel
</div>

<div class="nav-links">

<a href="index.jsp">Home</a>
<a href="dashboard.jsp">Dashboard</a>
<a href="bookRoom.jsp">Book Room</a>
<a href="myBookings.jsp">My Bookings</a>
<a href="logout">Logout</a>


</div>

</div>

<!-- Dashboard Hero -->

<section class="dashboard-hero">

<h1>Welcome To Your Dashboard</h1>

<p>
Manage your bookings and enjoy a luxury hotel experience.
</p>

</section>

<!-- Dashboard Cards -->

<section class="dashboard-section">

<div class="dashboard-container">

<div class="dashboard-card">

<h2>Book Room</h2>

<p>
Reserve your favorite room quickly and easily.
</p>

<a href="bookRoom.jsp" class="dashboard-btn">
Book Now
</a>

</div>

<div class="dashboard-card">

<h2>My Bookings</h2>

<p>
View and manage all your room reservations.
</p>

<a href="myBookings.jsp" class="dashboard-btn">
View Bookings
</a>

</div>

<div class="dashboard-card">

<h2>Logout</h2>

<p>
Securely logout from your account.
</p>

<a href="logout" class="dashboard-btn">
Logout
</a>

</div>

</div>

</section>

</body>
</html>