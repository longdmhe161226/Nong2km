<%-- 
    Document   : index
    Created on : Oct 8, 2022, 5:01:26 AM
    Author     : FPT SHOP PCC Hai Hau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.css" integrity="sha512-HHsOC+h3najWR7OKiGZtfhFIEzg5VRIPde0kB0bG2QRidTQqf+sbfcxCTB16AcFB93xMjnBIKE29/MjdzXE+qw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:300i,400,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="preconnect" href="https://fonts.gstatic.com" />
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet" />
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>



        <title>Nong2km</title>
    </head>


    <body style="background-color: #0d1318">


        <nav class="navbar navbar-light p-0" style="z-index: 10;">
            <div class="container-fluid px-5">

                <a class="navbar-brand" href="home" style="height: 100px;"><img style="height: 100%" src="images/image-removebg-preview.png" alt="logo"/></a>
                <ul id="main-menu" class="d-flex" style="list-style: none;">
                    <li><a style="font-size: 19px" href="home" >Trang chủ</a></li>
                    <li><a style="font-size: 19px" href="">Thể loại</a>
                        <ul class="sub-menu" style="z-index: 2">

                            <c:forEach items="${sessionScope.genre}" var="g" >
                                <li><a style="font-size: 13px" href="list?cate=${g.name}">${g.getName()}</a></li>

                            </c:forEach>                            
                        </ul>
                    </li>
                    <li><a style="font-size: 19px" href="favorite">Yêu thích</a></li>
                    <li><a style="font-size: 19px" href="support">Hỗ trợ</a></li>
                </ul>
                <span class="d-flex header-search">
                    <style>
                        #search{
                            background: #fff;
                            padding-left: 0px;
                            border-radius: 30px;
                            margin:0px 0px;
                        }
                        #search #txt {
                            border: none;
                            outline: none;
                            background: none;
                            width: 0;
                            padding-left: 0px;
                            margin: 0px -26px;
                            transition: all 0.25s ease-in-out;
                        }
                        #search #search-btn{
                            background-color: #fff;
                            cursor: pointer;
                            border: none;
                            padding: 8px 12px;
                            border-radius: 50%;
                        }

                        #search:hover #txt,#search #txt:valid{
                            width: 300px;
                            padding: 0px 40px;
                        }
                        #searchad{
                            background: #fff;
                            padding-left: 0px;
                            border-radius: 30px;
                            margin:0px 0px;
                        }
                        #searchad #txt {
                            border: none;
                            /*outline: none;*/
                            width: 300px;
                            padding: 0px 22px;
                            background: none;
                            /*width: 0;*/
                            /*padding-left: 0px;*/
                            /*margin: 0px -26px;*/
                            transition: all 0.25s ease-in-out;
                        }
                        #searchad #search-btn{
                            background-color: #fff;
                            cursor: pointer;
                            border: none;
                            padding: 8px 12px;
                            border-radius: 50%;
                        }

                        /*                        #searchad:hover #txt,#search #txt:valid{
                                                    width: 300px;
                                                    padding: 0px 40px;
                                                }*/

                    </style>


                    <c:if test="${sessionScope.user==null}">
                        <form action="search" method="" id="search">

                            <input type="text" name="search" id="txt" placeholder="Tìm gì cũng có :33" required="Nhập đi rồi tìm :<<<" />
                            <button id="search-btn">
                                <i class="fa-solid fa-magnifying-glass"></i></i></button>
                        </form>
                        <a href="register" class="btn top-sign-up button" style="text-decoration: none ;   ">Đăng Kí</a>
                        <a href="login" class="btn top-sign-up button" style="text-decoration: none ;">Đăng Nhập</a>
                    </c:if>

                    <c:if test="${sessionScope.role==0}">
                        <ul id="main-menu" class="d-flex" style="list-style: none;">

                            <li><form action="search" method="" id="search">

                                    <input type="text" name="search" id="txt" placeholder="Tìm gì cũng có :33" required="Nhập đi rồi tìm :<<<" />
                                    <button id="search-btn">
                                        <i class="fa-solid fa-magnifying-glass"></i></i></button>
                                </form></li>

                            <li><a style="font-size: 19px" href=""></a>
                                <ul class="sub-menu" style="z-index: 2">

                                    <li><a style="font-size: 15px" href="profile">Hồ Sơ</a></li>
                                    <li><a style="font-size: 15px" href="logout">Đăng Xuất</a></li>


                                </ul>
                            </li>

                        </ul>
                    </c:if>
                    <c:if test="${sessionScope.role==1}">
                        <ul id="main-menu" class="d-flex" style="list-style: none;">

                            <li><form action="search" method="" id="search">

                                    <input type="text" name="search" id="txt" placeholder="Tìm gì cũng có :33" required="Nhập đi rồi tìm :<<<" />
                                    <button id="search-btn">
                                        <i class="fa-solid fa-magnifying-glass"></i></i></button>
                                </form></li>

                            <li><a style="font-size: 19px" href=""></a>
                                <ul class="sub-menu" style="z-index: 2">

                                    <li><a style="font-size: 15px" href="profile">Hồ Sơ</a></li>
                                    <li><a style="font-size: 15px" href="logout">Đăng Xuất</a></li>
                                    <li><a style="font-size: 15px" href="listad">Quản Lý Phim</a></li>
                                    <li><a style="font-size: 15px" href="listcate">Category</a></li>
                                    <li><a style="font-size: 15px" href="listdirect">Directors</a></li>
                                    <li><a style="font-size: 15px" href="listprodu">Producers</a></li>
                                    <li><a style="font-size: 15px" href="liststar">Actor</a></li>


                                </ul>
                            </li>

                        </ul>
                    </c:if>
                </span>

            </div>
        </nav>


        <style>
            @import url('https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&display=swap');
            *{
                padding: 0;
                margin: 0;
            }

            #wrapper{
                max-width: 1800px;
                margin: 0 auto;
            }
            body{
                font-family: 'Open Sans',sans-serif;
                font-size: 14px;
                line-height: 1.15;
                color: #fff;
            }
            .products-preview{
                /*justify-content: center;*/
                text-align: center;

            }
            .products-preview h2{
                padding-top: 155px;
            }

        </style>

        <div class="products-preview" id="wrapper" style="background-color: #0d1318;height: auto;padding-top: 222px;">
            <form action="addstar" method="post">
                <div>Name: &nbsp;&nbsp;&nbsp;&nbsp;<input style="width: 444px;margin-right:289px;height: 33px;" type="text" name="name"/>
                    <br><!-- comment -->
                    <br>



                    Description: <textarea id="overv" name="des" rows="5" cols="100" style="height: 155px"></textarea>
                    <br><!-- comment -->
                    <br>
                    Male: <input type="radio" id="id" name="male" value="1"> Male
                    <input type="radio" id="id" name="male" value="0"> feMale
                    <br><!-- comment -->
                    <br>
                    Dob: <input type="date" name="dob">
                    <br><!-- comment -->
                    <br>
                    Nationality: <input type="text" id="id" name="Nationality">
                    <br><!-- comment -->
                    <br>





                    <input  style="margin-bottom: 33px;width: 55px;height: 28px;" type="submit" value="ADD"/><!-- comment -->


                </div>


            </form>
        </div>






        <footer style="background-color: #0d1318">
            <div class="container">
                <ul>
                    <li class="ps-2 pb-3">Questions? Call <a href="#">0945249828</a><br><!-- comment -->
                        Mail: <a href="#">nguyenthanhlong16102002@gmail.com</a>
                    </li>

                </ul>
                <div class="row">
                    <div class="col-md-3 col-6">
                        <ul>
                            <li><a href="#">FAQ</a></li>
                            <li><a href="#">Investor Relations</a></li>
                            <li><a href="#">Privacy</a></li>
                            <li><a href="#">Speed Test</a></li>
                        </ul>
                    </div>
                    <div class="col-md-3 col-6">
                        <ul>
                            <li>An active item</a></li>
                            <li><a href="#">Help Centre</a></li>
                            <li><a href="#">Jobs</a></li>
                            <li><a href="#">Cookie Preferences</a></li>
                            <li><a href="#">Legal Notices</a></li>
                        </ul>
                    </div>
                    <div class="col-md-3 col-6">
                        <ul>
                            <li><a href="#">Account</a></li>
                            <li><a href="#">Ways to Watch</a></li>
                            <li><a href="#">Corporate Information</a></li>
                            <li><a href="#">Nong2km Originals</a></li>
                        </ul>
                    </div>
                    <div class="col-md-3 col-6">
                        <ul>
                            <li><a href="#">Media Centre</a></li>
                            <li><a href="#">Terms of Use</a></li>
                            <li><a href="#">Contact Us</a></li>
                        </ul>
                    </div>
                </div>
            </div>


        </footer>
        <script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
        <script>
            $(document).ready(function () {
                //tim tat ca cac li co sub menu va them vao no class has child
                $('.sub-menu').parent('li').addClass('has-child');
            });
        </script>

        <script>
            $(document).ready(function () {
                $(".image-slider").slick({
                    slidesToShow: 5,
                    slidesToScroll: 5,
                    infinite: true,
                    arrows: true,
                    draggable: true,
                    //                    prevArrow: none,
                    prevArrow: `<button type='button' class='slick-prev slick-arrow'><ion-icon name="arrow-back-outline"></ion-icon></button>`,
                    nextArrow: `<button type='button' class='slick-next slick-arrow'><ion-icon name="arrow-forward-outline"></ion-icon></button>`,

                    dots: true,
                    responsive: [
                        {
                            breakpoint: 1025,
                            settings: {
                                slidesToShow: 3,
                            },
                        },
                        {
                            breakpoint: 480,
                            settings: {
                                slidesToShow: 1,
                                arrows: false,
                                infinite: false,
                            },
                        },
                    ],
                    //                    autoplay: true,
                    //                    autoplaySpeed: 3000,
                });
            });

            $(document).ready(function () {
                $(".image-slider2").slick({
                    slidesToShow: 10,
                    slidesToScroll: 10,
                    infinite: true,
                    arrows: true,
                    draggable: true,
                    prevArrow: `<button type='button' class='slick-prev slick-arrow'><ion-icon name="arrow-back-outline"></ion-icon></button>`,
                    nextArrow: `<button type='button' class='slick-next slick-arrow'><ion-icon name="arrow-forward-outline"></ion-icon></button>`,

                    dots: true,
                    responsive: [
                        {
                            breakpoint: 1025,
                            settings: {
                                slidesToShow: 3,
                            },
                        },
                        {
                            breakpoint: 480,
                            settings: {
                                slidesToShow: 1,
                                arrows: false,
                                infinite: false,
                            },
                        },
                    ],
                    // autoplay: true,
                    // autoplaySpeed: 1000,
                });
            });
        </script>
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
        <script type="text/javascript" src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"></script>
    </body>
</html>
