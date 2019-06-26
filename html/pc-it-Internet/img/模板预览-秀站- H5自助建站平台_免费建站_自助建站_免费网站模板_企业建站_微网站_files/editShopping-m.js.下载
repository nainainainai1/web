/**
 * Created by user on 2016/10/19.
 */
$(function () {
    //if($(".mobile-buyCar.goods-pay").length){
    //    var catc = getQueryString(location.href,"catch"),
    //        random = catc ? location.pathname+location.hash+"?catch="+catc+"&ran="+new Date().getTime() :
    //        location.pathname+location.hash+"?ran="+new Date().getTime();
    //    history.replaceState({page: 3}, '',random);
    //}
    var itemsLength = sessionStorage.getItem("itemsLength");
    var $personalMore = $(".goods-pay .personal-more");
    var $personalBasket = $(".personal-basket");

    if (itemsLength !== (undefined||null) && itemsCount != itemsLength) {

        if (itemsLength == 0) { //减少到 0 的时候增加类名 none
            $personalMore.find("i").addClass("none");
            $personalBasket.find("i").addClass("none");
        }

        $personalMore.find("i").text(itemsLength);
        $personalBasket.find("i").text(itemsLength);


        if (itemsCount == 0) { //起始值为 0 的时候需要删除类名
            $personalMore.find("i").removeClass("none");
            $personalBasket.find("i").removeClass("none");
        }
    }


    //手机弹出蒙层购物车
    $(document).on("click",".mobile-buyCar.goods-pay .personal-more", function (e) {
        e.stopPropagation();
        $(".mobile-popup").addClass("on");
    });
    //手机关闭蒙层购物车
    $(document).on("click",".mobile-popup .user-closebtn", function (e) {
        e.stopPropagation();
        $(".mobile-popup").removeClass("on");
    });

    //点击
    $(document).on("addShoppingCart", function (e,data) {
        if($("#mini").length||!$(".goods-pay").length) return;
        var obj=$.parseJSON(data.cartItem);
        data.count=obj.count;
        var srcPath=obj.picPath;
        var $shoppingCartBtn=$(".shoppingCartBtn");
        var left=$shoppingCartBtn.offset().left-$(window).scrollLeft()+ $(window).width()/4-15;
        var top=$shoppingCartBtn.offset().top-$(window).scrollTop()+5;
        var curTop=$personalMore.offset().top-$(window).scrollTop()+5;
        var curLeft=$personalMore.offset().left-$(window).scrollLeft()+5;
        $("<div class='mini' id='mini'> </div>")
            .css({
                "left":left,
                "top":top,
                "background-image": "url(" + srcPath + ")",
                "background-size": "100% 100%"
            }).appendTo($("body"));
        $.ajax({
            url: "/shoppingcart/updateCart",
            type: "post",
            data: data,
            dataType: "json",
            success: function (json) {
                if(json.status==200){
                    $("#mini").addClass("animate");
                    setTimeout(function () {
                        $("#mini").css({
                            "width":"20px",
                            "height":"20px",
                            "left":curLeft,
                            "top":curTop
                        });
                    },50);
                    setTimeout(function () {
                        $("#mini").remove();
                        $personalMore.find("i").removeClass("none").text(json.data);
                        $personalBasket.find("i").removeClass("none").text(json.data);

                        sessionStorage.setItem("itemsLength",JSON.stringify(json.data));

                    },550)

                }else {
                    $("#mini").remove();
                }
            },
            error:function(){
                $("#mini").remove();
            }
        })
    });
    //获取url地址参数
    function getQueryString (url, name) {
        url = String(url);
        url = url.substring(String(url).indexOf("?"));
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = url.substring(1).match(reg);
        if (r != null) return decodeURIComponent(r[2]); return null;
    }

});