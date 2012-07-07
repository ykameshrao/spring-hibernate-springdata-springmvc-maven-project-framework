<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="tabbable tabs-left">
    <ul class="nav nav-tabs">
        <li class="active"><a href="#option1" data-toggle="tab">Option 1</a></li>
        <li><a href="#option2" data-toggle="tab">Option 2</a></li>
        <li><a href="#option3" data-toggle="tab">Option 3</a></li>
    </ul>
    <div class="tab-content">
        <div class="tab-pane active" id="option1">
            <p>I'm in Option 1.</p>
        </div>
        <div class="tab-pane" id="option2">
            <p>Howdy, I'm in Option 2.</p>
        </div>
        <div class="tab-pane" id="option3">
            <p>Howdy, I'm in Option 3.</p>
        </div>
    </div>
</div>