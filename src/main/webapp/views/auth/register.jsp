<jsp:include page="/views/parcials/header.jsp" />

<!-- Page Title Start -->
<section class="page-title title-bg13">
    <div class="d-table">
        <div class="d-table-cell">
            <h2>Sign Up</h2>
            <ul>
                <li>
                    <a href="index.html">Home</a>
                </li>
                <li>Sign Up</li>
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
                <form class="signup-form" action="${pageContext.request.contextPath}/auth/register" method="POST">
                    <div class="form-group">
                        <label>Enter First Name</label>
                        <input type="text" class="form-control" placeholder="Enter First Name" name="firstName">
                    </div>

                    <div class="form-group">
                        <label>Enter Last Name</label>
                        <input type="text" class="form-control" placeholder="Enter Last Name" name="lastName">
                    </div>

                    <div class="form-group">
                         <label>Enter Email</label>
                         <input type="email" class="form-control" placeholder="Enter Your Email" name="email">
                    </div>

                    <div class="form-group">
                        <label>Enter Password</label>
                        <input type="password" class="form-control" placeholder="Enter Your Password" >
                    </div>

                    <div class="form-group">
                        <label>Confirm Password</label>
                        <input type="password" class="form-control" name="confirmPassword" placeholder="Confirm Your Password" >
                    </div>

                    <div class="signup-btn text-center">
                        <button type="submit">Sign Up</button>
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