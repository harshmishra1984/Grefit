<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>

    <title>Login - RIMT.com</title>
    <meta content="text/html; charset=utf-8" http-equiv="content-type"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet/less" type="text/css" href="${pageContext.request.contextPath}/css/application.less"/>

<style type="text/css">  
	
	.errorblock {  
	 color: #ff0000;  
	 background-color: #ffEEEE;  
	 border: 3px solid #ff0000;  
	 padding: 8px;  
	 margin: 16px;  
}  
</style> 

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
            <a href="${pageContext.request.contextPath}/" class="pull-left"><img src="${pageContext.request.contextPath}/images/rimt-logo.png" alt="RIMT"></a>

            <div class="pull-left"><span class="leftHeadCurve">.</span><span class="rtHeadCurve">Login</span></div>
        </div>
        <!--logo ends-->
        <div class="span6 pull-right text-right PT20">
        	<a href="${pageContext.request.contextPath}/" class="blue-btn ML20">Login</a>
            <a href="${pageContext.request.contextPath}/" class="green-btn">SignUp</a>
        </div>
    </div>
</div>
<div class="row-fluid MT20" style="border-bottom:1px solid #f2f2f2;"></div>
<!-- header end here -->

<!-- content start here-->


<div class="container MB30 MT30 PT20 PB30">
    <div class="MT5 hidden-phone"></div>
    <!--Rights panel start here -->
    <div style="text-align:center;" class="row-fluid">
        <span class="blue_hd_3 hidden-phone"> Login to RIMT.com</span>
        <br>
        <br>

        <div class="span3"></div>
        <div class="span6">
            <form style="padding:10px 20px;" class="form-horizontal" action="${pageContext.request.contextPath}/j_spring_security_check" method="POST"  >
               	<c:if test="${not empty param.login_error}"> 
	                <div class="loginSorryDisplayMessage errorblock">
						 Your login attempt was not successful, try again.
							  <!--  Your login attempt was not successful, try again. Caused : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}  -->
					</div>
				</c:if>
                <p style="line-height:3px;">&nbsp;</p>

                <div class="MT20">
			
                    <div class="control-group">
                        <div class="control-label">&nbsp;Email Id</div>
                        <div class="controls">
                           <!--  <input type="text" class=" m-wrap span10"> -->
                            <input type='text' name='j_username' value='' class=" m-wrap span10"> 
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="control-label">Password</div>
                        <div class="controls">
                        <input type='password' name='j_password' class=" m-wrap span10" />
                       </div>
                    </div>
                    <div class="PB5">
                        <div style=""><a href="#">Forgot Password ?</a></div>
                    </div>

                </div>
                <div class="CL PB10"></div>
                <div>
                    <div>
                        <div><font size="1"><input type="checkbox" value="true" checked="checked">&nbsp;Remember
                            Me</font></div>
                        <div class="MT20 MB20">
                            <input type="submit" value="Log-In &#187;" class="buttons blue medium" name="">
                        </div>
                    </div>

                </div>
            </form>
        </div>
        <div class="span3"></div>
    </div>
    <!--Rightpanel ends here-->
    <div class="CL"></div>
</div>
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
        <div class=" span3 pull-right PB10 ML30">
            <span class="PR10 hidden-phone hidden-tablet text-right">Follow Us </span>
            <a href="#" target="_blank"><img src="${pageContext.request.contextPath}/images/facebook-icon.png" width="33px" height="33px"></a>
            <a href="#" target="_blank"><img src="${pageContext.request.contextPath}/images/twitter-icon.png" width="33px" height="33px"></a>
            <a href="#" target="_blank"><img src="${pageContext.request.contextPath}/images/gplus-icon.png" width="33px" height="33px"></a>
            <a href="#" target="_blank"><img src="${pageContext.request.contextPath}/images/linkedin-icon.png" width="33px" height="33px"></a>
        </div>
    </div>
</div>


<div class="MB20" style="clear:right"></div>
<!---Footer ends -->

<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/less.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js" type="text/javascript"></script>

</body>
