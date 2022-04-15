<!DOCTYPE html>
<html>
    <body>
        <c:forEach items="${course}" var="course">
            <ul>
                <h3>${course.coursename}</h3>
                <c:forEach items="${course.lecture}" var="lecture">
                    <li><a href="">${lecture.lecturetitle}</a></li>
                    </c:forEach>

            </ul>
        </c:forEach>
    </body>
</html>