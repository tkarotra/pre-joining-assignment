<% 
	if (session.getAttribute("name") != null) {
		response.sendRedirect("index.jsp");
	}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en" dir="ltr">

<head>

    <meta name='viewport' content='width=device-width, initial-scale=1.0, user-scalable=0'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="ISS Pre Training Assignment - Register Page">
    <meta name="author" content="Teesha Karotra">

    <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png" />
    <title>Register | ISS</title>

    <link id="style" href="assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="assets/css/style.css" rel="stylesheet" />
    <link href="assets/css/materialdesignicons.css" rel="stylesheet" />
    <link id="theme" rel="stylesheet" type="text/css" media="all" href="assets/css/color1.css" />
    
    <style>
    	@media (min-width: 768px) {
		    .wrap-login100 {
		        width: 35%;
		    }
		}
		.iti--allow-dropdown {
			width: 100%;
			height: 45px;
		}
		.form-group {
	    	margin-bottom: 10px;
	    }
	    #phoneNumber {
	    	height: 43px;
	    	border-left: 1px solid #e9edf4 !important;
	    }
    </style>

</head>

<body class="app sidebar-mini ltr login-img">

    <div class="">

        <div id="global-loader">
            <img src="assets/images/loader.svg" class="loader-img" alt="Loader">
        </div>

        <!-- PAGE -->
        <div class="page">
            <div class="">

                <div class="container-login100">
                    <div class="wrap-login100 p-6">
                    <input type="hidden" id="status" value="<%= request.getAttribute("status") %>" />
                        <form id="registrationForm" class="needs-validation" method="POST" action="register" novalidate>
                            
                            <span class="login100-form-title">
									Register
							</span>
							
							<div id="message"> </div>

                            <div class="wrap-input100 validate-input input-group">
                                <a href="javascript: void(0);" class="input-group-text bg-white text-muted">
                                    <i class="zmdi zmdi-email text-muted" aria-hidden="true"></i>
                                </a>
                                <input class="input100 border-start-0 form-control ms-0" id="email" name="email" type="email" placeholder="Email" pattern="\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{1,})+" required>
                                <div class="invalid-feedback">Enter a valid email address</div>
                            </div>

                            <div class="wrap-input100 validate-input input-group">
                                <a href="javascript: void(0);" class="input-group-text bg-white text-muted">
                                    <i class="zmdi zmdi-account text-muted" aria-hidden="true"></i>
                                </a>
                                <input class="input100 border-start-0 form-control ms-0" id="name" name="name" type="text" placeholder="Name" pattern="[A-Za-z]{2,} [A-Za-z]{2,}" required>
                                <div class="invalid-feedback">Enter a valid first name followed by last name (no special characters. e.g. John Doe)</div>
                            </div>

                            <div class="form-group">
                                <input type="text" id="phoneNumber" pattern="[0-9]{3,}" class="form-control" placeholder="Phone Number" name="phoneNumber" required>
                                <div class="invalid-feedback" id="phonenumberInvalidFeedback">Enter a valid phone number</div>
                            </div>

                            <div class="wrap-input100 validate-input input-group" id="Password-toggle1">
                                <a href="javascript: void(0);" class="input-group-text bg-white text-muted">
                                    <i class="zmdi zmdi-eye text-muted" aria-hidden="true"></i>
                                </a>
                                <input class="input100 border-start-0 form-control ms-0" id="password" name="password" type="password" placeholder="Password" pattern="(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,13}" required>
                                <div class="invalid-feedback">Enter a valid password</div>
                            </div>

                            <div class="wrap-input100 validate-input input-group" id="Password-toggle">
                                <a href="javascript: void(0);" class="input-group-text bg-white text-muted">
                                    <i class="zmdi zmdi-eye text-muted" aria-hidden="true"></i>
                                </a>
                                <input class="input100 border-start-0 form-control ms-0" id="confirmPassword" name="confirmPassword" type="password" placeholder="Confirm Password" required>
                                <div class="invalid-feedback">Confirm Password must be same as password</div>
                            </div>
                            
                            <span class="text-danger">Password must have atleast 1 uppercase alphabet, 1 lowercase alphabet, 1 digit and 1 special character. Length must be between 8 to 13 characters.</span>

                            <input type="hidden" id="countryCode" name="countryCode" >
                            <input type="hidden" id="countryName" name="countryName" >
                            <input type="hidden" id="countryNameCode" name="countryNameCode" >
                            
                            <div class="container-login100-form-btn">
                                <button type="submit" class="login100-form-btn btn-primary">
									Register
                                </button>
                            </div>
                            <div class="text-center pt-3">
                                <p class="text-dark mb-0">Already have account?<a href="login.jsp" class="text-primary ms-1">Sign In</a></p>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- CONTAINER CLOSED -->
            </div>
        </div>
        <!-- END PAGE -->

    </div>
    <!-- BACKGROUND-IMAGE CLOSED -->

    <!-- JQUERY JS -->
    <script src="assets/js/jquery.min.js"></script>

    <!-- SHOW PASSWORD JS -->
    <script src="assets/js/show-password.min.js"></script>

    <!-- Color Theme js -->
    <script src="assets/js/themeColors.min.js"></script>

    <!-- CUSTOM JS -->
    <script src="assets/js/custom.min.js"></script>

    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/16.0.8/js/intlTelInput-jquery.min.js"></script>
    
    <script>
        $(document).ready(function() {
            $("#phoneNumber").intlTelInput({
                initialCountry: "in",
                separateDialCode: true,
                // utilsScript: "https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/11.0.4/js/utils.js"
            });

        })
    </script>
    
    <script>
    	var status = document.getElementById("status").value;
    	if (status == 'dbFailed') {
    		$('#message').html(`
    			<div class="alert alert-danger mb-3" role="alert">
                    Could not connect to the database. Please try again.
    			</div>
    		`);
    	}
    	else if (status == 'emailError') {
    		$('#message').html(`
       			<div class="alert alert-danger mb-3" role="alert">
                       Please enter a valid email address.
       			</div>
       		`);
    	}
    	else if (status == 'nameError') {
    		$('#message').html(`
       			<div class="alert alert-danger mb-3" role="alert">
                       Please enter your first name followed by your last name.
       			</div>
       		`);
    	}
    	else if (status == 'phoneNumberError') {
    		$('#message').html(`
       			<div class="alert alert-danger mb-3" role="alert">
                       Please enter a valid phone number.
       			</div>
       		`);
    	}
    	else if (status == 'passwordError') {
    		$('#message').html(`
       			<div class="alert alert-danger mb-3" role="alert">
                       Please enter a valid password.
       			</div>
       		`);
    	}
    	else if (status == 'confirmPasswordError') {
    		$('#message').html(`
       			<div class="alert alert-danger mb-3" role="alert">
                       Please note that password and confirm password must match.
       			</div>
       		`);
    	}
    	else if (status == 'emailFailed') {
    		$('#message').html(`
       			<div class="alert alert-danger mb-3" role="alert">
                       Account does not exist. Register to continue.
       			</div>
       		`);
    	}
    </script>

	<script>
        (function() {
            'use strict';

            window.addEventListener('load', function() {
                var forms = document.getElementsByClassName('needs-validation');
                var countryCode = document.getElementById('countryCode');
                var countryName = document.getElementById('countryName');
                var countryNameCode = document.getElementById('countryNameCode');
                var cName;
                
                
                var validation = Array.prototype.filter.call(forms, function(form) {
                    form.addEventListener('submit', function(event) {

                        countryCode.value = document.getElementsByClassName('iti__selected-flag')[0].innerText.substring(1);
                        countryNameCode.value = document.getElementsByClassName('iti__selected-flag')[0].childNodes[0].classList[1].split('__')[1];
                        cName = document.getElementsByClassName('iti__selected-flag')[0].title.split('(');
                        if (cName.length == 1) {
                            countryName.value = cName[0].split(':')[0].trim();
                            console.log(cName[0].split(':')[0].trim())
                        } else {
                            countryName.value = cName[0].trim();
                            console.log(cName[0].trim())
                        }

                        if (!checkFormValid()) {
                            event.preventDefault();
                            event.stopPropagation();
                        } else {
                            form[0].submit();
                        }

                        $('#email').on('input', function () {
                            checkFormValid();
                        });
                        $('#name').on('input', function () {
                            checkFormValid();
                        });
                        $('#phoneNumber').on('input', function () {
                            checkFormValid();
                        });
                        $('#password').on('input', function () {
                            checkFormValid();
                        });
                        $('#confirmPassword').on('input', function () {
                            checkFormValid();
                        });
                    }, false);
                });
            }, false);
            
        })();
    </script>

    <script>
    	function checkFormValid() {
            var email = $('#email').val();
            var name = $('#name').val();
            var phoneNumber = $('#phoneNumber').val();
            var password = $('#password').val();
            var confirmPassword = $('#confirmPassword').val();

            var emailPattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{1,})+$/;
            var namePattern = /^[A-Za-z]{2,} [A-Za-z]{2,}$/;
            var phonePattern = /^[0-9]{3,}$/;
            var passwordPattern = /^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,13}$/;

			var isValid = true;
            if (password !== confirmPassword) {
            	isValid = false;
                $('#confirmPassword').addClass('is-invalid');
                $('#confirmPassword').siblings('.invalid-feedback').show();
            } else {
                $('#confirmPassword').removeClass('is-invalid').addClass('is-valid');
                $('#confirmPassword').siblings('.invalid-feedback').hide();
            }

            if (!emailPattern.test(email)) {
            	isValid = false;
                $('#email').addClass('is-invalid');
                $('#email').siblings('.invalid-feedback').show();
            } else {
                $('#email').removeClass('is-invalid').addClass('is-valid');
                $('#email').siblings('.invalid-feedback').hide();
            }

            if (!namePattern.test(name)) {
            	isValid = false;
                $('#name').addClass('is-invalid');
                $('#name').siblings('.invalid-feedback').show();
            } else {
                $('#name').removeClass('is-invalid').addClass('is-valid');
                $('#name').siblings('.invalid-feedback').hide();
            }

            if (!phonePattern.test(phoneNumber)) {
            	isValid = false;
                $('#phoneNumber').addClass('is-invalid');
                $('#phoneNumber').closest('.form-group').find('.invalid-feedback').show();
            } else {
                $('#phoneNumber').removeClass('is-invalid').addClass('is-valid');
                $('#phoneNumber').closest('.form-group').find('.invalid-feedback').hide();
            }

            if (!passwordPattern.test(password)) {
            	isValid = false;
                $('#password').addClass('is-invalid');
                $('#password').siblings('.invalid-feedback').show();
            } else {
                $('#password').removeClass('is-invalid').addClass('is-valid');
                $('#password').siblings('.invalid-feedback').hide();
            }
            
            if (password=="") {
            	if (!passwordPattern.test(confirmPassword)) {
	            	isValid = false;
	                $('#confirmPassword').addClass('is-invalid');
	                $('#confirmPassword').siblings('.invalid-feedback').show();
	            } else {
	                $('#confirmPassword').removeClass('is-invalid').addClass('is-valid');
	                $('#confirmPassword').siblings('.invalid-feedback').hide();
	            }
            }
            return isValid;
    	}
    </script>


</body>

</html>