<jsp:include page="/views/parcials/header.jsp" />
<%@ page import="talentflow.model.User, java.util.*" %>

<%
    User user = (User) session.getAttribute("user");
%>

<h1> hello <%= user.getFirstName() %> </h1>

<jsp:include page="/views/parcials/footer.jsp" />