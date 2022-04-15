<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form:form method="POST" enctype="multipart/form-data"
                             modelAttribute="lectureForm">
        <b>Attachments</b><br />
        <input type="file" name="attachments" multiple="multiple" /><br /><br />
        <input type="submit" value="Submit"/>
    </form:form>    </body>
</html>
