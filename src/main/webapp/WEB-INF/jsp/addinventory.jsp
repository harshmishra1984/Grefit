<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>

    <title>Login - RIMT.com</title>
    <meta content="text/html; charset=utf-8" http-equiv="content-type"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet/less" type="text/css" href="${pageContext.request.contextPath}/css/application.less"/>
    <script src="${pageContext.request.contextPath}/js/less.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/enhance.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jQuery.fileinput.js"></script>
    <script>
        $(document).ready(function () {

            // hide #back-top first
            $(".go-top").hide();

            // fade in #back-top
            $(function () {
                $(window).scroll(function () {
                    if ($(this).scrollTop() > 100) {
                        $('.go-top').fadeIn();
                    } else {
                        $('.go-top').fadeOut();
                    }
                });

                // scroll body to 0px on click
                $('.go-top').click(function () {
                    $('body,html').animate({
                        scrollTop: 0
                    }, 800);
                    return false;
                });
            });
            $('.sidebar-toggler').click(function () {
                $("body").toggleClass('page-sidebar-closed');
				$('.innerl').addClass('hide');

            });
            $('.btn-navbar').click(function () {
                $(".page-sidebar").toggleClass('heightauto');

            });


		  $('#addinventory').click(function() {
			$('.innerl').toggleClass('hide');
		  });

        });

		 $(function () {
            $('#files').customFileInput();
            $('#file1').customFileInput();
            $('#file2').customFileInput();
        });
    </script>

</head>

<body>
<!-- header start -->
<div class="navbar  navbar-inverse navbar-static-top">
    <div style="opacity:1;" class="navbar-inner">
        <div class="container-fluid PL2">
            <a data-target=".nav-collapse" data-toggle="collapse" class="btn-navbar" href="javascript:;">
                <img alt="" src="${pageContext.request.contextPath}/images/menu-toggler.png">
            </a>

            <!-- logo start -->
            <a class="pull-left" href="/">
                <button type="button" class="btnLog btnLogPat blackLog">Rimt.com</button>
            </a>
            <a class="pull-left" href="#">
                <button type="button" class="btnLog btnLogPat  greenLog active ">My Network</button>
            </a>
            <a class="pull-left" href="#">
                <button type="button" class="btnLog btnLogPat  blackLog">My Practice</button>
            </a>
            <!-- end logo -->
            <!-- top nav-->
			
            <ul style="top:1px ;left:0px" class="nav pull-right ">
			
                <li style="height:30px;" class="dropdown user">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="javascript:;">
                        <img width="29" height="25" style="width:25px;height:21px;" src="${pageContext.request.contextPath}/images/noimage.png"
                             alt="profile image">
                        <span style="color:#fff;font-size:11px;padding-right:6px;" class="username">user</span>
                        <i class="icon-angle-down"></i>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#"><i class="icon-key"></i> Log Out</a></li>
                    </ul>
                </li>
            </ul>
			<div class="pull-right follow-count">
               100
            </div>
            <div id="first" class="nav-collapse collapse " style="height: 0px;">
                <ul class="nav pull-right">
                    <li>
                        <a class="home" href="/">Home</a>
                    </li>
                </ul>
            </div>

        </div>
    </div>
