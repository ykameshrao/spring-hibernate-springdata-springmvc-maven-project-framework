<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${error}">
    <div class="alert alert-error">
        <a class="close" data-dismiss="alert">x</a>
            ${errorMessage}
    </div>
</c:if>

<c:if test="${alert}">
    <div class="alert">
        <a class="close" data-dismiss="alert">x</a>
            ${alertMessage}
    </div>
</c:if>

<c:if test="${success}">
    <div class="alert alert-success">
        <a class="close" data-dismiss="alert">x</a>
            ${successMessage}
    </div>
</c:if>

<c:if test="${info}">
    <div class="alert alert-info">
        <a class="close" data-dismiss="alert">x</a>
            ${infoMessage}
    </div>
</c:if>

<c:if test="${infoWithAction}">
    <div class="alert alert-block alert-info fade in">
        <button class="close" data-dismiss="alert">&times;</button>
        <h4 class="alert-heading">${infoWithActionHeading}</h4>
        <p>${infoWithActionContent}</p>
        <p>
            <a class="btn btn-info" href="${infoWithActionPrimaryActionLink}">${infoWithActionPrimaryAction}</a>
            <a class="btn" href="${infoWithActionSecActionLink}">${infoWithActionSecAction}</a>
        </p>
    </div>
</c:if>