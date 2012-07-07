<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand active" href="#">Your Web Project</a>
            <ul class="nav">
                <li class="active"><a href="#">and its motto!</a></li>
            </ul>
            <ul class="nav pull-right">
                <li class="dropdown">
                    <c:choose>
                        <c:when test="${loggedIn}">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Welcome,
                                    ${user.userName}<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="logoutUser">Logout</a></li>
                            </ul>
                        </c:when>
                        <c:otherwise>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">User Sign
                                In<b class="caret"></b></a>

                            <div class="dropdown-menu signin-pad">
                                <form id="loginUserForm" method="post" action="loginUser" class="pull-right">
                                    <label for="username_lgn">Username</label>
                                    <input class="span3" type="text" id="username_lgn" name="username"
                                           placeholder="Username"/>
                                    <label for="password_lgn">Password</label>
                                    <input class="span3" type="password" id="password_lgn" name="password"
                                           placeholder="Password"/>
                                    <input type="submit" name="Login" class="btn small" value="Login"/>
                                    <br/><br/>
                                    <a href="forgotPassword" style="margin-left: -14px;">Forgot your password?</a>
                                </form>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </li>
            </ul>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function () {
        // Setup drop down menu
        $('.dropdown-toggle').dropdown();

        // Fix input element click problem
        $('.dropdown input, .dropdown label').click(function (e) {
            e.stopPropagation();
        });
    });

    $(document).ready(function () {
        $("#loginMerchantForm").validate({
            rules:{
                username_lgn:{
                    required:true
                },
                password_lgn:{
                    required:true
                }
            },
            errorClass:"control-group error",
            validClass:"control-group success",
            errorElement:"span",
            highlight:function (element, errorClass, validClass) {
                if (element.type === 'radio') {
                    this.findByName(element.name).parent("div").parent("div").removeClass(validClass).addClass(errorClass);
                } else {
                    $(element).parent("div").parent("div").removeClass(validClass).addClass(errorClass);
                }
            },
            unhighlight:function (element, errorClass, validClass) {
                if (element.type === 'radio') {
                    this.findByName(element.name).parent("div").parent("div").removeClass(errorClass).addClass(validClass);
                } else {
                    $(element).parent("div").parent("div").removeClass(errorClass).addClass(validClass);
                }
            }
        });
    });
</script>