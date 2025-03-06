<%@ page import="talentflow.model.User" %>
<%@ page import="talentflow.model.Candidat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/views/parcials/header.jsp" />
    <%
        Candidat candidat = (Candidat) request.getAttribute("candidat");
    %>


    <!-- Candidate Details Start -->
    <section class="candidate-details pt-100 pb-100">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-4">
                    <div class="candidate-profile">
                        <img src="assets/img/client-1.png" alt="candidate image">
                        <h3>John Smith</h3>
                        <p>Web Developer</p>

                        <ul>
                            <li>
                                <a href="tel:+100230342">
                                    <i class='bx bxs-phone'></i>
                                    +101 023 0342
                                </a>
                            </li>
                            <li>
                                <a href="mailto:john@gmail.com">
                                    <i class='bx bxs-location-plus'></i>
                                    john@gmail.com
                                </a>
                            </li>
                        </ul>

                        <div class="candidate-social">
                            <a href="https://www.facebook.com/login/" target="_blank"><i class='bx bxl-facebook'></i></a>
                            <a href="https://twitter.com/i/flow/login" target="_blank"><i class='bx bxl-twitter'></i></a>
                            <a href="https://www.linkedin.com/" target="_blank"><i class='bx bxl-linkedin'></i></a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-8">
                    <div class="candidate-info-text">
                        <h3>About Me</h3>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
                    </div>

                    <div class="candidate-info-text candidate-education">
                        <h3>Education</h3>

                        <div class="education-info">
                            <h4>School</h4>
                            <p>Amherst School, USA</p>
                            <span>2000-2010</span>
                        </div>

                        <div class="education-info">
                            <h4>College</h4>
                            <p>Swarthmore College, USA</p>
                            <span>2010-2012</span>
                        </div>

                        <div class="education-info">
                            <h4>University</h4>
                            <p>Princeton University, USA</p>
                            <span>2012-2016</span>
                        </div>
                    </div>

                    <div class="candidate-info-text candidate-experience">
                        <h3>Experience</h3>

                        <ul>
                            <li>Proficient in HTML, CSS, Server-Scripting, C/C++, and Oracle</li>
                            <li>Experience with SEO</li>
                            <li>Experience Teaching Web Development</li>
                            <li>Knowledgeable in Online Advertising</li>
                            <li>Expert in LAMP Web Service Stacks</li>
                        </ul>
                    </div>

                    <div class="candidate-info-text candidate-skill">
                        <h3>Skills</h3>

                        <ul>
                            <li>HTMl</li>
                            <li>CSS</li>
                            <li>JS</li>
                            <li>PHP</li>
                            <li>Oracle</li>
                            <li>C/C++</li>
                            <li>SQL</li>
                            <li>Ruby</li>
                        </ul>
                    </div>

                    <div class="candidate-info-text text-center">
                        <div class="theme-btn">
                            <a href="#" class="default-btn">Hire Me</a>
                            <a href="#" class="default-btn">Download CV</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Candidate Details End -->


<jsp:include page="/views/parcials/footer.jsp" />
