<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>


  <title>DashBoard</title>
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
            $('#file').customFileInput();
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
                        <a class="home" href="${pageContext.request.contextPath}/home">Home</a>
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

            <li class="active">
                <a href="${pageContext.request.contextPath}/home" class="ajaxify first">
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

                <a href="${pageContext.request.contextPath}/search-inventory" class="ajaxify">
                    <i class=" icon-search"></i>
                    <span class="title">Search Inventory</span>
                    <span class="selected"></span>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/saved-search" class="ajaxify">
                    <i class=" icon-book"></i>
                    <span class="title">My Saved Search</span>
                    <span class="selected"></span>
                </a>
            </li>
            <li>
                <a href="#" class="ajaxify" id="addinventory">
                    <i class="icon-th-list"></i>
                    <span class="title">Manage Inventory</span>
                    <span class="selected"></span>
                </a>
				</li>
			<li class="innerl hide"><a href="${pageContext.request.contextPath}/add-inventory" class="ajaxify"><i class="icon-plus"></i><span class="title"> Add Inventory</span></a></li>
            
            <li>
                <a href="${pageContext.request.contextPath}/my-notification" class="ajaxify">
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
                <a href="${pageContext.request.contextPath}/help" class="ajaxify">
                    <i class="icon-question-sign"></i>
                    <span class="title">Help</span>
                    <span class="selected"></span>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/feedbck" class="ajaxify">
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
            My Dashboard
            <small>Your Channel Network Statistics</small>
        </h3>
        <hr class="clearfix">
        <!-- END PAGE TITLE & BREADCRUMB-->
    </div>
</div>
<!-- END PAGE HEADER-->
<div id="dashboard">
    <!-- BEGIN DASHBOARD STATS -->
    <div class="row-fluid">
        <div data-desktop="span3" data-tablet="span6" class="span3 responsive">
            <div class="dashboard-stat blue">
                <div class="visual">
                    <i class="icon-comments"></i>
                </div>
                <div class="details">
                    <div class="number">
                        <span id="uq">0</span>
                    </div>
                    <div style="font-weight:400;" class="desc">
                        My Notification &amp; Alerts
                    </div>
                </div>
            </div>
        </div>
        <div data-desktop="span3" data-tablet="span6" class="span3 responsive">
            <div class="dashboard-stat green">
                <div class="visual">
                    <i class="icon-plus-sign"></i>
                </div>
                <div class="details">
                    <div class="number">
                        <span id="df">0</span>
                    </div>
                    <div style="font-weight:400;" class="desc">
                        Left Invitations
                    </div>
                </div>
            </div>

        </div>
        <div data-desktop="span3" data-tablet="span6 fix-offset" class="span3 responsive">
            <div class="dashboard-stat purple">
                <div class="visual">
                    <i class="icon-user"></i>
                </div>
                <div class="details">
                    <div class="number">
                        <span id="pf">0</span>
                    </div>
                    <div style="font-weight:400;" class="desc">
                        No. of Followers
                    </div>
                </div>
            </div>

        </div>
        <div data-desktop="span3" data-tablet="span6" class="span3 responsive">
            <div class="dashboard-stat yellow">
                <div class="visual">
                    <i class=" icon-list"></i>
                </div>
                <div class="details">
                    <div class="number">
                        <span id="fp">0</span>
                    </div>
                    <div style="font-weight:400;" class="desc">
                        No. of Inventories
                    </div>
                </div>
            </div>

        </div>
    </div>

    <div class="clearfix"></div>
    <!-- END DASHBOARD STATS -->

    <div class="row-fluid">
        <div class="span7">
            <!-- start Feed-->
            <div class="portlet">
                <div class="portlet-title line">
                    <h4><i class="icon-comments"></i>&nbsp;My Network Feed</h4>
                </div>
                <div class="portlet-body">
                    <div class="slimScrollDiv"
                         style="position: relative; overflow: hidden; width: auto; height: 360px;">
                        <div data-rail-visible1="0" data-always-visible="1" data-height="360px" id="pat_feed-scroll"
                             class="scroller" style="overflow: hidden; width: auto; height: 360px;">
                            <div id="pat_feed">
                                <div class="3806"><h4>Today</h4>
                                    <ul class="chats dailyfeed">
                                        <li class="in"><img src="${pageContext.request.contextPath}/images/noimage.png" alt="" class="avatar">

                                            <div class="message">
                                                <span class="arrow"></span>
                                                <span class="body">You joined <span
                                                        style="color:#D55804">RIMT</span>.</span>
                                                <span class="datetime">10 mnt ago</span>
                                            </div>
                                        </li>
                                        <li class="in"><img src="${pageContext.request.contextPath}/images/noimage.png" alt="" class="avatar">

                                            <div class="message">
                                                <span class="arrow"></span>
                                                <span class="body">You joined <span
                                                        style="color:#D55804">RIMT</span>.</span>
                                                <span class="datetime">10 mnt ago</span>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                                <div class="3806"><h4>Yesterday</h4>
                                    <ul class="chats dailyfeed">
                                        <li class="in"><img src="${pageContext.request.contextPath}/images/noimage.png" alt="" class="avatar">

                                            <div class="message">
                                                <span class="arrow"></span>
                                                <span class="body">You joined <span
                                                        style="color:#D55804">RIMT</span>.</span>
                                                <span class="datetime">10 mnt ago</span>
                                            </div>
                                        </li>
                                        <li class="in"><img src="${pageContext.request.contextPath}/images/noimage.png" alt="" class="avatar">

                                            <div class="message">
                                                <span class="arrow"></span>
                                                <span class="body">You joined <span
                                                        style="color:#D55804">RIMT</span>.</span>
                                                <span class="datetime">10 mnt ago</span>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- end Feed-->
        </div>

        <!-- experties start -->
        <div class="span5">
            <div class="portlet box blue">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="icon-cog"></i>&nbsp;My Experties
                    </div>
                </div>
                <div class="portlet-body">
                    <div class="slimScrollDiv">
                        <div class="scroller portlet-iner">
                            <div class="btn-box">
                                <div class="row-fluid" id="add-span">
                                    <input type="text" placeholder="Add Disease/Symptom" id="addtopictxt"
                                           class="span9 pull-left addtxtbox ui-autocomplete-input"
                                           autocomplete="off"><span role="status" aria-live="polite"
                                                                    class="ui-helper-hidden-accessible"></span>
                                    <button class="span3 btn green pull-right goadd" style="margin-bottom:10px;"
                                            type="button"><i class="icon-plus"></i>&nbsp; Add
                                    </button>
                                    <br>
                                </div>
                                <div class="CL"></div>
                            </div>
                            <div class="mytopics">
                                <h2>Add Your Experties<br/>
                                    <span>(to get queries from related broker on RIMT Network)</span></h2>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <!-- experties end -->
        <!-- experties start -->
        <div class="span5">
            <div class="portlet box blue">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="icon-cog"></i>&nbsp;News &amp; Updates
                    </div>
                </div>
                <div class="portlet-body">
                    <div class="slimScrollDiv">
                        <div class="scroller portlet-iner">
                            <div class="btn-box">
                                reg
                            </div>

                        </div>

                    </div>
                </div>
            </div>
        </div>
        <!-- experties end -->
    </div>


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
