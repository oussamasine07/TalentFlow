<jsp:include page="/views/parcials/header.jsp" />
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<%@ page import="java.util.Map" %>

<h1>hello world</h1>
    <c:forEach var="offer" items="${offers}" >
            <div>
                <h1>
                    <c:out value="${offer.title}" />
                </h1>
                <p>
                    <c:out value="${offer.description}" />
                </p>
                <p>
                    <c:out value="${offer.offerDate}" />
                </p>
                <a href='${pageContext.request.contextPath}/recruiter/offer/update?id=<c:out value="${offer.id}" />'>edit</a>
                <form action='${pageContext.request.contextPath}/recruiter/offer/delete?id=<c:out value="${offer.id}" />' method="POST">
                       <button type="submit">Delete</button>
                </form>

            </div>
        </c:forEach>


<jsp:include page="/views/parcials/footer.jsp" />