<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

		  <title>Edit Page</title>
		  <meta charset="utf-8">
		  <meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
	${message}
	  <h2>Edit Form</h2>
	  <img src="images/edit.jpg" alt="registration logo" style="height:150px">
	  <form action="updateEmployee" method="post">
	    
	    <div class="form-group">
	      <label for="empId">Employee Id:</label>
	      <input type="number" class="form-control" value="${employeeDTO.employeeId}" name="employeeId" readonly>
	    </div>
	    
	    <div class="form-group">
	      <label for="empName">Employee Name:</label>
	      <input type="text" class="form-control" value="${employeeDTO.employeeName}" name="employeeName">
	    </div>
	    
	    <div class="form-group">
	      <label for="salary">Salary:</label>
	      <input type="text" class="form-control" value="${employeeDTO.salary}" name="salary">
	    </div>
	    
	    <div class="form-group">
	      <label for="emailId">Email Id:</label>
	      <input type="text" class="form-control" value="${employeeDTO.emailId}" name="emailId">
	    </div>
	    
	    <div class="form-group">
	      <label for="pwd">Password:</label>
	      <input type="password" class="form-control" value="${employeeDTO.password}" name="password">
	    </div>
	    
	  
	    
	         <button type="submit" class="btn btn-primary">Update</button>
	        
	  </form>
	</div>

</body>
</html>