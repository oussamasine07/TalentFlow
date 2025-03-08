<jsp:include page="/views/parcials/header.jsp" />
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<%@ page import="java.util.Map" %>

<h1>hello world</h1>
    <c:forEach var="offer" items="${offers}" >
            <div>
                <h1>
                    <a href="${pageContext.request.contextPath}/offer/mes-offer/candidatures?id=<c:out value='${offer.id}' />">
                     <c:out value="${offer.title}" />
                    </a>

                </h1>
                <p>
                    <c:out value="${offer.description}" />
                </p>
                <p>
                    <c:out value="${offer.offerDate}" />
                </p>
                <a href='${pageContext.request.contextPath}/offer/update?id=<c:out value="${offer.id}" />'>edit</a>
                <form action='${pageContext.request.contextPath}/offer/delete?id=<c:out value="${offer.id}" />' method="POST">
                       <button type="submit">Delete</button>
                </form>

            </div>
        </c:forEach>


<jsp:include page="/views/parcials/footer.jsp" />