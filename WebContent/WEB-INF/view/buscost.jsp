<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
    <meta charset="ISO-8859-1">
    <title>Yes</title>
    <style>
        .table	{
            border: 2px solid black;
        		}
        .table thead th	{
            border-bottom: 2px solid black;
        				}
    </style>
</head>
<body>
        <div class="container col-sm-6 align-items-center mt-5">
        <table class="table">
                <thead>
                  		<tr>
                        <th>BUS</th>
                        <th>TIMING</th>
                        <th>TICKET COST</th>
                  		</tr>
                </thead>
                <tbody>
                  <tr>
                        <td>PRIVATE BUS</td>
                        <td>${pvt}</td>
                        <td>Rs.${pmoney}</td>
                  </tr>
                  <tr>
                        <td>GOVERNMENT BUS</td>
                        <td>${gbt}</td>
                        <td>Rs.${gmoney}</td>
                  </tr>
                  <tr>
                        <td>AIRBUS</td>
                        <td>${abt}</td>
                        <td>Rs.${amoney}</td>
                  </tr>
                </tbody>
              </table>
            </div>
        </div>
            
    <!-- <table border="1px">
        <tr>
            <th>BUS</th>
            <th>TIMING</th>
            <th>MONEY</th>
        </tr>
        <tr>
            <td>PRIVATE BUS </td>
            <td>${pvt}</td>
            <td> Rs.${pmoney}</td>
        </tr>
        <tr>
            <td>GOVERNMENT BUS </td>
            <td>${gbt}</td>
            <td> Rs.${gmoney}</td>
        </tr>
        <tr>
            <td>AIRBUS </td>
            <td>${abt}</td>
            <td> Rs.${amoney}</td>
        </tr>
    </table> -->
</body>
</html>