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
        <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:300i,400,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css" integrity="sha512-10/jx2EXwxxWqCLX/hHth/vu2KY3jCF70dCQB8TSgNjbCVAC/8vai53GfMDrO2Emgwccf2pJqxct9ehpzG+MTw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="preconnect" href="https://fonts.gstatic.com" />
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet" />
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />


        <title>Nong2km</title>
    </head>


    <body>



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



        <div class="bg-img" style="background-image: url(images/banner_bg01.jpg); height: 975px;" >
            <div class="layer">
                <div class=""  >
                    <div id="content" style="margin-right: 500px; line-height: 30px; ">
                        <h5 style="color: #e4d804; font-size: 26px;font-weight: 700;">Nong2km</h5>
                        <h1>Unlimited <span style="color: #e4d804">Movie</span> , TVs <br> Shows, & More.</h1>
                        <h3>Xem mọi lúc mọi nơi</h3>

                    </div>
                </div>
                <div class="row w-100">
                    <div class="col-md-2 col-1"></div>
                    <div class="col-md-8 col-10 p-0 main-search">
                        <div class="input-group mb-3" style="font-family: 'Poppins', sans-serif;">

                            <a href="login" class="btn top-sign-in  button d-flex " style="text-decoration: none ;
                               height: 60px;
                               line-height: 30px;"> 
                                <span style="margin-top: 10px;padding-left: 10px;"  >Xem Ngay</span>
                                <span id="boot-icon" class="bi bi-play" style="font-size: 40px; opacity: 0.5; color: rgb(255, 210, 48); -webkit-text-stroke-width: 0px;
                                      padding-top: 4px"></span>
                            </a>

                        </div>
                    </div>
                    <div class="col-md-2 col-1"></div>
                </div>
            </div>
        </div>

        <style>

            a {
                text-decoration: none;
            }

            img {
                display: block;
                max-width: 100%;
            }

            body,
            input,
            button,
            textarea,
            select {
                outline: none;
                font-size: 12px;
                line-height: 1.5;
                font-family: "Poppins", sans-serif;
            }

            input {
                line-height: normal;
            }



            .image-item {
                transition: all 0.5s ease;
                position: relative;
                right: 44px;
                top:100px;
                margin-bottom: 100px;

            }




            .image {
                height: 300px;
                margin-left: 200px;
                margin-bottom: 20px;

            }
            .image img {
                position: relative;
                bottom: 320px;
                left: 5px;

            }

            .image2 {
                height: 300px;
                margin-bottom: 20px;
            }

            .image2 img {
                width: 100%;
                height: 100%;
                object-fit: cover;
                border-radius: 12px;
                padding-bottom: 0px;
            }

            .image-slider .slick-dots  {
                margin-bottom: 300px;

            }
            .image-slider2 .slick-dots  {
                position: relative;
                top: 0px;

            }
            .image-slider2{
                padding-top: 55px;
            }
            .image img {
                width: 100%;
                height: 100%;
                object-fit: cover;
                border-radius: 12px;
            }

            .image-top-number {
                height: 300px;
                margin-bottom: 20px;
                margin-right: 44px
            }

            .image-top-number img {
                width: 100%;
                height: 100%;
            }

            .slick-initialized .slick-slide {
                margin: 0 10px;
            }

            .slick-arrow:hover {
                background: none;
                color: rgb(141, 141, 141);
            }
            .slick-prev{
                position: absolute;
                top: 40%;
                transform: translateY(-50%);
                left: 0px;

            }

            .slick-next{
                /*float: right;*/
                position: absolute;
                right: 0px;
                top: 40%;
                transform: translateY(-50%);

            }
            .image-slider .slick-prev{
                position: absolute;
                top: 35%;
                transform: translateY(-50%);
                left: 0px;

            }

            .image-slider .slick-next{
                /*float: right;*/
                position: absolute;
                right: 0px;
                top: 35%;
                transform: translateY(-50%);

            }



            .slick-arrow {
                border: none;
                /*display: flex;*/
                /*justify-content: center;*/
                /*align-items: center;*/
                font-size: 60px;
                background: none;
                cursor: pointer;
                color: rgb(141, 141, 141);
                z-index: 2;
            }




            .slick-dots {
                position: absolute;
                bottom: 0;
                left: 50%;
                transform: translate(-50%, 0);
                display: flex !important;
                align-items: center;
                justify-content: center;
                gap: 0 20px;
            }

            .slick-dots button {
                font-size: 0;
                width: 15px;
                height: 6px;
                border-radius: 50%;
                background-color: #eee;
                border: none;
                outline: none;
                transition: all 0.2s linear;
            }

            .slick-dots .slick-active button {
                background-color: #2cccff;
            }

            ol,
            ul {
                list-style: none;
            }

            .image-title {
                font-size: 20px;
                color: #8e8fb5;
            }

            .section h2{
                padding-top: 55px;
            }
            .image-item:hover{
                scale:122%;

            }
            .image-item:hover img{
                opacity:1;


            }

            .image-item i{
                display: none;
            }
            .image-item:hover i{
                display: inline;
            }
            .image-item:hover img{
                filter: brightness(80%);
            }

        </style>

        <section class="section2" style="background-image:linear-gradient(rgba(0, 0, 0, 0.8), rgba(0, 0, 0, 0.8)),url(images/3498448.jpg);
                 height: 975px; position: relative;
                 ">
            <h2 style="padding-left: 100px;position: relative;top:50px">Top 10</h2>
            <div class="image-slider" style="padding-right: 0px; top: 80px; ">

                <c:forEach items="${requestScope.top10}" var="m">
                    <div style="position: relative;" >

                        <div class="image-item " >
                            <div class="image-top-number">
                                <img style="z-index: 9;" src="images/${m.index}.png" alt="images" />
                            </div>
                            <div class="image">
                                <img "
                                     src="${m.poster}"
                                     alt="" />

                            </div>
                            <a class="play" href="login" style="color: #fff;z-index: 100;" >
                                <i class="bx bx-play-circle"  style="font-size: 38px;position: absolute;bottom: 74%;left: 74%"></i>
                            </a>



                            <a href="trailer.jsp" class="ph" style="color: #fff">
                                <i class="bx bx-movie-play "  style="font-size: 38px;font-weight: lighter;position: absolute;bottom: 85%;left:74%"></i>

                            </a>
                            <a href="login"  class="ph" style="color: #fff">
                                <i class="bx bx-heart "  style="font-size: 38px;font-weight: lighter;position: absolute;bottom: 63%;left:  74%"></i>

                            </a>
                            <i class="bx bx-dots-horizontal-rounded"  style=" color: #fff;font-size: 22px;font-weight: lighter;position: absolute;bottom: 81%;left:76%"></i>

                        </div>
                    </div>

                </c:forEach>



            </div>
        </section>


        <section class="section"  style="background-image:linear-gradient(rgba(0, 0, 0, 0.8), rgba(0, 0, 0, 0.8)),
                 url(images/minions.jpg); background-position-x: -500px;
                 height: 1999px;">
            <h2 style="padding-left: 33px">Phim Được Đánh Giá Cao</h2>

            <div class="image-slider2">
                <c:forEach items="${requestScope.topVote}" var="m">
                    <div style="position: relative;" >

                        <div class="image2-item">
                            <div class="image2">
                                <img
                                    src="${m.poster}"
                                    alt="" />
                            </div>
                            <h3 class="image-title" style="text-align: center">(${m.vote_average})<br>${m.title}<!-- comment --></h3>
                            <a class="play" href="login" style="color: #fff;z-index: 100;" >
                                <i class="bx bx-play-circle"  style="font-size: 38px;position: absolute;bottom: 55%;left: 38%"></i>
                            </a>



                            <a href="trailer.jsp" class="ph" style="color: #fff">
                                <i class="bx bx-movie-play "  style="font-size: 38px;font-weight: lighter;position: absolute;bottom: 70%;left:38%"></i>

                            </a>
                            <a href="login"  class="ph" style="color: #fff">
                                <i class="bx bx-heart "  style="font-size: 38px;font-weight: lighter;position: absolute;bottom: 40%;left:  38%"></i>

                            </a>
                            <i class="bx bx-dots-horizontal-rounded"  style=" color: #fff;font-size: 22px;font-weight: lighter;position: absolute;bottom: 65%;left:42%"></i>


                        </div>
                    </div>

                </c:forEach>
            </div>
            <style>

                .image2-item i{
                    display: none;
                }
                .ph:hover i{
                    scale:100%;
                }
                .image2-item:hover i{
                    display: inline;

                }
                .image2-item:hover img{
                    filter: brightness(80%);

                }

                .play:hover i{
                    scale:120%
                }
                .ph i{
                    scale:80%;
                }

            </style>

            <h2 style="padding-left: 33px">Phim Có Nhiều Lượt Xem</h2>

            <div class="image-slider2">

                <c:forEach items="${requestScope.topView}" var="m">
                    <div style="position: relative;" >
                        <div class="image2-item">
                            <div class="image2">
                                <img
                                    src="${m.poster}"
                                    alt="" />
                            </div>

                            <h3 class="image-title" style="text-align: center">${m.title}<!-- comment --></h3>
                            <a class="play" href="login" style="color: #fff;z-index: 100;" >
                                <i class="bx bx-play-circle"  style="font-size: 38px;position: absolute;bottom: 55%;left: 38%"></i>
                            </a>



                            <a href="trailer.jsp" class="ph" style="color: #fff">
                                <i class="bx bx-movie-play "  style="font-size: 38px;font-weight: lighter;position: absolute;bottom: 70%;left:38%"></i>

                            </a>
                            <a href="login"  class="ph" style="color: #fff">
                                <i class="bx bx-heart "  style="font-size: 38px;font-weight: lighter;position: absolute;bottom: 40%;left:  38%"></i>

                            </a>
                            <i class="bx bx-dots-horizontal-rounded"  style=" color: #fff;font-size: 22px;font-weight: lighter;position: absolute;bottom: 65%;left:42%"></i>
                            <i class="bx bx-dots-horizontal-rounded"  style="color: #fff;font-size: 22px;font-weight: lighter;position: absolute;bottom: 50%;left: 42%"></i>
                        </div>



                    </div>
                </c:forEach>
            </div>
            <h2 style="padding-left: 33px">Phim Sắp Chiếu</h2>

            <div class="image-slider2">
                <c:forEach items="${requestScope.New}" var="m">
                    <div style="position: relative;" >

                        <div class="image2-item">
                            <div class="image2">
                                <img
                                    src="${m.poster}"
                                    alt="" />
                            </div>
                            <h3 class="image-title" style="text-align: center">${m.title}<!-- comment --></h3>
                            <a class="play" href="login" style="color: #fff;z-index: 100;" >
                                <i class="bx bx-play-circle"  style="font-size: 38px;position: absolute;bottom: 55%;left: 38%"></i>
                            </a>



                            <a href="trailer.jsp" class="ph" style="color: #fff">
                                <i class="bx bx-movie-play "  style="font-size: 38px;font-weight: lighter;position: absolute;bottom: 70%;left:38%"></i>

                            </a>
                            <a href="login"  class="ph" style="color: #fff">
                                <i class="bx bx-heart "  style="font-size: 38px;font-weight: lighter;position: absolute;bottom: 40%;left:  38%"></i>

                            </a>
                            <i class="bx bx-dots-horizontal-rounded"  style=" color: #fff;font-size: 22px;font-weight: lighter;position: absolute;bottom: 65%;left:42%"></i>
                            <i class="bx bx-dots-horizontal-rounded"  style="color: #fff;font-size: 22px;font-weight: lighter;position: absolute;bottom: 50%;left: 42%"></i>


                        </div>
                    </div>

                </c:forEach>
            </div>









            <section style="background-color: #0d1318">
                <div class="faq">
                    <div class="row">
                        <div class="col-md-12 text-center">
                            <h2 class="mb-5">Các Câu Hỏi Thường Gặp</h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-3 col-md-2 col-1"></div>
                        <div class="col-lg-6 col-md-8 col-10 p-0">
                            <a class="btn text-white" data-bs-toggle="collapse" href="#multiCollapseExample1" role="button" aria-expanded="false" aria-controls autoplay="multiCollapseExample1">Nong2km là gì?</a>
                            <div class="collapse multi-collapse" id="multiCollapseExample1">
                                <div class="card card-body">
                                    Nong2km là một dịch vụ phát trực tuyến cung cấp nhiều chương trình truyền hình, phim ảnh, anime, phim tài liệu từng đoạt giải thưởng và hơn thế nữa? trên hàng nghìn thiết bị có kết nối internet. <br><br>
                                    Bạn có thể xem bao nhiêu tùy thích, bất cứ khi nào bạn muốn mà không cần một quảng cáo nào? tất cả với một mức giá thấp hàng tháng. Luôn có điều gì đó mới để khám phá và các chương trình truyền hình và phim mới được thêm vào mỗi tuần!
                                </div>
                            </div>
                            <a class="btn text-white" data-bs-toggle="collapse" href="#multiCollapseExample2" role="button" aria-expanded="false" aria-controls autoplay="multiCollapseExample2">Tôi có thể xem nó ở đâu?</a>
                            <div class="collapse multi-collapse" id="multiCollapseExample2">
                                <div class="card card-body">
                                    Xem mọi lúc mọi nơi trên số lượng thiết bị không giới hạn. Đăng nhập bằng tài khoản Nong2km của bạn để xem ngay lập tức trên web tại Nong2km.com từ máy tính cá nhân của bạn hoặc trên bất kỳ thiết bị kết nối internet nào cung cấp ứng dụng Nong2km, bao gồm TV thông minh, điện thoại thông minh, máy tính bảng, trình phát đa phương tiện và bảng điều khiển trò chơi.
                                </div>
                            </div>

                            <a class="btn text-white" data-bs-toggle="collapse" href="#multiCollapseExample4" role="button" aria-expanded="false" aria-controls autoplay="multiCollapseExample4">Tôi có thể xem gì trên Nong2km?</a>
                            <div class="collapse multi-collapse" id="multiCollapseExample4">
                                <div class="card card-body">
                                    Nong2km có một thư viện phong phú bao gồm phim truyện, phim tài liệu, chương trình truyền hình, anime, bản gốc Nong2km từng đoạt giải thưởng và hơn thế nữa. Xem bao nhiêu tùy thích, bất cứ lúc nào bạn muốn.
                                </div>
                            </div>
                            <a class="btn text-white" data-bs-toggle="collapse" href="#multiCollapseExample5" role="button" aria-expanded="false" aria-controls autoplay="multiCollapseExample5">Nong2km có tốt cho trẻ nhỏ?</a>
                            <div class="collapse multi-collapse" id="multiCollapseExample5">
                                <div class="card card-body">
                                    Trải nghiệm Nong2km Kids được bao gồm trong tư cách thành viên của bạn để cung cấp cho cha mẹ quyền kiểm soát trong khi trẻ em thưởng thức các chương trình truyền hình và phim thân thiện với gia đình trong không gian riêng của chúng. <br> <br> Hồ sơ trẻ em đi kèm với tính năng kiểm soát của phụ huynh được bảo vệ bằng mã PIN cho phép bạn hạn chế xếp hạng độ tuổi của nội dung mà trẻ em có thể xem và chặn các tiêu đề cụ thể mà bạn không muốn trẻ em xem.
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-2 col-1"></div>
                    </div>

                </div>
            </section>

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
