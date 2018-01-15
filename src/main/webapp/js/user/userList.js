
var $excelImport=$("#excelImport");//excel导入按钮
var $excelExport=$("#excelExport");//excel导出按钮
var $tableUserList=$("#tableUserInfo");//表格内容对象（不包含表格的标题）
var $tablePaginator=$("#tablePaginator");//表格分页对象

function UserPreviewer(){};

UserPreviewer.prototype = {
		
		//初始化事件
	    init:function () {
	    	
	    	userPreviewer.loadUserList();//加载用户列表
	    	
	    	//导入
	    	$excelImport.click(function(){
	    		
	    		alert("导入");
	    	});
	    	
	    	//导出
	    	$excelExport.click(function(){
	    		
	    		userPreviewer.excelExport();
	    	});

	    },
	    
	    
	    //导出
	    excelExport:function(){
	    	//导出另存为的效果要使用以下链接的方式
	    	window.location.href="/springmvc_mybatis/excel/exportUserList";
	    },
	    
	    //加载用户列表
	    loadUserList:function(){
    		
	    	$.ajax({
	            type: "post",
	            url: "/springmvc_mybatis/user/getUserList",
	            contentType: "application/json; charset=utf-8",
	            dataType: "json",
	            success: function (data) {
	                if(data !=null){
	                	
	                	//将用户信息添加到表格中
	                	
	                	userPreviewer.fillUserTableInfo(data);
	                	
	                	//设置分页
	                	var pageCount = data.pageCount; //取到pageCount的值
						var currentPage = data.CurrentPage; //得到currentPage
						 
						 var options = {
							bootstrapMajorVersion: 3, //版本
							currentPage: currentPage, //当前页数
							totalPages: pageCount, //总页数
							numberOfPages: 5,
							itemTexts: function (type, page, current) {
								switch (type) {
									case "first":
										return "首页";
									case "prev":
										return "上一页";
									case "next":
										return "下一页";
									case "last":
										return "末页";
									case "page":
										return page;
								}
							},//点击事件，用于通过Ajax来刷新整个list列表
							onPageClicked: function (event, originalEvent, type, page) {
								$.ajax({
									url: "table.jsp",
									type: "Post",
									dataType : "json",
									data: "page=" + page,
									success: function (data) {
									     tbody1="<tr class='success'><th>设备标识号</td><th  align='center'>设备类别</td><th  align='center'>参数编码</td><th  align='center'>失效模式编码</td><th  align='center'>数据来源</td></tr>";
									     
										 $.each(data.list, function(i, n) {
											 var trs = "";
					                          trs += "<tr><td align='center'>" + n.sbbsh + "</td><td align='center'>"+n.sblb+"</td><td align='center'>"+n.csbm+"</td><td align='center'>"+n.sxcode+"</td><td align='center'>"+n.sjly+"</td></tr>";
					                      	  tbody1+=trs; 
					                     });
					                     $("#testTable").html(tbody1);
									}
								});
							}
						};
						$tablePaginator.bootstrapPaginator(options);
	                }
	            },
	            error: function (msg) {
	                alert(msg);
	            }
	        });
	    	
    	},
	    
    	//填充表格信息
    	//data: list用户列表
    	fillUserTableInfo:function(data){
    		
    		var tableStr="";
        	$.each(data,function(index,user){
        		var className="";
        		if(index %2==0)className="active";
        		
//        		tableStr+=
//        		"<tr class='"+className+"'>"+
//        		"<td>"+user.id+"</td>"+
//        		"<td>"+user.username +"</td>"+
//        		"<td>"+user.nickName+"</td>"+
//        		"<td>"+user.sex +"</td>"+
//        		"<td>"+user.phoneNumber +"</td>"+
//        		"<td>"+user.idCardsNumber+"</td>"+
//        		"<td>"+user.eMail +"</td>"+
//        		"<td>"+user.birthday +"</td>"+
//        		"<td>"+user.companyName +"</td>"+
//        		"</tr>";
        		
        		//此写法为高级写法，目前不支持IE
        		tableStr+=
        			`
        			<tr class="${className}">
        			<td>${user.id}</td>
        			<td>${user.username}</td>
        			<td>${user.nickName}</td>
        			<td>${user.sex}</td>
        			<td>${user.phoneNumber}</td>
        			<td>${user.idCardsNumber}</td>
        			<td>${user.eMail}</td>
        			<td>${user.birthday}</td>
        			<td>${user.companyName}</td>
        			</tr>
        			`;
        	});
        	
        	$tableUserList.html(tableStr);
    	},
    	
	    
	    
}


var userPreviewer=new UserPreviewer();
$(function(){
	
	userPreviewer.init();
	
});
