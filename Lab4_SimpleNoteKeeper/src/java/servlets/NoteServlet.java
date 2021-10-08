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


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("DO GET ");
        String title;
        String content;
        ArrayList filedata = new ArrayList<>();
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        // to read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        try{
            String line;
            while (br.readLine() != null) {
                
                line = br.readLine();
                filedata.add(line);
                System.out.println("FIND THIS "+ line);
            }   
//            title = (String) filedata.get(0);
//            content = (String) filedata.get(1);
//            Note userNote = new Note(title, content);
//            request.setAttribute("title", userNote);
//            request.setAttribute("content", userNote);
        }catch(IOException e) {
            e.printStackTrace();
       }
// to write to a file
//        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 
  
        
        String edit = request.getParameter("edit"); 
        if(edit != null){
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request,response);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request,response);
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
    }

}
