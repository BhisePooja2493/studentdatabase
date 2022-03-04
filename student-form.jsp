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
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
               <c:if test="${student != null }">
                   form action="update" method="post">
               </c:if>
               <c:if test="${student == null }">
                   form action="insert" method="post">
               </c:if>
               <caption>
                      <h2>
                        <c:if test="${student != null }">
                          Edit Student
               </c:if>
               <c:if test="${student == null }">
                   Add New Student
               </c:if>    
                </h2>
              </caption>
              
              <c:if test="${student != null }">
                  <input type="hidden" name="id" value="<c:out value='${student.id }'/>"/>
               </c:if>
               
               <fieldset class="form-group">
                    <lable>Student Name</lable> <input type="text"
                           value="<c:out value='${student.name }'/>" class="form-control"
                           name="name" required="required">
               </fieldset>   
                  
              <fieldset class="form-group">
                    <lable>Student Date_Of_Birth</lable> <input type="text"
                           value="<c:out value='${student.date_of_birth }'/>" class="form-control"
                           name="date_of_birth">
               </fieldset>  
               
               <fieldset class="form-group">
                    <lable>Student Date_Of_Joining</lable> <input type="text"
                           value="<c:out value='${student.date_of_joining }'/>" class="form-control"
                           name="date_of_joining">
               </fieldset>  
               
               <button type="submit" class="btn btn-success">Save
               </button>
               </form>
               
           </div>
      </div>
  </div>
</body>
</html>