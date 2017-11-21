
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" href="img/favicon.ico">

    <title>Medify</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/color-scheme.css" rel="stylesheet">

    <style>
        #header {
            height: 120px;
            width: 100%;
            margin-bottom: 0px;
        }
        #mainSizing {
            height: calc(100vh - 120px);
            margin-top: 0px;
        }
        #menuSide {
            display: flex;
            float: left;
        }
        #menuSide > ul {
            list-style: none;
            padding-right: 20px;
            height: calc(100vh - 120px);
            margin: 0px;
        }
        #menuSide > ul > li {
            font-size: 30px;
        }
        #menuSide > ul > li:hover {
            cursor: pointer;
            text-decoration: underline;
        }
        #mainContent {
            flex-grow: 100%;
            padding: 10px;
            margin-left:20px;
        }
        #menuBtn:hover {
            cursor: pointer;
            text-decoration: underline;
        }
    </style>
  </head>

  <body>
    <!--nav bar-->
    <div id="header" class="new-bg-colour-2">
        <img src="img/logo.png" class="center-block" alt="Community Living Cambridge Logo" style="height:90%; padding-top:12px;">
    </div>
    <!--close nav bar -->

    <!-- main content-->
    <div id="mainSizing">
        <div class="row" id="mainContent" style="margin-top:100px; margin-right:0px; margin-left:0px;">
            <!-- page content goes here -->

            <div class="col-md-6 col-md-offset-3">
                <div style="text-align:center; padding-bottom:10px;">
                    <label id="loginError"></label>
                </div>
                <div class="row">
                    <div class="col-md-6 col-md-offset-3">
                        <div class="form-group">
                            <label for="email">Email Address:</label>
                            <input type="text" class="form-control" id="email">
                        </div>
                        <div class="form-group">
                            <label for="pwd">Password:</label>
                            <input type="password" class="form-control" id="pwd">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 col-md-offset-3">
                        <div class="form-check">
                            <label class="form-check-label">
                                <input type="checkbox" class="form-check-input" onclick="showPassword()">
                                Show Password
                            </label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 col-md-offset-3 text-center">
                        <button id="forgotPass" name="forgotPass" class="btn btn-link">Forgot your password? Reset it!</button>
                    </div>
                </div>
                <div class="row" style="margin-top:10px;">
                    <div class="col-md-6 col-md-offset-3 text-center">
                        <div class="col-md-7 text-center">
                            <button style="width:100%;" id="createAccount" name="createAccount" class="btn btn-default">Create Account</button>
                        </div>
                        <div class="col-md-4 col-md-offset-1 text-center">
                            <button style="width:100%;" id="login" name="login" class="btn btn-default" onclick="login()">Login</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--end main content-->

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/login.js"></script>
  </body>
</html>
