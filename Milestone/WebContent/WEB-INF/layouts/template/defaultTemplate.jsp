<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>GCU</title>
	
	 <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" />
	 <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet" />
	 <script src="<c:url value="/resources/js/jquery-3.3.1.min.js" />"/></script>
	 <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	
</head>

	<body>
		<!-- Header -->
		<tiles:insertAttribute name="header" />
	
		<!-- Body Page -->
		<div align="center">
			<tiles:insertAttribute name="body" />
		</div>
	
		
		<!-- Footer Page -->
		<tiles:insertAttribute name="footer" />
		
	</body>

</html>