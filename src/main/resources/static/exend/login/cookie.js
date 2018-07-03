//设置cookie
function setCookie ( name, value, expdays )
{
    var expdate = new Date();
    //设置Cookie过期日期
    expdate.setDate(expdate.getDate() + expdays) ;
    //添加Cookie
    document.cookie = name + "=" + escape(value) + ";expires=" + expdate.toUTCString();
}


function getCookie ( name )
{
    //获取name在Cookie中起止位置
    var start = document.cookie.indexOf(name+"=") ;

    if ( start != -1 )
    {
        start = start + name.length + 1 ;
        //获取value的终止位置
        var end = document.cookie.indexOf(";", start) ;
        if ( end == -1 )
            end = document.cookie.length ;
        //截获cookie的value值,并返回
        return unescape(document.cookie.substring(start,end)) ;
    }
    return "" ;
}

//清除cookie  
function delCookie ( name )
{
    setCookie ( name, "", -1 ) ;
}