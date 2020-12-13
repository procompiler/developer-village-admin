<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.devil.domain.Report"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<link rel="stylesheet"
  href="../node_modules/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../style.css">
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<a href='../user/list' style='text-decoration: none;'>전체회원관리</a>
	<a href='../report/list' style='text-decoration: none;'>신고내역</a>
	<a href='../block/list' style='text-decoration: none;'>활동정지회원</a>
	<h1>
		<a href='list' style='text-decoration: none;'>신고내역</a>
	</h1>
	<br>

	<%
	  List<Report> list = (List<Report>) request.getAttribute("reportList");
	%>

	<table border='1'>
		<tr>
			<th>신고자</th>
			<th>피신고자</th>
			<th>신고링크</th>
			<th>신고사유</th>
			<th>신고승인</th>
		</tr>

		<%
		  for (Report report : list) {
		%>
		<%
		  boolean blockAdmit = false;
		%>
		<%
		  String reportType = null;
		%>
		<%
		  switch (report.getReportTypeNo()) {
		  case 1:
		    reportType = "욕설";
		    break;
		  case 2:
		    reportType = "권리침해";
		    break;
		  case 3:
		    reportType = "폭력적 또는 혐오성 게시글";
		    break;
		  case 4:
		    reportType = "불법광고";
		    break;
		  case 5:
		    reportType = "음란성";
		    break;
		  case 6:
		    reportType = "도배";
		    break;
		}
		%>

		<tr>
			<td><%=report.getReporter().getNickname()%> [<%=report.getReporter().getEmail()%>]</td>
			<td><%=report.getReportedArticle().getWriter().getNickname()%> [<%=report.getReportedArticle().getWriter().getEmail()%>]
			<%
			if(report.getReportedArticle() == null) {%>
			<%=report.getReportedComment().getWriter().getNickname()%> [<%=report.getReportedComment().getWriter().getEmail()%>]
			<% }	%>
			
			</td>
			
			<td><a
				href='../article/detail?no=<%=report.getReportedArticle().getNo()%>'
				style='text-decoration: none;'>신고 링크</a></td>
			<td><%=reportType%></td>

			<td>
				<form action="../block/form" method="get">
					<input type='hidden' name='reportNo' value='<%=report.getNo()%>'>
					
				<%
      switch (report.getStatus()) {
      case 1:%>
      <button>신고승인</button> 
        <%
        break;
      case 2: %>
         차단중 
       <%
        break;
      case 3: %>
         차단해제 
        <%
        break;
    }
    %>
				</form>
			</td>
		</tr>
		<%
		  }
		%>
	</table>
	<jsp:include page="/footer.jsp"></jsp:include>
	  <script src="../node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
	
</body>
</html>