<jsp:include page="/views/parcials/header.jsp" />

<%@ page import="java.util.Map" %>

<%
    // Get errors from session and remove them after displaying
    Map<String, String> errors = (Map<String, String>) session.getAttribute("errors");
    session.removeAttribute("errors");

    // Get user input from session and remove it after displaying
    talentflow.dto.LoginDTO old = (talentflow.dto.LoginDTO) session.getAttribute("old");
    session.removeAttribute("old");

    String errorUser = (String) session.getAttribute("errorUser");
    session.removeAttribute("errorUser");

    String registerSuccess = (String) session.getAttribute("registerSuccess");
    session.removeAttribute("registerSuccess");
%>


<!-- Page Title Start -->
<section class="page-title title-bg13">
    <div class="d-table">
        <div class="d-table-cell">
            <h2>Sign In</h2>
            <ul>
                <li>
                    <a href="index.html">Home</a>
                </li>
                <li>Sign In</li>
            </ul>
        </div>
    </div>
    <div class="lines">
        <div class="line"></div>
        <div class="line"></div>
        <div class="line"></div>
    </div>
</section>
<!-- Page Title End -->

<!-- Sign up Section Start -->
<div class="signup-section ptb-100">


    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-6 col-md-8  ">
                <% if (errorUser != null) { %>
                    <div class="alert alert-danger  alert-dismissible fade show" role="alert">
                      <strong><%= errorUser %></strong>
                    </div>
                <% } %>
                <% if (registerSuccess != null) { %>
                    <div class="alert alert-success  alert-dismissible fade show" role="alert">
                      <strong><%= registerSuccess %></strong>
                    </div>
                <% } %>


                <form class="signup-form" action="${pageContext.request.contextPath}/auth/login" method="POST">

                    <div class="form-group">
                         <label>Enter Email</label>
                         <input
                            type="text"
                            class="form-control"
                            placeholder="Enter Your Email"
                            name="email"
                            value="<%= old != null ? old.getEmail() : "" %>"
                         >
                         <% if (errors != null && errors.containsKey("email")) { %>
                             <p class="text-red-500 text-xs italic mt-2"><%= errors.get("email") %></p>
                         <% } %>
                    </div>

                    <div class="form-group">
                        <label>Enter Password</label>
                        <input
                            type="password"
                            class="form-control"
                            placeholder="Enter Your Password"
                            name="password"
                            value="<%= old != null ? old.getPassword() : "" %>"
                        >
                        <% if (errors != null && errors.containsKey("password")) { %>
                             <p class="text-red-500 text-xs italic mt-2"><%= errors.get("password") %></p>
                        <% } %>
                    </div>

                    <div class="signup-btn text-center">
                        <button type="submit">Login</button>
                    </div>

                    <div class="other-signup text-center">
                        <span>Or sign up with</span>
                        <ul>
                            <li>
                                <a href="#">
                                    <i class='bx bxl-google'></i>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <i class='bx bxl-facebook'></i>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <i class='bx bxl-twitter'></i>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <i class='bx bxl-linkedin'></i>
                                </a>
                            </li>
                        </ul>
                    </div>

                    <div class="create-btn text-center">
                        <p>
                            Have an Account?
                            <a href="signin.html">
                                Sign In
                                <i class='bx bx-chevrons-right bx-fade-right'></i>
                            </a>
                        </p>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- Sign Up Section End -->

<jsp:include page="/views/parcials/footer.jsp" />