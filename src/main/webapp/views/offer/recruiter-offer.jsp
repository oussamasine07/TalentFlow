<jsp:include page="/views/parcials/header.jsp" />
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<%@ page import="java.util.Map" %>

    <section class="page-title title-bg5">
        <div class="d-table">
            <div class="d-table-cell">
                <h2>My offers</h2>
                <ul>
                    <li>
                        <a href="${pageContext.request.contextPath}">Home</a>
                    </li>
                    <li>My offers</li>
                </ul>
            </div>
        </div>
        <div class="lines">
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
        </div>
    </section>

    <section class="job-section jobs-grid-section pt-100 pb-70">
        <div class="container">
            <div class="section-title text-center">
                <h2>List of all my posted offers</h2>
            </div>

            <div class="row justify-content-center">
                <c:forEach var="offer" items="${offers}" >
                    <div class="col-md-6">
                        <div class="job-card">
                            <div class="row align-items-center justify-content-center">
                                <div class="col-lg-3">
                                    <div class="thumb-img">
                                        <a href="job-details.html">
                                            <img src="assets/img/company-logo/1.png" alt="company logo">
                                        </a>
                                    </div>
                                </div>

                                <div class="col-lg-6">
                                    <div class="job-info">
                                        <h3>
                                            <a href="${pageContext.request.contextPath}/offer/mes-offer/candidatures?id=<c:out value='${offer.id}' />">
                                                <c:out value="${offer.title}" />
                                            </a>
                                        </h3>
                                        <ul>
                                            <li>
                                                <i class='bx bx-filter-alt' ></i>
                                                <c:out value="${offer.description}" />
                                            </li>
                                        </ul>
                                    </div>
                                </div>

                                <div class="col-lg-3">
                                    <div class="job-save">
                                        <a href='${pageContext.request.contextPath}/offer/update?id=<c:out value="${offer.id}" />'>
                                            <i class='bx bx-pencil' ></i>
                                        </a>
                                        <form action='${pageContext.request.contextPath}/offer/delete?id=<c:out value="${offer.id}" />' method="POST">
                                               <button type="submit" class="btn btn-danger">
                                                    <i class='bx bx-trash' ></i>

                                               </button>
                                        </form>
                                        <p>
                                            <i class='bx bx-stopwatch' ></i>
                                            <c:out value="${offer.offerDate}" />
                                        </p>
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