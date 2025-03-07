<jsp:include page="/views/parcials/header.jsp" />
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page import="java.util.Map" %>

<h1>hello world</h1>
<c:forEach var="candidature" items="${candidatures}" >
    <div>
<%--        <h1>--%>
<%--            <c:out value="${candidature.offer.title}" />--%>
<%--        </h1>--%>
<%--        <p>--%>
<%--            <c:out value="${candidature.offer.offerDate}" />--%>
<%--        </p>--%>
        <p>
            <c:out value="${candidature.status}" />
        </p>
        <p>
            <c:out value="${candidature.isCanceled}" />
        </p>


<%--        <form action="${pageContext.request.contextPath}/candidature/postuler?offerId=${offer.id}" method="POST">--%>
<%--            <button type="submit">Postuler</button>--%>
<%--        </form>--%>
    </div>
</c:forEach>


<jsp:include page="/views/parcials/footer.jsp" />