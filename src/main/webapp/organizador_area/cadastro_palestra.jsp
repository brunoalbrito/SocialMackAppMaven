<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url="/template/header_post_login_organizador.jsp"/>

    <form method="POST" action="${pageContext.request.contextPath}/FrontController">
        <p>
            <input type="text" id="tema" name="tema" placeholder="tema">
        </p>
        <p>
            <input type="text" id="codigo" name="codigo" placeholder="codigo">
        </p>
        <input type="hidden" name="ctrl" value="RegistrarPalestra"/>
        <p>
            <input type="submit" value="Registrar"/>
        </p>
    </form>

<c:import url="../template/footer_post_login.jsp"/>
