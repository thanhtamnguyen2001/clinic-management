<%-- 
    Document   : logo
    Created on : Aug 1, 2022, 7:54:42 PM
    Author     : Thanh_Tam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ page import = "java.util.ResourceBundle" %>

<!-------------------------------- properties file variables --------------------------------->
<% ResourceBundle resource = ResourceBundle.getBundle("images");
        String logo = resource.getString("cloudinary.logo");
        String email = resource.getString("email");
        String phone = resource.getString("phone");
%>

<div class="row">
        <div class="col-md-4 col-xs-12">
                <img src="<%=logo%>" width="200"  />
        </div>
        <div class="col-md-8 col-xs-12">
                <h1 class="text-danger">QUAN LY PHONG MACH</h1>
        </div>
</div>