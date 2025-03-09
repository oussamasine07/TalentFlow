<%@ taglib uri="jakarta.tags.core" prefix="c" %>
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

    <div class="job-post ptb-100">
        <div class="container">
            <form class="job-post-from" action='${pageContext.request.contextPath}/offer/update?id=<c:out value="${offer.id}" />' method="POST">
                <h2>Fill Up Your Job information</h2>
                <div class="row justify-content-center">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label>Enter Title</label>
                             <input
                                type="text"
                                class="form-control"
                                placeholder="Enter a title"
                                name="title"
                                value='<c:out value="${offer.title}" />'
                             >
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <label>Enter Date</label>
                             <input
                                type="datetime-local"
                                class="form-control"
                                placeholder="Enter a date"
                                name="datetime"
                                value='<c:out value="${offer.offerDate}" />'
                             >
                        </div>
                    </div>

                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="exampleFormControlTextarea1">Job Description</label>
                            <textarea
                                class="form-control description-area"
                                id="exampleFormControlTextarea1"
                                rows="6"
                                placeholder="Enter a descreption"
                                name="description"
                            ><c:out value="${offer.description}" /></textarea>
                        </div>
                    </div>

                    <div class="col-md-12 text-center">
                        <button type="submit" class="post-btn">
                            Post A Job
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>


<jsp:include page="/views/parcials/footer.jsp" />