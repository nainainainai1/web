window.onload = function (){
	//1.获取事件
	var pic = document.getElementById("pic");
	var screen = pic.firstElementChild || pic.firstChild;
	var imgWidth = screen.offsetWidth;
	var ul = screen.firstElementChild || screen.firstChild;
	var ol = screen.children[1];
	var div =screen.firstElementChild || screen.firstChild;
	var spanArr = div.children;
	//2.第一张li添加到ul的最后面
	var ulNewLi = ul.children[0].cloneNode(true);
	ul.appendChild(ulNewLi);
	//3.给ol中添加li，ul中的个数减1，并点亮第一个按钮
	for(var i=0; i < ul.children.length - 1; i++){
		var olNewLi = document.creatElement("li");
		olNewLi.innerHTML = i+1;
		ol.appendChild(olNewLi)
	}
	var olLiArr = ol.children;
	olLiArr[0].className = "current";

	//4.鼠标放到ol的li上切图
	for (var i = 0;i< olLiArr.length; i++) {
		//自定义属性，把索引值绑定到元素的index的属性上
		olLiArr[i].index =i;
		olLiArr[i].onmouseover = function(){
			//排他思想
			for (var j = 0; j< olLiArr.length; i++) {
				olLiArr[j].className = "";
			}
			this.className = "current";
			//鼠标放到小的方块上的时候索引值和key以及square同步
			key = this.index;
			square = this.index;
			key = square = this.index;
			//移动盒子
			animate(ul,-this.index * imgWidth);
		}
		//5.添加定时器
		var timer = setInterval(autoPlay,1000);
		//固定向右切换图片
		//两个定时器
		var key =0;
		var square =0;
		function autoPlay(){
			//通过控制key的自增来模拟图片的索引值，然后移动li
			key++;
			if(key > olLiArr.length){
				//图片已滑动到最后一张，接下来，跳转到第一张，然后在滑动第二张
				ul.style.left = 0;
				key = 1;
			}
			animate(ul,-key * imgWidth);
			square++;
			if (square > olLiArr.length; i++) {
				square =0;
			}
			for(var i = 0; i < olLiArr.length; i++){
				olLiArr[i].className = "";
			}
			olLiArr[square].className = "current";
		}
		//把鼠标放上去清楚定时器，然后在开启定时器
		pic.onmouseover = function(){
			div.style.display = "block";
			clearInterval(timer);
		}
		//6.左右切换图片
		spanArr[0].onclick = function(){
			key--;
			if (key < 0) {
				ul.style.left = -imgWidth *(olLiArr.length) + "px";
				key = ol.length -1;
			}
			animate(ul,-key * imgWidth);
			square--;
			if (square < 0) {
				square = olLiArr.length -1;
			}
			for (var i = 0; i < olLiArr.length; i++) {
				olLiArr[i].className = "";
			}
			olLiArr[square].className = "current";
		}
		spanArr[1].onclick =function(){
			autoPlay();
		}
		function animate(ele,target){
			clearInterval(ele.timer);
			var speed = target > ele.offsetLeft ? 10 : -10;
			ele.style.left =ele.offsetLeft + speed + "px";
			if(Math.abs(val) < Math.abs(speed)){
				ele.style.left = target + "px";
				clearInterval(ele.timer);
			}

		},10
	}
}