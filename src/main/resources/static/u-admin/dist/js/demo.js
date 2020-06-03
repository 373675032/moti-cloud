$("body").append('<div class="demo-settings"><div class="demo-settings-toggle"><i class="ion ion-gear-a"></i></div><div class="demo-settings-options"><ul><li class="demo-toggle-skin" style="background-color: #574B90;" title="Default"></li><li class="demo-toggle-skin" style="background-color: #3F52E3;" title="Blue"></li><li class="demo-toggle-skin" style="background-color: #39065A;" title="Deep Purple"></li><li class="demo-toggle-skin" style="background-color: #3DC7BE;" title="Light Blue"></li><li class="demo-toggle-skin" style="background-color: #212330;" title="Dark Sidebar"></li></ul></div></div>');

var skin = function(color) {
	$("#skin-css").remove();
	if(color == 'default') return;
	$("head").append($("<link/>", {
		rel: 'stylesheet',
		href: 'u-admin/dist/css/skins/' + color + '.css',
		id: 'skin-css'
	}));
}

$(".demo-settings-toggle").on("click", function() {
	if($(".demo-settings")[0].classList.contains("active")) {
	  $(".demo-settings")[0].classList.remove('active');
	}else{
	  $(".demo-settings")[0].classList += ' active';
	}
});

if(localStorage.getItem("skin")) {
	skin(localStorage.getItem("skin").replace(/ /g, ''));
}

$(".demo-toggle-skin").each(function(i) {
	let me = $(this);
	me.on("click", function(e) {
		let _this = e.target;
		localStorage.removeItem("skin");
		localStorage.setItem("skin", _this.attributes.title.nodeValue.toLowerCase());
	 	skin(_this.attributes.title.nodeValue.toLowerCase().replace(/ /g, ''));
	});
 });

