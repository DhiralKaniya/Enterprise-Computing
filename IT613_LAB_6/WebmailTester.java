/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dhiral
 */
public class WebmailTester {
    public static void main(String[] args){
        Webmail webmail = new Webmail();
        webmail.Read();
        System.out.println("===Existing Users == ");
        webmail.printUser();
        User user = new User("Dhiral","123");
        webmail.addUser(user);
        try {
            User user1 = webmail.login("Dhiral","123");
            
            MailBox mailbox = user1.getMailBox();
            message m = null;
            mailbox.addToInbox(m);
            m = new message("Hello");
            m.addCC("test@gmail.com");
            m.addBCC("Tester@gmail.com");
            m.appendBody("Hello World");
            mailbox.send(m);
            System.out.println("Successfully Working");
        }catch(UserNotFounded uf){
            System.out.println(uf);
        }
        webmail.Save();
    }
}
