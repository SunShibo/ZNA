

$(function () {
    if (!(/android/i.test(navigator.userAgent) || /(iPhone|iPad|iPod|iOS)/i.test(navigator.userAgent))) {
    }else{

        var language = "cn";
        var href = window.location.href;
        href = href.replace("/pc/","/webApp/");
        if(href.indexOf("_cn")>-1){
            // 中文
        }else{

            //英文
            if(href.indexOf("language=")>-1){
                href.replace("language=cn","language=en")
            }else if(href.indexOf("?=")>-1){
                href +="&language=en"
            }else{
                href +="?language=en"
            }
        }
        href = href.replace("/aboutUs_en.html","/aboutUs.html")
        href = href.replace("/aboutUs_cn.html","/aboutUs.html")
        href = href.replace("/dynamic_en.html","/news.html")
        href = href.replace("/dynamic_cn.html","/news.html")
        href = href.replace("/home_en.html","/home.html")
        href = href.replace("/home_cn.html","/home.html")
        href = href.replace("/history_en.html","/history.html")
        href = href.replace("/history_cn.html","/history.html")
        href = href.replace("/member_en.html","/team.html")
        href = href.replace("/member_cn.html","/team.html")
        href = href.replace("/projectDetail_en.html","/project_detailed.html")
        href = href.replace("/projectDetail_cn.html","/project_detailed.html")
        href = href.replace("/project_en.html","/project.html")
        href = href.replace("/project_cn.html","/project.html")
        href = href.replace("/projectType_en.html","/project_classification.html")
        href = href.replace("/projectType_cn.html","/project_classification.html")
        href = href.replace("/zp_en.html","/recruitment.html")
        href = href.replace("/zp_cn.html","/recruitment.html")
        href = href.replace("/memberDetail_en.html","/team_detailed.html")
        href = href.replace("/memberDetail_cn.html","/team_detailed.html")
        window.location.href = href;
    }


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
            $(this).removeClass("show");
            $(".w-tableindexsearch").addClass("hide");
            $(".nav-span").removeClass("hide");
        }else{
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

    $("#weibo").on("click",function () {
        window.location.href = $(this).data("id")
    })
    $("#inlink").on("click",function () {
        window.location.href = $(this).data("id")
    })

    $(".code-wp").hover(function () {
        // debugger;
        $(".code-img").css("display","block")
    },function () {
        $(".code-img").css("display","none")
    })
});

function renderFloor(d) {
    $("#tel").html(d.mobile);
    $("#fax").html(d.faxNO);
    $("#mail").html(d.email);
    $("#weibo").data("id",d.pictureOneUrl);
    $("#inlink").data("id",d.pictureTwoUrl);
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


//webApp
//判断是否手机端
 function checkPlatform() {
    var strUrl = ($.getLang() ? '_en.html' : '_cn.html') + window.location.search;
    switch (window.location.pathname.substring(window.location.pathname.lastIndexOf('/') + 1, window.location.pathname.lastIndexOf('.'))) {
        case 'aboutUs':
            strUrl = 'aboutUs' + strUrl;
            break;
        case 'history':
            strUrl = 'history' + strUrl;
            break;
        case 'home':
            strUrl = 'home' + strUrl;
            break;
        case 'news':
            strUrl = 'dynamic' + strUrl;
            break;
        case 'office':
            strUrl = 'zp' + strUrl;
            break;
        case 'project':
            strUrl = 'project' + strUrl;
            break;
        case 'project_classification':
            strUrl = 'projectType' + strUrl;
            break;
        case 'project_detailed':
            strUrl = 'projectDetail' + strUrl;
            break;
        case 'recruitment':
            strUrl = 'zp' + strUrl;
            break;
        case 'team':
            strUrl = 'member' + strUrl;
            break;
        case 'team_detailed':
            strUrl = 'memberDetail' + strUrl;
            break;
    }
    //判断是否是PC端   依据判断只要不是android系统和IOS系统就算是PC系统
    if (!(/android/i.test(navigator.userAgent) || /(iPhone|iPad|iPod|iOS)/i.test(navigator.userAgent))) {
        location.href = '/pc/' + strUrl;
    }
}


$("#weixin").hover(function () {
    document.getElementById('div1').style.display = 'block';
},function () {
    document.getElementById('div1').style.display = 'none';
})



