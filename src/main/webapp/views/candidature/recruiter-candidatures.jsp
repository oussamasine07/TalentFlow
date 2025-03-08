
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="/views/parcials/header.jsp" />
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page import="java.util.Map" %>

<h1>this candidature by offer</h1>

<c:forEach var="candidature" items="${candidatures}" >
    <div>
        <h1>
            <c:out value="${candidature.candidat.firstName}" /> <c:out value="${candidature.candidat.lastName}" />
        </h1>
        <p>
            <c:out value="${candidature.candidat.email}" />
        </p>
        <p>
            <c:out value="${candidature.candidat.phone}" />
        </p>
        <p>
            <c:out value="${candidature.candidat.diploma}" />
        </p>
        <p>
            <c:out value="${candidature.status}" />
        </p>
        <p>
            <%--
            <c:choose>
                <c:when test="${not candidature.isCanceled}">
                    still active
                </c:when>
                <c:otherwise>
                    canceled
                </c:otherwise>
            </c:choose>
            --%>
        </p>


        <form action="${pageContext.request.contextPath}/candidature/update-status?id=<c:out value='${candidature.id}' />" method="POST">
            <input type="hidden" name="id" value="<c:out value='${candidature.id}' />">
            <select name="status">
                <option value="acceptée">Acceptée</option>
                <option value="refusée">Refusée</option>
                <option value="en attente">En attente</option>
            </select>
            <button type="submit">change</button>
        </form>
    </div>
</c:forEach>

<jsp:include page="/views/parcials/footer.jsp" />