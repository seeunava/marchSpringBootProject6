<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Search Employee</title>
</head>
<body>
    <h2>Search Employee</h2>
    <form action="search" method="get">
        <input type="text" name="employeeId" placeholder="Enter Employee Id">
        <button type="submit" class="btn btn-primary">Search</button>
    </form>
    <c:if test="${not empty employeeDTO}">
        <p>Employee Details:</p>
        <p>Employee ID: ${employeeDTO.employeeId}</p>
        <p>Employee Name: ${employeeDTO.employeeName}</p>
        <p>Email ID: ${employeeDTO.emailId}</p>
        <p>Department: ${employeeDTO.department}</p>
    </c:if>
    <c:if test="${empty employeeDTO}">
        <p>No employee found with the specified EmployeeId.</p>
    </c:if>
    <br>
    <a href="fetchAllRecords">Fetch All Records</a>
    <a href="logout">Logout</a>
</body>
</html>
