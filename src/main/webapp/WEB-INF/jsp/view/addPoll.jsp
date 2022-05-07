<!DOCTYPE html>
<html>
    <body>

        <form:form method="POST" enctype="multipart/form-data" modelAttribute="addPoll">
            <form:label path="question">Question :</form:label><br/>
            <form:input type="question" path="question" required="required"/><br/><br/>
            
            <form:label path="answer0">Answer :</form:label><br/>
            <form:input type="text" path="answer0" required="required"/><br/><br/>

            <form:label path="answer1">Answer :</form:label><br/>
            <form:input type="text" path="answer1" required="required"/><br/><br/>

            <form:label path="answer2">Answer :</form:label><br/>
            <form:input type="text" path="answer2" required="required"/><br/><br/>

            <form:label path="answer3">Answer :</form:label><br/>
            <form:input type="text" path="answer3" required="required"/><br/><br/>

            <br /><br />
            <input type="submit" value="Add"/>
        </form:form>
        <br/>
    </body>
</html>