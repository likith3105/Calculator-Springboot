<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <title>Calculator</title></head>
<body>

<h1>Simple Calculator</h1>
    <form action="/calculate" method="get">
        <label for="operation">Select operation:</label>
        <select name="operation" id="operation">
            <option value="add">Add</option>
            <option value="subtract">Subtract</option>
            <option value="multiply">Multiply</option>
            <option value="divide">Divide</option>
        </select>
        <br>
        <label for="a">Number num1:</label>
        <input type="number" name="Enter the num1" step="0.01" required>
        <br>
        <label for="b">Number num2:</label>
        <input type="number" name="Enter the num2" step="0.01" required>
        <br>
        <button type="submit">Calculate</button>
    </form>
    <br>
    <p>Result: <span th:text="${result}">0.0</span></p>







</body>
</html>