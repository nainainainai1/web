window.onload = function () {

 

var div = document.get('carousel-map');//通过id查找div
var img = div.getElementsByTagName('img');//通过div查找div下的所有img标签（获取所有的图片）

//通过getElementsByTagName 获取的标签是一个数组


var count = 0;//定义一个变量用来记录图片数组下标

var timer = null;//定义一个变量标识时器

timer=setInterval(change ,2000);//启动一个定时器2000毫秒调用一次change函数（切换一张图片）

function change() {//切换图片的函数


for (var i = 0; i < img.length; i++) {//遍历所有图片

img[i].style.display = 'none';//先让所有图片隐藏
}

img[count].style.display = 'block';//让当前下标的图片显示

count++;//每次加1
if (count == img.length) {

//当count==图片张数时让count=0；
count = 0;//使图片数组下标又回到0就形成了一个循环那么就可以让图片循环切换了
}
}
div.onmouseover = function () {

clearInterval(timer);//当鼠标移入Div时清除定时器，作用是当我们鼠标移入图片时
//图片就不再自动切换
}
div.onmouseout = function () {
timer = setInterval(change, 2000);//当鼠标移入Div时开启定时器，作用是当我们鼠标移
//出div时又让图片自动切换

}
}