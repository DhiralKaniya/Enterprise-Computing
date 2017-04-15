<%-- 
    Document   : registration
    Created on : 13 Apr, 2017, 1:21:46 PM
    Author     : dhiral
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Registration</title>
       <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css">
        <style>
            body {
              display: flex;
              min-height: 100vh;
              flex-direction: column;
            }

            main {
              flex: 1 0 auto;
            }

            body {
              background: #fff;
            }

            .input-field input[type=date]:focus + label,
            .input-field input[type=text]:focus + label,
            .input-field input[type=email]:focus + label,
            .input-field input[type=password]:focus + label {
              color: #e91e63;
            }

            .input-field input[type=date]:focus,
            .input-field input[type=text]:focus,
            .input-field input[type=email]:focus,
            .input-field input[type=password]:focus {
              border-bottom: 2px solid #e91e63;
              box-shadow: none;
            }
        </style>
    </head>
    <body>
       <div class="section"></div>
  <main>
    <center>
      
      <div class="section"></div>

      <h5 class="indigo-text">Please, Register Your Details</h5>
      <div class="section"></div>

      <div class="container">
        <div class="z-depth-1 grey lighten-4 row" style="display: inline-block; padding: 32px 48px 0px 48px; border: 1px solid #EEE;">

          <form action="Controller?action=register" class="col s12" method="post">
            <div class='row'>
              <div class='col s12'>
              </div>
            </div>
              
            <div class='row'>
              <div class='input-field col s12'>
                  <input class='validate' type='text' name='custname' id='custname' required />
                <label for='custname'>Enter your Name</label>
              </div>
            </div>
              
            <div class='row'>
              <div class='input-field col s12'>
                <input class='validate' type='number' name='contactno' id='contact' required/>
                <label for='email'>Enter your Contact no</label>
              </div>
            </div>
              
            <div class='row'>
              <div class='input-field col s12'>
                <input class='validate' type='email' name='email' id='email' required />
                <label for='email'>Enter your email</label>
              </div>
            </div>

            <div class='row'>
              <div class='input-field col s12'>
                <input class='validate' type='password' name='password' id='password' required />
                <label for='password'>Enter your password</label>
              </div>
              <label style='float: right;'>
                                <a class='pink-text' href='index.jsp'><b>Back to Login</b></a>
                            </label>
            </div>

            <br />
            <center>
              <div class='row'>
                <button type='submit' name='register' class='col s12 btn btn-large waves-effect indigo'>SignUp</button>
              </div>
            </center>
          </form>
        </div>
      </div>
      
    </center>

    <div class="section"></div>
    <div class="section"></div>
  </main>

  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.1/jquery.min.js"></script>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js"></script> 
    </body>
</html>
