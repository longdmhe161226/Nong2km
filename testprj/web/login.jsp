<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : login
    Created on : Oct 23, 2022, 3:24:51 AM
    Author     : FPT SHOP PCC Hai Hau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <style>

            *{
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            body{
                font-family: "Open Sans";
                color: #fff;

            }
            section{
                position: relative;
                height: 100vh;
                width: 100%;
                background:linear-gradient(rgba(0, 0, 0, 0.8), rgba(0, 0, 0, 0.8)), url("images/3498448.jpg");
                background-size: cover;
                background-position: center center;

            }

            .form-container{
                position: absolute;

                left: 50%;
                transform: translate(-50%,50%);
                background: linear-gradient(rgba(0,0,0,0.3),rgba(0,0,0,0.3));
                width: 380px;
                padding: 50px 30px;
                border-radius: 22px;
                box-shadow:  7px 7px 60px #000;

            }
            h1{
                /*                text-transform: uppercase;*/
                font-size: 2em;
                text-align: center;
                margin-bottom: 2em;

            }

            .control input{
                width: 100%;
                display: block;
                padding: 10px;
                color: #222;
                border: none;
                outline: none;
                margin: 1em 0;
            }


            .control input[type="submit"]{
                background: #fff;

                /*                text-transform: uppercase;*/
                font-size: 1.2em;
                opacity: 1;
                transition: opacity .3s ease;

            }


            .control input[type="submit"]:hover{
                opacity: 0.7;
            }
            .link{
                text-align: center
                    ;

            }
            .link a{
                text-decoration: none;
                color: #fff;
                opacity: 1;
                transition: opacity .3s ease;

            }

            .link a:hover{
                opacity: 1;
                text-decoration: underline;
            }

        </style>
        <section>
            <div class="form-container" style="    font-family: 'Roboto', sans-serif;">
                <h1 style="    font-size: 2rem;    font-weight: bold;">Đăng nhập</h1>
                <form action="login" method="post">
                    <div class="control">
                        <label style="color: rgb(169,170,173); font-size: 19px" for="name">Tên đăng nhập</label>
                        <input style="border-radius: 6px;"  type="text" name="name" id="name"><!-- comment -->
                    </div>
                    <div class="control">
                        <label style="color: rgb(169,170,173)" for="psw">Mật khẩu</label>
                        <input style="border-radius: 6px;" type="password" name="psw" id="psw"><!-- comment -->
                    </div>
                    <p style="color: red"> ${requestScope.error}  </p>

                    <span><input type="checkbox"> Remember me.</span>
                    <div class="control" > 
                        <input style="color: black;border-radius: 33px;font-size: 15px;font-weight: bold;height: 44px" type="submit" value="Tiếp tục"><!-- comment -->
                    </div>

                </form>
                <div class="link">
                    <a href="forgotpass">Quên mật khẩu?</a>
                </div>
            </div>
        </section>
    </body>
</html>
