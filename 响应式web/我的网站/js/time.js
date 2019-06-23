/ 时间
    var add=setInterval("getTime()",1000);
    //stop()这个函数主要是清除设置的定时器
    function stop() {
        clearInterval(add);
    }
    //这个函数主要是获取时间然后写入div中
    function getTime() {
        var date=new Date().toLocaleString();//创建date对象，获取时间
        var id1=document.getElementById("time");//通过div标签的id多去div标签
        id1.innerHTML=date;//将时间通过innerHTML属性写入div标签中
    }

 