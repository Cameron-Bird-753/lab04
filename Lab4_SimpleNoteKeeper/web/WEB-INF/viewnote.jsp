<%-- 
    Document   : viewnote
    Created on : 7-Oct-2021, 4:11:20 AM
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
        <h2>View Note</h2>
        <div>
            
            <h3>Title: ${note.title}</h3>
            <br>
            <h3>Content: ${note.content}</h3>
        </div>
        <a href="note?edit">Edit</a>
    </body>
</html>
