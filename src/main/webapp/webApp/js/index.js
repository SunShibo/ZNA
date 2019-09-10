(function (window, $) {
    var lang = false, langDom = $('#language'), navDom = $('#nav, #closeMenu'),
        m = false, s = false, closeDom = $('#closeMenu'), openDom = $('.menu, .search, .language');

    var menu = [
        {name: '关于我们', nameEN: 'ABOUT US ', children: []},
        {
            name: '经典项目', nameEN: 'PROJECTS', children: [
                {name: '酒店/度假村', nameEN: 'HOTEL/RESORT'},
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
                {name: '经典项目', nameEN: 'PROJECTS'},
                {name: '经典项目', nameEN: 'PROJECTS'}
            ]
        }
    ];

    //全局上声明一个切换中英文的方法
    window.switch_language = new Function();

    $(function () {
        $.checkPlatform();
        if (location.href.indexOf('?') === -1) {
            location.href = location.href + "?language=" + $.getLangStr();
        }
        //获取语言类型
        lang = $.getLang();
        //设置菜单
        settingMenu(lang);
        lang ? langDom.text('英') : langDom.text('中');
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
                    var subSrc = dom.find('.sub-nav').children('li').eq(j).children('a').attr('href');
                    if (lang) {
                        dom.find('.sub-nav').children('li').eq(j).children('a').text(menu[i].children[j].nameEN).attr('href', subSrc + '&language=' + $.getLangStr());
                    } else {
                        dom.find('.sub-nav').children('li').eq(j).children('a').text(menu[i].children[j].name).attr('href', subSrc + '&language=' + $.getLangStr());
                    }
                }
            }
        }
    }


    //设置语音
    langDom.on('click', function (e) {
        //更改当前页面的语言变量
        lang = !lang;
        //保存语言类型
        localStorage.setItem('EN_LANG', lang ? 'EN_US' : 'EN_CH');
        //更新菜单
        settingMenu($.getLang());
        lang ? langDom.text('英') : langDom.text('中');
        //触发并更新回调参数
        window.switch_language($.getLang());
    });

    //菜单显示
    $('#clickMenu').on('click', function () {
        menuState(m);
    });

    //菜单蒙层和关闭按钮
    navDom.on('click', function (e) {
        var ev = ev || window.event;
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
    $('#clickSearch').on('click', function (e) {
        searchState(s);
    });

    //搜索框显示
    function searchState(state) {
        var search = $('.head_search');
        $('.head_search input').val('');
        if (state) {
            search.fadeOut();
            topHeadState(state);
            s = false;
        } else {
            search.fadeIn();
            topHeadState(state);
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
    $('.nav-ul li').on('click', function (e) {
        var ev = ev || window.event, target = ev.target || ev.srcElement, that = $(this);
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

    //扩展jquery方法
    $.extend({
        footData: function (data) {
            for (var item in data) {
                $('#' + item).text(data[item]);
            }
        },
        getLang: function () {
            //页面初始时候的加载项
            lang = localStorage.getItem('EN_LANG') === 'EN_US';
            //如何localStorage中没有数据则获取地址栏中的语言类型
            if (lang === 'undefined' || lang === null || lang === '') {
                lang = $.getUrl('language') === 'en';
            }
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
        UpdateUrlParam: function (name, val) {
            var thisURL = document.location.href;

            // 如果 url中包含这个参数 则修改
            if (thisURL.indexOf(name + '=') > 0) {
                var v = getUrlParam(name);
                if (v != null) {
                    // 是否包含参数
                    thisURL = thisURL.replace(name + '=' + v, name + '=' + val);

                }
                else {
                    thisURL = thisURL.replace(name + '=', name + '=' + val);
                }

            } // 不包含这个参数 则添加
            else {
                if (thisURL.indexOf("?") > 0) {
                    thisURL = thisURL + "&" + name + "=" + val;
                }
                else {
                    thisURL = thisURL + "?" + name + "=" + val;
                }
            }
            location.href = thisURL;

        },
        getLangStr: function () {
            return $.getLang() ? 'en' : 'cn';
        },

        //判断是否手机端
        checkPlatform: function () {
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
    });
})(window, jQuery);