</div>
<!-- top nav end-->
<!-- BEGIN SIDEBAR CONTAINER -->
<div class="page-container row-fluid">
    <!-- BEGIN SIDEBAR -->
    <div class="page-sidebar nav-collapse collapse">
        <!-- BEGIN SIDEBAR MENU -->
        <ul class="page-sidebar-menu">
            <li>
                <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                <div class="sidebar-toggler hidden-phone"></div>
                <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
            </li>
            <li>
                <div class="" style="height:30px;"></div>
            </li>

            <li>
                <a href="#" class="ajaxify first">
                    <i class="icon-home"></i>
                    <span class="title">Home</span>
                    <span class="selected"></span>
                </a>
            </li>
            <li>
                <a href="#" class="ajaxify">
                    <i class="icon-user"></i>
                    <span class="title">My Public Profile</span>
                    <span class="selected"></span>
                </a>
            </li>
            <li>

                <a href="#" class="ajaxify">
                    <i class=" icon-search"></i>
                    <span class="title">Search Inventory</span>
                    <span class="selected"></span>
                </a>
            </li>
            <li>
                <a href="#" class="ajaxify">
                    <i class=" icon-book"></i>
                    <span class="title">My Saved Search</span>
                    <span class="selected"></span>
                </a>
            </li>
            <li class="active">
                <a href="#" class="ajaxify" id="addinventory">
                    <i class="icon-th-list"></i>
                    <span class="title">Manage Inventory</span>
                    <span class="selected"></span>
                </a>
				</li>
			<li class="innerl hide active"><a href="#" class="ajaxify"><i class="icon-plus"></i><span class="title"> Add Inventory</span></a></li>
            
            <li>
                <a href="#" class="ajaxify">
                    <i class="icon-comments"></i>
                    <span class="title">My Notifications</span>
                    <span class="selected"></span>
                </a>
            </li>
            <li>
                <a href="#" class="ajaxify">
                    <i class="icon-cogs"></i>
                    <span class="title">Settings</span>
                    <span class="selected"></span>
                </a>
            </li>
            <li>
                <a href="#" class="ajaxify">
                    <i class="icon-shopping-cart"></i>
                    <span class="title">Subscriptions</span>
                    <span class="selected"></span>
                </a>
            </li>
            <li>
                <a href="#" class="ajaxify">
                    <i class="icon-question-sign"></i>
                    <span class="title">Help</span>
                    <span class="selected"></span>
                </a>
            </li>
            <li>
                <a href="#" class="ajaxify">
                    <i class="icon-thumbs-up"></i>
                    <span class="title">Feedback</span>
                    <span class="selected"></span>
                </a>
            </li>
        </ul>
        <!-- END SIDEBAR MENU -->
    </div>
</div>
<!-- END SIDEBAR -->

<!--content start here-->
<div class="page-content">
<!-- BEGIN PAGE CONTAINER-->
<div class="container-fluid">
<div class="page-content-body">

<!-- BEGIN PAGE HEADER-->
<div class="row-fluid">
    <div class="span12">
        <!-- BEGIN PAGE TITLE & BREADCRUMB-->
        <h3 class="page-title">
           Inventory Management
            <small>View, Modify, Delete and Add Inventory</small>
        </h3>
        <hr class="clearfix">
        <!-- END PAGE TITLE & BREADCRUMB-->
    </div>
</div>
<!-- END PAGE HEADER-->
    <!-- BEGIN DASHBOARD STATS -->
    <div class="row-fluid">
     
        <!-- search page srart here-->

    <!-- sidebar links -->
	<div class="main-search-div">
	<div class="header-box"><i class="icon-th-list"></i> Add Inventory</div>
    <!-- sidebar ends-->


    <!-- right part start-->
    <div class="right-panel-long">
	<!-- topsearch-box -->
<div class="topsearch-box">
    <a href="#">Upload Using Template</a>
    <a href="#">Add Manually</a>
</div>
<!-- topsearch-box end -->


        <div class="contentbox newcontent">
		<p class="big-size">Upload Inventory using MS Exel based template, Download template from <a href="#">here</a></p>
			<div class="form-group">
				<form:form action="${pageContext.request.contextPath}/upload" commandName="uploadForm" enctype="multipart/form-data">
	                <input type="submit" name="upload" id="upload" class="btns" value="Upload"/>
	                <input type="file" name="files" id="file"/>
                </form:form>
            </div>

        </div>
        
    </div>
    <!-- right part end-->
</div>
		<!-- search page end here-->
  </div>

<!-- end DASHBOARD STATS -->


<div class="clearfix"></div>
</div>
</div>
</div>
<!-- END PAGE CONTAINER-->
<div id="load_statistics_loading" style="display: none;"></div>
</div>
<div class="MT30"></div>
<!-- content end here-->

<!---Footer start -->
<div class="footer">
    <div class="footer-inner">
        2013 &copy; RIMT
    </div>
    <div class="footer-tools">
<span class="go-top">
<i class="icon-angle-up"></i>
</span>
    </div>
</div>
<!---Footer ends -->


</body>
</html>