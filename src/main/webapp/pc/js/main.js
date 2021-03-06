
var currentEnvironmental = 'pc';

$(function () {
    if(document.documentElement.clientWidth<1150){
        if(window.location.href.indexOf("pc/projectType_")==-1
            &&window.location.href.indexOf("pc/project_")==-1
            &&window.location.href.indexOf("pc/member_")==-1

        ){

            $(".w-lang").css("margin-right",-20);
        }

    }

    if(document.documentElement.clientWidth<751 || (/android/i.test(navigator.userAgent) || /(iPhone|iPad|iPod|iOS)/i.test(navigator.userAgent))){
        // currentEnvironmental  = 'mobile'
    // }
    // if (!(/android/i.test(navigator.userAgent) || /(iPhone|iPad|iPod|iOS)/i.test(navigator.userAgent))) {
    //
    // }else{

        var language = "cn";
        var href = window.location.href;
        href = href.replace("/pc/","/webApp/");
        if(href.indexOf("_cn")>-1){
            // 中文
        }else{

            //英文
            if(href.indexOf("language=")>-1){
                href.replace("language=cn","language=en")
            }else if(href.indexOf(".html?")>-1){
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
        href = href.replace("/project_en.html","/project_classification.html")
        href = href.replace("/project_cn.html","/project_classification.html")
        href = href.replace("/projectType_en.html","/project.html")
        href = href.replace("/projectType_cn.html","/project.html")
        href = href.replace("/zp_en.html","/recruitment.html")
        href = href.replace("/zp_cn.html","/recruitment.html")
        href = href.replace("/office_en.html","/office.html")
        href = href.replace("/office_cn.html","/office.html")
        href = href.replace("/memberDetail_en.html","/team_detailed.html")
        href = href.replace("/memberDetail_cn.html","/team_detailed.html")

        href =href.replace("/project_search_cn.html?title=","/project.html?language=cn&search=")
        href =href.replace("/project_search_en.html?title=","/project.html?language=en&search=")
        href =href.replace("/dynamic_search_cn.html?title=","/news.html?language=cn&search=")
        href =href.replace("/dynamic_search_en.html?title=","/news.html?language=en&search=")

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


    $('#searchInput').bind('keyup', function(event) {
        if(document.getElementById("searchInput").value==''){
            return;
        }

        if (event.keyCode == "13") {
            var url = window.location.href;
            if(url.indexOf("home_")>-1||url.indexOf("project_search_")){

                if(window.location.href.indexOf("_cn")>-1){
                    window.location.href = "/pc/project_search_cn.html?title="+ encodeURIComponent(document.getElementById("searchInput").value)
                }else{
                    window.location.href = "/pc/project_search_en.html?title="+ encodeURIComponent(document.getElementById("searchInput").value)
                }


            }else{
                if(window.location.href.indexOf("_cn")>-1){
                    window.location.href = "/pc/dynamic_search_cn.html?title="+ encodeURIComponent(document.getElementById("searchInput").value)
                }else{
                    window.location.href = "/pc/dynamic_en.html?title="+ encodeURIComponent(document.getElementById("searchInput").value)
                }
            }

        }
    });

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
    // else if(){
    //
    //     }






    })


    $("#news_search").on("click",function () {
        if(document.getElementById("searchInput").value==''){
            return;
        }
        if(window.location.href.indexOf("_cn")>-1){
            window.location.href = "/pc/dynamic_search_cn.html?title="+ encodeURIComponent(document.getElementById("searchInput").value)
        }else{
            window.location.href = "/pc/dynamic_search_en.html?title="+ encodeURIComponent(document.getElementById("searchInput").value)
        }

    })

    $("#project_search").on("click",function () {
        if(document.getElementById("searchInput").value==''){
            return;
        }
        if(window.location.href.indexOf("_cn")>-1){
            window.location.href = "/pc/project_search_cn.html?title="+ encodeURIComponent(document.getElementById("searchInput").value)
        }else{
            window.location.href = "/pc/project_search_en.html?title="+ encodeURIComponent(document.getElementById("searchInput").value)
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
        else if(id=="office_cn"){
            location.href = "office_cn.html"
        }
        else if(id=="office_en"){
            location.href = "office_en.html"
        }
    });
    
    
    $("#topImg").on("click",function () {
            $("#w-head-nav").css("display","none");
            $(".searchDiv").css("display","block");

    });

    $(".w-isimgclose").on("click",function () {
        $("#w-head-nav").css("display","block");
        $(".searchDiv").css("display","none");
    });


    //
    $(".w-isimgsearch").on("click",function () {
        if(document.getElementById("searchInput").value==''){
            return;
        }
        if(window.location.href.indexOf("_cn")>-1){
            
            window.location.href = "/pc/project_search_cn.html?title="+ encodeURIComponent(document.getElementById("searchInput").value);
        }else{
            window.location.href = "/pc/project_search_en.html?title="+ encodeURIComponent(document.getElementById("searchInput").value);
        }


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
            strUrl = 'office' + strUrl;
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



window.onload = function () {
    window.onresize = function () {
        var width  = document.documentElement.clientWidth;
        if( width < 850 ){
            openMobile();
        }else if(width<1150){
            // console.log(width)
            if(window.location.href.indexOf("pc/projectType_")==-1
                &&window.location.href.indexOf("pc/project_")==-1
                &&window.location.href.indexOf("pc/member_")==-1){
                $(".w-lang").css("margin-right",-20);
            }

        }
    }
}


function openMobile() {
    var language = "cn";
    var href = window.location.href;
    href = href.replace("/pc/","/webApp/");
    if(href.indexOf("_cn")>-1){
        // 中文
    }else{

        //英文
        if(href.indexOf("language=")>-1){
            href.replace("language=cn","language=en")
        }else if(href.indexOf(".html?")>-1){
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
    href = href.replace("/project_en.html","/project_classification.html")
    href = href.replace("/project_cn.html","/project_classification.html")
    href = href.replace("/projectType_en.html","/project.html")
    href = href.replace("/projectType_cn.html","/project.html")
    href = href.replace("/zp_en.html","/recruitment.html")
    href = href.replace("/zp_cn.html","/recruitment.html")
    href = href.replace("/office_en.html","/office.html")
    href = href.replace("/office_cn.html","/office.html")
    href = href.replace("/memberDetail_en.html","/team_detailed.html")
    href = href.replace("/memberDetail_cn.html","/team_detailed.html")

    href =href.replace("/project_search_cn.html?title=","/project.html?language=cn&search=")
    href =href.replace("/project_search_en.html?title=","/project.html?language=en&search=")
    href =href.replace("/dynamic_search_cn.html?title=","/news.html?language=cn&search=")
    href =href.replace("/dynamic_search_en.html?title=","/news.html?language=en&search=")

    window.location.href = href;
}