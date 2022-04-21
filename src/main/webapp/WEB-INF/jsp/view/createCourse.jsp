
<h2>Create Course</h2>
<form:form method="POST" enctype="multipart/form-data" modelAttribute="course">
    <form:label path="coursename" >Course Name: </form:label><br/>
    <form:input type="text" path="coursename" required="required"/><br/><br/>
    <form:label path="lecturetitle">Lecture Title: </form:label><br/>
    <form:input type="text" path="lecturetitle" required="required"/><br/><br/>
    <br /><br />
    <b>Attachments</b><br />
    <input type="file" name="attachments" multiple="multiple" /><br /><br />
    <input type="submit" value="Create"/>
</form:form>
</body>
</html>
