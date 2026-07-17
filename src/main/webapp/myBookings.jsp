<%@ page import="java.util.ArrayList" %>
<%@ page import="com.hotel.dao.BookingDAO" %>
<%@ page import="com.hotel.model.Booking" %>

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
<title>My Bookings</title>

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
        <a href="logout">Logout</a>
    </div>

</div>

<!-- Main Content -->

<div class="booking-container">

    <h1 class="booking-title">
        My Bookings
    </h1>

    <%
    String msg = request.getParameter("msg");

    if("success".equals(msg))
    {
    %>

    <div class="booking-success">
        Booking Successful
    </div>

    <%
    }
    %>

    <!-- Search Bar -->

    <div style="text-align:center; margin-bottom:25px;">

        <input
        type="text"
        id="searchInput"
        placeholder="Search by Name, Room Type or Date..."
        style="
        width:400px;
        padding:12px;
        border:1px solid #ccc;
        border-radius:10px;
        font-size:16px;">

    </div>

    <table class="booking-table" id="bookingTable">

        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Room</th>
            <th>Price</th>
            <th>Check In</th>
            <th>Check Out</th>
            <th>Action</th>
        </tr>

        <%

        BookingDAO dao = new BookingDAO();

        ArrayList<Booking> list = dao.getAllBookings();

        for(Booking b : list)
        {
        %>

        <tr>

            <td><%= b.getBookingId() %></td>

            <td><%= b.getUserName() %></td>

            <td><%= b.getRoomType() %></td>

            <td>Rs <%= b.getPrice() %></td>

            <td><%= b.getCheckIn() %></td>

            <td><%= b.getCheckOut() %></td>

            <td>

                <a class="delete-btn"
                   onclick="return confirm('Delete this booking?')"
                   href="deleteBooking?id=<%= b.getBookingId() %>">

                    Delete

                </a>

            </td>

        </tr>

        <%
        }
        %>

    </table>

    <br>

    <a href="dashboard.jsp" class="back-btn">
        Back To Dashboard
    </a>

</div>

<script>

document.getElementById("searchInput")
.addEventListener("keyup", function(){

    let filter =
    this.value.toLowerCase();

    let rows =
    document.querySelectorAll(
    "#bookingTable tr"
    );

    for(let i=1;i<rows.length;i++)
    {
        let text =
        rows[i].innerText.toLowerCase();

        if(text.includes(filter))
        {
            rows[i].style.display="";
        }
        else
        {
            rows[i].style.display="none";
        }
    }

});

</script>

</body>
</html>