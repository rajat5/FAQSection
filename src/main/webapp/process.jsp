<%@page import="com.userFAQ.userQuerySearch.QueryHandlerTest"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.userFAQ.userQuerySearch.UserQueryHandler"%>
<%@page import="com.userFAQ.userQuerydto.UserQuery"%>
<%@page import="javax.annotation.Resources"%>
<%@page import="com.userFAQ.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.plus-icon{
    background: #fff;
    border: 2px solid #555;
    border-radius: 2px;
    cursor: pointer;
    height: 18px;
    width: 18px;
    left: 10px;
    top: 4px;
    position : absolute;
    z-index: 1;
   }
.question{
	color: #333;
    background-color: #f5f5f5;
    border-color: #ddd;
	border-bottom: 1px dashed #ebebeb;
    padding: 0px 25px 10px 40px;
    position: relative;
	text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    line-height: 1.5em;
    -webkit-box-orient: vertical;
    overflow: hidden;
    font-size: 14px;
    padding-top : 10px;
    padding-bottom : 10px;
    /*background-color: #f6f6f6;
    box-shadow: 0 3px 3px rgba(255,255,255,.1), 0 3px 0 #bbb, 0 4px 0 #aaa, 0 5px 5px #444;
    background-image: linear-gradient(top, #f6f6f6, #eae8e8);*/
    
}
.questionvalue{
	white-space: pre-wrap;
	width: 89%;
    display: inline-block;
    list-style: none;
    text-align: center;
}

</style>

</head>
<body>
<script type="text/javascript">
function toggle(){
    var e = document.getElementById('questiondetails');
    if ( e.style.display == 'block' )
        e.style.display = 'none';
    else
        e.style.display = 'block';
}
</script>
	<% 
		String  mystr=null;
	 	String query = request.getParameter("str");
		QueryHandlerTest handlerTest = new QueryHandlerTest();
		ArrayList<String> questions = handlerTest.searchQueryKeywordsInDB(query);
		if(questions!=null){
			int totalDisplay = 5;
			for(int i=0;i<questions.size() && i<totalDisplay;i++){
				%>
				<%
				mystr=questions.get(i); 
				%>
				<div class="question"><div class="plus-icon" id="plusclick" >+</div>
							<div class="questionvalue"><%= mystr %></div>
							</div>
				
	
    
				<% 
			}
		}
		%> 
		
</body>
</html>