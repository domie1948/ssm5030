
var projectName = '书店仓库管理系统';
/**
 * 轮播图配置
 */
var swiper = {
	// 设定轮播容器宽度，支持像素和百分比
	width: '100%',
	height: '400px',
	// hover（悬停显示）
	// always（始终显示）
	// none（始终不显示）
	arrow: 'none',
	// default（左右切换）
	// updown（上下切换）
	// fade（渐隐渐显切换）
	anim: 'default',
	// 自动切换的时间间隔
	// 默认3000
	interval: 2000,
	// 指示器位置
	// inside（容器内部）
	// outside（容器外部）
	// none（不显示）
	indicator: 'outside'
}

/**
 * 个人中心菜单
 */
var centerMenu = [{
	name: '个人中心',
	url: '../' + localStorage.getItem('userTable') + '/center.jsp'
}, 
]


var indexNav = [

{
	name: '图书信息',
	url: './pages/tushuxinxi/list.jsp'
}, 
{
	name: '供应商',
	url: './pages/gongyingshang/list.jsp'
}, 

{
	name: '新闻资讯',
	url: './pages/news/list.jsp'
},
]

var adminurl =  "http://localhost:8080/jspm1mh8m/index.jsp";

var cartFlag = false

var chatFlag = false




var menu = [{"backMenu":[{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"员工","menuJump":"列表","tableName":"yuangong"}],"menu":"员工管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"图书分类","menuJump":"列表","tableName":"tushufenlei"}],"menu":"图书分类管理"},{"child":[{"buttons":["新增","查看","修改","删除","打印","导出"],"menu":"图书信息","menuJump":"列表","tableName":"tushuxinxi"}],"menu":"图书信息管理"},{"child":[{"buttons":["新增","查看","修改","删除","打印","导出"],"menu":"供应商","menuJump":"列表","tableName":"gongyingshang"}],"menu":"供应商管理"},{"child":[{"buttons":["查看","修改","删除","打印","导出"],"menu":"进货信息","menuJump":"列表","tableName":"jinhuoxinxi"}],"menu":"进货信息管理"},{"child":[{"buttons":["查看","修改","删除","打印","导出"],"menu":"出货信息","menuJump":"列表","tableName":"chuhuoxinxi"}],"menu":"出货信息管理"},{"child":[{"buttons":["查看","修改","删除","审核","打印","导出"],"menu":"损坏上报","menuJump":"列表","tableName":"sunhuaishangbao"}],"menu":"损坏上报管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"系统公告","tableName":"news"},{"buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"lunbotuguanli"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"buttons":["查看","打印","导出","进货","出货"],"menu":"图书信息列表","menuJump":"列表","tableName":"tushuxinxi"}],"menu":"图书信息模块"},{"child":[{"buttons":["查看"],"menu":"供应商列表","menuJump":"列表","tableName":"gongyingshang"}],"menu":"供应商模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"buttons":["查看","修改","删除","打印","导出"],"menu":"进货信息","menuJump":"列表","tableName":"jinhuoxinxi"}],"menu":"进货信息管理"},{"child":[{"buttons":["查看","修改","删除","打印","导出"],"menu":"出货信息","menuJump":"列表","tableName":"chuhuoxinxi"}],"menu":"出货信息管理"},{"child":[{"buttons":["新增","查看","修改","删除","打印","导出"],"menu":"损坏上报","menuJump":"列表","tableName":"sunhuaishangbao"}],"menu":"损坏上报管理"}],"frontMenu":[{"child":[{"buttons":["查看","打印","导出","进货","出货"],"menu":"图书信息列表","menuJump":"列表","tableName":"tushuxinxi"}],"menu":"图书信息模块"},{"child":[{"buttons":["查看"],"menu":"供应商列表","menuJump":"列表","tableName":"gongyingshang"}],"menu":"供应商模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"否","roleName":"员工","tableName":"yuangong"}]


var isAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].backMenu.length;j++){
                for(let k=0;k<menus[i].backMenu[j].child.length;k++){
                    if(tableName==menus[i].backMenu[j].child[k].tableName){
                        let buttons = menus[i].backMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}

var isFrontAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].frontMenu.length;j++){
                for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
                    if(tableName==menus[i].frontMenu[j].child[k].tableName){
                        let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}
