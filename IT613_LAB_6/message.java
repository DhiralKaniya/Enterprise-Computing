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
public class message implements Serializable{
    private ArrayList<String> to ;
    private ArrayList<String> toCC;
    private ArrayList<String> toBCC;
    private ArrayList<String> attachments;
    private String sender;
    private String body;
    private long msg_id;
    static long next_msg_id = 00000;
    
    
    public message(String sender){
        this.to = new ArrayList<String>();
        this.toCC = new ArrayList<String>();
        this.toBCC = new ArrayList<String>();
        this.attachments = new ArrayList<String>();
        this.body = new String();
        this.sender = sender;
        this.msg_id = next_msg_id++;
    }
    
    public void addRecipent(String toStr){
        this.to.add(toStr);
    }
    
    public void addCC(String CC){
        this.toCC.add(CC);
    }
    
    public void addBCC(String BCC){
        this.toBCC.add(BCC);
    }
    
    public void addAttachment(String filename){
        this.attachments.add(filename);
    }
    
    public void appendBody(String body){
        this.body += body;
    }
    
    public long getMsg_id(){
        return this.msg_id;
    }
    public boolean equals(message object){
        if(this.getMsg_id() == object.getMsg_id())
            return true;
        else
            return false;
    }
}
