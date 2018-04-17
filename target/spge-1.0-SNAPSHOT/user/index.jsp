<%-- 
    Document   : index
    Created on : 12/04/2018, 14:10:14
    Author     : Tom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <!-- Head -->
    <jsp:include page="include/head.jsp"/>

    <body class="fixed-nav sticky-footer bg-dark" id="page-top">
        <!-- Navigation-->
        <jsp:include page="include/nav.jsp"/>

        <div class="content-wrapper">
            <!-- Footer -->
            <jsp:include page="include/footer.jsp"/>
            <!-- Scroll To Top Button -->
            <jsp:include page="include/topbutton.jsp"/>
            <!-- Logout Modal -->
            <jsp:include page="include/logout.jsp"/>

            <!-- JS -->
            <jsp:include page="include/script.jsp"/>
        </div>
    </body>
</html>

