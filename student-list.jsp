<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>StudentLogin</title>
</head>
<body>
  <header>
         <nav class="navbar navbar-expand-md navbar-dark"
              style="background-color:tomato">
              
              <ul class="navbar-nav">
                   <li><a href=<%=request.getContextPath() %>/list"
                       class="nav-link">Student</a></li>
              </ul>
                   
              
</nav>
</header>
<br>
<div class="row">
      <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
      
      <div class="container">
         <h3 class="text-center">List of Students</h3>
         <hr>
         <div class="container text-Left">
         <a href="<%=request.getContextPath() %>/new" class="btn btn-success">Add New Student</a>
         </div>
         <br>
         <table class="table table-bordered">
             <thead>
                   <tr>
                       <th>ID</th>
                       <th>Name</th>
                       <th>Date_Of_Birth</th>
                       <th>Date_Of_Joining</th>
                   </tr>
              </thead>
              <tbody>
                   <!-- for(ToDo todo: todos){ -->
                   <c:forEach var="student" items="${listStudent }">
                        <tr>
                            <td><c:out value="${student.id}"/></td>
                            <td><c:out value="${student.name}"/></td>
                            <td><c:out value="${student.date_of_birth}"/></td>
                            <td><c:out value="${student.date_of_joining}"/></td>
                            <td><a href="edit?id=<c:out value='${student.id}'/>">Edit</a>
                                  &nbsp;&nbsp;&nbsp;&nbsp;<a
                                  href="delete?id=<c:out value='${student.id}'/>">Delete></a>
                            </td>
                        </tr>
                    </c:forEach>
                    <!-- } -->
                </tbody>
          </table>      
                   
      </div>
</div>
</body>
</html>