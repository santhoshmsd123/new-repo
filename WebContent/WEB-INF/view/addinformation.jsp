<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 
<!DOCTYPE html>
<html>
<head>
<style>
body {font-family: Arial, Helvetica, sans-serif;}

input[type=text], input[type=password] ,input[type=number]{
  width:300px;
  padding:12px 300px;
  margin:8px 0;
  display:inline-block;
  border: 1px solid #ccc;
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 80px;
}

button:hover {
  opacity: 0.8;
}
.center {
  padding: 120px 70px;
  }


/* Change styles for span and cancel button on extra small screens */

</style>
</head>
<body>

<form action="addinformation" method="get" modelAttribute="addinformation">
	<table>
    <tr>
    <td><label for="PLACE"><b>PLACE</b></label></td>
    <td><input type="text" placeholder="Enter place" name="place" required><br></td>
    </tr>
    <tr>
    <td><label for="busno"><b>BUS NO</b></label></td>
    <td><input type="text" placeholder="Enter busno" name="busno" required><br></td>
    </tr>
    <tr>
    <td><label for="dis"><b>DISTANCE</b></label></td>
    <td><input type="number" placeholder="Enter distance" name="distance" required><br></td>
    </tr>
    <tr>
    <td><label for="pbt"><b>PVT BUSTIME</b></label></td>
    <td><input type="text" placeholder="Enter pvt bus time" name="pvtbustime" required><br></td>
    </tr>
    <tr>
    <td><label for="abt"><b>AIR BUSTIME</b></label></td>
    <td><input type="text" placeholder="Enter air bus time" name="airbustime" required><br></td>
    </tr>
    <tr>
    <td><label for="gbt"><b>GOVTBUSTIME</b></label></td>
    <td><input type="text" placeholder="Enter govt bus time" name="govtbustime" required><br></td>
    </tr>
    <tr>
    <td><button type="submit">submit</button></td>
    </tr>
  </table>

</form>
</body>
</html>
 