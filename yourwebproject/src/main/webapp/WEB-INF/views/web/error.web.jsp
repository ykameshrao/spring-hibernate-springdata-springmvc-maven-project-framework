<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row">
    <div class="span12">
        <div class="hero-unit">
            <h1>Oops! An error encountered!</h1>
            <br/>
            <h2>${exception}</h2>
            <br/>
        </div>
        <p>${stack}</p>
        <br/>
    </div>
</div>