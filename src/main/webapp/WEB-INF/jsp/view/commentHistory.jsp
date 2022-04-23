<html>
    <body>
        <h1>Comment History</h1>
        
            <c:forEach items = "${lectures}" var = "lecture">
                <h3>${lecture.coursename}(<a href="<c:url value="/course/${lecture.id}"/>">${lecture.lecturetitle}</a>) :</h3>
                <c:forEach items="${comments}" var="comment">
                    <c:if test = "${lecture.id == comment.lecture_id}">
                        ${comment.username} : ${comment.comment}<br/><br/>
                    </c:if>
                </c:forEach> 
            </c:forEach> 
        <a href="<c:url value="/course" />">Return to course list</a>                   
    </body>
</html>
