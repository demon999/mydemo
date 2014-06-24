var i18n = function(){
	// 加载资源文件
	function load(name,callback) {
		jQuery.i18n.properties({ 
		    name:name,			// 资源文件名称
		    path:'res/i18n/',	// 资源文件所在目录路径
		    mode:'both',		// 模式：变量或 Map 
		    language:'en-US',	// 对应的语言
		    cache:false, 
		    encoding: 'UTF-8', 
		    callback: function() {
		    	// 回调方法
		    	if(callback) {
		    		callback.call();
		    	}
		    } 
		 }); 
	}
	
	return {
		load:function(name,callback){load(name,callback);}
	};
}();