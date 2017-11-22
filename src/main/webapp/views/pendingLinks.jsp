<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" href="img/favicon.ico">

    <title>CLC</title>

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
        #logo:hover {
            cursor: pointer;
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
        <div id="mainContent">
            <!-- page content goes here -->









<style>
    .listing{
        font-size: 20px;
    }
    button {
        font-size: 40px;
    }
    .listing > span:hover{
        cursor: pointer;
    }
    #linkList {
        margin: auto;
    }
	.wid30{
		width: 30%;
		display: inline-block;
	}
	.listing:hover {
		background: rgba(0,0,0,0.2);
	}
	.row {
		margin-top:45px;
	}
</style>
<div class="row">
	<div class="col-sm-2">
		<a href="./links"><button id="backToLink" type="button" class="btn btn-primary">Back</button></a>
	</div>
	<div class="col-sm-8">
		<h3>Pending Links</h3>
	</div>
</div>
<div>
	<div class="col-sm-2"></div>
	<div class="col-sm-8" id="linkList">
	</div>
</div>

</div>
    </div>
    <!--end main content-->
    <div class="md-overlay"></div>

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
    $('#menu-logout').click(function (){location.href = "./logout"});
    links = [
        {
            id: 2,
            username: "testUser02",
            first: "Fred",
            last: "Smith"
        },
        {
            id: 7,
            username: "testUser07",
            first: "Liz",
            last: "Summers"
        },
        {
            id: 1,
            username: "theOne",
            first: "Thomas",
            last: "Anderson"
        },
        {
            id: 14,
            username: "testUser 14",
            first: "Trinity",
            last: "hidden"
        }
    ];

    var temp = $('#linkList');
    links.forEach(function(item) {
        var add = '<div id="' + item.id + '">';
        add += '<p class="listing"><span onclick="info(' + item.id + ')">';
		add += '<span class="wid30">' + item.username + '</span>';
		add += '<span class="wid30">' + getFiller(item.first) + ' ' + getFiller(item.last) + ' </span>';
		add += '<span>More <span class="chev">' + ' &#9660;' + '</span></span>';
		add += '</span>';
		add += '<button type="button" class="btn btn-danger pull-right" onclick="removeMe(' + item.id + ')">Remove</button></p>';
        add += '<div class="extra" style="display: none;"><p>We are currently waiting on ' + item.username + '(' + item.first + ') to accept your request.</p></div>';
        add += '<hr/>';
		add += '</div>';
        temp.append(add);
    });

	function getFiller(input){
		if (input == "unknown" || input == "hidden"){
			return "";
		} else {
			return input;
		}
	};

    var info = function (id){
		var test = $('#' + id + ' .extra');
		var item = $('#' + id + ' .chev');
		test.toggle();
		test.toggleClass('flag');
		if (test.hasClass('flag')){
			item.html('&#9650;');
		} else {
			item.html('&#9660;');
		}
    };

    var removeMe = function (id){
        $('#' + id).remove();
    };
</script>
  </body>
</html>
