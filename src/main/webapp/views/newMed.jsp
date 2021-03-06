<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" href="img/favicon.ico">

    <title>Add Medication</title>

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
        #hide {
            display: none;
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
    <!--close nav bar -->

    <!-- main content-->
    <div id="mainSizing">
        <div id="menuSide">
            <ul class="color-scheme-background-1 color-scheme-2">
                <li id="menu-home">Home</li>
                <li id="menu-profile">Profile</li>
                <li id="menu-schedule">Medication Schedule</li>
                <li id="menu-messages">Messages</li>
                <li id="menu-links">Family/Friend Links</li>
                <li id="menu-settings">Settings</li>
            </ul>
        </div>
        <div id="mainContent">
            <!-- page content goes here -->
            <a href="./schedule" class="btn btn-primary btn-lg pull-left" role="button">Back</a>
            <div style="text-align: center"><h1 style="display: inline; text-decoration: underline">Add New Medication</h1></div><br>
            <label for="name" style="font-size: 20px">Medication Name:</label>
            <input type="text" maxlength="20" style="width: 400px" class="form-control" id="name">
            <label for="dosage" style="font-size: 18px">Dosage:</label>
            <input type="text" maxlength="20" style="width: 200px" class="form-control" id="dosage">
            <label style="font-size: 20px">Taken On: (Select daily or all that apply)</label><br>
            <label style="font-size: 18px;font-weight: bold"><input type="checkbox" id="selectall">Daily</label>
            <div id="checkboxlist">
                <div class="checkbox">
                    <label style="font-size: 18px"><input type="checkbox" name="daily">Sunday</label>
                </div>
                <div class="checkbox">
                    <label style="font-size: 18px"><input type="checkbox" name="daily">Monday</label>
                </div>
                <div class="checkbox">
                    <label style="font-size: 18px"><input type="checkbox" name="daily">Tuesday</label>
                </div>
                <div class="checkbox">
                    <label style="font-size: 18px"><input type="checkbox" name="daily">Wednesday</label>
                </div>
                <div class="checkbox">
                    <label style="font-size: 18px"><input type="checkbox" name="daily">Thursday</label>
                </div>
                <div class="checkbox">
                    <label style="font-size: 18px"><input type="checkbox" name="daily">Friday</label>
                </div>
                <div class="checkbox">
                    <label style="font-size: 18px"><input type="checkbox" name="daily">Saturday</label>
                </div>
            </div>
            <label for="times-taken" style="font-size: 20px">Times Taken Per Day (select one):</label>
            <select class="div-toggle" style="width: 5%" id="times-taken">
                <option value="1-time">1</option>
                <option value="2-time">2</option>
                <option value="3-time">3</option>
                <option value="4-time">4</option>
            </select>
            <div class="one-time hide" id="timeone">
                <label for="hour1" style="font-size: 18px">Time One:</label>
                <select class="form-control" id="hour1" style="width: 5%;display: inline">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                    <option>6</option>
                    <option>7</option>
                    <option>8</option>
                    <option>9</option>
                    <option>10</option>
                    <option>11</option>
                    <option>12</option>
                </select> :
                <select class="form-control" id="minute1" style="width: 5%;display: inline">
                    <option>00</option>
                    <option>30</option>
                </select>
                <select class="form-control" id="AMPM1" style="width: 5%;display: inline">
                    <option>AM</option>
                    <option>PM</option>
                </select>
            </div>
            <div class="two-time hide" id="timetwo">
                <label for="hour2" style="font-size: 18px">Time Two:</label>
                <select class="form-control" id="hour2" style="width: 5%;display: inline">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                    <option>6</option>
                    <option>7</option>
                    <option>8</option>
                    <option>9</option>
                    <option>10</option>
                    <option>11</option>
                    <option>12</option>
                </select> :
                <select class="form-control" id="minute2" style="width: 5%;display: inline">
                    <option>00</option>
                    <option>30</option>
                </select>
                <select class="form-control" id="AMPM2" style="width: 5%;display: inline">
                    <option>AM</option>
                    <option>PM</option>
                </select>
            </div>
            <div class="three-time hide" id="timethree">
                <label for="hour3" style="font-size: 18px">Time Three:</label>
                <select class="form-control" id="hour3" style="width: 5%;display: inline">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                    <option>6</option>
                    <option>7</option>
                    <option>8</option>
                    <option>9</option>
                    <option>10</option>
                    <option>11</option>
                    <option>12</option>
                </select> :
                <select class="form-control" id="minute3" style="width: 5%;display: inline">
                    <option>00</option>
                    <option>30</option>
                </select>
                <select class="form-control" id="AMPM3" style="width: 5%;display: inline">
                    <option>AM</option>
                    <option>PM</option>
                </select>
            </div>
            <div class="four-time hide" id="timefour">
                <label for="hour4" style="font-size: 18px;padding-right:10px">Time Four:</label>
                <select class="form-control" id="hour4" style="width: 5%;display: inline">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                    <option>6</option>
                    <option>7</option>
                    <option>8</option>
                    <option>9</option>
                    <option>10</option>
                    <option>11</option>
                    <option>12</option>
                </select> :
                <select class="form-control" id="minute4" style="width: 5%;display: inline">
                    <option>00</option>
                    <option>30</option>
                </select>
                <select class="form-control" id="AMPM4" style="width: 5%;display: inline">
                    <option>AM</option>
                    <option>PM</option>
                </select>
            </div>
        </div>
        <label for="notes" style="font-size: 18px; padding-left: 20px">Notes:</label>
        <div style="padding-left: 20px">
            <textarea rows="4" style="width: 400px;" class="form-control" id="notes"></textarea>
            <br>
            <a href="./schedule" class="btn btn-success btn-lg" role="button">Add To Schedule</a>
        </div>
    </div>
    <!--end main content-->

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>

    <script>
        $('#menu-home').click(function (){location.href = "./home"});
	      $('#logo').click(function (){location.href = "./home"});
	      $('#menu-profile').click(function (){location.href = "./profile"});
	       $('#menu-schedule').click(function (){location.href = "./schedule"});
	      $('#menu-messages').click(function (){location.href = "./messages"});
	      $('#menu-links').click(function (){location.href = "./links"});
	      $('#menu-settings').click(function (){location.href = "./settings"});
	      $('#menu-logout').click(function (){location.href = "./index"});
    </script>
    <script>
        $(document).on('change', function() {
            var selector = document.getElementById("times-taken");
            var timeOne = document.getElementById("timeone");
            var timeTwo = document.getElementById("timetwo");
            var timeThree = document.getElementById("timethree");
            var timeFour = document.getElementById("timefour");
            var timeOption = selector.options[selector.selectedIndex].value;
            if (timeOption == "1-time") {
                $(timeOne).removeClass('hide');
                $(timeTwo).addClass('hide');
                $(timeThree).addClass('hide');
                $(timeFour).addClass('hide');
            }
            else if (timeOption == "2-time") {
                $(timeOne).removeClass('hide');
                $(timeTwo).removeClass('hide');
                $(timeThree).addClass('hide');
                $(timeFour).addClass('hide');
            }
            else if (timeOption == "3-time") {
                $(timeOne).removeClass('hide');
                $(timeTwo).removeClass('hide');
                $(timeThree).removeClass('hide');
                $(timeFour).addClass('hide');
            }
            else if (timeOption == "4-time") {
                $(timeOne).removeClass('hide');
                $(timeTwo).removeClass('hide');
                $(timeThree).removeClass('hide');
                $(timeFour).removeClass('hide');
            }
        });
        $(document).ready(function() {
            $('.div-toggle').trigger('change');
        });
    </script>
    <script>
        $('#selectall').click(function() {
            if ($('#selectall').is(':checked')) {
                $('input[name=daily]').prop('checked', true);
            }
            else {
                $('input[name=daily]').prop('checked', false);
            }
        });
    </script>
  </body>
</html>
