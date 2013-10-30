<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>

    <title>Login - RIMT.com</title>
    <meta content="text/html; charset=utf-8" http-equiv="content-type"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet/less" type="text/css" href="css/application.less"/>
    <script src="js/less.js" type="text/javascript"></script>
    <script src="js/bootstrap.js" type="text/javascript"></script>
    <script src="js/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/enhance.js"></script>
    <script type="text/javascript" src="js/jQuery.fileinput.js"></script>
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
<tiles:insertAttribute name="header" />

<!-- top nav end-->
<!-- BEGIN SIDEBAR CONTAINER -->
<tiles:insertAttribute name="menu" />
<!-- END SIDEBAR -->

<!--content start here-->
<div class="page-content">
<!-- BEGIN PAGE CONTAINER-->
<tiles:insertAttribute name="body" />
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
    <tiles:insertAttribute name="body" />
</div>
<!---Footer ends -->


</body>
</html>