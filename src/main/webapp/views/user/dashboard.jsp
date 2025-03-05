<jsp:include page="/views/parcials/header.jsp" />
<%@ page import="talentflow.model.User, java.util.*" %>

<%
    Map<String, String> user = (Map<String, String>) session.getAttribute("user");
%>

<h1> hello <%= user.get("firstName") %> </h1>

<jsp:include page="/views/parcials/footer.jsp" />