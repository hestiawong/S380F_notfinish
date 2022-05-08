
<html>
    <body>
        <h1>Poll page</h1>
        
        <security:authorize access="hasRole('LECTURER')">    
            [<a href="<c:url value="/course/pollContentPage/addPoll" />">Add poll</a>]
        </security:authorize>
        
            
            Poll :
        <c:choose>
            <c:when test="${fn:length(poll) == 0}">    
            </c:when>
            <c:otherwise>
                <c:forEach items="${poll}" var="pol">
                    <form:form method="POST" enctype="multipart/form-data" modelAttribute="p">
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
                        
    </body>
</html>
