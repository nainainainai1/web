//画布开始
var startX,startY;
        var flag = false;
            window.onload = function(){
                var c = document.getElementById("myCanvas");
                var ctx = c.getContext("2d");
                ctx.lineWidth = 10;
                ctx.strokeStyle = "rgba(255,0,0,0.5)";

                ctx.stroke();
                //---- 添加鼠标响应事件----
                c.addEventListener("mousedown",function(){
                    var evt = evt || window.event;
                    if(!flag){
                        startX = evt.clientX-10;
                        startY = evt.clientY-10;
                        ctx.moveTo(startX,startY);
                        flag = true;
                    }
                })
                c.addEventListener("mousemove",function(){
                    if(flag){
                        var evt = evt || window.event;//mouse position
                        var curX = evt.clientX-10;
                        var curY = evt.clientY-10;
                        ctx.lineTo(curX,curY);
                        ctx.stroke();
                    }
                })
                c.addEventListener("mouseup",function(){
                    flag = false;
                })
            }