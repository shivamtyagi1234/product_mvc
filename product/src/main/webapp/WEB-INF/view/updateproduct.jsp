<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="base.jsp" />
 <%@ page isELIgnored="false" %>
</head>
<body>
<title>${title }</title>
<form action="${pageContext.request.contextPath }/update-product" method="post">
<div class="text-center">
<h2>Change Product Details</h2>
 <div class="form-group col-md-8 offset-md-2">
    <input type="hidden" class="form-control" placeholder="Enter Product Name" name="id" value="${product.id}">
  </div>
  <div class="form-group col-md-8 offset-md-2">
    <label>Product Name</label>
    <input type="text" class="form-control" placeholder="Enter Product Name" name="name" value="${product.name}">
  </div>
  <div class="form-group col-md-8 offset-md-2">
  <label>Product Description</label>
    <div class="md-form mb-4 pink-textarea active-pink-textarea">
  <textarea class="md-textarea form-control" rows="6" name="description" placeholder="Enter Product Description" >${product.description}</textarea>
  
</div>
  </div>
    <div class="form-group col-md-8 offset-md-2">
    <label>Product Price</label>
    <input type="text" class="form-control" placeholder="Enter Product Price" name="price"  value="${product.price}">
  </div>
  <div class="row col-md-8 offset-md-2 mt-2">
  <a href="${pageContext.request.contextPath }/">
  <button type="button" class="btn btn-primary">Back</button>
  </a>
  <button type="update" class="btn btn-warning ml-4">Submit</button>
  </div>
  </div>
  </form>
  </body>
  </html>