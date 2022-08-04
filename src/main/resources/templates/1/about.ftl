<!doctype html>
<html class="no-js" lang="en">
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
                    <#if designWebsite.aboutBg??>
                        .about-bg {
                            background: rgba(0, 0, 0, 0) url(/upload/img${designWebsite.aboutBg!}) repeat scroll center center / cover;
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
                                        <li><a>关于我</a></li>


                                        <!-- END BLOG -->
                                        <li><a href="contact.html">联系我</a></li>
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
                                        <li><a>关于我</a></li>
                                        <li><a href="contact.html">联系我</a></li>
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
        <div class="basic-slider <#if designWebsite.aboutBg??>about-bg<#else>slide-2</#if> height-100-vh">
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

		<div class="about-us-area pt-90">
			<div class="container">
					
				<div class="row">
					<!-- ABOUT TEXT -->
					<div class="col-md-6">
						<div class="about-text mt-90">
							<h5>Hello, I'm ${designer.name!}</h5>
							
							<ul>
								<li>电话: ${designer.phone!}</li>
								<li>E-mail: <a href="mailto:${designer.email!}">${designer.email!}</a></li>
							</ul>
							<div class="signature mt-20">
								<img src="/upload/img${designer.logo!}" alt="" style="width:100px">
							</div>
						</div>
					</div>
					<!-- /ABOUT TEXT -->
					<!-- PHOTO -->
					<div class="col-md-6">
						<div class="about-img">
							<img src="img/me.jpg" alt="">
						</div>
					</div>
					<!-- /PHOTO -->
				</div>
			</div>
		</div>
		
			
		<!-- basic-process-area start -->
		<!--
		<div class="basic-process-area pt-90 pb-60">
			<div class="container">
				<div class="area-title text-center">
					<h2>服务</h2>
					<p></p>
				</div>			
				<div class="row">
					<div class="col-md-3 col-sm-6 mb-30">
						<div class="process-item text-center">
							<div class="process-item-icon">
								<span class="icon-linegraph "></span>
							</div>
							<div class="process-item-content">
								<span class="process-item-number">1</span>
								<h3 class="process-item-title">包装</h3>
								<p>A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy.</p>
							</div>
						</div>
					</div>
					<div class="col-md-3 col-sm-6 mb-30">
						<div class="process-item text-center highlight">
							<div class="process-item-icon">
								<span class="icon-lightbulb"></span>
							</div>
							<div class="process-item-content">
								<span class="process-item-number">2</span>
								<h3 class="process-item-title">设计</h3>
								<p>Balancing a composition involves arranging both positive elements and negative space in such a way.</p>
							</div>
						</div>
					</div>
					<div class="col-md-3 col-sm-6 mb-30">
						<div class="process-item text-center">
							<div class="process-item-icon">
								<span class="icon-pencil"></span>
							</div>
							<div class="process-item-content">
								<span class="process-item-number">3</span>
								<h3 class="process-item-title">海报</h3>
								<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live.</p>
							</div>
						</div>
					</div>
					<div class="col-md-3 col-sm-6 mb-30">
						<div class="process-item text-center highlight">
							<div class="process-item-icon">
								<span class="icon-laptop"></span>
							</div>
						<div class="process-item-content">
							<span class="process-item-number">4</span>
							<h3 class="process-item-title">插画</h3>
							<p>One morning, when Gregor Samsa woke from troubled dreams, he found himself transformed in his bed.</p>
						</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		-->
		
		
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
        <script src="js/plugins.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
