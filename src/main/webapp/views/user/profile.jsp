<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page import="talentflow.model.Candidat, talentflow.model.User" %>
<%@ page import="java.io.File" %>
<jsp:include page="/views/parcials/header.jsp" />

<%
    User user = (User) session.getAttribute("user");
%>

    <section class="page-title title-bg11">
        <div class="d-table">
            <div class="d-table-cell">
                <h2>Resume</h2>
                <ul>
                    <li>
                        <a href="index.html">Home</a>
                    </li>
                    <li>Resume</li>
                </ul>
            </div>
        </div>
        <div class="lines">
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
        </div>
    </section>

    <section class="resume-section ptb-100">
        <div class="container">
            <div class="resume-area">
                <div class="row justify-content-center">
                    <div class="col-md-12">
                        <div class="resume-thumb-area text-center">
                            <img src="assets/img/account.jpg" alt="account image">
                            <h3><c:out value="${user.firstName}"/> <c:out value="${user.lastName}"/></h3>

                            <p><i class="bx bxs-phone"></i> <c:out value="${userType.phone}"/></p>

                            <div class="social-links">
                                <a href="${pageContext.request.contextPath}/edit-profile" target="-blank">
                                    <i class="bx bx-pencil"></i>
                                </a>
                                <a href="#" target="-blank">
                                    <form action="#" method="POST" style="display: inline">
                                        <button type="submit"><i class="bx bx-trash"></i></button>
                                    </form>

                                </a>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-12">
                        <div class="resume-content about-text">
                            <h3>
                                <i class='bx bx-user-circle'></i>
                                About Me
                            </h3>
                            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
                        </div>



                        <c:if test="userType.diploma != null" >
                            <div class="resume-content education-text">
                                <h3>
                                    <i class='bx bx-book-reader'></i>
                                    Education Background
                                </h3>

                                    <div class="education-info">
                                        <span>2014-2018</span>
                                        <h5><c:out value="${userType.diploma}"/></h5>
                                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
                                    </div>
                            </div>

                            <div class="theme-btn">
                                <a href="#" class="default-btn">
                                    Download
                                    <i class='bx bx-download bx-fade-down' ></i>
                                </a>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </section>

<c:out value="${userType.phone}"/>



<jsp:include page="/views/parcials/footer.jsp" />
