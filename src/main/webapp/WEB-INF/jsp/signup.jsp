<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>

    <title>Sign Up</title>
    <meta content="text/html; charset=utf-8" http-equiv="content-type"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet/less" type="text/css" href="${pageContext.request.contextPath}/css/application.less"/>

    <script src="${pageContext.request.contextPath}/js/less.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
    <script>
        $(document).ready(function(){
            $(":radio:eq(1)").click(function(){
                $("#broker").slideDown('fast');
            });

            $(":radio:eq(0)").click(function(){
                $("#broker").slideUp('fast');
            });

        });

    </script>

</head>

<body>
<div class="navbar  navbar-inverse navbar-static-top">
    <div style="opacity:1;" class="navbar-inner">
        <div class="container-fluid PL2">
            <button data-target="#first" data-toggle="collapse" style="margin-right:17px;" class="btn btn-navbar collapsed" type="button" href="javascript:;">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <!-- top nav-->
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
        <div class="span6 pull-right text-right PT20">
            <input type="submit" value="Login" class="blue-btn ML20">
            <input type="submit" value="SignUp" class="green-btn">
        </div>
    </div>
</div>
<div class="row-fluid MT20" style="border-bottom:1px solid #f2f2f2;"></div>
<!-- header end here -->

<!-- content start here-->

<!--freelancer sign up-->
<div class="container hl-psignup">
    <div style="opacity: 1;">
        <div class="row-fluid">
            <div class="span12">
                <div id="hl-signup-title" class="FL PL30"><img src="${pageContext.request.contextPath}/images/iconLock.png" height="40px"><span
                        style="padding-left:5px;position:relative;top:5px;">Sign Up ! </span>
                </div>
                <div class="FL  PL30 hl-stitle" id="hl" style="padding-top:25px;padding-bottom:20px;line-height:2;">Grow
                    Your business. Search from 1000's of resale inventories. Increase your market reach!.
                </div>
                <div class="CL"></div>
            </div>
        </div>
        <div class="row-fluid">
            <div class="span8">
                <form:form class="form-horizontal" action="${pageContext.request.contextPath}/signup" method="POST" commandName="signup"  >
                    
                    <div class="field control-group" id="member_type">
                        <label class="control-label" for="">I am a:</label>
                         <div class="controls">
	 						<form:radiobutton path = "userType" class="FL"  name="signup1" value="0" checked="checked"/>
	                            <label class="FL PT2 PL10">FreeLancer</label><br/>
	                            <label class="CL"></label>
	                            <form:radiobutton class="FL" path="userType" name="signup1" value="1"/>
	                            <label class="FL PT2 PL10" style="cursor:pointer;">
	                                Broker / Consultancy Firm
	                            </label>
                        </div>
                       


                    </div>

                    <div class="control-group">
                        <label class="control-label">Name </label>

                        <div class="controls">
                            <form:input type="text" path="firstName" placeholder="First Name" value=""/>
                            <form:input type="text" path="lastName" placeholder="Last Name"/>
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label">Email</label>

                        <div class="controls">
                            <form:input path="email" type="text" />
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" >Password</label>

                        <div class="controls">
                            <form:input path="password" type="password" />
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">Confirm Password</label>

                        <div class="controls">
                            <form:input path="confirmPassword" />
                        </div>
                    </div>
                    <div class="field control-group">
                        <label class="control-label">Mobile Number</label>

                        <div class="controls">
                            <form:select style="width:69px;" path="countryCode">
                                <option  selected="selected" value = "IN" >+91</option>
                            </form:select>
                            <form:input type="text" style="width:135px" path="mobileNumber" value=""/>
                        </div>
                    </div>


					 <div id="broker" class="hide">
                        <div class="field control-group">
                            <label class="control-label">Organization Name</label>

                            <div class="controls">
                                <form:input type="text" class="span10" path="organizationName" placeholder='Organization Name'/>
                            </div>
                        </div>

                        <div class="field control-group">
                            <label class="control-label" >Professional License Number</label>

                            <div class="controls">
                                <form:input type="text" path="licenceNumber" placeholder="Professional License Number" />
                                <form:select class="span2" style="width:90px;" path="country" >
                                    <option selected="selected" value="${country.id}">${country.name}</option>
                                </form:select>
                                <form:select class="span3" path="state">
                                   <!--  <option value="-1" selected="true" >--State--</option> -->
                                    <c:forEach var="state" items="${states}">
  										<option value="${state.id}">${state.name}</option>
									</c:forEach>
                                </form:select>

                            </div>
                        </div>
 					</div>
                    <div class="control-group"><p id="ptime-zone">Your current timezone is Asia/Kolkata, <a>Click here</a> to change</p></div>
                    <div class="control-group actions main">
                        <div class="controls">
                            <input type="submit" class=" MT10 search_submit green submit-btn" value="Accept &amp; Apply &raquo;"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                        </div>
                        <span style="font-size:11px;line-height:12px;">By signing up, you agree to our <a href="#" target="_blank">Terms
                            of Use</a> and <a href="#" target="_blank">Privacy Policy</a>, and confirm that you're 18 years old or more.</span>
                    </div>
                </form:form>
            </div>
            <div class="span4">
                <div id="doctor_redirect" style="">
                    <p class="hl-stitle">Why Choose Rimt.com?</p>
                    <ul id="benefits">
                        <li><span title="Build your online repution" target="_blank">Build your online repution</span>
                        </li>
                        <li><span title="Get practice managment software for free" target="_blank">Get practice managment software for free</span>
                        </li>
                        <li><span title="Expand your practice with global channel base" target="_blank">Expand your practice with global channel base</span>
                        </li>
                        <li><span title="Personal and financial rewards"
                                  target="_blank">Personal and financial rewards</span></li>
                        <li><span title="Improve quality of care and channel loyalty" target="_blank">Improve quality of care and channel loyalty</span>
                        </li>
                    </ul>
                </div>
            </div>

        </div>
    </div>
</div>
<!--freelancer sign up end-->

<!-- content start here-->


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

