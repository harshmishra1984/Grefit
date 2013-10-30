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
    <script>
        $(document).ready(function(){

                $("#warningm").slideUp(3000);

        });

    </script>
</head>

<body>
<div class="navbar  navbar-inverse navbar-static-top">
    <div style="opacity:1;" class="navbar-inner">
        <div class="container-fluid PL2">
            <button data-target="#first" data-toggle="collapse" style="margin-right:17px;"
                    class="btn btn-navbar collapsed" type="button" href="javascript:;">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <!-- logo start -->
            <a class="pull-left" href="/">
                <button type="button" class="btnLog btnLogPat greenLog active">Rimt.com</button>
            </a>
            <a class="pull-left" href="#">
                <button type="button" class="btnLog btnLogPat  blackLog ">My Network</button>
            </a>
            <a class="pull-left" href="#">
                <button type="button" class="btnLog btnLogPat  blackLog">My Practice</button>
            </a>
            <!-- end logo -->
            <!-- top nav-->
            <ul style="top:1px ;left:0px" class="nav pull-right ">
                <li style="height:30px;" class="dropdown user">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="javascript:;">
                        <img width="29" height="25" style="width:25px;height:21px;" src="${pageContext.request.contextPath}/images/noimage.png" alt="profile image">
                        <span style="color:#fff;font-size:11px;padding-right:6px;" class="username">user</span>
                        <i class="icon-angle-down"></i>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#"><i class="icon-key"></i> Log Out</a></li>
                    </ul>
                </li>
            </ul>
            <div id="first" class="nav-collapse  collapse" style="height: 0px;">
                <ul class="nav pull-right">
                    <li>
                        <a href="/">Home</a>
                    </li>
                    <li>
                        <a href="#">Test</a>
                    </li>
                    <li>
                        <a href="#">Test</a>
                    </li>
                    <li>
                        <a href="#">Test</a>
                    </li>
                    <li>
                        <a href="#">Test</a>
                    </li>
                    <li style="height:30px;" class="dropdown user">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="javascript:;">
                            <span style="padding-right:6px;" class="username">More</span>
                            <i class="icon-angle-down"></i>
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#">Test</a>
                            </li>
                            <li>
                                <a href="#">Test</a>
                            </li>
                        </ul>

                    </li>
                </ul>

            </div>
        </div>
    </div>
</div>
<!-- top nav end-->

<!-- header start here -->
<div class="container PT20">
    <div class="row-fluid">
        <!---logo start here-->
        <div class="span6">
            <a href="${pageContext.request.contextPath}/home" class="pull-left"><img src="${pageContext.request.contextPath}/images/rimt-logo.png" alt="RIMT"></a>
        </div>
        <!--logo ends-->
    </div>
</div>
<div class="row-fluid MT20" style="border-bottom:1px solid #f2f2f2;"></div>
<!-- header end here -->

<!-- content start here-->

<!--warning start here-->
<div class="container PT5 PB5 warningm" id="warningm">
    <h1 id="hl-signup-success-title"><img height="40px" src="${pageContext.request.contextPath}/images/iconThumbsup.png"><span style="position:relative;top:-10px;padding-left:10px;">Welcome to RIMT </span></h1>

    <p class="FR MT20"><i>We need to know a little more about you to provide you with the most personalized experience.<br><span id="start_help_blurb">Your information on Rimt is private and secure !</i></span>
        <a class="close"></a>
    </p>

    <div class="CL"></div>
</div>
<!--warning end here-->
<!--form start here-->
<div class="container">
    <div style="cursor:pointer;" class="container ">
        <div class="sep-top container"></div>
        <div style="cursor:pointer;" class="container">
            <div class="row-fluid">

                <div style="" class="span3 PT10 PB10">
                    <span>
                    <span class="number u1 active">1</span>
                    <span class="blue_hd_4_5">Professional Information</span></span>
                </div>

                <div style="" class="span3 PT10 PB10">
                    <span>
                    <span class="number u2">2</span>
                    <span class="blue_hd_4_5">Organization Detail</span></span>
                </div>

                <div style="" class="span3 PT10 PB10">
                    <span>
                    <span class="number u3">3</span>
                    <span class="blue_hd_4_5">Organization Location</span></span>
                </div>

                <div style="" class="span3 PT10 PB10">
                    <span>
                    <span id="last" class="number u4">4</span>
                    <span class="blue_hd_4_5">Get Followers</span></span>
                </div>
            </div>
        </div>
        <div class="sep-bot container"></div>
    </div>

    <div class="progress progress-success progress-striped">
        <div style="width:25%;" class="bar"></div>
    </div>

</div>

