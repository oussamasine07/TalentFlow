<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<jsp:include page="/views/parcials/header.jsp" />

<%@ page import="java.util.Map" %>

    <c:forEach var="offer" items="${offers}" >
        <div>
            <h1>
                <c:out value="${offer.title}" />
            </h1>
            <p>
                <c:out value="${offer.description}" />
            </p>
        </div>
    </c:forEach>


<jsp:include page="/views/parcials/footer.jsp" />