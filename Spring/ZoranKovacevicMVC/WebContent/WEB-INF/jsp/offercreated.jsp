<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  
<!DOCTYPE html>
<html>
<head>

<style>

@-webkit-keyframes blink {
    from {
        opacity: 1.0;
    }
    to {
        opacity: 0.0;
    }
}
.blink {
    -webkit-animation-name: blink;
    -webkit-animation-iteration-count: infinite;
    -webkit-animation-timing-function: cubic-bezier(1.0, 0, 0, 1.0);
    -webkit-animation-duration: 0.5s;
}


  @keyframes argh-my-eyes {
    0%   { background-color: black; }
    49% { background-color: black; }
    50% { background-color: red; }
    99% { background-color: red; }
    100% { background-color: black; }
  }
  body {
  -webkit-animation: argh-my-eyes 0.2s infinite;
  -moz-animation:    argh-my-eyes 0.2s infinite;
  animation:         argh-my-eyes 0.2s infinite;
}

 



</style>



<meta charset="ISO-8859-1">
<title>OFFER CREATED</title>
</head>
<body>

<p class="blink" style="color:yellow;text-align:center; margin:17% auto;font-size:170px;">Offer created!!!</p>


</body>
</html>