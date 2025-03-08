<jsp:include page="/views/parcials/header.jsp" />
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page import="java.util.Map" %>

<%
    // todo show alert message
%>

    <section class="page-title title-bg4">
        <div class="d-table">
            <div class="d-table-cell">
                <h2>Job List</h2>
                <ul>
                    <li>
                        <a href="${pageContext.request.contextPath}">Home</a>
                    </li>
                    <li>Job List</li>
                </ul>
            </div>
        </div>
        <div class="lines">
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
        </div>
    </section>

    <section class="job-style-two job-list-section pt-100 pb-70">
        <div class="container">
            <div class="section-title text-center">
                <h2>Jobs You May Be Interested In</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida</p>
            </div>

            <div class="row justify-content-center">
                <c:forEach var="offer" items="${offers}" >
                    <div class="col-lg-12">
                        <div class="job-card-two">
                            <div class="row align-items-center justify-content-center">
                                <div class="col-md-1">
                                    <div class="company-logo">
                                        <a href="job-details.html"></a>
                                        <img src="assets/img/company-logo/1.png" alt="logo">
                                    </div>
                                </div>
                                <div class="col-md-8">
                                    <div class="job-info">
                                        <h3>
                                            <c:out value="${offer.title}" />
                                        </h3>
                                        <ul>
                                            <li>
                                                <i class='bx bx-briefcase' ></i>
                                                <c:out value="${offer.description}" />
                                            </li>
                                            <li>
                                                <i class='bx bx-location-plus'></i>
                                                Wellesley Rd, London
                                            </li>
                                            <li>
                                                <i class='bx bx-stopwatch' ></i>
                                                <c:out value="${offer.offerDate}" />
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="theme-btn text-end">
                                        <form action="${pageContext.request.contextPath}/candidature/postuler?offerId=${offer.id}" method="POST">
                                            <button type="submit" class="default-btn">Postuler</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </section>


<jsp:include page="/views/parcials/footer.jsp" />