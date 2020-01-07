<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<HTML>
<HEAD>
<TITLE>Lab06 Select Query Results</TITLE>
<LINK REL=STYLESHEET HREF="mainstyle.css" TYPE="text/css">
</HEAD>

<BODY>

	<div id="mainDoc">

		<%@ page errorPage="/WEB-INF/error.jsp"%>

		<%@ taglib uri="/WEB-INF/tableTags-taglib.tld" prefix="tableTags"%>

		<h2>
			<a href="user.jsp">Query Again</a>
		</h2>
		<br>
		<h2>
			<a id="logout" title="Log out" href="logout">Log out</a>
		</h2>
		<TABLE>

			<!-- Custom tag use -->
			<tableTags:headers headerVector="${columns}" headerColor="RED"/>
			<tableTags:rows vectorRows="${results}" />

		</TABLE>

	</div>