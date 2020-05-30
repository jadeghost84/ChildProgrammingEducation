$(document).ready(function () {
    // 导航hover
    var $nav_item = $(".header-nav").find(".nav-item_hover");
    var $subNav = $(".header-nav").find(".subNav");
    var $subNav_item = $subNav.find(".subNav-item");
    var cur_index = 0;
    var timer = null;


    $nav_item.hover(function () {
        cur_index = $(this).index() - 2;

        $subNav_item.hide();

        operate(cur_index);

        // 二级导航偏移值
        var nowNav_left = $nav_item.eq(cur_index).offset().left;
        var newLeft = nowNav_left - $subNav_item.eq(cur_index).width() / 2 + (parseInt($nav_item.css("margin-right")) / 2);

        if (cur_index !== 0) {
            $subNav_item.eq(cur_index).css({left: newLeft});
        }
    }, setTime);

    $subNav.hover(function () {
        operate(cur_index);
    }, setTime);

    function setTime() {
        timer = setTimeout(function () {
            $subNav.hide();
        }, 800);
    };

    function operate(cur_index) {
        clearTimeout(timer);

        $subNav.show();
        $subNav_item.eq(cur_index).show();
    };
})