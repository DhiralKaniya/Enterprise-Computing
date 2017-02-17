/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
/**
 *
 * @author dhiral
 */
public class User implements Serializable{
   private String name;
   private String password;
   private MailBox mailbox;
   public User(String name,String password){
       this.name = name;
       this.password = password;
       this.mailbox = new MailBox();
   }
   public void addMailBox(MailBox mailbox){
       this.mailbox = mailbox;
   }
   public String getName(){
       return this.name;
   }
   public String getPassword(){
       return this.password;
   }
   public MailBox getMailBox(){
       return this.mailbox;
   }
}
