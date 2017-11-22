<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>CLC- CAPTCHA</title>

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">


      <link rel="stylesheet" href="css/style.css">
      <link rel="stylesheet" href="css/color-scheme.css">
<div class="center">
  <p><img src="img/logo.png" /></p>
</div>
<body class="color-scheme-background-3">
<form id="msform">
<ul id="progressbar">
    <li>Account Setup</li>
    <li>Terms and Conditions</li>
    <li class="active">Captcha Test</li>
</ul>
    <fieldset>
        <h2 class="fs-title">CAPTCHA TEST</h2>
    <img src="img/captchas/captchas/captcha3.jpg" alt="captcha" width="200" height="97" id="cappbutt">
    <button class = "capbutt" id="close-image"><img src="img/captchas/reCAPTCHA_logo.png" onclick="changeImage();"></button>
    <script>
        var images = [];
        function changeImage()
        {
            //var img = document.getElementById("close-image");
            return true;
        }
    </script>

    <input type="text" name="captcha" placeholder="Type in Captcha" />
    <input type="button" name="previous" class="previous action-button" value="Previous" onclick="location.href='./agreeTerms'"/>
    <input type="reset" name="submit" class="submit action-button" value="Submit" onclick="location.href='./success'"/>
    </fieldset>
    </form>
</body>
</head>
</html>
