/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author tweet
 */
public class NoteServlet extends HttpServlet {

    private Note userNote;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String edit = request.getParameter("edit"); 
        String title;
        String content;
        ArrayList<String> filedata = new ArrayList<>();
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        if (userNote == null){
            System.out.println("IT IS NULL");
            try{

                String line;
                while (br.ready()) {
                    line = br.readLine();
                    filedata.add(line);
                    System.out.println("This line " + line);
                } 
                System.out.println("filedata "+ filedata.size());
                if(filedata.size()>1){
                    title = (String) filedata.get(0);
                    content = (String) filedata.get(1);
                    userNote = new Note(title, content);
                    request.setAttribute("note", userNote);
                }

            }catch(IOException e) {
                e.printStackTrace();
            }
        }else{
            request.setAttribute("note", userNote);
            
        }
 
        if(edit != null){
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request,response);
            request.setAttribute("note_title", userNote);
            request.setAttribute("note_content", userNote);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("note_title");
        String content= request.getParameter("note_content");
        System.out.println("New Title "+ title);
        System.out.println("New Content "+ content);
        if(userNote != null){
            userNote.setTitle(title);
            userNote.setContent(content);
            request.setAttribute("note", userNote);
            System.out.println("New Title of Nopte object"+ userNote.getTitle());
            try{
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 
            pw.println(title);
            pw.println(content);
            
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request,response);
            }catch(IOException e) {
                e.printStackTrace();
           }
        }
    }
}
