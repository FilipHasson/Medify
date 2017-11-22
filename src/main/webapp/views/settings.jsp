<style>
.row{
	margin-top:45px;
}


</style>

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

<div class="row">
	<div class="col-sm-2">
		<a href="index.php?page=home"><button id="backToLink" type="button" class="btn btn-primary">Back</button></a>
	</div>
	<div class="col-sm-8">
		<h3 style="display:inline">Settings</h3>
	</div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	<div class="col-sm-8">
		<h3>I suppose that this page will contain various system settings such as colour scheme, text size, and medication notifications.</h3>
	</div>
</div>

<script>
    $('#menu-home').click(function (){location.href = "./home"});
    $('#logo').click(function (){location.href = "./home"});
    $('#menu-profile').click(function (){location.href = "./profile"});
    $('#menu-schedule').click(function (){location.href = "./schedule"});
    $('#menu-messages').click(function (){location.href = "./messages"});
    $('#menu-links').click(function (){location.href = "./links"});
    $('#menu-settings').click(function (){location.href = "./settings"});
    $('#menu-logout').click(function (){location.href = "./logout"});
</script>
