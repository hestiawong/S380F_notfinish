<!DOCTYPE html>
<html>
    <body>
        <security:authorize access="hasRole('LECTURER')">    
            <a href="<c:url value="/userlist" />">Manage User Accounts</a><br /><br />
        </security:authorize>

        <security:authorize access="hasRole('LECTURER')">    
            [<a href="<c:url value="/course/createcourse" />">Create Course</a>]
        </security:authorize>[<a href="<c:url value = "/course/comment/history"/>">Comment History</a>]
        <br/><br/>

        [<a href="<c:url value = "/course/addPoll"/>">Add Poll</a>]
        <br/><br/>
        <c:forEach items="${course}" var="course">
            <ul>
                <h3>${course.coursename} 
                    <security:authorize access="hasRole('LECTURER')">    
                        [<a href="<c:url value="/course/deletecourse/${course.coursename}" />">Delete</a>]
                    </security:authorize>
                </h3>
                <c:forEach items="${course.lecture}" var="lecture">
                    <li><a href="<c:url value="/course/${lecture.id}" />">${lecture.lecturetitle}</a><security:authorize access="hasRole('LECTURER')">    
                            [<a href="<c:url value="/course/deletelecture/${lecture.id}" />">Delete</a>]
                        </security:authorize></li>
                    </c:forEach>

            </ul>
        </c:forEach>
        Poll :
        <c:choose>
            <c:when test="${fn:length(poll) == 0}">    
            </c:when>
            <c:otherwise>
                <c:forEach items="${poll}" var="pol">
                    <form:form method="POST" action="vote" enctype="multipart/form-data" modelAttribute="p">
                        ${pol.question}<br/>
                        <c:forEach items="${pol.pollAnswer}" var="ans">
                            <form:radiobutton path="answer" value="${ans.answerId}" /> ${ans.pollAnswer} <br />
                        </c:forEach>       
                        <form:input type='hidden' path="question_id" value="${pol.question_id}"/>                     
                        <input type="submit" value="Vote"/>
                    </form:form>
                </c:forEach>
            </c:otherwise>
        </c:choose>


        <c:url var="logoutUrl" value="/logout"/>
        <form action="${logoutUrl}" method="post">
            <input type="submit" value="Log out" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

    </body>
</html>