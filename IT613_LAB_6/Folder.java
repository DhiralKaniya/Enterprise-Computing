/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
/**
 *
 * @author dhiral
 */
public class Folder {
    private ArrayList<message> messages;
    public Folder(){
        messages = new ArrayList<message>();
    }
    public void addMessage(message newMessage){
        this.messages.add(newMessage);
    }
    public void removeMessage(long msg_id){
        for(message e : this.messages){
            if(e.getMsg_id() == msg_id){
                this.messages.remove(e);
            }
        }
    }
}
