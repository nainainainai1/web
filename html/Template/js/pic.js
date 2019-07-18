$(function(){
		var timer = setInterval(autoPlay,6000);
		var iNow = 0;
		var iX = $(".banner_ul li").width();
		var iL = $(".banner_ul").children();
 
		console.log(iL.length);
		//自动播放
		function autoPlay(){
			iNow++;
			if(iNow>=iL.length){
				$(".banner_ul").css('left',0);
				iNow = 0;
			}
			$(".banner_ul").animate({left:-iX*iNow},3000);
			$(".banner-span span").removeClass("span_point");
			$(".banner-span span").eq(iNow).addClass("span_point");
		}
 
		//鼠标移动事件  //清除定时器
 
		$(".banner").hover(function(){
			clearInterval(timer);
			$(".banner_prev").show();
			$(".banner_next").show();
		},function(){
			timer = setInterval(autoPlay,3000);
			$(".banner_prev").hide();
			$(".banner_next").hide();
		})
 
		
		//鼠标点击事件（左右）
		//右点击
		$(".banner_next").click(function(){
			clearInterval(timer);
			iNow++;
			if(iNow>=iL.length){
				$(".banner_ul").css('left','0');
				iNow = 0;
			}
			$(".banner_ul").css("left",-iNow*iX);
			$(".banner-span span").removeClass("span_point");
			$(".banner-span span").eq(iNow).addClass("span_point");
		})
		//左点击
		$(".banner_prev").click(function(){
			clearInterval(timer);
			--iNow;
			if(iNow<=-1){
				$(".banner_ul").css("left",-(iL.length-1)*iX);
				iNow = iL.length-1;
			}
			$(".banner_ul").css("left",-iNow*iX);
			$(".banner-span span").removeClass("span_point");
			$(".banner-span span").eq(iNow).addClass("span_point");
		});
 
		//图标点击事件
		$(".banner-span span").click(function(){
			clearInterval(timer);
			$(".banner-span span").removeClass("span_point");
			$(".banner-span span").eq($(this).index()).addClass("span_point");
			iNow= $(this).index();
			$(".banner_ul").css("left",-iNow*iX);
		})
 
	})
