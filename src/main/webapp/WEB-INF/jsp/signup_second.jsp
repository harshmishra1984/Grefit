<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>

    <title>Login - RIMT.com</title>
    <meta content="text/html; charset=utf-8" http-equiv="content-type"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet/less" type="text/css" href="${pageContext.request.contextPath}/css/application.less"/>
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
                        <img width="29" height="25" style="width:25px;height:21px;" src=""${pageContext.request.contextPath}/imagesnoimage.png" alt="profile image">
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
            <a href="/" class="pull-left"><img src=""${pageContext.request.contextPath}/imagesrimt-logo.png" alt="RIMT"></a>
        </div>
        <!--logo ends-->
    </div>
</div>
<div class="row-fluid MT20" style="border-bottom:1px solid #f2f2f2;"></div>
<!-- header end here -->

<!-- content start here-->

<!--form start here-->
<div class="container">
    <div style="cursor:pointer;" class="container ">
        <div class="sep-top container"></div>
        <div style="cursor:pointer;" class="container">
            <div class="row-fluid">

                <div style="" class="span3 PT10 PB10">
                    <span>
                    <span class="number u1">1</span>
                    <span class="blue_hd_4_5">Professional Information</span></span>
                </div>

                <div style="" class="span3 PT10 PB10">
                    <span>
                    <span class="number u2 active">2</span>
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
        <div style="width:50%;" class="bar"></div>
    </div>

</div>

<div style="overflow:hidden;" class="container">
    <div id="wrapper">
        <div id="steps" style="width: 3510px; margin-left: 0px;">
            <fieldset class="step">
                <form:form class="formElem form-horizontal" action="${pageContext.request.contextPath}/signup_second" method="POST" commandName="orgForm"  >
                	<c:forEach var="org" items="${organizations}">
                		<form:input type ="hidden" value="${org.id}" path="id"/>
	                    <div class="row-fluid">
	                        <div class="control-group">
	                            <label class="control-label">
	                                Organization Type
	                            </label>
	                            <div class="controls">
	                                    <form:select class="span3" path="type">
	                                        <option value="private" selected="selected">private</option>
	                                        <option value="public">public</option>
	                                    </form:select>
	                            </div>
	                        </div>
	                        <div class="control-group">
	                            <label class="control-label">
	                                Organization Name
	                            </label>
	                            <div class="controls">
	                                <form:input type="text" class="span3" path="name" value="${org.name}"/>
	                            </div>
	                        </div>
	                         <div class="control-group">
	                            <label class="control-label">
	                                Licence Number
	                            </label>
	                            <div class="controls">
	                                <form:input type="text" class="span3" path="licence" value="${org.licenceNumber}"/>
	                            </div>
	                        </div>
	                        <div class="control-group">
	                            
	                            <div class="controls">
	                            	<c:forEach  var = "orgDetails" items="${org.orgAddrList}">
	                            		<label class="control-label">
	                                		Organization Adrress
	                            		</label>
		                                <form:input type="text" class="span3" path="location" value="${orgDetails.address}" />
		                                <p>
		                                 <%--    <form:select class="span3"  path="country">
		                                        <option value="India" value="${org.orgAddrList[0].country.id}" selected="selected">India</option>
		                                    </form:select> --%>
		                                </p>
		                                <p>
		                                    <form:select class="span3" path="city" >
		                                    	
		                                    	<c:forEach var="city" items="${cities}">
		                                    		<c:choose>
	      												<c:when test="${orgDetails.city.id == city.id}">
													      <option value="${city.id}"  selected="selected">${city.name}</option>
													    </c:when>
													    <c:otherwise>
													      <option value="${city.id}" >${city.name}</option>
													    </c:otherwise>
													</c:choose>
		                                        </c:forEach>
		                                    </form:select>
		                                </p>
		                                <label class="control-label">
	                                		Organization Contact
	                            		</label>
			                            <div class="controls" id="hl-list-topics">
			                                <p>
			                                    <form:select class="span1" style="width:75px;" path="countryCode">
			                                        <option value="IN" selected="selected">+91</option>
			                                    </form:select>
			                                    <form:input type="text" class="span2" path="contact" value = "${orgDetails.contactNumber}"/>
			                                </p>
			                            </div>
			                            <div class="controls">
			                                <a style="font-size:14px;"> + Add Another</a>
			                            </div>
	                               </c:forEach>
	                            </div>
	                        </div>
	
	                        <div class="control-group">
	                         
	                        </div>
	                    </div>
                    </c:forEach>

                    <div style="" class="control-group hl-navigation MT10">
                        <div class="controls">
                            <a href="#">Back</a> | <a href="${pageContext.request.contextPath}/signup_skip_this_step?step=4">Skip this step</a>
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
            <a href="#" target="_blank"><img src=""${pageContext.request.contextPath}/imagesfacebook-icon.png" width="33px" height="33px"></a>
            <a href="#" target="_blank"><img src=""${pageContext.request.contextPath}/imagestwitter-icon.png" width="33px" height="33px"></a>
            <a href="#" target="_blank"><img src=""${pageContext.request.contextPath}/imagesgplus-icon.png" width="33px" height="33px"></a>
            <a href="#" target="_blank"><img src=""${pageContext.request.contextPath}/imageslinkedin-icon.png" width="33px" height="33px"></a>
        </div>
    </div>
</div>

<div class="MB20" style="clear:right"></div>
<!---Footer ends -->

<script src="${pageContext.request.contextPath}/js/less.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
</body>
</html>
