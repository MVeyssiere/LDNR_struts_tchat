<%-- 
    Document   : template
    Created on : 23 mai 2019, 10:54:12
    Author     : Marine Veyssiere
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">  
        <title><s:text name="page.title"/></title>
    </head>
    <body>
        <section id="content">
            <jsp:include page="/WEB-INF/views/${param.content}.jsp" />
        </section>
    </body>
</html>