<div style="overflow:hidden;" class="container">
    <div id="wrapper">
        <div id="steps" style="width: 3510px; margin-left: 0px;">
            <fieldset class="step">
                <form:form class="formElem form-horizontal" action="${pageContext.request.contextPath}/signup_first" method="POST" commandName="professionalExpertiesform">
                    <div class="row-fluid">
                        <div class="control-group">
                            <label class="control-label">
                                You are Expert in
                            </label>
                            <div class="controls">
                                <p>
                                    <form:select class="span3" path="experties1">
	                                    <c:forEach var="exp" items="${experties}">
	  										<option value="${exp.id}">${exp.name}</option>
										</c:forEach>
                                    </form:select>
                                </p>

                                <p>
                                    <form:select class="span3" path="experties2">
                                         <c:forEach var="exp" items="${experties}">
	  										<option value="${exp.id}">${exp.name}</option>
										</c:forEach>
                                    </form:select>
                                </p>

                                <p>
                                    <form:select class="span3" path="experties3" >
                                         <c:forEach var="exp" items="${experties}">
	  										<option value="${exp.id}">${exp.name}</option>
										</c:forEach>
                                    </form:select>
                                </p>
                            </div>
                            <div class="controls">
                                <a style="font-size:14px;"> + Add Another</a>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">
                               Deals with Builders
                            </label>
                            <div class="controls">
                                <p>
                                    <form:select class="span3" path="builder1" >
                                         <c:forEach var="bl" items="${builders}">
	  										<option value="${bl.id}">${bl.name}</option>
										</c:forEach>
                                    </form:select>
                                </p>

                                <p>
                                    <form:select class="span3" path="builder2">
                                        <c:forEach var="bl" items="${builders}">
	  										<option value="${bl.id}">${bl.name}</option>
										</c:forEach>
                                    </form:select>
                                </p>

                                <p>
                                    <form:select class="span3" path="builder3" >
                                        <c:forEach var="bl" items="${builders}">
	  										<option value="${bl.id}">${bl.name}</option>
										</c:forEach>
                                    </form:select>
                                </p>
                            </div>
                            <div class="controls">
                                <a style="font-size:14px;" > + Add Another</a>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">
                                Your work locations
                            </label>
                            <div class="controls" id="hl-list-topics">
                                <p>
                                    <form:select class="span3" path="location1">
                                        <c:forEach var="city" items="${cities}">
	  										<option value="${city.id}">${city.name}</option>
										</c:forEach>
                                    </form:select>
                                </p>

                                <p>
                                    <form:select class="span3" path="location2">
                                        <c:forEach var="city" items="${cities}">
	  										<option value="${city.id}">${city.name}</option>
										</c:forEach>
                                    </form:select>
                                </p>

                                <p>
                                    <form:select class="span3" path="location3">
                                        <c:forEach var="city" items="${cities}">
	  										<option value="${city.id}">${city.name}</option>
										</c:forEach>
                                    </form:select>
                                </p>
                            </div>
                            <div class="controls">
                                <a style="font-size:14px;"> + Add Another</a>
                            </div>
                        </div>
                    </div>
                    <div style="" class="control-group hl-navigation MT10">
                        <div class="controls">
                            <a href="${pageContext.request.contextPath}/signup_skip_this_step?step=2">Skip this step</a>
                            <input type="submit" value="Next Step &raquo;" class="search_submit green submit-btn">
                        </div>
                    </div>
                </form:form>
            </fieldset>
        </div>
    </div>
</div>
<div class="MT30"></div>

<!--form end-->


<!-- content end here-->

<!---Footer start -->
<div class="MT30"></div>
<div class=" container ">
    <div class="sep-bot CL container "></div>
</div>
<div class="container">
    <div class="row-fluid text-center;">
        <div class="ML20 PT10 PB20 FL span3">
            <a href="#">About Us</a> | <a href="#">Contact</a> | <a href="/tnc/">T&amp;C</a> | <a href="/privacy/">Privacy</a>
        </div>
        <div class="MT10 MB10 span6" height="20" valign="middle" align="center">
            Copyright &copy; 2013, <span> PSPG Consultancy Services Pvt. Ltd.</span> All Rights Reserved
        </div>
        <div class=" span3 pull-right PB10 ML30 text-right">
            <span class="PR10 hidden-phone hidden-tablet ">Follow Us </span>
            <a href="#" target="_blank"><img src="${pageContext.request.contextPath}/images/facebook-icon.png" width="33px" height="33px"></a>
            <a href="#" target="_blank"><img src="${pageContext.request.contextPath}/images/twitter-icon.png" width="33px" height="33px"></a>
            <a href="#" target="_blank"><img src="${pageContext.request.contextPath}/images/gplus-icon.png" width="33px" height="33px"></a>
            <a href="#" target="_blank"><img src="${pageContext.request.contextPath}/images/linkedin-icon.png" width="33px" height="33px"></a>
        </div>
    </div>
</div>

<div class="MB20" style="clear:right"></div>
<!---Footer ends -->
</body>
</html>
