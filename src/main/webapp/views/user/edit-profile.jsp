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
                <h2>Edit Profile</h2>
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

    <section class="account-section ptb-100">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-4">
                    <div class="account-information">
                        <div class="profile-thumb">
                            <img src="assets/img/account.jpg" alt="account holder image">
                            <h3><c:out value="${user.firstName}"/> <c:out value="${user.lastName}"/></h3>
                            <p><i class="bx bxs-phone"></i> <c:out value="${userType.phone}"/></p>
                        </div>

                        <ul>
                            <li>
                                <a href="#" class="active">
                                    <i class='bx bx-user'></i>
                                    My Profile
                                </a>
                            </li>
                            <li>
                                <a href="resume.html">
                                    <i class='bx bxs-file-doc'></i>
                                    My Resume
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <i class='bx bx-coffee-togo'></i>
                                    Delete Account
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="col-md-8">
                    <div class="account-details">
                        <h3>Basic Information</h3>
                        <form class="basic-info" action="#" method="POST">
                            <div class="row justify-content-center">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>First Name</label>
                                        <input type="text" class="form-control" value='<c:out value="${user.firstName}" />' name="firstName" placeholder="First Name">
                                    </div>
                                </div>

                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Last Name</label>
                                        <input type="text" class="form-control" value='<c:out value="${user.lastName}" />' name="lastName" placeholder="Last Name">
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label>Your Email</label>
                                        <input type="text" class="form-control" value='<c:out value="${user.email}" />' name="email" placeholder="Your Email">
                                    </div>
                                </div>


                                <div class="col-md-12">
                                    <button type="submit" class="account-btn">Save</button>
                                </div>
                            </div>
                        </form>

                        <h3>Personal info</h3>
                        <c:choose>
                            <c:when test="${user.role eq 'condidat'}">
                                <form class="candidates-sociak" action="#" method="POST" >
                                    <div class="row justify-content-center">
                                        <div class="col-lg-6">
                                            <div class="form-group">
                                                <label>Phone</label>
                                                <input type="text" class="form-control" value='<c:out value="${userType.phone}" />' name="phone" placeholder="Phone">
                                            </div>
                                        </div>

                                        <div class="col-lg-6">
                                            <div class="form-group">
                                                <label>Diploma</label>
                                                <input type="text" class="form-control" value='<c:out value="${userType.diploma}" />' name="diploma" placeholder="Diploma">
                                            </div>
                                        </div>

                                        <div class="col-md-12">
                                            <button type="submit" class="account-btn">Save</button>
                                        </div>
                                    </div>
                                </form>
                            </c:when>
                            <c:otherwise>
                                <form class="candidates-sociak" action="#" method="POST" >
                                    <div class="row justify-content-center">
                                        <div class="col-lg-6">
                                            <div class="form-group">
                                                <label>Company</label>
                                                <input type="text" class="form-control" value='<c:out value="${userType.company}" />' name="diploma" placeholder="company">
                                            </div>
                                        </div>

                                        <div class="col-lg-6">
                                            <div class="form-group">
                                                <label>Phone</label>
                                                <input type="text" class="form-control" value='<c:out value="${userType.phone}" />' name="diploma" placeholder="Phone">
                                            </div>
                                        </div>

                                        <div class="col-lg-12">
                                            <div class="form-group">
                                                <label>Address</label>
                                                <input type="text" class="form-control" value='<c:out value="${userType.address}" />' name="diploma" placeholder="Address">
                                            </div>
                                        </div>

                                        <div class="col-md-12">
                                            <button type="submit" class="account-btn">Save</button>
                                        </div>
                                    </div>
                                </form>
                            </c:otherwise>
                        </c:choose>


                    </div>
                </div>
            </div>
        </div>
    </section>






<jsp:include page="/views/parcials/footer.jsp" />