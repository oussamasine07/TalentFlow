<jsp:include page="/views/parcials/header.jsp" />
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page import="java.util.Map" %>

<h1>hello world</h1>
<c:forEach var="candidature" items="${candidatures}" >
    <div>
        <h1>
            <c:out value="${candidature.offre.title}" />
        </h1>
        <p>
            <c:out value="${candidature.offre.offerDate}" />
        </p>
        <p>
            <c:out value="${candidature.status}" />
        </p>
        <p>
            <c:choose>
                <c:when test="${not candidature.isCanceled}">
                    still active
                </c:when>
                <c:otherwise>
                    canceled
                </c:otherwise>
            </c:choose>
            <%--<c:out value="${candidature.isCanceled}" />--%>
        </p>


        <form action="#" method="POST">
            <button type="submit">Retirer</button>
        </form>
    </div>
</c:forEach>


<jsp:include page="/views/parcials/footer.jsp" />