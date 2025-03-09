<jsp:include page="/views/parcials/header.jsp" />
<%@ page import="talentflow.model.User, java.util.*" %>

<%
    User user = (User) session.getAttribute("user");
%>

    <section class="page-title title-bg3">
        <div class="d-table">
            <div class="d-table-cell">
                <h2>Dashboard</h2>
                <ul>
                    <li>
                        <a href="${pageContext.request.contextPath}">Home</a>
                    </li>
                    <li>Dashboard</li>
                </ul>
            </div>
        </div>
        <div class="lines">
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
        </div>
    </section>

    <div class="container py-5">
        <h1> Welcome back <%= user.getFirstName() %> </h1>
    </div>


<jsp:include page="/views/parcials/footer.jsp" />