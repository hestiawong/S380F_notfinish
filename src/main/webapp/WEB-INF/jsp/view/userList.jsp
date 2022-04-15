

<a href="<c:url value="/course" />">Return to  course list </a>
<h2>Users</h2>
<a href="<c:url value="/createUser" />">Create a User</a><br /><br />
<c:choose>
    <c:when test="${fn:length(WebUsers) == 0}">
        <i>There are no users in the system.</i>
    </c:when>
    <c:otherwise>
    <table>
        <tr>
            <th>Username</th><th>Password</th><th>Roles</th><th>Fullname</th><th>Phone</th><th>Address</th>
        </tr>
        <c:forEach items="${WebUsers}" var="user">
        <tr>
            <td>${user.username}</td><td>${user.password}</td><td>${user.roles}</td><td>${user.fullname}</td><td>${user.phone}</td><td>${user.address}</td>
            <td>
            [<a href="<c:url value="/userlist/delete/${user.username}" />">Delete</a>]
            </td>
            <td>
            [<a href="<c:url value="/userlist/edit/${user.username}" />">Edit</a>]
            </td>
        </tr>
        </c:forEach>
    </table>
    </c:otherwise>
</c:choose>
</body>
