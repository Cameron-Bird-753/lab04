/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author tweet
 */
public class Note {
    
   private String title;
   private String content;
   
   public Note(String title, String content){
       this.content = content;
       this.title = title;
   }
   
   public void setTitle(String title){
       this.title = title;
   }
   
      
   public void setContent(String content){
       this.content = content;
   }
   
   public String getContent(){
       return content;
   }
   public String getTitle(){
       return title;
   }
    
}