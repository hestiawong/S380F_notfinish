
<html>

    <body>
        <c:if test="${fn:length(lecture.attachments) > 0}">
            <b>Course Materials :</b>
            <ul>
                <c:forEach items="${lecture.attachments}" var="attachment">
                    <li><a href="<c:url value="/course/${lecture.id}/attachment/${attachment.name}" />">
                            <c:out value="${attachment.name}" /></a>
                            <security:authorize access="hasRole('LECTURER')">
                            [<a href="<c:url value="/course/${lecture.id}/delete/attachment/${attachment.name}" />">Delete</a>]
                        </security:authorize>

                    </li>
                </c:forEach><br />
            </ul>
            <hr>
        </c:if>

        <c:if test="${fn:length(lecture.comments) > 0}">        
            <b>Comments :</b>
            <c:forEach items="${lecture.comments}" var="comment">
                <br /><br />
                ${comment.username} : ${comment.comment}
                <security:authorize access="hasRole('LECTURER')">
                    [<a href="<c:url value="/course/${lecture.id}/delete/comment/${comment.id}" />">Delete</a>]
                </security:authorize>
            </c:forEach><br /><br />
            <hr><br />
        </c:if>
        <form:form method="POST" action="comment/${lecture.id}" enctype="multipart/form-data" modelAttribute="AttachmentForm">   
            <form:label path="comment">Comment :</form:label><br/>
            <form:textarea path="comment" rows="3" cols="30" /><br/><br/>
            <input type="submit" value="Post"/>
        </form:form><br /><br />   
        <security:authorize access="hasRole('LECTURER')">
            <form:form method="POST" enctype="multipart/form-data" modelAttribute="AttachmentForm"> 
                <b>Add attachments :</b><br />
                <input type="file" name="attachments" multiple="multiple"/><br/><br/>
                <input type="submit" value="Add"/>
            </form:form>
        </security:authorize>    
        <a href="<c:url value="/course" />">Return to course list</a>    
    </body>
</html>
