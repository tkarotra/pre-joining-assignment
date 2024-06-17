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
    <meta name="description" content="ISS Pre Training Assignment - Login Page">
    <meta name="author" content="Teesha Karotra">

    <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png" />
    <title>Login | ISS</title>

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
                        <form class="needs-validation" method="POST" action="login" novalidate>
                            
                            <span class="login100-form-title">
									Login
							</span>

							<div id="message"> </div>

                            <div class="wrap-input100 validate-input input-group">
                                <a href="javascript: void(0);" class="input-group-text bg-white text-muted">
                                    <i class="zmdi zmdi-email text-muted" aria-hidden="true"></i>
                                </a>
                                <input class="input100 border-start-0 form-control ms-0" id="email" name="email" type="email" placeholder="Email" pattern="\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{1,})+" required>
                                <div class="invalid-feedback">Enter a valid email address</div>
                            </div>

                            <div class="wrap-input100 validate-input input-group" id="Password-toggle1">
                                <a href="javascript: void(0);" class="input-group-text bg-white text-muted">
                                    <i class="zmdi zmdi-eye text-muted" aria-hidden="true"></i>
                                </a>
                                <input class="input100 border-start-0 form-control ms-0" id="password" name="password" type="password" placeholder="Password" required>
                                <div class="invalid-feedback">Enter a password</div>
                            </div>
                            <div class="container-login100-form-btn">
                                <button type="submit" class="login100-form-btn btn-primary">
									Login
                                </button>
                            </div>
                            <div class="text-center pt-3">
                                <p class="text-dark mb-0">Don't have an account?<a href="register.jsp" class="text-primary ms-1">Sign Up</a></p>
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
    	if (status == 'registrationSuccess') {
    		$('#message').html(`
    			<div class="alert alert-success mb-3" role="alert">
                    You have registered successfully. Login to continue.
    			</div>
    		`);
    	}
    	else if (status == 'logoutSuccess') {
    		$('#message').html(`
       			<div class="alert alert-success mb-3" role="alert">
                       You have logged out successfully.
       			</div>
       		`);
    	}
    	else if (status == 'emailFailed') {
    		$('#message').html(`
       			<div class="alert alert-danger mb-3" role="alert">
                       An account with this email already exists. Login to continue.
       			</div>
       		`);
    	}
    	else if (status == 'passwordFailed') {
    		$('#message').html(`
       			<div class="alert alert-danger mb-3" role="alert">
                       Incorrect password. Please try again.
       			</div>
       		`);
    	}
    	
    </script>

    <script>
        (function() {
            'use strict';

            window.addEventListener('load', function() {
                var forms = document.getElementsByClassName('needs-validation');
                
                var validation = Array.prototype.filter.call(forms, function(form) {
                    form.addEventListener('submit', function(event) {
                        if (form.checkValidity() === false) {
                            event.preventDefault();
                            event.stopPropagation();
                        }
                        form.classList.add('was-validated');
                    }, false);
                });
            }, false);
            
        })();
    </script>


</body>

</html>