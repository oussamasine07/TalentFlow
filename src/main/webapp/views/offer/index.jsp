<jsp:include page="/views/parcials/header.jsp" />
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<%@ page import="java.util.Map" %>

<%
    // todo show alert message
%>

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

                <form action="${pageContext.request.contextPath}/candidature/postuler?offerId=${offer.id}" method="POST">
                    <button type="submit">Postuler</button>
                </form>
            </div>
        </c:forEach>


<jsp:include page="/views/parcials/footer.jsp" />