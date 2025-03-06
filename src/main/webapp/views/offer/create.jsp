<jsp:include page="/views/parcials/header.jsp" />

<%@ page import="java.util.Map" %>




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

<!-- create offer Section Start -->
<div class="create-section ptb-100">

    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-6 col-md-8  ">
                <form class="offer-form" action="${pageContext.request.contextPath}/recruiter/offer/create" method="POST">

                    <div class="form-group">
                         <label>Enter Title</label>
                         <input
                            type="text"
                            class="form-control"
                            placeholder="Enter a title"
                            name="title"
                            value=""
                         >
                    </div>
                     <div class="form-group">
                         <label>Enter Description</label>
                         <input
                            type="text"
                            class="form-control"
                            placeholder="Enter a descreption"
                            name="description"
                         >
                    </div>
                    <div class="form-group">
                         <label>Enter Date</label>
                         <input
                            type="datetime-local"
                            class="form-control"
                            placeholder="Enter a date"
                            name="datetime"
                            value=""
                         >
                    </div>
                    <div class="signup-btn text-center">
                        <button type="submit">Create</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- Create Section End -->

<jsp:include page="/views/parcials/footer.jsp" />