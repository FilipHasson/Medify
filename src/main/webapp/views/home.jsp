
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" href="img/favicon.ico">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <title>Medify</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/color-scheme.css" rel="stylesheet">
    <link href="css/home.css" rel="stylesheet">

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
        #logo:hover {
            cursor: pointer;99999
        }
    </style>
  </head>

  <body>

    <!--nav bar-->
    <div id="header" class="new-bg-colour-2">
        <img src="img/logo.png" id="logo" class="center-block" alt="Community Living Cambridge Logo" style="height:60%; padding-top:20px; padding-bottom:10px;">
        <div class="row" style="margin:0px;">
            <nav class="navbar navbar-default navbar-static-top new-bg-colour-2" style="text-align:center;">
                <div class="container">
                    <button id="menu-home" name="menu-home" class="btn btn-link" style="color:white;">HOME</button>
                    <button id="menu-profile" name="menu-profile" class="btn btn-link" style="color:white;">PROFILE</button>
                    <button id="menu-schedule" name="menu-schedule" class="btn btn-link" style="color:white;">MEDICATION SCHEDULE</button>
                    <button id="menu-messages" name="menu-messages" class="btn btn-link" style="color:white;">MESSAGES</button>
                    <button id="menu-links" name="menu-links" class="btn btn-link" style="color:white;">CONNECTIONS</button>
                    <button id="menu-settings" name="menu-settings" class="btn btn-link" style="color:white;">SETTINGS</button>
                    <button id="menu-logout" name="menu-logout" class="btn btn-link" style="color:white;">LOGOUT</button>
                </div>
            </nav>
        </div>
    </div>
    <!--end nav bar -->

    <!-- main content-->
    <div id="mainSizing" style="font-family:Helvetica;">
        <div class="row" id="mainContent" style="margin:0px;">
            <!-- page content goes here -->
            <div class="col-md-10 col-md-offset-1">
                <div class="row">
                    <div class="col-md-10 col-md-offset-1" style="text-align:center; padding-top:15px;">
                        <h1 id="welcomeName" style="font-family:Cursive; font-size:45pt;"></h1>
                    </div>
                </div>
                <div class="row" style="margin-top:10px;">
                    <div class="col-md-4">
                        <h1 style="font-size:15pt; text-align:center;">Did you take these pills?</h1>
                        <div id="missed-pills-container" style="height:200px; overflow-y: scroll; border:2px solid grey; border-radius:5px;">
                        </div>
                    </div>
                    <div class="col-md-2 col-md-offset-1" style="border-radius:5px;">
                        <h1 id="medalCountMessage" style="font-size:15pt; text-align:center;">Medals:</h1>
                        <img src="img/medalX2.png" id="medalL" class="center-block" alt="Medication Streak Medal" style="padding-top:20px;">
                    </div>
                    <div class="col-md-4 col-md-offset-1" style="border-radius:5px;">
                        <h1 style="font-size:15pt; text-align:center;">Today's Schedule</h1>
                        <div id="todays-pills-container" style="height:200px; overflow-y: scroll; border:2px solid grey; border-radius:5px;">
                            <div id="no-pills-today" style="margin-top:80px; text-align:center; padding-left:5px; padding-right:5px;">
                                <p>You do not have any pills to take today!</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row" style="margin-top:30px; margin-left:0px; margin-right:0px; text-align:center;">
                    <p id="medalStreakMessage" style="font-size:15pt;"></p>
                </div>
                <div class="row" style="margin-top:15px;">
                    <div class="col-md-1">
                        <img src="img/medalX1.png" id="medalS" class="center-block" alt="Medication Streak Medal">
                    </div>
                    <div class="col-md-10 col-md-offset-1">
                        <div class="row" style="margin-right:0px; margin-top:-10px;">
                            <div class="progress" style="margin-top:16px; height:32px; border:1px solid black;">
                                <div id="medalProgress" class="progress-bar progress-bar-striped progress-bar-success" role="progressbar" style="width:0%; font-size:18px; padding:6px; color:black;" aria-valuenow="0" aria-valuemin="0" aria-valuemax="7">0</div>
                            </div>
                        </div>
                        <div class="row"  style="margin-right:0px; margin-top:-15px;">
                            <div class="col-md-1" style="padding:0px;">
                                <p>0</p>
                            </div>
                            <div class="col-md-1 col-md-offset-10" style="padding:0px;">
                                <p style="float:right;">7</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--end main content-->

    <!-- Modal -->
    <div id="pillInfo" class="modal fade" role="dialog">
        <div class="modal-dialog modal-sm">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 id="pillInfoName" class="modal-title"></h4>
                </div>
                <div class="modal-body">
                    <p id="pillInfoInfo"></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
  </div>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.11/handlebars.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="js/home.js"></script>

    <script id="missed_pills" type="text/x-handlebars-template">
      <div class="past-pill new-bg-colour-2 last-past-pill-item" style="padding-left:7px;">
          <div class="row" style="margin-right:0px;">
              <div class="col-md-9" style="padding-right:0px;">
                  <div class="row" style="margin:0px; padding-top:8px;">
                      <h1 style="padding:0px; margin:0px; color:white; font-size:20pt;">{{pillName}}</h1>
                  </div>
                  <div class="row" style="margin:0px; padding-top:2px;">
                      <p style="margin:0px; color:white; font-size:8pt;">Amount: {{pillDosage}}</p>
                  </div>
                  <div class="row" style="margin:0px; padding-top:2px;">
                      <div style="padding:0px; color:white; font-size:10pt;">
                          When: {{pillDate}}
                      </div>
                  </div>
              </div>
              <div class="col-md-3" style="padding-left:5px; padding-right:0px;">
                  <div class="row" style="margin:7px;">
                      <button id="taken" data-pill_id="{{pillID}}" class="btn btn-success btn-sm" style="width:100%; color:black; font-family:Helvetica-Bold;" onclick="markPill(this.getAttribute('data-pill_id'), true)">YES</button>
                  </div>
                  <div class="row" style="margin:7px;">
                      <button id="missed" data-pill_id="{{pillID}}" class="btn btn-danger btn-sm" style="width:100%; color:black; font-family:Helvetica-Bold;" onclick="markPill(this.getAttribute('data-pill_id'), false)">NO</button>
                  </div>
              </div>
          </div>
      </div>
    </script>

    <script id="todays_pills" type="text/x-handlebars-template">
        <div class="past-pill new-bg-colour-2 last-past-pill-item" style="padding-left:7px;">
            <div class="row" style="margin-right:0px;">
                <div class="row" style="margin:0px; padding-top:8px;">
                    <div class="col-md-10" style="padding-right:0px;">
                        <h1 style="padding:0px; margin:0px; color:white; font-size:20pt;">{{pillName}}</h1>
                    </div>
                    <div class="col-md-2" style="padding:0px;">
                        <button type="button" class="btn btn-default btn-sm" style="font-family:Helvetica-Bold;" data-pill_name="{{pillName}}" data-pill_id="{{pillID}}" data-pill_info="{{pillInfo}}" onclick="openPillInfo(this.getAttribute('data-pill_name'), this.getAttribute('data-pill_info'))">Info</button>
                    </div>
                </div>
                <div class="row" style="margin:0px; padding-left:15px;">
                    <p style="margin:0px; padding:0px; color:white; font-size:8pt;">Amount: {{pillDosage}}</p>
                </div>
                <div class="row" style="margin:0px; padding-left:15px; padding-bottom:5px;">
                    <div style="padding:0px; color:white; font-size:10pt;">
                        Time: {{pillTime}}
                    </div>
                </div>
            </div>
        </div>
    </script>
  </body>
</html>
