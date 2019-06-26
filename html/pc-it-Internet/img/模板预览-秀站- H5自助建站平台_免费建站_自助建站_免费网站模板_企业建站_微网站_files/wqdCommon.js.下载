// JavaScript Document
$(function() {
	//滑动浏览
	wqdTouchSlide = function (box,config){
	    this.box = typeof box == 'object' ? box : $(box);
	    this.config = $.extend({},config||{});
	    this.slideTime = this.config.slideTime || 500;  		//动画过渡时间
	    this.bindClick = this.config.bindClick || false;		//是否绑定click事件
	    this.translatX = 0; 									//横向位移
	    this.touchX = 0;
	    this.sliding = false;									//过渡状态，true为正在过渡
	    this.dataArr = [this.contentWidth-this.boxWidth];		//记录每个节点的位置
	   	this.boxWidth = this.box.parent().width();				//外容器的宽
	   	this.contentWidth = this.box.width();
	   	this.maxTranslat = this.boxWidth - this.contentWidth;	//最大位移值
	    this.maxTranslat < 0 && this.init();	
	}

	$.extend(wqdTouchSlide.prototype,{
		init : function(){
			this.inteData();
			this.bindEvent();
			this.bindClick && this.clickEvent();
		},
		//子节点的点击事件，保持点击节点处于中间且
		clickEvent : function(){
			var self = this;
			self.box.children().on("click.slide",function(){
				var that = $(this),
				targetVal = 0,
				lastLeft = 0,
				minVal = 99999,
				thisLeft = 0;
				that.prevAll().each(function(){
					thisLeft += $(this).outerWidth();
				});
				thisLeft += that.outerWidth()/2;
				targetVal = self.boxWidth/2 - thisLeft;
				if(targetVal > 0){
					self.translatX = 0;
				}else if(targetVal < self.maxTranslat){
					self.translatX = self.maxTranslat;
				}else{
					for(var k=0; k<self.dataArr.length; k++){
						if(Math.abs(self.dataArr[k]+targetVal) < minVal){
							minVal = Math.abs(self.dataArr[k]+targetVal);
							lastLeft = 0 - self.dataArr[k];
						} 
					}
					if(self.translatX != lastLeft) self.translatX = lastLeft;
				}
				self.sliding = true;
				self.box.attr("translatx",self.translatX).css(self.getStyle(self.translatX));
				setTimeout(function(){self.sliding = false;},self.slideTime);
			});
		},
		inteData : function(){
			var self = this;
			self.box.children().each(function(){
				var tempLeft = 0;
				if($(this).prev().length){
					tempLeft = ($(this).prev().attr("tempLeft")||0) - 0 + $(this).prev().outerWidth();
				}
				$(this).attr("tempLeft",tempLeft);
				self.dataArr.push(tempLeft);
			});
		},
		bindEvent : function(){
			var self = this;
			self.box.on("touchstart",function(e){
				if (!self.sliding && e.originalEvent.changedTouches.length == 1){
					self.touchX = e.originalEvent.changedTouches[0].screenX;
				}
			}).on("touchmove",function(e){
				e.preventDefault();
				!self.sliding && e.originalEvent.changedTouches.length == 1 && self.touchMove(e.originalEvent.changedTouches[0].screenX);
			}).on("touchcancel touchend",function(e){
				!self.sliding && e.originalEvent.changedTouches.length == 1 && self.touchEnd(e.originalEvent.changedTouches[0].screenX);
			});
		},
		touchMove : function(screenX){
			typeof this.config.moveCallback == "function" && this.config.moveCallback();
			var tempX = screenX - this.touchX;
			if(this.translatX+tempX > 0 || this.translatX+tempX < this.maxTranslat) tempX = tempX/3;
			this.box.attr("translatx",this.translatX+tempX).css(this.getStyle(this.translatX+tempX,0));
		},
		touchEnd : function(screenX){
			if(Math.abs(screenX - this.touchX)<20) return;
			var self = this,
				minVal = 99999,
				lastLeft = 0;
			self.translatX += screenX - self.touchX;
			this.sliding = true;
			if(self.translatX > 0){
				self.translatX = 0;
			}else if(self.translatX < self.maxTranslat){
				self.translatX = self.maxTranslat;
			}else{
				for(var k=0; k<self.dataArr.length; k++){
					if(Math.abs(self.dataArr[k]+self.translatX) < minVal){
						minVal = Math.abs(self.dataArr[k]+self.translatX);
						lastLeft = 0 - self.dataArr[k];
					} 
				}
				self.translatX = lastLeft;
			}
			self.box.attr("translatx",self.translatX).css(self.getStyle(self.translatX));
			setTimeout(function(){self.sliding = false;},self.slideTime);
		},
		getStyle : function(val,time){
			var timer = typeof time == "undefined" ? this.slideTime : time;
			return {
	            '-webkit-transition':'-webkit-transform '+timer+'ms',
	            '-webkit-transform':'translate3d('+val+'px,0,0)',
	            'transition':'transform '+timer+'ms',
	            'transform':'translate3d('+val+'px,0,0)',
	            '-webkit-backface-visibility': 'hidden'
	        };
		}
	});
	//无缝轮播
	wqdImgSlide = function (box,config){
	    this.box = typeof box == 'object' ? box : $(box);
	    this.config = $.extend({},config||{});
	    this.width = this.config.width||this.box.children().eq(0).width();//一次滚动的宽度
	    this.size = this.config.size||this.box.children().length;
	    this.loop = this.config.loop == undefined ? true : this.config.loop;//默认能循环滚动
	    this.auto = this.config.auto == undefined ? true : this.config.auto;//默认自动滚动
	    this.auto_wait_time = this.config.auto_wait_time||3000;//轮播间隔
	    this.scroll_time = 300;//滚动时长
	    this.minleft = -this.width*(this.size-1);//最小left值，注意是负数[不循环情况下的值]
	    this.maxleft =0;//最大lfet值[不循环情况下的值]
	    this.now_left = 0;//初始位置信息[不循环情况下的值]
	    this.point_x = null;//记录一个x坐标
	    this.point_y = null;//记录一个y坐标
	    this.move_left = false;//记录向哪边滑动
	    this.index = 0;
	    this.busy = false;
	    this.size > 1 && this.timer;
	    this.size > 1 && this.init();
	};
	$.extend(wqdImgSlide.prototype,{
	    init : function(){
	        this.bind_event();
	        this.init_loop();
	        this.auto_scroll();
	    },
	    bind_event : function(){
	        var self = this;
	        self.box.bind('touchstart',function(e){
	            if(e.originalEvent.changedTouches.length==1 && !self.busy){
	                self.point_x = e.originalEvent.changedTouches[0].screenX;
	                self.point_y = e.originalEvent.changedTouches[0].screenY;
	            }
	        }).bind('touchmove',function(e){
	            if(e.originalEvent.changedTouches.length==1 && !self.busy){
	                return self.move(e.originalEvent.changedTouches[0].screenX,e.originalEvent.changedTouches[0].screenY);
	            }
	        }).bind('touchend',function(e){
	            !self.busy && self.move_end();
	        });
	    },
	   
	    init_loop : function(){
	        if(this.box.children().length == this.size && this.loop){
	            this.now_left = -this.width;//设置初始位置信息
	            this.minleft = -this.width*this.size;//最小left值
	            this.maxleft = -this.width;
	            this.box.prepend(this.box.children().eq(this.size-1).clone()).append(this.box.children().eq(1).clone()).css(this.get_style(2));
	            this.box.css('width',this.width*(this.size+2));
	        }else{
	            this.loop = false;
	            this.box.css('width',this.width*this.size);
	        }
	    },
	    auto_scroll : function(){//自动滚动
	        var self = this;
	        if(!self.loop || !self.auto)return;
	        clearTimeout(self.timer);
	        self.timer = setTimeout(function(){
	            self.go_index(self.index+1);
	        },self.auto_wait_time);
	    },
	    go_index : function(ind){//滚动到指定索引页面
	        var self = this;
	        if(self.busy)return;
	        clearTimeout(self.timer);
	        self.busy = true;
	        if(self.loop){//如果循环
	            ind = ind<0?-1:ind;
	            ind = ind>self.size?self.size:ind;
	        }else{
	            ind = ind<0?0:ind;
	            ind = ind>=self.size?(self.size-1):ind;
	        }
	        if(!self.loop && (self.now_left == -(self.width*ind))){
	            self.complete(ind);
	        }else if(self.loop && (self.now_left == -self.width*(ind+1))){
	            self.complete(ind);
	        }else{
	            if(ind == -1 || ind == self.size){//循环滚动边界
	                self.index = ind==-1?(self.size-1):0;
	                self.now_left = ind==-1?0:-self.width*(self.size+1);
	            }else{
	                self.index = ind;
	                self.now_left = -(self.width*(self.index+(self.loop?1:0)));
	            }
	            self.box.css(this.get_style(1));
	            setTimeout(function(){
					if(self.complete)
						self.complete(ind);
	            },self.scroll_time);
	        }
	    },
	    complete : function(ind){//动画完成回调
	        var self = this;
	        self.busy = false;
			if(self.config){
				if(self.config.callback){
					self.config.callback(self.index);
				}
			}
	        if(ind==-1){
	            self.now_left = self.minleft;
	        }else if(ind==self.size){
	            self.now_left = self.maxleft;
	        }
	        self.box.css(this.get_style(2));
	        self.auto_scroll();
	    },
	    next : function(){//下一页滚动
	        if(!this.busy){
	            this.go_index(this.index+1);
	        }
	    },
	    prev : function(){//上一页滚动
	        if(!this.busy){
	            this.go_index(this.index-1);
	        }
	    },
	    move : function(point_x,point_y){
	        var changeX = point_x - (this.point_x===null?point_x:this.point_x),
	            changeY = point_y - (this.point_y===null?point_y:this.point_y),
	            marginleft = this.now_left, return_value = false,
	            sin =changeY/Math.sqrt(changeX*changeX+changeY*changeY);
	        this.now_left = marginleft+changeX;
	        this.move_left = changeX<0;
	        if(sin>Math.sin(Math.PI/3) || sin<-Math.sin(Math.PI/3)){
	            return_value = true;//不阻止默认行为
	        }
	        this.point_x = point_x;
	        this.point_y = point_y;
	        this.box.css(this.get_style(2));
	        return return_value;
	    },
	    move_end : function(){
	        var changeX = this.now_left%this.width,ind;
	        if(this.now_left<this.minleft){//手指向左滑动
	            ind = this.index +1;
	        }else if(this.now_left>this.maxleft){//手指向右滑动
	            ind = this.index-1;
	        }else if(changeX!=0){
	            if(this.move_left){//手指向左滑动
	                ind = this.index+1;
	            }else{//手指向右滑动
	                ind = this.index-1;
	            }
	        }else{
	            ind = this.index;
	        }
	        this.point_x = this.point_y = null;
	        this.go_index(ind);
	    },
	   
	    get_style : function(fig){
	        var x = this.now_left ,
	            time = fig==1?this.scroll_time:0;
	        return {
	            '-webkit-transition':'-webkit-transform '+time+'ms',
	            '-webkit-transform':'translate3d('+x+'px,0,0)',
	            '-webkit-backface-visibility': 'hidden',
	            'transition':'transform '+time+'ms',
	            'transform':'translate3d('+x+'px,0,0)'
	        };
	    }
	});




	var common = {
		init : function(){
			//隐藏需要默认隐藏的元素
			$(".wqdPublisHidden").hide().removeClass("wqdPublisHidden");
		}
	};

	common.init();
});	