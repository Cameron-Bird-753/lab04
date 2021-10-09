<%-- 
    Document   : editnote
    Created on : 7-Oct-2021, 4:11:41 AM
    Author     : tweet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Note - Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note keeper</h1>
        <h2>Edit Note</h2>
        <form method="post">
            <label>Title</label>
            <input type="text" name="note_title" value="${note.title}"> 
            <br>
            <label>Content</label>
            <textarea rows = "5" cols = "20" name ="note_content" >${note.content}</textarea>
            <br>
            <input type = "submit" value = "Save" />
        </form>
        <a href="note?view">View</a>
    </body>
</html>
