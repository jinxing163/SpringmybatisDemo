
var $excelImport=$("#excelImport");//excel���밴ť
var $excelExport=$("#excelExport");//excel������ť
var $tableUserList=$("#tableUserInfo");//������ݶ��󣨲��������ı��⣩
var $tablePaginator=$("#tablePaginator");//����ҳ����

function UserPreviewer(){};

UserPreviewer.prototype = {
		
		//��ʼ���¼�
	    init:function () {
	    	
	    	userPreviewer.loadUserList();//�����û��б�
	    	
	    	//����
	    	$excelImport.click(function(){
	    		
	    		alert("����");
	    	});
	    	
	    	//����
	    	$excelExport.click(function(){
	    		
	    		userPreviewer.excelExport();
	    	});

	    },
	    
	    
	    //����
	    excelExport:function(){
	    	//�������Ϊ��Ч��Ҫʹ���������ӵķ�ʽ
	    	window.location.href="/springmvc_mybatis/excel/exportUserList";
	    },
	    
	    //�����û��б�
	    loadUserList:function(){
    		
	    	$.ajax({
	            type: "post",
	            url: "/springmvc_mybatis/user/getUserList",
	            contentType: "application/json; charset=utf-8",
	            dataType: "json",
	            success: function (data) {
	                if(data !=null){
	                	
	                	//���û���Ϣ��ӵ������
	                	
	                	userPreviewer.fillUserTableInfo(data);
	                	
	                	//���÷�ҳ
	                	var pageCount = data.pageCount; //ȡ��pageCount��ֵ
						var currentPage = data.CurrentPage; //�õ�currentPage
						 
						 var options = {
							bootstrapMajorVersion: 3, //�汾
							currentPage: currentPage, //��ǰҳ��
							totalPages: pageCount, //��ҳ��
							numberOfPages: 5,
							itemTexts: function (type, page, current) {
								switch (type) {
									case "first":
										return "��ҳ";
									case "prev":
										return "��һҳ";
									case "next":
										return "��һҳ";
									case "last":
										return "ĩҳ";
									case "page":
										return page;
								}
							},//����¼�������ͨ��Ajax��ˢ������list�б�
							onPageClicked: function (event, originalEvent, type, page) {
								$.ajax({
									url: "table.jsp",
									type: "Post",
									dataType : "json",
									data: "page=" + page,
									success: function (data) {
									     tbody1="<tr class='success'><th>�豸��ʶ��</td><th  align='center'>�豸���</td><th  align='center'>��������</td><th  align='center'>ʧЧģʽ����</td><th  align='center'>������Դ</td></tr>";
									     
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
	    
    	//�������Ϣ
    	//data: list�û��б�
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
        		
        		//��д��Ϊ�߼�д����Ŀǰ��֧��IE
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
