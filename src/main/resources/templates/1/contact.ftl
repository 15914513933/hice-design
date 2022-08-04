<!doctype html>
<html class="no-js" lang="">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>HICE</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- favicon icon -->
        <link rel="icon" href="img/favicon.png">
       
		<!-- All CSS Files Here -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/et-line-fonts.css">
        <link rel="stylesheet" href="css/ionicons.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="css/meanmenu.css">
        <link rel="stylesheet" href="css/global.css">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="css/responsive.css">
        <script src="js/vendor/modernizr-2.8.3.min.js"></script>
        <style>
            <#if designWebsite.contactBg??>
                .contact-bg {
                    background: rgba(0, 0, 0, 0) url(/upload/img${designWebsite.contactBg!}) repeat scroll center center / cover;
                }
            </#if>
        </style>
    </head>
    <body>
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

        <!-- Add your site or application content here -->
		<!-- PRELOADER -->
		<div class="page-loader">
			<div class="loader">Loading...</div>
		</div>
		<!-- /PRELOADER -->        
		<!-- header start -->
		<header id="sticky-header" class="header-fixed">
            <div class="header-area">
                <div class="container sm-100">
                    <div class="row">
                        <div class="col-md-3 col-sm-2">
                            <div class="logo text-upper">
                                <h4><a href="index.html"><img src="/upload/img${designWebsite.logo!}" alt="" style="width:80px;"/></a></h4>
                            </div>
                        </div>
                        <div class="col-md-9 col-sm-10">
                            <div class="menu-area hidden-xs">

                                <nav>
                                    <ul class="basic-menu clearfix">
                                        <li><a href="index.html">首页</a>
                                        </li>
                                        <!-- PORTFOLIO -->
                                        <li>
                                            <a href="portfolio.html">作品</a>

                                        </li>
                                        <li><a href="about.html">关于我</a></li>


                                        <!-- END BLOG -->
                                        <li><a>联系我</a></li>
                                    </ul>
                                </nav>
                            </div>
                            <!-- basic-mobile-menu -->
                            <div class="basic-mobile-menu visible-xs">
                                <nav id="mobile-nav">
                                    <ul>
                                        <li><a href="index.html">首页</a>
                                        </li>

                                        <!-- PORTFOLIO -->
                                        <li>
                                            <a href="portfolio.html">作品</a>

                                        </li>
                                        <li><a href="about.html">关于我</a></li>
                                        <li><a>联系我</a></li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- header end -->

        <div class="basic-space"></div>

        <!-- basic-slider start -->
        <div class="basic-slider <#if designWebsite.contactBg??>contact-bg<#else>slide-2</#if> height-100-vh">
            <div class="container">
                <div class="hero-caption">
                    <div class="slider-content hero-text">
                        <!--
                        <h2>Hello, I am mehedi & Developer</h2>
                        <p>Design | Development | Branding</p>
                        <a class="btn" href="#">About Us</a> -->
                    </div>
                </div>
            </div>
        </div>
		
		<div class="basic-contact-form ptb-90">
			<div class="container">
				<div class="area-title text-center">
					<h2>联系我</h2>
				</div>			
				<div class="row">
					<div class="col-sm-8 col-sm-offset-2">
						<form id="contact-form" action="mail.php" method="post">
							<div class="row">
								<div class="col-md-6 form-group">
									<label class="sr-only">First Name</label>
									<input type="text" class="form-control input-lg" name="name" placeholder="名字" >
									<p class="help-block text-danger"></p>
								</div>
								<div class="col-md-6 form-group">
									<label class="sr-only">Email</label>
									<input type="email" class="form-control input-lg" name="email" placeholder="Email" >
									<p class="help-block text-danger"></p>
								</div>
								<div class="col-md-12 form-group">
									<label class="sr-only">Subject</label>
									<input type="text" class="form-control input-lg" name="subject" placeholder="电话" >
									<p class="help-block text-danger"></p>
								</div>
								<div class="col-md-12 form-group">
									<textarea class="form-control input-lg" rows="7" name="message" placeholder="留言"></textarea>
									<p class="help-block text-danger"></p>
								</div>
								<div class="col-md-12 text-center">
									<button type="submit" class="btn btn-lg btn-round btn-dark">发送</button>
								</div>

							</div><!-- .row -->
						</form>
						<!-- Ajax response -->
						<div class="ajax-response text-center"></div>
					</div>
				</div>			
			</div>
		</div>
		
		<footer>
			<div class="basic-footer text-center ptb-50 gray-bg">
				<div class="container">
					<div class="footer-menu mt-30">
						<nav>
							<ul>
								<li><a href="#">作品</a></li>
								<li><a href="#">关于我</a></li>
								<li><a href="#">联系我</a></li>
							</ul>
						</nav>
					</div>
					<div class="copyright mt-20">
						<p>All copyright © reserved By chenkj</a></p>
					</div>
				</div>
			</div>
		</footer>


		
		<!-- All js plugins here -->
        <script src="js/vendor/jquery-1.12.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/isotope.pkgd.min.js"></script>
        <script src="js/imagesloaded.pkgd.min.js"></script>
        <!--<script src="js/jquery.magnific-popup.min.js"></script>-->
        <script src="js/jquery.meanmenu.js"></script>
        <script src="js/mail.js"></script>

		
        <script src="js/plugins.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
