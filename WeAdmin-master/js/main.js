$(document).ready(function(){
	

	// footer微信二维码
	$('.topMa a').hover(function() {
		$(this).find('.int').hide();
		$(this).find('.hover').show();
		$('.topMa').find('div').show();
		$('.topMa').find('div').find('img').hide();
		$('.topMa').find('div').find('img').eq($(".topMa a").index($(this))).show();
	}, function() {
		$(this).find('.int').show();
		$(this).find('.hover').hide();
		$('.topMa').find('div').hide();
	});

	// 活动也详情返回顶部按钮
	$('.gotopButton').click(function(event) {
		$(document).scrollTop(0);
	});
	$(window).scroll(function(){
		var offsetTop = $(window).scrollTop();
		if(offsetTop==0){ $(".gotopButton").addClass('show'); }else{ $(".gotopButton").removeClass('show') }
	}); 
	// 手机菜单特效
	$('.phoneUL li a.menuA').click(function(event) {
		$(this).next('ul').toggle();
		$(this).find('b').toggle();
	});
	$('.phoneUL li ul li a.menuB').click(function(event) {
		$(this).next('div').toggle();
		$(this).find('b').toggle();
	});
	// 登录鼠标经过特效
	$('.loginBtn').hover(function() {
		$(this).addClass('loginBtnHover');
		$(this).find('div').addClass('loginDownShow');
	}, function() {
		loginTimer=setTimeout(function(){
			$('.loginBtn').removeClass('loginBtnHover');
			$('.loginBtn').find('div').removeClass('loginDownShow');	
		}, 10);
	});
	$('.loginBtn').find('div').hover(function() {
		clearTimeout(loginTimer);
	}, function() {
		$(this).addClass('loginDownShow');
	});

	// 菜单悬浮
	if($(".infoLeft").length>0){

		$(window).scroll(function(){
			if($(document).scrollTop() > $('.infoLeft').offset().top){
					$(".infoLeft ul").addClass("leftMenufixed");
				}else{
					$(".infoLeft ul").removeClass("leftMenufixed");
				}
		});
	};

	//ie版本判断 如果是ie8或者低于ie8  不显示加载动画
	var DEFAULT_VERSION = "8.0";
	var ua = navigator.userAgent.toLowerCase();
	var isIE = ua.indexOf("msie")>-1;
	var safariVersion;
	if(isIE){
	    safariVersion =  ua.match(/msie ([\d.]+)/)[1];
	}
	if(safariVersion <= DEFAULT_VERSION ){
	    // 进行你所要的操作
	}else{
		// 首页载入动画特效
		var wow = new WOW({
		    boxClass: 'wow',
		    animateClass: 'animated',
		    offset: 0,
		    mobile: true,
		    live: true
		});
		wow.init();
	}
	

	// 左侧二级菜单
	// $('.menuUlLeft li').click(function(event) {
	// 	$('.menuUlLeft li span').hide();
	// 	$(this).find('span').show();	
	// });

	// 详情页 tab
	var tabBtn1=$('.tabObjTitle a');
	tabBtn1.click(function(event) {
		$('.tabObjTitle').find('a').removeClass('active');
		$(this).addClass('active');
		$('.tabObjMain').find('.tabObjItem').hide();
		$('.tabObjMain').find('.tabObjItem').eq($(".tabObjTitle a").index($(this))).show();
	});

	// 登录窗口
	$('.winClosBtn').click(function(event) {
		$('#mark').hide();
		$('.winBox').hide();
	});
	$('.loginBtn1').click(function(event) {
		$('#mark').show();
		$('#winBox').show();
		$('#mark').css({'width':$(window).width(),'height':$(window).height()});
		$('#winBox').css({'left':($(window).width()-$('#winBox').width())/2,'top':200});
		window.onresize=function(){
			$('#mark').css({'width':$(window).width(),'height':$(window).height()});
			$('#winBox').css({'left':($(window).width()-$('#winBox').width())/2,'top':200});
		}
	});
	$('#infoBtn,.loginBtn2').click(function(event) {
		$('#mark').show();
		$('#winBox').hide();
		$('#infoMain').show();
		$('#mark').css({'width':$(window).width(),'height':$(window).height()});
		$('#infoMain').css({'left':($(window).width()-$('#infoMain').width())/2,'top':200});
		window.onresize=function(){
			$('#mark').css({'width':$(window).width(),'height':$(window).height()});
			$('#infoMain').css({'left':($(window).width()-$('#infoMain').width())/2,'top':200});
		}
	});

	// 响应式菜单
	$('#phoneMenu').click(function(event) {
		if($('#phoneMenu2').attr('class')=='phoneMenumain phoneMenuOpen'){
			$('#phoneMenu2').attr({'class':'phoneMenumain'});
			$('#bodyBox').attr({'class':'box'});
		}else{
			$('#phoneMenu2').attr({'class':'phoneMenumain phoneMenuOpen'});
			$('#bodyBox').attr({'class':'box menu-open'});
		}
	});

	//banner
	var mySwiper = new Swiper('.swiper-container1',{
	    pagination: '.pagination',
	    loop:true,
	    grabCursor: true,
	    paginationClickable: true,
	    autoResize : true,
	    calculateHeight : true,
	    resizeReInit : true
	});

	// 合作伙伴 
	var findLink = new Swiper('.cooperationMain',{
	    loop:true,
	    slidesPerView : 4,
	    slidesPerColumn : 2,
	    slidesPerGroup : 1,
	    grabCursor: true,
	    paginationClickable: true,
	    autoResize : true,
	    resizeReInit : true,
	    calculateHeight : true
	});
	$('#rollLeft').click(function(event) {
		findLink.swipePrev();
	});
	$('#rollRight').click(function(event) {
		findLink.swipeNext();
	});
	

	// 首页评论
	$('#comments p').hover(function() {
		$(this).css({'height':'auto'});
	}, function() {
		$(this).removeAttr('style');
		
	});


	// tab 首页
	var tabBtn=$('#indexTabBtn a');
	tabBtn.hover(function(event) {
		$('#indexTabBtn').find('a').removeClass('active');
		$(this).addClass('active');
		$('#indexTabBox').find('.indexTabBm').hide();
		$('#indexTabBox').find('.indexTabBm').eq($("#indexTabBtn a").index($(this))).show();
	});

});

