<!doctype html>
<html class="no-js" lang="">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>HICE</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" href="img/favicon.png">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/et-line-fonts.css">
        <link rel="stylesheet" href="css/ionicons.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="css/meanmenu.css">
        <link rel="stylesheet" href="css/global.css">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="css/responsive.css">
        <style>
            <#if designWebsite.indexBg??>
                .index-bg {
                    background: rgba(0, 0, 0, 0) url(/upload/img${designWebsite.indexBg!}) repeat scroll center center / cover;
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
										<li><a>首页</a>
										</li>
										<!-- PORTFOLIO -->
										<li>
											<a href="portfolio.html">作品</a>

										</li>
										<li><a href="about.html">关于我</a></li>


										<!-- END BLOG -->
										<li><a href="contact.html">联系我</a></li>
									</ul>
								</nav>
							</div>
							<!-- basic-mobile-menu -->
							<div class="basic-mobile-menu visible-xs">
								<nav id="mobile-nav">
									<ul>
										<li><a>首页</a>
										</li>

										<!-- PORTFOLIO -->
										<li>
											<a href="portfolio.html">作品</a>

										</li>
										<li><a href="about.html">关于我</a></li>
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
		<div class="basic-slider <#if designWebsite.indexBg??>index-bg<#else>slide-2</#if> height-100-vh">
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
		<!-- basic-slider end -->
		<!-- basic-portfolio-area start -->
		<div class="basic-portfolio-area ptb-50">
			<div class="container">
				<div class="filter-menu text-center mb-40">
					<button class="active" data-filter="*">所有</button>
					<#list designWorkCategoryList as item>
                        <button data-filter=".${item.code!}">${item.name!}</button>
                    </#list>
				</div>
				<div id="portfolio-grid" class="row-portfolio portfolio-style-2">

					<#list recommendDesignWorks as item>
					    <div class="portfolio-item ${item.categoryCode!}">
                            <div class="portfolio-wrapper">
                                <div class="portfolio-thumb">
                                    <img src="/upload/img${item.cover!}" alt="" />
                                    <div class="view-icon">
                                        <a href="portfolio/${item.id!}.html" target="_blank"><span class="icon-attachment"></span></a>
                                    </div>
                                </div>
                                <div class="portfolio-caption text-right">
                                    <h4><a href="portfolio-single.html">${item.theme!}</a></h4>
                                    <!--
                                    <div class="work-tag">
                                        ${item.label}
                                    </div>
                                    -->
                                </div>
                            </div>
                        </div>
                    </#list>

				</div>
				<div class="view-more mt-20 text-center">
					<a class="btn btn-large" href="portfolio.html">更多</a>
				</div>
			</div>
		</div>

		<!-- basic-blog-area end -->
		<!-- footer start -->
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
		<!-- footer end -->


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
