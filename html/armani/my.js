
/*
	轮播图
*/
	//这是所有图片的地址 定义为数组
	var imgArray = new Array("img/O1CN01bXSJ2T1UGSgmCuzSy_!!3527212490.jpg",
							"img/O1CN01MRdOD11UGSgsK4bzu_!!3527212490.jpg",
							"img/O1CN01u2wI6u1UGSgnDSVL6_!!3527212490.jpg",
							"img/O1CN01ZxxdXe1UGSglUPyYW_!!3527212490.jpg",
							"img/O1CN011UGSfbGvOafb19E_!!3527212490.jpg",
							"img/O1CN013zJIs41UGShFFENVm_!!3527212490.jpg"
							);

window.onload = function(){
	let index = 0;
	setInterval(function(){
		//图片下标
		index = (index >= 5) ? 0 : index += 1;
		console.log("index:"+index)
		// 1. 获取轮播块的象
		let element = document.getElementById("swiper");
		//移除父节点下的子节点
		element.removeChild(element.children[0]);
		//创建img 节点并添加图片
		let img=document.createElement("img");
		img.src=imgArray[index];
		console.log(img);
		element.appendChild(img);
	},3000);
}
