/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.lang.ClassNotFoundException;

/**
 *
 * @author dhiral
 */
public class Webmail implements Serializable {
    private ArrayList<User> users;
    public Webmail(){
        this.users = new ArrayList<User>();
    }
    public void addUser(User user){
        this.users.add(user);
    }
    
    public void Save(){
        try {
                FileOutputStream fos = new FileOutputStream("users.src");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(this.users);
            }catch(IOException fn ){
                System.out.println(fn);
            }
    }
    public void Read(){
        try {
            FileInputStream fin = new FileInputStream("users.src");
            ObjectInputStream ooi = new ObjectInputStream(fin);
            this.users.addAll((Collection<? extends User >) ooi.readObject());
        }catch(IOException | ClassNotFoundException io ){
            System.out.println(io);
        }
    }
    public void printUser(){
        for(User u : this.users){
            System.out.println(u.getName()+" "+u.getPassword());
        }
    }
    public void deleteUser(User user){
        this.users.remove(user);
    }
    public User login(String user_name,String password)throws UserNotFounded{
        for(User u : this.users){
            if(u.getName().compareTo(user_name)==0 && u.getPassword().compareTo(password)==0){
                return u;
            }
        }
        throw new UserNotFounded();
    }
}