window.onload=function(){

	// 导航效果
	var oNav=document.getElementById('nav');
	var navAli=getElementsByClassName('menuItem', oNav, 'li');
	var navIndex=null;
	for(var i=0;i<navAli.length;i++){
		navAli[i].index=i;

		if(getElementsByClassName('menuA', navAli[i], 'a')[0].className=='active menuA'){
				navIndex=navAli[i].index;
		}
		navAli[i].onmouseover=function(){
			for(var s=0;s<navAli.length;s++){
				getElementsByClassName('menuA', navAli[s], 'a')[0].className='menuA';
			}

			getElementsByClassName('menuA', this, 'a')[0].className='active menuA'; 

			var ulNavB=this.getElementsByTagName('ul');
			if(ulNavB.length){
				ulNavB[0].style.display='block';
				var navcLI=ulNavB[0].getElementsByTagName('li');
				for(var j=0;j<navcLI.length;j++){
					navcLI[j].onmouseover=function(){
						getElementsByClassName('menuB', this, 'a')[0].className='menuB act';
						var navDiv=this.getElementsByTagName('div');
						if(navDiv.length){
							navDiv[0].style.display='block';
						}
					};
					navcLI[j].onmouseout=function(){
						getElementsByClassName('menuB', this, 'a')[0].className='menuB';
						var navDiv=this.getElementsByTagName('div');
						if(navDiv.length){
							navDiv[0].style.display='none';
						}
					};

				}
			}
		};

		navAli[i].onmouseout=function(){
			getElementsByClassName('menuA', this, 'a')[0].className='menuA';
			var ulNavB=this.getElementsByTagName('ul');
			if(ulNavB.length){
				ulNavB[0].style.display='none';
			}
			getElementsByClassName('menuA', navAli[navIndex], 'a')[0].className='active menuA';
		};
	}
	
};

function getElementsByClassName(className, root, tagName) {    
    if (root) {
        root = typeof root == "string" ? document.getElementById(root) : root;
    } else {
        root = document.body;
    }
    tagName = tagName || "*";
    if (document.getElementsByClassName) {                  
        return root.getElementsByClassName(className);
    } else {
        var tag = root.getElementsByTagName(tagName);    
        var tagAll = [];                                    
        for (var i = 0; i < tag.length; i++) {                
            for (var j = 0, n = tag[i].className.split(' ') ; j < n.length; j++) {   
                if (n[j] == className) {
                    tagAll.push(tag[i]);
                    break;
                }
            }
        }
        return tagAll;
    }
}
