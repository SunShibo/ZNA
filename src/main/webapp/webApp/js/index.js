(function (window, $) {

    var lang = false, langDom = $('#language'), navDom = $('#nav, #closeMenu'),
        m = false, s = false, closeDom = $('#closeMenu'), openDom = $('.menu, .search, .language');

    var menu = [
        {name: '关于我们', nameEN: 'ABOUT US ', children: []},
        {
            name: '经典项目', nameEN: 'PROJECTS', children: [
                {name: '酒店/度假', nameEN: 'HOTEL/RESORT'},
                {name: '办公/综合体', nameEN: 'OFFICE/MIXED-USE'},
                {name: '文化/会展', nameEN: 'CIVIC/EXHIBITION'},
                {name: '居住/养老', nameEN: 'RESIDENTIAL/HEALTHCARE'},
                {name: '教育/科研', nameEN: 'EDUCATION/SCIENCE'},
                {name: '城市规划', nameEN: 'MASTER PLANNING'},
                {name: '景观设计', nameEN: 'LANDSCAPE DESIGN'},
                {name: '室内设计', nameEN: 'INTERIOR DESIGN'}
            ]
        },
        {name: '核心团队', nameEN: 'TEAM', children: []},
        {name: '最新动态', nameEN: 'NEWS', children: []},
        {
            name: '联系我们', nameEN: 'CONTACT US', children: [
                {name: '办公室', nameEN: 'OFFICE'},
                {name: '人才招聘', nameEN: 'CAREER'}
            ]
        }
    ];

    var search_menu = [
        {
            name: '经典项目', nameEN: 'PROJECTS'
        },
        {
            name: '最新动态', nameEN: 'NEWS'
        }
    ];

    //扩展jquery方法
    $.extend({
        baseUrl: function () {
            return 'http://39.96.173.228:8080';
        },
        //设置尾部数据
        footData: function (data) {
            for (var item in data) {
                $('#' + item).text(data[item]);
            }
        },
        //向外抛出lang属性
        getLang: function () {
            return lang;
        },
        getUrl: function (name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if (name) {
                if (r != null)
                    return decodeURI(r[2]);
                return null;
            } else {
                r = window.location.search.substr(1);
                if (r != null)
                    return decodeURI(r);
                return null;
            }
        },
        // 添加 或者 修改 url中参数的值
        changeURLArg: function (url, arg, arg_val) {
            var pattern = arg + '=([^&]*)';
            var replaceText = arg + '=' + arg_val;
            if (url.match(pattern)) {
                var tmp = '/(' + arg + '=)([^&]*)/gi';
                tmp = url.replace(eval(tmp), replaceText);
                return tmp;
            } else {
                if (url.match('[\?]')) {
                    return url + '&' + replaceText;
                } else {
                    return url + '?' + replaceText;
                }
            }
            return url + '\n' + arg + '\n' + arg_val;
        },
        getLangStr: function () {
            return lang ? 'en' : 'cn';
        },

        //判断是否手机端
        checkPlatform: function () {
            var strUrl = ($.getLang() ? '_en.html' : '_cn.html') + window.location.search;
            var htmlUrl = window.location.pathname.substring(window.location.pathname.lastIndexOf('/') + 1, window.location.pathname.lastIndexOf('.'));
            if (window.location.search.indexOf('search') > -1 && (htmlUrl === 'news' || htmlUrl === 'project')) {
                // /pc/dynamic_search_cn.html?title=%E9%A1%B9%E7%9B%AE
                if (htmlUrl === 'project') {
                    strUrl = (lang ? 'project_search_en.html' : 'project_search_cn.html') + "?title=" + $.getUrl('search');
                } else if (htmlUrl === 'news') {
                    strUrl = (lang ? 'dynamic_search_en.html' : 'dynamic_search_cn.html') + "?title=" + $.getUrl('search');
                }
            } else {
                switch (htmlUrl) {
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
                        strUrl = 'projectType' + strUrl;
                        break;
                    case 'project_classification':
                        strUrl = 'project' + strUrl;
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
            }
            location.href = '/pc/' + strUrl;
            //判断是否是PC端   依据判断只要不是android系统和IOS系统就算是PC系统
            // if (!(/android/i.test(navigator.userAgent) || /(iPhone|iPad|iPod|iOS)/i.test(navigator.userAgent))) {
            //     location.href = '/pc/' + strUrl;
            // }
        }
    });

    //全局上声明一个切换中英文的方法
    window.switch_language = new Function();

    $(function () {

        //跳转
        var clientWidth = document.body.clientWidth;
        if (clientWidth > 850) {
            $.checkPlatform();
        }

        //获取语言类型
        lang = $.getUrl('language') === 'en';
        if (lang) {
            langDom.text('中');
            $('.logo').removeClass('ch_logo_w').addClass('en_logo_w');
        } else {
            langDom.text('EN');
            $('.logo').removeClass('en_logo_w').addClass('ch_logo_w');
        }

        //LOGO
        setLogo(lang);

        if (location.pathname.indexOf('language') > -1 && location.pathname.indexOf('?') < 0) {
            location.href = location.href + "?language=" + $.getLangStr();
        }
        //设置菜单
        settingMenu(lang);
        //执行回调
        window.switch_language(lang);
    });

    //按语言设置菜单
    function settingMenu(lang) {

        //设置logo路径
        var logoDom = $('.logo>a');
        logoDom.attr('href', 'home.html' + '?language=' + $.getLangStr());

        //遍历菜单
        for (var i = 0, len = menu.length; i < len; i++) {
            var dom = $('.nav-ul').children('li').eq(i);
            var aSrc = dom.children('a').attr('href');
            //设置一级菜单
            if (lang) {
                dom.children('a').text(menu[i].nameEN).attr('href', aSrc + '?language=' + $.getLangStr());
            } else {
                dom.children('a').text(menu[i].name).attr('href', aSrc + '?language=' + $.getLangStr());
            }
            //设置二级菜单
            if (menu[i].children.length) {
                for (var j = 0, jLen = menu[i].children.length; j < jLen; j++) {
                    var subDom = dom.find('.sub-nav').children('li').eq(j).children('a');
                    var subSrc = subDom.attr('href');
                    subSrc = subSrc.indexOf('?') === -1 ? subSrc + '?' : subSrc + '&';
                    if (lang) {
                        subDom.text(menu[i].children[j].nameEN).attr('href', subSrc + 'language=' + $.getLangStr());
                    } else {
                        subDom.text(menu[i].children[j].name).attr('href', subSrc + 'language=' + $.getLangStr());
                    }
                }
            }
        }
    }


    //设置语音
    langDom.on('tap click', function (e) {
        var ev = e || window.event;
        var target = ev.target || ev.srcElement;
        ev.preventDefault();
        //更改当前页面的语言变量
        lang = !lang;
        //设置logo
        setLogo(lang);


        //保存语言类型
        localStorage.setItem('EN_LANG', lang ? 'EN_US' : 'EN_CH');
        //更新菜单
        settingMenu(lang);
        if (lang) {
            langDom.text('中');
            $('.logo').removeClass('ch_logo_w').addClass('en_logo_w');
        } else {
            langDom.text('EN');
            $('.logo').removeClass('en_logo_w').addClass('ch_logo_w');
        }
        //触发并更新回调参数
        window.switch_language(lang);
    });

    //根据语言设置logo
    function setLogo(lang) {
        //LOGO
        var imageUrl = lang ? 'image/logo.jpg' : 'image/logo_cn.jpg';
        $('#logoImage').attr('src', imageUrl);
    }

    //菜单显示
    $('#clickMenu').on('tap click', function () {
        menuState(m);
    });

    //菜单蒙层和关闭按钮
    navDom.on('tap click', function (e) {
        var ev = e || window.event;
        var target = ev.target || ev.srcElement;

        //防止点击菜单也关闭，只有点击最外层的div#nav的时候才关闭
        if (m && (target.id === 'nav' || target.id === 'closeMenu' || target.nodeName.toLowerCase() === 'img')) {
            menuState(true);
            m = false;
        } else if (s && (target.id === 'closeMenu' || target.nodeName.toLowerCase() === 'img')) {
            searchState(true);
            s = false;
        }
    });

    //搜索
    $('#clickSearch').on('tap click', function (e) {
        searchState(s);
    });

    //搜索框显示
    function searchState(state) {
        var search = $('.head_search, .search_list');
        $('#keyword').val('');
        if (state) {
            search.fadeOut();
            topHeadState(state);
            s = false;
        } else {
            search.fadeIn();
            topHeadState(state);
            for (var i = 0, len = search_menu.length; i < len; i++) {
                $('.search_list .list div').eq(i).children('a').text($.getLang() ? search_menu[i].nameEN : search_menu[i].name);
            }
            s = true;
        }
    }

    // 控制菜单是否显示
    function menuState(state) {
        if (state) {
            navDom.fadeOut();
            topHeadState(state);
            //将二级菜单隐藏
            $('.sub').hide();
            $(document.body).css({"overflow-y": "auto"});
            m = false;
        } else {
            navDom.fadeIn();
            topHeadState(state);
            $(document.body).css({"overflow-y": "hidden"});
            m = true;
        }
    }

    //控制头部按钮显示
    function topHeadState(state) {
        if (state) {
            closeDom.hide();
            openDom.show();
        } else {
            closeDom.show();
            openDom.hide();
        }
    }

    //控制子菜单是否显示
    function subMenuState(state, that) {
        $('.sub').hide();
        if (state) {
            that.children(".sub").hide();
        } else {
            that.children(".sub").show();
        }
    }

    //一级菜单的事件委托
    $('.nav-ul li').on('tap click', function (e) {
        var ev = e || window.event, target = ev.target || ev.srcElement, that = $(this);
        switch (target.id) {
            case 'about':
                subMenuState(true, that);
                break;
            case 'project':
                subMenuState(false, that);
                break;
            case 'team':
                subMenuState(true, that);
                break;
            case 'dynamic':
                subMenuState(true, that);
                break;
            case 'information':
                subMenuState(false, that);
                break;
        }
    });

    //搜索页面导航
    $('.list').on('tap click', function (e) {
        var ev = e || window.event, target = ev.target || ev.srcElement;
        var search = $('#keyword').val();
        switch (target.id) {
            case 'toProject':
                location.href = 'project.html?language=' + $.getLangStr() + "&search=" + encodeURIComponent(search);
                break;
            case 'toNews':
                location.href = 'news.html?language=' + $.getLangStr() + "&search=" + encodeURIComponent(search);
                break;
        }
    });

    //底部跳转链接
    $('.icon-list').on('tap click', function (e) {
        var ev = e || window.event, target = ev.target || ev.srcElement;
        switch (target.id) {
            case 'toMicroblog':
                location.href = 'https://weibo.com/znabeijing?topnav=1&wvr=6&topsug=1&is_all=1';
                break;
            case 'toIn':
                location.href = 'https://www.linkedin.com/feed/?trk=v5nav_cap_to_consumer_home';
                break;
            case 'toWechat':
                $(document.body).css({"overflow-y": "hidden"});
                $('#icon_wechat').show();
                break;
        }
    });

    //底部跳转icon
    $('#icon_wechat').on('tap click', function (e) {
        var ev = e || window.event, target = ev.target || ev.srcElement;
        if (target.id === 'icon_wechat') {
            $('#icon_wechat').hide();
            $(document.body).css({"overflow-y": "auto"});
        }
    });

    // 页面适配
    $(window).resize(function (ev) {
        $('.home-item-image>div').removeClass('home-item-image-wrapper').addClass('home-item-image-wrapper');
        var clientWidth = document.body.clientWidth;
        if (clientWidth > 850 && !(/android/i.test(navigator.userAgent) || /(iPhone|iPad|iPod|iOS)/i.test(navigator.userAgent))) {
            $.checkPlatform();
        }
    });


})(window, jQuery);