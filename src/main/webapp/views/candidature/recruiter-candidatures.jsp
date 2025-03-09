
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="/views/parcials/header.jsp" />
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page import="java.util.Map" %>

    <section class="page-title title-bg4">
        <div class="d-table">
            <div class="d-table-cell">
                <h2>All Candidatures</h2>
                <ul>
                    <li>
                        <a href="${pageContext.request.contextPath}">Home</a>
                    </li>
                    <li>candidaturs</li>
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
            <h2 class="my-5">Offer: </h2>
            <table class="table table-striped">
                  <thead>
                        <tr>
                              <th scope="col">Full name</th>
                              <th scope="col">Email</th>
                              <th scope="col">Phone</th>
                              <th scope="col">Diploma</th>
                              <th scope="col">Status</th>
                              <th scope="col">Update status</th>
                        </tr>
                  </thead>
                  <tbody>
                        <tr>
                              <th scope="row">1</th>
                              <td>Mark</td>
                              <td>Otto</td>
                              <td>@mdo</td>
                              <td>@mdo</td>
                              <td>@mdo</td>
                        </tr>
                        <c:forEach var="candidature" items="${candidatures}">
                            <tr>
                                  <th scope="row">
                                    <c:out value="${candidature.candidat.firstName}" /> <c:out value="${candidature.candidat.lastName}" />
                                  </th>
                                  <td>
                                    <c:out value="${candidature.candidat.email}" />
                                  </td>
                                  <td>
                                    <c:choose>
                                        <c:when test="${not candidature.candidat.phone}">
                                            ---
                                        </c:when>
                                        <c:otherwise>
                                            <c:out value="${candidature.candidat.phone}" />
                                        </c:otherwise>
                                    </c:choose>
                                  </td>
                                  <td>
                                      <c:choose>
                                          <c:when test="${not candidature.candidat.diploma}">
                                              ---
                                          </c:when>
                                          <c:otherwise>
                                              <c:out value="${candidature.candidat.diploma}" />
                                          </c:otherwise>
                                      </c:choose>
                                  </td>
                                  <td>
                                    <c:out value="${candidature.status}" />
                                  </td>
                                  <td>
                                    <form action="${pageContext.request.contextPath}/candidature/update-status?id=<c:out value='${candidature.id}' />" method="POST">
                                        <input type="hidden" name="id" value="<c:out value='${candidature.id}' />">
                                        <select name="status">
                                            <option value="acceptée">Acceptée</option>
                                            <option value="refusée">Refusée</option>
                                            <option value="en attente">En attente</option>
                                        </select>
                                        <button type="submit" class="btn btn-primary">change</button>
                                    </form>
                                  </td>
                            </tr>
                        </c:forEach>
                  </tbody>
            </table>
        </div>
    </div>



<jsp:include page="/views/parcials/footer.jsp" />