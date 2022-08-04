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
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/et-line-fonts.css">
        <link rel="stylesheet" href="../css/ionicons.min.css">
        <link rel="stylesheet" href="../css/magnific-popup.css">
        <link rel="stylesheet" href="../css/meanmenu.css">
        <link rel="stylesheet" href="../css/global.css">
        <link rel="stylesheet" href="../style.css">
        <link rel="stylesheet" href="../css/responsive.css">
        <script src="../js/vendor/modernizr-2.8.3.min.js"></script>
        <style>
            .pic-row{
                margin-bottom: 10px
            }
            .area-description {
                margin: 0 auto 28px;
                width: 60%;
            }
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
        								<h4><a href="../index.html"><img src="/upload/img${designWebsite.logo!}" alt="" style="width:80px;"/></a></h4>
        							</div>
        						</div>
        						<div class="col-md-9 col-sm-10">
        							<div class="menu-area hidden-xs">

        								<nav>
        									<ul class="basic-menu clearfix">
        										<li><a href="../index.html">首页</a>
        										</li>
        										<!-- PORTFOLIO -->
        										<li>
        											<a href="../portfolio.html">作品</a>

        										</li>
        										<li><a href="../about.html">关于我</a></li>


        										<!-- END BLOG -->
        										<li><a href="../contact.html">联系我</a></li>
        									</ul>
        								</nav>
        							</div>
        							<!-- basic-mobile-menu -->
        							<div class="basic-mobile-menu visible-xs">
        								<nav id="mobile-nav">
        									<ul>
        										<li><a href="../index.html">首页</a>
        										</li>

        										<!-- PORTFOLIO -->
        										<li>
        											<a href="../portfolio.html">作品</a>

        										</li>
        										<li><a href="../about.html">关于我</a></li>
        										<li><a href="../contact.html">联系我</a></li>
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

        		<!-- basic-breadcrumb start -->

        		<div class="basic-breadcrumb-area gray-bg pt-80 pb-60">
        			<div class="container">
        				<div class="basic-breadcrumb text-center">
        					<h3 class="">${designWork.theme!}</h3>
        					<ol class="breadcrumb text-xs">
        						<li>${designWork.label!}</li>

        					</ol>
        				</div>
        			</div>
        		</div>
        		<!-- basic-breadcrumb end -->
        		<!-- basic-portfolio-area start -->
        		<div class="portfolio-details-area ptb-40">
        			<div class="container">
        			    <#list designWorkPictures as item>
        			        <div class="row pic-row">
                                <div class="col-md-12">
                                    <div class="portfolio-full-img">
                                        <img src="/upload/img${item.pictureUrl!}" alt="" />
                                    </div>
                                </div>
                            </div>
                            <div class="area-description text-center">
                                <p>${item.description!}</p>
                            </div>
        			    </#list>


        				<!--
        				<div class="row mt-70">
        					<div class="col-md-4">
        						<ul class="project-details">
        							<li class="font-alt">Categories: <a href="#">Photography</a>,<a href="#">Design</a></li>
        							<li class="font-alt">Released: 23 November 2015</li>
        							<li class="font-alt">Online: <a href="#">www.site.com</a></li>
        							<li class="font-alt">Client: <a href="#">Mark Stone</a></li>
        						</ul>
        						<div class="portfolio-view-btn mt-20">
        							<a class="btn" href="#">View Project</a>
        						</div>
        					</div>
        					<div class="col-md-8">
        						<div class="row multi-columns-row">
        							<div class="col-sm-6 col-md-6 mb-30">
        								<h5 class="font-alt m-t-0">Highly customizable</h5>
        								<p>The European languages are members of the same family. Their separate existence is a myth. For science, music, sport, etc, Europe uses the same vocabulary.</p>
        							</div>

        							<div class="col-sm-6 col-md-6 mb-30">
        								<h5 class="font-alt m-t-0">Responsive design</h5>
        								<p>The European languages are members of the same family. Their separate existence is a myth. For science, music, sport, etc, Europe uses the same vocabulary.</p>
        							</div>

        							<div class="col-sm-6 col-md-6 mb-30">
        								<h5 class="font-alt m-t-0">Optimised for speed</h5>
        								<p>The European languages are members of the same family. Their separate existence is a myth. For science, music, sport, etc, Europe uses the same vocabulary.</p>
        							</div>

        							<div class="col-sm-6 col-md-6 mb-30">
        								<h5 class="font-alt m-t-0">Features & plugins</h5>
        								<p>The European languages are members of the same family. Their separate existence is a myth. For science, music, sport, etc, Europe uses the same vocabulary.</p>
        							</div>
        						</div>
        					</div>
        				</div>
        				-->
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
        <script src="../js/vendor/jquery-1.12.0.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/isotope.pkgd.min.js"></script>
        <script src="../js/imagesloaded.pkgd.min.js"></script>
        <!--<script src="../js/jquery.magnific-popup.min.js"></script>-->
        <script src="../js/jquery.meanmenu.js"></script>
        <script src="../js/plugins.js"></script>
		<script type="text/javascript">
			// grab an element
			var myElement = document.querySelector(".headroom");
			// construct an instance of Headroom, passing the element
			var headroom  = new Headroom(myElement);
			// initialise
			headroom.init();
		</script>
        <script src="../js/main.js"></script>
    </body>
</html>
