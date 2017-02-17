/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.io.Serializable;
/**
 *
 * @author dhiral
 */
public class MailBox implements Serializable {
    private ArrayList<message> inbox;
    private ArrayList<message> draft;
    private ArrayList<message> sent;
    private ArrayList<Folder> folders;
    public MailBox(){
        this.inbox = new ArrayList<message>();
        this.draft = new ArrayList<message>();
        this.sent = new ArrayList<message>();
        this.folders = new ArrayList<Folder>();
    }
    public void addFolder(Folder f){
        this.folders.add(f);
    }
    
    public void send(message m) {
        this.sent.add( m );
    }

    public void addToInbox(message m) {
        this.inbox.add( m );
    }

    public void addToDraft(message m) {
        this.draft.add( m );
    }
    
    @Override
    protected MailBox clone() throws CloneNotSupportedException {

        MailBox cloned = (MailBox) super.clone();
        //cloned.inbox = this.inbox.clone();
        //cloned.sent = this.sent.clone();
    
        return cloned;
    }
}
