<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row">
    <form id="registerUserForm" action="registerUser" method="post">
        <fieldset>

            <div class="span12">
            <legend>Sign Up as a Merchant</legend>
            </div>

            <div class="span6">
                <div class="control-group" id="usernameCtl">
                    <label class="control-label" for="username">Username</label>

                    <div class="controls">
                        <input type="text" class="input-xlarge" id="username" name="username"/>
                    </div>
                </div>

                <div class="control-group" id="passwordCtl">
                    <label class="control-label" for="password">Password</label>

                    <div class="controls">
                        <input type="password" class="input-xlarge" id="password" name="password"/>
                    </div>
                </div>

                <div class="control-group" id="confirmCtl">
                    <label class="control-label" for="confirm">Confirm</label>

                    <div class="controls">
                        <input type="password" class="input-xlarge" id="confirm" name="confirm"/>
                    </div>
                </div>

                <div class="control-group" id="emailCtl">
                    <label class="control-label" for="email">Email</label>

                    <div class="controls">
                        <input type="text" class="input-xlarge" id="email" name="email"/>
                    </div>
                </div>

                <div class="control-group" id="mobileCtl">
                    <label class="control-label" for="mobile">Mobile</label>

                    <div class="controls">
                        <input type="text" class="input-xlarge" id="mobile" name="mobile"/>
                    </div>
                </div>

            </div>
            <div class="span6">
                <div class="control-group" id="companyNameCtl">
                    <label class="control-label" for="companyName">Company</label>

                    <div class="controls">
                        <input type="text" class="input-xlarge" id="companyName" name="companyName"/>
                    </div>
                </div>

                <div class="control-group" id="streetAddressCtl">
                    <label class="control-label" for="streetAddress">Street Address</label>

                    <div class="controls">
                        <input type="text" class="input-xlarge" id="streetAddress" name="streetAddress"/>
                    </div>
                </div>

                <div class="control-group" id="cityCtl">
                    <label class="control-label" for="city">City</label>

                    <div class="controls">
                        <input type="text" class="input-xlarge" id="city" name="city"/>
                    </div>
                </div>

                <div class="control-group" id="stateCtl">
                    <label class="control-label" for="state">State</label>

                    <div class="controls">
                        <input type="text" class="input-xlarge" id="state" name="state"/>
                    </div>
                </div>

                <div class="control-group" id="countryCtl">
                    <label class="control-label" for="country">Country</label>

                    <div class="controls">
                        <input type="text" disabled="disabled"
                               class="input-xlarge disabled" id="country" name="country" value="India"/>
                    </div>
                </div>

                <div class="control-group" id="postalCodeCtl">
                    <label class="control-label" for="postalCode">Postal Code</label>

                    <div class="controls">
                        <input type="text" class="input-xlarge" id="postalCode" name="postalCode"/>
                    </div>
                </div>

                <input class="btn btn-primary btn-large" type="submit" value="Register"/>
                <a href="${pageContext.request.contextPath}/home" class="btn btn-large">Cancel</a>

            </div>
        </fieldset>
    </form>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $("#registerUserForm").validate({
            rules:{
                username:{
                    required:true,
                    minlength:6
                },
                password:{
                    required:true,
                    minlength:6
                },
                confirm:{
                    equalTo:'#password'
                },
                email:{
                    required:true,
                    email:true
                },
                mobile:{
                    required:true,
                    digits:true,
                    maxlength:10
                },
                streetAddress:{
                    required:true
                },
                city:{
                    required:true
                },
                postalCode:{
                    required:true,
                    digits:true
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
