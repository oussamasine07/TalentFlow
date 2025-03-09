<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="/views/parcials/header.jsp" />
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page import="java.util.Map" %>

    <section class="page-title title-bg4">
        <div class="d-table">
            <div class="d-table-cell">
                <h2>Mes Candidatures</h2>
                <ul>
                    <li>
                        <a href="${pageContext.request.contextPath}">Home</a>
                    </li>
                    <li>Mes candidaturs</li>
                </ul>
            </div>
        </div>
        <div class="lines">
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
        </div>
    </section>

    <div class="container">
        <div class="section-title text-center">
            <table class="table table-striped my-5">
                  <thead>
                        <tr>
                              <th scope="col">Title</th>
                              <th scope="col">Offer date</th>
                              <th scope="col">Status</th>
                              <th scope="col">Is active</th>
                              <th scope="col">Apply</th>
                        </tr>
                  </thead>
                  <tbody>
                        <c:forEach var="candidature" items="${candidatures}">
                            <tr>
                                  <th scope="row">
                                    <c:out value="${candidature.offre.title}" />
                                  </th>
                                  <td>
                                    <c:out value="${candidature.offre.offerDate}" />
                                  </td>
                                  <td>
                                    <c:choose>
                                        <c:when test='${candidature.status == "acceptée"}'>
                                            <span class="badge bg-success">
                                                <c:out value="${candidature.status}" />
                                            </span>
                                        </c:when>
                                        <c:when test='${candidature.status == "refusée"}'>
                                            <span class="badge bg-danger">
                                                <c:out value="${candidature.status}" />
                                            </span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="badge bg-primary">
                                                <c:out value="${candidature.status}" />
                                            </span>
                                        </c:otherwise>
                                    </c:choose>
                                  </td>
                                  <td>
                                      <c:choose>
                                          <c:when test="${not candidature.isCanceled}">
                                              <span class="badge bg-primary">
                                                  still active
                                              </span>
                                          </c:when>
                                          <c:otherwise>
                                                <span class="badge bg-danger">
                                                      canceled
                                                </span>
                                          </c:otherwise>
                                      </c:choose>
                                  </td>
                                  <td>
                                    <form action='${pageContext.request.contextPath}/candidature/delete?id=<c:out value="${candidature.id}" />' method="POST">
                                        <button type="submit" class="btn btn-danger">Retirer</button>
                                    </form>
                                  </td>
                            </tr>
                        </c:forEach>
                  </tbody>
            </table>
        </div>
    </div>


<jsp:include page="/views/parcials/footer.jsp" />