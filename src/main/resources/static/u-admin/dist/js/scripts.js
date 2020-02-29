// ChartJS
if(window.Chart) {
	Chart.defaults.global.defaultFontFamily = "'Segoe UI', 'Arial'";
	Chart.defaults.global.tooltips.backgroundColor = '#000';
	Chart.defaults.global.tooltips.titleFontFamily = 'Segoe UI';
	Chart.defaults.global.tooltips.titleFontColor = '#fff';
	Chart.defaults.global.tooltips.xPadding	= 10;
	Chart.defaults.global.tooltips.yPadding	= 12;
	Chart.defaults.global.tooltips.cornerRadius	= 3;
}

// DropzoneJS
if(window.Dropzone) {
	Dropzone.autoDiscover = false;
}

// Global
$(function() {
	if($(".main-sidebar").length) {
		$(".main-sidebar").niceScroll({
				cursoropacitymin: .1,
				cursoropacitymax: .8,
		});
		var sidebar_nicescroll = $(".main-sidebar").getNiceScroll();
	
		$(".main-sidebar .sidebar-menu li a.has-dropdown").on('click', function() {
			var me = $(this);

			me.parent().find('> .menu-dropdown').slideToggle(500, function() {
				sidebar_nicescroll.resize();
			});
			return false;
		});
	}

	$(".main-content").css({
		minHeight: $(window).outerHeight() - 95
	})

	$("[data-toggle='sidebar']").click(function() {
		var body = $("body");

		body.removeClass('search-show search-gone');
		if(body.hasClass('sidebar-gone')) {
			body.removeClass('sidebar-gone');
			body.addClass('sidebar-show');
			sidebar_nicescroll.resize();
		}else{
			body.addClass('sidebar-gone');
			body.removeClass('sidebar-show');
			sidebar_nicescroll.resize();
		}
		return false;
	});

	$("[data-toggle='search']").click(function() {
		var body = $("body");

		if(body.hasClass('search-gone')) {
			body.addClass('search-gone');
			body.removeClass('search-show');
		}else{
			body.removeClass('search-gone');
			body.addClass('search-show');
		}
	});

	var toggleSidebar = function() {
		var w = $(window);
		if(w.outerWidth() <= 1024) {
			$("body").addClass("sidebar-gone");
			$("body").off('click').on('click', function(e) {
				if($(e.target).hasClass('sidebar-show') || $(e.target).hasClass('search-show')) {
					$("body").removeClass("sidebar-show");
					$("body").addClass("sidebar-gone");
					$("body").removeClass("search-show");
				}
			});
		}else{
			$("body").removeClass("sidebar-gone");
		}
	}
	toggleSidebar();
	$(window).resize(toggleSidebar);

	// tooltip
	$("[data-toggle='tooltip']").tooltip();

	// popover
	$('[data-toggle="popover"]').popover({
		container: 'body'
	});

	$(".notification-toggle").dropdown();
	$(".notification-toggle").parent().on('shown.bs.dropdown', function() {
		$(".dropdown-list-content").niceScroll({
			cursoropacitymin: .3,
			cursoropacitymax: .8,
			cursorwidth: 7
		});
	});

	if(jQuery().summernote) {	
		$(".summernote").summernote({
			minHeight: 250,
		});
		$(".summernote-simple").summernote({
			minHeight: 150,
			toolbar: [
				['style', ['bold', 'italic', 'underline', 'clear']],
				['font', ['strikethrough']],
				['para', ['paragraph']]
			]
		});
	}

	// Dismiss function
	$("[data-dismiss]").each(function() {
		var me = $(this),
				target = me.data('dismiss');

		me.click(function() {
			$(target).fadeOut(function() {
				$(target).remove();
			});
			return false;
		});
	});

	// Collapsable
	$("[data-collapse]").each(function() {
		var me = $(this),
				target = me.data('collapse');

		me.click(function() {
			$(target).collapse('toggle');
			$(target).on('shown.bs.collapse', function() {
				me.html('<i class="ion ion-minus"></i>');
			});
			$(target).on('hidden.bs.collapse', function() {
				me.html('<i class="ion ion-plus"></i>');
			});
			return false;
		});
	});

	// Background
	$("[data-background]").each(function() {
		var me = $(this);
		me.css({
			backgroundImage: 'url(' + me.data('background') + ')'
		});
	});

	// Custom Tab
	$("[data-tab]").each(function() {
		var me = $(this);

		me.click(function() {
			if(!me.hasClass('active')) {
				var	tab_group = $('[data-tab-group="' + me.data('tab') + '"]'),
						tab_group_active = $('[data-tab-group="' + me.data('tab') + '"].active'),
						target = $(me.attr('href')),
						links = $('[data-tab="'+me.data('tab') +'"]');

				links.removeClass('active');
				me.addClass('active');
				target.addClass('active');
				tab_group_active.removeClass('active');
			}
			return false;
		});
	});

	// Bootstrap 4 Validation
	$(".needs-validation").submit(function() {
		var form = $(this);
        if (form[0].checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
		form.addClass('was-validated');
	});

	// alert dismissible
	$(".alert-dismissible").each(function() {
		var me = $(this);

		me.find('.close').click(function() {
			me.alert('close');
		});
	});

	if($('.main-navbar').length) {
		$(".main-navbar").scrollupbar({
			enterViewport: function() {
				$(".main-navbar").addClass('active');
			},
			exitViewport: function() {
				$(".main-navbar").removeClass('active');
			}
		});

		$(window).scroll(function() {
			if($(this).scrollTop() == 0) {
				$(".main-navbar").removeClass('active');
			}
		});
	}
});