<%@ page import="talentflow.model.Candidat" %>
<%@ page import="java.io.File" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/views/parcials/header.jsp" />

<%
    Candidat candidat = (Candidat) request.getAttribute("candidat");
%>

<section class="edit-profile pt-100 pb-100">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-8">
                <div class="edit-profile-form">
                    <h3>Edit Profile</h3>
                    <form action="edit-profil" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="nom">Name:</label>
                            <input type="text" id="nom" name="nom" value="<%= candidat.getPhone() %>" required>
                        </div>

                        <div class="form-group">
                            <label for="email">Email:</label>
                            <input type="email" id="email" name="email" value="<%= candidat.getDiploma() %>" required>
                        </div>



                        <button type="submit" class="btn btn-primary">Save Changes</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/views/parcials/footer.jsp" />
