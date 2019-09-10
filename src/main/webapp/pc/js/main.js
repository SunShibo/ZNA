

$(function () {


    $(".w-langc").on('click',function () {
        var i = window.location.href.indexOf('?');
        var l = window.location.href.indexOf('language=en');
        if(getUrl("language")!='cn'){

                if(i==-1){

                    var h = window.location.href.replace("_en.html","_cn.html")+"?language=cn";
                    window.location.href = h;
                }else{
                    var hr = window.location.href;

                    if(l>-1){

                        window.location.href = hr.replace("language=en","language=cn").replace("_en","_cn")
                    }else{
                        window.location.href = hr.replace("_en","_cn")+"&language=cn"
                    }
                }
            }
    })

    $(".w-c").on('click',function () {
        var i = window.location.href.indexOf('?');
        var l = window.location.href.indexOf('language=cn');
        if(getUrl("language")!='en'){
            var hr = window.location.href;
            if(i==-1){

                window.location.href = hr.replace("language=cn","language=en").replace("_cn","_en")
            }else{

                if(l>-1){

                    window.location.href = hr.replace("language=cn","language=en").replace("_cn","_en")
                }else{
                    window.location.href = hr.replace("_cn","_en")+"&language=en"
                }
            }
        }
    })

    
    
    
    $(".nav-span").on("click",function () {
        var id = $(this).data("id");
        if(id=="aboutus_en"){
            location.href = "aboutUs_en.html"
        }
        if(id=="aboutus_cn"){
            location.href = "aboutUs_cn.html"
        }
        else if(id=="home_en"){
            location.href = "home_en.html"
        }
        else if(id=="home_cn"){
            location.href = "home_cn.html"
        }

        else if(id=="project_cn"){
            location.href = "project_cn.html"
        }

        else if(id=="project_en"){
            location.href = "project_en.html"
        }

        else if(id=="team_cn"){
            location.href = "member_cn.html"
        }

        else if(id=="team_en"){
            location.href = "member_en.html"
        }

        else if(id=="dynamic_cn"){
            location.href = "dynamic_cn.html"
        }
        else if(id=="dynamic_en"){
            location.href = "dynamic_en.html"
        }
        else if(id=="zp_cn"){
            location.href = "zp_cn.html"
        }
        else if(id=="zp_en"){
            location.href = "zp_en.html"
        }
    });
    
    
    $(".w-tabtleimg").on("click",function () {
        if($(this).hasClass("show")){
            console.log("hasClass")
            $(this).removeClass("show");
            $(".w-tableindexsearch").addClass("hide");
            $(".nav-span").removeClass("hide");
        }else{
            console.log("no-hasClass")
            $(this).addClass("show");
            $(".w-tableindexsearch").removeClass("hide");
            $(".nav-span").addClass("hide");
        }
    });


    $(".w-tableindexsearch").mouseout(function (e) {
        if(e.clientY>50){
            $(".nav-span").removeClass("hide");
            $(".w-tableindexsearch").addClass("hide");
            $(".w-tabtleimg").removeClass("show")
        }
    });

    $(".w-isimgsearch").on("click",function () {
        console.log("您点击了搜索按钮")
    });

    $(".w-isimgclose").on("click",function () {
        console.log("您点击了清除按钮")
        $("#searchInput").val("");
    });
});

function renderFloor(d) {
    $("#tel").html(d.mobile);
    $("#fax").html(d.faxNO);
    $("#mail").html(d.email);
}

function getUrl(variable)
{
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable){return pair[1];}
    }
    return("");
}

    // $(function(){
    //     function footerPosition(){
    //         // debugger;
    //         $(".w-bottom").removeClass("fixed-bottom");
    //         var contentHeight = document.body.scrollHeight,//网页正文全文高度
    //             winHeight = window.innerHeight;//可视窗口高度，不包括浏览器顶部工具栏
    //         if(!(contentHeight > winHeight)){
    //             //当网页正文高度小于可视窗口高度时，为footer添加类fixed-bottom
    //             $(".w-bottom").addClass("fixed-bottom");
    //         } else {
    //             $(".w-bottom").removeClass("fixed-bottom");
    //         }
    //     }
    //     footerPosition();
    //     $(window).resize(footerPosition);
    // });