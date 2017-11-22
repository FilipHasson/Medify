<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>CLC- create account</title>

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">


      <link rel="stylesheet" href="css/style.css">
      <link rel="stylesheet" href="css/color-scheme.css">
<div class="center">
  <p><img style="width:75%; margin-bottom:25px;" src="img/logo.png"></p>
</div>

<body class="color-scheme-background-3">
<form id="msform">
    <ul id="progressbar">
    <li class="active">Account Setup</li>
    <li>Terms and Conditions</li>
    <li>Captcha Test</li>
  </ul>
    <fieldset  = "form1">
        <h2 class="fs-title">Create your account</h2>
    <input type="text" name="name" placeholder="Username *" id="u_name" onkeyup="emptyText()" onblur="validate()"/><div id="errfn"></div>
    <input type="text" name="email" placeholder="Email *" id="email" onkeyup="emptyText()" onblur="validate()"/><div id="errem"></div>
    <input placeholder="Date Of Birth" class="textbox-n" type="text" onfocus="(this.type='date')"  id="date">
    <input type="password" name="pass" placeholder="Password *" id="pass" onkeyup="emptyText();check();" onblur="validate()"/><div id="errp"></div>
    <input type="password" name="rpass" placeholder="Retype Password *" id="rpass" onkeyup="emptyText();check();" onblur="validate()"/><div id="errp"></div>
    <span id='message'></span>
        <div><input type="checkbox" onclick="showPassword()"><font face = "Verdana" size = "3">Show Password</font></div>
    <input type="button" name="prev" class="previous action-button" value="Previous" onclick="location.href='#'" onkeyup="emptyText()"/>
    <input type="button" id="next" name="next" class="next action-button" value="Next" onclick="location.href='./agreeTerms'" disabled />
    <script>
function validate() {
var u=document.getElementById("u_name");
        var e=document.getElementById("email");
        var p=document.getElementById("pass");
        var r=document.getElementById("rpass");
        var pv=document.getElementById("pass").value;
        var rv=document.getElementById("rpass").value;
  if(u.value=="")
  {
      document.getElementById('errfn').style.color = 'red';
      document.getElementById('errfn').innerHTML="username is required";
      document.getElementById("next").disabled=true;
  }else{
      document.getElementById('errfn').innerHTML="";
  }
  if(e.value=="")
  {
      document.getElementById('errem').style.color = 'red';
      document.getElementById('errem').innerHTML="email is required";
      document.getElementById("next").disabled=true;
  }else{
      document.getElementById('errem').innerHTML="";
  }
  if(p.value=="")
  {
      document.getElementById('errp').style.color = 'red';
      document.getElementById('errp').innerHTML="password is required";
      document.getElementById("next").disabled=true;
  }else{
      document.getElementById('errp').innerHTML="";
  }
 }
var check = function() {
  if (document.getElementById('pass').value ==
    document.getElementById('rpass').value) {
    document.getElementById('message').style.color = 'green';
    document.getElementById('message').innerHTML = 'Matching';
    document.getElementById("next").disabled=false;
  } else {
    document.getElementById('message').style.color = 'red';
    document.getElementById('message').innerHTML = 'Not matching';
    document.getElementById("next").disabled=true;
  }
}
    function showPassword(){
        var x = document.getElementById("pass");
        var y = document.getElementById("rpass");
        if (x.type === "password" ) {
            x.type = "text";
        } else {
            x.type = "password";
        }
        if (y.type === "password" ) {
            y.type = "text";
        } else {
            y.type = "password";
        }
    }
    function emptyText(){
        var u=document.getElementById("u_name");
        var e=document.getElementById("email");
        var p=document.getElementById("pass");
        var r=document.getElementById("rpass");
        var pv=document.getElementById("pass").value;
        var rv=document.getElementById("rpass").value;
        if(((u.value=="") || (e.value=="") || (p.value=="") || (r.value==""))&&(pv!=rv))
        {
            document.getElementById("next").disabled=true;
        }
        else{
        document.getElementById("next").disabled=false;
        }

        }
        </script>
    </fieldset>
    </form>
</body>
</head>
</html>
