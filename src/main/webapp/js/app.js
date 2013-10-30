/**
Core script to handle the entire layout and base functions
**/
var App = function () {

    // IE mode
    var isRTL = false;
    var isIE8 = false;
    var isIE9 = false;
    var isIE10 = false;
    var sidebarWidth = 225;
    var sidebarCollapsedWidth = 35;
    var slimscrollercaller=0;
    var responsiveHandlers = [];
    var miniset='';

    var handleInit = function() {

        if ($('body').css('direction') === 'rtl') {
            isRTL = true;
        }

        isIE8 = !! navigator.userAgent.match(/MSIE 8.0/);
        isIE9 = !! navigator.userAgent.match(/MSIE 9.0/);
        isIE10 = !! navigator.userAgent.match(/MSIE 10/);

        if (isIE10) {
            jQuery('html').addClass('ie10'); // detect IE10 version
        }
    }

    var handleDesktopTabletContents = function () {
        // loops all page elements with "responsive" class and applies classes for tablet mode
        // For metornic  1280px or less set as tablet mode to display the content properly
        if ($(window).width() <= 1280 || $('body').hasClass('page-boxed')) {
            $(".responsive").each(function () {
                var forTablet = $(this).attr('data-tablet');
                var forDesktop = $(this).attr('data-desktop');
                if (forTablet) {
                    $(this).removeClass(forDesktop);
                    $(this).addClass(forTablet);
                }
            });
        }

        // loops all page elements with "responsive" class and applied classes for desktop mode
        // For metornic  higher 1280px set as desktop mode to display the content properly
        if ($(window).width() > 1280 && $('body').hasClass('page-boxed') === false) {
            $(".responsive").each(function () {
                var forTablet = $(this).attr('data-tablet');
                var forDesktop = $(this).attr('data-desktop');
                if (forTablet) {
                    $(this).removeClass(forTablet);
                    $(this).addClass(forDesktop);
                }
            });
        }
    }

    var handleSidebarState = function () {
        // remove sidebar toggler if window width smaller than 900(for table and phone mode)
        if ($(window).width() < 980) {
            $('body').removeClass("page-sidebar-closed");
        }
    }

    var runResponsiveHandlers = function () {
        // reinitialize other subscribed elements
        for (var i in responsiveHandlers) {
            var each = responsiveHandlers[i];
            each.call();
        }
    }

    var handleResponsive = function () {
        handleTooltips();
        handleSidebarState();
        handleDesktopTabletContents();
        handleSidebarAndContentHeight();
        handleSelect2();
        handleFixedSidebar();
        runResponsiveHandlers();
    }

    var handleResponsiveOnInit = function () {
        handleSidebarState();
        handleDesktopTabletContents();
        handleSidebarAndContentHeight();
    }

    var handleResponsiveOnResize = function () {
        var resize;
        if (isIE8) {
            var currheight;
            $(window).resize(function() {
                if(currheight == document.documentElement.clientHeight) {
                    return; //quite event since only body resized not window.
                }
                if (resize) {
                    clearTimeout(resize);
                }
                resize = setTimeout(function() {
                    handleResponsive();
                }, 50); // wait 50ms until window resize finishes.                
                currheight = document.documentElement.clientHeight; // store last body client height
            });
        } else {
            $(window).resize(function() {
            if (resize) {
                    clearTimeout(resize);
                }
                resize = setTimeout(function() {
                    //console.log('resize');
                    handleResponsive();
                }, 50); // wait 50ms until window resize finishes.
            });
        }
    }

    //* BEGIN:CORE HANDLERS *//
    // this function handles responsive layout on screen size resize or mobile device rotate.

    var handleSidebarAndContentHeight = function () {
        var content = $('.page-content');
        var sidebar = $('.page-sidebar');
        var body = $('body');
        var height;

        if (body.hasClass("page-footer-fixed") === true && body.hasClass("page-sidebar-fixed") === false) {
            var available_height = $(window).height() - $('.footer').height();
            if (content.height() <  available_height) {
                content.attr('style', 'min-height:' + available_height + 'px !important');
            }
        } else {
            if (body.hasClass('page-sidebar-fixed')) {
                height = _calculateFixedSidebarViewportHeight();
            } else {
                height = sidebar.height() + 20;
            }
            if (height >= content.height()) {
                content.attr('style', 'min-height:' + height + 'px !important');
            }
        }
    }

    var handleSidebarMenu = function () {
        jQuery('.page-sidebar').on('click', 'li > a', function (e) {
                if ($(this).next().hasClass('sub-menu') == false) {
                    if ($('.btn-navbar').hasClass('collapsed') == false) {
                        $('.btn-navbar').click();
                    }
                    return;
                }

                var parent = $(this).parent().parent();

                parent.children('li.open').children('a').children('.arrow').removeClass('open');
                parent.children('li.open').children('.sub-menu').slideUp(200);
                parent.children('li.open').removeClass('open');

                var sub = jQuery(this).next();
                if (sub.is(":visible")) {
                    jQuery('.arrow', jQuery(this)).removeClass("open");
                    jQuery(this).parent().removeClass("open");
                    sub.slideUp(200, function () {
                            handleSidebarAndContentHeight();
                        });
                } else {
                    jQuery('.arrow', jQuery(this)).addClass("open");
                    jQuery(this).parent().addClass("open");
                    sub.slideDown(200, function () {
                            handleSidebarAndContentHeight();
                        });
                }

                e.preventDefault();
        });


        // handle ajax links
        jQuery('.page-sidebar').on('click', ' li > a.ajaxify', function (e) {
            e.preventDefault();
            App.scrollTop();
	    set="unset";
            var url = $(this).attr("href");
            var sectionurl = $(this).attr("data-sectionurl");
            var menuContainer = jQuery('.page-sidebar ul');
            var pageContent = $('.page-content');
            var pageContentBody = $('.page-content .page-content-body');
	    if(sectionurl!='' && typeof sectionurl!=='undefined') //section url should be loaded once
	    {
		url=sectionurl;
		$(this).removeAttr('data-sectionurl');
	    }
            menuContainer.children('li.active').removeClass('active');
            menuContainer.children('arrow.open').removeClass('open');

            $(this).parents('li').each(function(){
                $(this).addClass('active');
                $(this).children('a > span.arrow').addClass('open');
            });
            $(this).parents('li').addClass('active');

            App.blockUI(pageContent, false);

            $.get(url, {}, function (res) {
                App.unblockUI(pageContent);
                pageContentBody.html(res);
                App.fixContentHeight(); // fix content height
                App.initUniform(); // initialize uniform elements
            });
        });
        
	jQuery('.page-sidebar li > a.ajaxify.first').first().trigger('click');
    }

    var _calculateFixedSidebarViewportHeight = function () {
        var sidebarHeight = $(window).height() - $('.header').height() + 1;
        if ($('body').hasClass("page-footer-fixed")) {
            sidebarHeight = sidebarHeight - $('.footer').height();
        }

        return sidebarHeight;
    }

    var handleFixedSidebar = function () {
        var menu = $('.page-sidebar-menu');

        if (menu.parent('.slimScrollDiv').size() === 1) { // destroy existing instance before updating the height
            menu.slimScroll({
                destroy: true
            });
            menu.removeAttr('style');
            $('.page-sidebar').removeAttr('style');
        }

        if ($('.page-sidebar-fixed').size() === 0) {
            handleSidebarAndContentHeight();
            return;
        }

        if ($(window).width() >= 980) {
            var sidebarHeight = _calculateFixedSidebarViewportHeight();

            menu.slimScroll({
                size: '7px',
                color: '#a1b2bd',
                opacity: .3,
                position: isRTL ? 'left' : ($('.page-sidebar-on-right').size() === 1 ? 'left' : 'right'),
                height: sidebarHeight,
                allowPageScroll: false,
                disableFadeOut: false
            });
            handleSidebarAndContentHeight();
        }
    }

    var handleFixedSidebarHoverable = function () {
        if ($('body').hasClass('page-sidebar-fixed') === false) {
            return;
        }

        $('.page-sidebar').off('mouseenter').on('mouseenter', function () {
            var body = $('body');

            if ((body.hasClass('page-sidebar-closed') === false || body.hasClass('page-sidebar-fixed') === false) || $(this).hasClass('page-sidebar-hovering')) {
                return;
            }

            body.removeClass('page-sidebar-closed').addClass('page-sidebar-hover-on');
            $(this).addClass('page-sidebar-hovering');
            $(this).animate({
                width: sidebarWidth
            }, 400, '', function () {
                $(this).removeClass('page-sidebar-hovering');
            });
        });
        $('.page-sidebar').off('mouseleave').on('mouseleave', function () {
            var body = $('body');

            if ((body.hasClass('page-sidebar-hover-on') === false || body.hasClass('page-sidebar-fixed') === false) || $(this).hasClass('page-sidebar-hovering')) {
                return;
            }

            $(this).addClass('page-sidebar-hovering');
            $(this).animate({
                width: sidebarCollapsedWidth
            }, 400, '', function () {
                $('body').addClass('page-sidebar-closed').removeClass('page-sidebar-hover-on');
                $(this).removeClass('page-sidebar-hovering');
            });
        });
    }

    var handleLinksPageContent = function () {

        //jQuery('.page-content .page-content-body').on('click', 'a.openpagecontent', function (e) {
        jQuery('body').on('click', 'a.openpagecontent', function (e) {
            e.preventDefault();
            App.scrollTop();

            var url = $(this).attr("href");
            var pageContent = $('.page-content');
            var pageContentBody = $('.page-content .page-content-body');
            App.blockUI(pageContent, false);

            $.get(url, {}, function (res) {
                App.unblockUI(pageContent);
                pageContentBody.html(res);
                App.fixContentHeight(); // fix content height
                App.initUniform(); // initialize uniform elements
            });
        });

    }

    var handleSidebarToggler = function () {
        // handle sidebar show/hide
        $('.page-sidebar').on('click', '.sidebar-toggler', function (e) {
            var body = $('body');
            var sidebar = $('.page-sidebar');

            if ((body.hasClass("page-sidebar-hover-on") && body.hasClass('page-sidebar-fixed')) || sidebar.hasClass('page-sidebar-hovering')) {
                body.removeClass('page-sidebar-hover-on');
                sidebar.css('width', '').hide().show();
                e.stopPropagation();
                runResponsiveHandlers();
                return;
            }

            $(".sidebar-search", sidebar).removeClass("open");

            if (body.hasClass("page-sidebar-closed")) {
                body.removeClass("page-sidebar-closed");
                if (body.hasClass('page-sidebar-fixed')) {
                    sidebar.css('width', '');
                }
            } else {
                body.addClass("page-sidebar-closed");
            }
            runResponsiveHandlers();
        });
        // handle the search bar close
        $('.page-sidebar').on('click', '.sidebar-search .remove', function (e) {
            e.preventDefault();
            $('.sidebar-search').removeClass("open");
        });

        // handle the search query submit on enter press
        $('.page-sidebar').on('keypress', '.sidebar-search input', function (e) {
            if (e.which == 13) {
                window.location.href = "extra_search.html";
                return false; //<---- Add this line
            }
        });

        // handle the search submit
        $('.sidebar-search .submit').on('click', function (e) {
            e.preventDefault();

                if ($('body').hasClass("page-sidebar-closed")) {
                    if ($('.sidebar-search').hasClass('open') == false) {
                        if ($('.page-sidebar-fixed').size() === 1) {
                            $('.page-sidebar .sidebar-toggler').click(); //trigger sidebar toggle button
                        }
                        $('.sidebar-search').addClass("open");
                    } else {
                        window.location.href = "extra_search.html";
                    }
                } else {
                    window.location.href = "extra_search.html";
                }
        });
    }

    //All links in right pane should open there
    var handleLinksRightPane = function () {
        var container = $(".page-content");
        $('.openpagecontent').click(function(){
                var href=$(this).attr('href');
                if(href!='javascript:;')
                {			
                        $('.page-content').load(href);
                }
                return false;
        });
    }

/*
    var handleHorizontalMenu = function () {
        //handle hor menu search form toggler click
        $('.header').on('click', '.hor-menu .hor-menu-search-form-toggler', function (e) {
                if ($(this).hasClass('hide')) {
                    $(this).removeClass('hide');
                    $('.header .hor-menu .search-form').hide();
                } else {
                    $(this).addClass('hide');
                    $('.header .hor-menu .search-form').show();
                }
                e.preventDefault();
            });

        //handle hor menu search button click
        $('.header').on('click', '.hor-menu .search-form .btn', function (e) {
                window.location.href = "extra_search.html";
                e.preventDefault();
            });

        //handle hor menu search form on enter press
        $('.header').on('keypress', '.hor-menu .search-form input', function (e) {
                if (e.which == 13) {
                    window.location.href = "extra_search.html";
                    return false;
                }
            });
    }

*/
var handleDateRangePickers = function (dates, daterangeCallback) {
        if (!jQuery().daterangepicker) {
            return;
        }
        $('#date-range-picker').daterangepicker({
	
            ranges: {
                'Today': [dates.today, dates.today],
                'Yesterday': [dates.yesterday, dates.yesterday],
                'Last 7 Days': [dates.last7days_start, dates.today],
                'Last 30 Days': [dates.last30days_start, dates.today],
                'This Month': [dates.thismonth_start, dates.today],
                'Last Month': [dates.lastmonth_start, dates.lastmonth_end]
            },
            opens: 'left',
            format: 'd MMM, yy',
            separator: 'to',
            startDate: dates.startDate,
            endDate: dates.endDate,
            minDate: dates.minDate,
            maxDate: dates.maxDate,
            locale: {
                applyLabel: 'Submit',
                fromLabel: 'From',
                toLabel: 'To',
                customRangeLabel: 'Select Date Range',
                daysOfWeek: ['Su', 'Mo', 'Tu', 'We', 'Th', 'Fr', 'Sa'],
                monthNames: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
                firstDay: 1
            },
            showWeekNumbers: false,
            buttonClasses: ['btn-danger']
        },
	function(start, end){
		App.scrollTo();
		daterangeCallback(start.toString('yyyy-MM-dd'), end.toString('yyyy-MM-dd'));
		$('#date-range-picker span').html(start.toString('MMMM d, yyyy') + ' - ' + end.toString('MMMM d, yyyy'));
	}
	);
        $('#date-range-picker').show();
        $('#date-range-picker span').html(Date.parse(dates.startDate).toString('MMMM d, yyyy') + ' - ' + Date.parse(dates.endDate).toString('MMMM d, yyyy'));

    }

    var handleGoTop = function () {
        /* set variables locally for increased performance */
        jQuery('.footer').on('click', '.go-top', function (e) {
                App.scrollTo();
                e.preventDefault();
            });
    }

    var handlePortletTools = function () {
        jQuery('body').on('click', '.portlet .tools a.remove', function (e) {
            e.preventDefault();
                var removable = jQuery(this).parents(".portlet");
                if (removable.next().hasClass('portlet') || removable.prev().hasClass('portlet')) {
                    jQuery(this).parents(".portlet").remove();
                } else {
                    jQuery(this).parents(".portlet").parent().remove();
                }
        });

        jQuery('body').on('click', '.portlet .tools a.reload', function (e) {
            e.preventDefault();
                var el = jQuery(this).parents(".portlet");
                App.blockUI(el);
                window.setTimeout(function () {
                        App.unblockUI(el);
                    }, 1000);
        });

        jQuery('body').on('click', '.portlet .tools .collapse, .portlet .tools .expand', function (e) {
            e.preventDefault();
                var el = jQuery(this).closest(".portlet").children(".portlet-body");
                if (jQuery(this).hasClass("collapse")) {
                    jQuery(this).removeClass("collapse").addClass("expand");
                    el.slideUp(200);
                } else {
                    jQuery(this).removeClass("expand").addClass("collapse");
                    el.slideDown(200);
                }
        });
    }

    var handleUniform = function () {
        if (!jQuery().uniform) {
            return;
        }
        var test = $("input[type=checkbox]:not(.toggle), input[type=radio]:not(.toggle, .star)");
        if (test.size() > 0) {
            test.each(function () {
                    if ($(this).parents(".checker").size() == 0) {
                        $(this).show();
                        $(this).uniform();
                    }
                });
        }
    }

    var handleAccordions = function () {
        $(".accordion").collapse().height('auto');

        var lastClicked;

        //add scrollable class name if you need scrollable panes
        jQuery('body').on('click', '.accordion.scrollable .accordion-toggle', function () {
            lastClicked = jQuery(this);
        }); //move to faq section

        jQuery('body').on('shown', '.accordion.scrollable', function () {
            jQuery('html,body').animate({
                scrollTop: lastClicked.offset().top - 150
            }, 'slow');
        });
    }

    var handleTabs = function () {

        // function to fix left/right tab contents
        var fixTabHeight = function(tab) {
            $(tab).each(function() {
                var content = $($($(this).attr("href")));
                var tab = $(this).parent().parent();
                if (tab.height() > content.height()) {
                    content.css('min-height', tab.height());
                }
            });
        }

        // fix tab content on tab shown
        $('body').on('shown', '.nav.nav-tabs.tabs-left a[data-toggle="tab"], .nav.nav-tabs.tabs-right a[data-toggle="tab"]', function(){
            fixTabHeight($(this));
        });

        $('body').on('shown', '.nav.nav-tabs', function(){
            handleSidebarAndContentHeight();
        });

        //fix tab contents for left/right tabs
        fixTabHeight('.nav.nav-tabs.tabs-left > li.active > a[data-toggle="tab"], .nav.nav-tabs.tabs-right > li.active > a[data-toggle="tab"]');

        //activate tab if tab id provided in the URL
        if(location.hash) {
            var tabid = location.hash.substr(1);
            $('a[href="#'+tabid+'"]').click();
        }
    }

    var handleScrollers = function (scroll_source,scroll_myfunction,scroll_webpage,scroll_date) {
      var cp='';var next=isnull=1;var currentPage=sidDown='';      
         
	$(document).unbind("slimscroll");
        $('.scroller').each(function () {
            $(this).slimScroll({
                size: '7px',
                color: '#a1b2bd',
		opacity:0.8,
		wheelStep:5,
                position: isRTL ? 'left' : 'right',
                height: $(this).attr("data-height"),
                alwaysVisible: ($(this).attr("data-always-visible") == "1" ? true : false),
                railVisible: ($(this).attr("data-rail-visible") == "1" ? true : false),
                disableFadeOut: false
            }).bind('slimscroll', function(e, pos){

		 
		if($(this).attr("id")!=null)
		{
			var ddiv=$(this).attr("id");
			var divid1=$(this).attr("id").split("-");currentPage=divid1[0];
		
	 		if(pos=='bottom' && isnull!=0)
         		{		
                      		if(currentPage!=cp)
				{				
					if($('#'+currentPage+'-next').length>0)
					{
						next=($('#'+currentPage+'-next').val()!='')?$('#'+currentPage+'-next').val():0;
					}
					else next=0;
					miniset='set';
				}
                      		next++; 
				$('#'+currentPage+'-next').attr('value',next);			
		      		if(scroll_webpage=='dash' || scroll_webpage=='admindash')scroll_date=$('#mydate').val();
		     		if(miniset=='set')
				if(slimscrollercaller==0)
                     	 	isnull=handlePageLoadOnMiniScroll(scroll_source,currentPage,next,scroll_myfunction,scroll_webpage,scroll_date,ddiv);
				cp=currentPage;
			}
		}
		
          });
      });
    }

    var handleTooltips = function () {
        if (App.isTouchDevice()) { // if touch device, some tooltips can be skipped in order to not conflict with click events
            jQuery('.tooltips:not(.no-tooltip-on-touch-device)').tooltip();
        } else {
            jQuery('.tooltips').tooltip();
        }
    }

    var handleDropdowns = function () {
        $('body').on('click', '.dropdown-menu.hold-on-click', function(e){
            e.stopPropagation();
        })
    }

    var handlePopovers = function () {
        jQuery('.popovers').popover();
    }

    var handleSelect2 = function () {
        if (!jQuery().select2) {
            return;
        }
        $("select.select2").each(function () {
            $(this).select2({
                allow_single_deselect: $(this).attr("data-with-diselect") === "1" ? true : false
            });
        });
        $("input.select2").each(function () {
            $(this).select2({
                allow_single_deselect: $(this).attr("data-with-diselect") === "1" ? true : false
            });
        });
    }

    var handleFancybox = function () {
        if (!jQuery.fancybox) {
            return;
        }

        if (jQuery(".fancybox-button").size() > 0) {
            jQuery(".fancybox-button").fancybox({
                groupAttr: 'data-rel',
                prevEffect: 'none',
                nextEffect: 'none',
                closeBtn: true,
                helpers: {
                    title: {
                        type: 'inside'
                    }
                }
            });
        }
    }

    var handleFixInputPlaceholderForIE = function () {
        //fix html5 placeholder attribute for ie7 & ie8
        if (isIE8 || isIE9) { // ie7&ie8
            // this is html5 placeholder fix for inputs, inputs with placeholder-no-fix class will be skipped(e.g: we need this for password fields)
            jQuery('input[placeholder]:not(.placeholder-no-fix), textarea[placeholder]:not(.placeholder-no-fix)').each(function () {

                var input = jQuery(this);

                if(input.val()=='' && input.attr("placeholder") != '') {
                    input.addClass("placeholder").val(input.attr('placeholder'));
                }

                input.focus(function () {
                    if (input.val() == input.attr('placeholder')) {
                        input.val('');
                    }
                });

                input.blur(function () {
                    if (input.val() == '' || input.val() == input.attr('placeholder')) {
                        input.val(input.attr('placeholder'));
                    }
                });
            });
        }
    }

   var handleDateTimePickers = function () {

        if (jQuery().datepicker) {
            $('.date-picker').datepicker({autoclose: true});
        }
    }
    //* END:CORE HANDLERS *//
    //* START: CUSTOM HANDLERS*//


   var handlePageLoadOnMiniScroll =function(scroll_source,currentPage,next,scroll_myfunction,scroll_webpage,scroll_date,divid1){

     	if(scroll_webpage=='doc_dash' || scroll_webpage=='pat_dash')
	{
		var currntclass=''
		slimscrollercaller=1;
		$.get(scroll_source+'?next='+next+'&feed=feeds', function(data)
		{
				currntclass=Dash.backFillFeed(scroll_webpage,currentPage,data);

				if(currntclass!=0)
				{	slimscrollercaller=0;
					$('#'+divid1).slimscroll({ 
						//start:$('.'+currntclass),
						scrollBy:'-150px',
						height:370,
						opacity:0.8,
						wheelStep:2
									                
					});
					return 1;
				}
				else return 0;		
			
	        });

      	}
       else
	{
		$.get(scroll_source+'?next='+next+'&getpage='+currentPage+'&page='+scroll_webpage+'&date='+scroll_date, function(data) {
             
	  		if(scroll_webpage=='smarty')
			{ 
				if(data!=null)			
				$('#'+currentPage).append(data);	
			}	
		   	else 
			{	var currntclass='';
				if(data!='')
					scroll_myfunction(currentPage,data);
				else
				{
					scroll_myfunction(currentPage,data);
					miniset='unset';
				}				
				
			}
          	}); 
        }
			     
       } 

  var changeDate = function(date){

   scroll_date=date;

   }


    var handlePageLoadOnScroll =function(source,currentPage,setting) {
         var nextval=0;var cp=0;var isDown='up';
	 if($('#load_statistics_loading').length<=0)
		$('<div id="load_statistics_loading"></div>').appendTo('.page-content');
	 var loadingdiv=$('#load_statistics_loading');
	 //App.blockUI(loadingdiv);
	
         $(window).unbind('scroll');
	$('#load_statistics_loading').text('');
	
	
	//TypeError
	var abc=0;
	 $(window).scroll(function() 
         {
		
		if(setting=='set'){
	 	if($(window).scrollTop() + $(window).height() > ((80/100)*$(document).height()))
		{	
			
			//isDown=(isDown=='down' || isDown=='nowhere')?'nowhere':'down';
			isDown='down';
		}
		else
		{
			isDown='up';
		}
		if($(window).scrollTop() + $(window).height()>($(document).height()-3)){
			isDown='down';
		}
	 	if(isDown=='down' && abc==0)
         	{   abc=1;
                    if(source=='' || source==null){return true;}
			if(cp!=currentPage){($('#'+currentPage+'-next').val()!=null && $('#'+currentPage+'-next').val()!='')?nextval=parseInt($('#'+currentPage+'-next').val()):nextval=0;}
         		nextval++;
                 	$('#'+currentPage+'-next').val(nextval);
			App.blockUI(loadingdiv);
                        if(source[1]=='#')
                        {                       
                        	var source1=source.split("#");var type=source1[0];var mysource=source1[1];                        
                       		var currentPage_arr=currentPage.split("-");                       
                       		var backupnext='';
                        	if($('#backupnext').val()!=''){
                        		 backupnext=parseInt($('#backupnext').val());backupnext++;
                         	}
                      		  $.get(mysource+'&next='+nextval+'&page='+currentPage_arr[1]+'&backupnext='+backupnext, function(data) {
                         	  abc=0;
				App.unblockUI(loadingdiv);
				if(currentPage=='patientfeed'){
                                	if(data!=null && data!=''){var data=$.parseJSON(data);
                      if(data.data!='' && data.data!=null)Templates.PatientQuestionsTemplate(data.data,currentPage,data.usertype,data.selflogged_in);
                         		}else{
				$('#load_statistics_loading').html('<span style="position:relative;left:40%;font-size:18px;opacity:0.3;"><B>NO MORE DATA</B></span>');
				setting="unset";
			        	 }
               		 	
				}else if(currentPage=='profile_followings-profile_followings' || currentPage=='profile_followers-profile_followers')  {				        		
					var data=$.parseJSON(data);	
					if(data!=null && data!=''){					
					followTemplates(data,currentPage_arr[1]);						
					}else{

			$('#load_statistics_loading').html('<span style="position:relative;left:40%;font-size:18px;opacity:0.3;"><B>NO MORE DATA</B></span>');
				setting="unset";
				}
				}else if(currentPage=='profile_wall-profile_wall')
					{
					if(data!=null && data!=''){					
					$('#'+currentPage_arr[1]).append(data);					
					}else{

			$('#load_statistics_loading').html('<span style="position:relative;left:40%;font-size:18px;opacity:0.3;"><B>NO MORE DATA</B></span>');
				setting="unset";
					}

				}else{
                   			if(data!=null && data!='' && data!='null'){
						Network.getBackPage(type,currentPage_arr[0],data);
					}
		   			else{
			$('#load_statistics_loading').html('<span style="position:relative;left:40%;font-size:18px;opacity:0.3;"><B>NO MORE DATA</B></span>');
						setting="unset";
					}
				 }
	 			});
             	 }else{
			
			
	 		$.get(source+'?next='+nextval+'&page='+currentPage, function(data) {  
				   abc=0;        
				App.unblockUI(loadingdiv);
				if(data!=null && data!='')
				{
              				$("#"+currentPage).append(data);
					Popovers.pops('a[rel=pop_rel]','expert');
				if(currentPage=='answerQuestions' || currentPage=='pastAnswers' || currentPage=='pendingQuestions' || currentPage=='allQuestions')formsubmission();
					
				}else{	
				 		
			$('#load_statistics_loading').html('<span style="position:relative;left:40%;font-size:18px;opacity:0.3;"><B>NO MORE DATA</B></span>');
				setting="unset";
				}
				
	 			});
                             }
			
			  
          		  cp=currentPage;
       		}
	 	else if(isDown=='up')
		{
			//App.unblockUI(loadingdiv);
		}
	    }
	 });
       
    }

    var handleModals = function () 
    {
    	$.fn.modalmanager.defaults.resize = true;
	$.fn.modalmanager.defaults.spinner = '<div class="loading-spinner fade" style="width: 200px; margin-left: -100px;"><img src="/assets/img/ajax-modal-loading.gif" align="middle">&nbsp;<span style="font-weight:300; color: #eee; font-size: 18px; font-family:Open Sans;">&nbsp;Loading...</div>'; 
    }

    //* END: CUSTOM HANDLERS*//

    return {

        //main function to initiate template pages
        initCore: function () {
            //IMPORTANT!!!: Do not modify the core handlers call order.
		
            //core handlers
            handleInit();
            handleResponsiveOnResize(); // set and handle responsive    
            handleUniform();
            handleScrollers(); // handles slim scrolling contents 
            handleResponsiveOnInit(); // handler responsive elements on page load
            
	    //layout handlers
            handleFixedSidebar(); // handles fixed sidebar menu
            handleFixedSidebarHoverable(); // handles fixed sidebar on hover effect 
            handleLinksPageContent(); // handles links to open in page content body
            handleSidebarMenu(); // handles main menu
            handleSidebarToggler(); // handles sidebar hide/show            
            handleGoTop(); //handles scroll to top functionality in the footer
	    handleModals();
            //handleHorizontalMenu(); // handles horizontal menu
            //handleTheme(); // handles style customer tool
	},
        init: function () {
            //core handlers
	    handlePageLoadOnScroll('','','unset');
            //layout handlers
            handleFixInputPlaceholderForIE(); // fixes/enables html5 placeholder attribute for IE9, IE8

            //ui component handlers
            //handlePortletTools(); // handles portlet action bar functionality(refresh, configure, toggle, remove)
            handleDropdowns(); // handle dropdowns
            handleTabs(); // handle tabs
            handleTooltips(); // handle bootstrap tooltips
            handlePopovers(); // handles bootstrap popovers
            handleAccordions(); //handles accordions
            handleSelect2(); // handles bootstrap chosen dropdowns     
    	    handleDateTimePickers();

            App.addResponsiveHandler(handleSelect2); // reinitiate chosen dropdown on main content resize. disable this line if you don't really use chosen dropdowns.

        },
        initDateRange: function(dates, daterangeCallback)
        {
              handleDateRangePickers(dates, daterangeCallback); 
        },
        initFillData: function(mypage,source)
        {           
		
            handlePageLoadOnScroll(source,mypage,'set');   
        },
        initHandleScrollers : function(scroll_source,scroll_webpage,scroll_myfunction,scroll_date)
        {
          handleScrollers(scroll_source,scroll_myfunction,scroll_webpage,scroll_date);
        },
	initChangeDate: function(date)
	{
		changeDate(date);
	},
        fixContentHeight : function() {
            handleSidebarAndContentHeight();
        },

        addResponsiveHandler: function (func) {
            responsiveHandlers.push(func);
        },

        // useful function to make equal height for contacts stand side by side
        setEqualHeight: function (els) {
            var tallestEl = 0;
            els = jQuery(els);
            els.each(function () {
                    var currentHeight = $(this).height();
                    if (currentHeight > tallestEl) {
                        tallestColumn = currentHeight;
                    }
                });
            els.height(tallestEl);
        },

        // wrapper function to scroll to an element
        scrollTo: function (el, offeset) {
            pos = el ? el.offset().top : 0;
            jQuery('html,body').animate({
                scrollTop: pos + (offeset ? offeset : 0)
            }, 'slow');
        },

        scrollTop : function() {
            App.scrollTo();
        },

        // wrapper function to  block element(indicate loading)
        blockUI: function (el, options) {
	    var options=(typeof(options)=='undefined')?'':options;
	    var msg =options.msg?options.msg:'<img src="/assets/img/ajax-loading.gif" align="absmiddle">';
	    var color =options.color?options.color:'#000';
	    var opacity =options.opacity?options.opacity:0.05;
            jQuery(el).block({
                message: msg,
                css: {
                    border: 'none',
                    padding: '2px',
                    backgroundColor: 'none'
                },
                overlayCSS: {
                    backgroundColor: color,
                    opacity: opacity,
                    cursor: 'wait'
                }
            });
        },

        // wrapper function to  un-block element(finish loading)
        unblockUI: function (el) {
            jQuery(el).unblock({
                onUnblock: function () {
                    jQuery(el).removeAttr("style");
                }
            });
        },

        // initializes uniform elements
        initUniform: function (els) {

            if (els) {
                jQuery(els).each(function () {
                    if ($(this).parents(".checker").size() == 0) {
                        $(this).show();
                        $(this).uniform();
                    }
                });
            } else {
                handleUniform();
            }

        },

        initFancybox: function () {
            handleFancybox();
        },

        showUpdateNotification: function(type, heading,content)
        {            
          if(type=='instant')
    	  $.gritter.add({
           title: heading,
           text: content
          });
        },
        getActualVal: function (el) {
            var el = jQuery(el);
            if (el.val() === el.attr("placeholder")) {
                return "";
            }

            return el.val();
        },

        getURLParameter: function (paramName) {
            var searchString = window.location.search.substring(1),
                i, val, params = searchString.split("&");

            for (i = 0; i < params.length; i++) {
                val = params[i].split("=");
                if (val[0] == paramName) {
                    return unescape(val[1]);
                }
            }
            return null;
        },

        // check for device touch support
        isTouchDevice: function () {
            try {
                document.createEvent("TouchEvent");
                return true;
            } catch (e) {
                return false;
            }
        },

        isIE8: function () {
            return isIE8;
        },

        isRTL: function () {
            return isRTL;
        }

    };

}();
