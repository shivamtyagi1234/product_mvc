<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="base.jsp" />
</head>
<body>
<title>${title }</title>
<form action="registration" method="post">
<div class="text-center">
<h2>Product Add Form</h2>
  <div class="form-group col-md-8 offset-md-2">
    <label>Product Name</label>
    <input type="text" class="form-control" placeholder="Enter Product Name" name="name">
  </div>
  <div class="form-group col-md-8 offset-md-2">
  <label>Product Description</label>
    <div class="md-form mb-4 pink-textarea active-pink-textarea">
  <textarea class="md-textarea form-control" rows="6" placeholder="Enter Product Description" name="description"></textarea>
  
</div>
  </div>
  
   <div class="form-group col-md-8 offset-md-2">
    <label>Product Price</label>
    <input type="text" class="form-control" placeholder="Enter Product Price" name="price">
  </div>
  <div class="row col-md-8 offset-md-2 mt-2">
  <a href="${pageContext.request.contextPath }/">
 <button type="button" class="btn btn-primary">Back</button>
 </a>

 <button type="submit" class="btn btn-success ml-4">Submit</button>

  </div>
  </div>
</form>
</body>
</html>