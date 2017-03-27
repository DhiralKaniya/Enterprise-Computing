/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Item;

import java.util.ArrayList;

/**
 *
 * @author dhiral
 */
public class ItemStore {
    ArrayList<Item> myitem;
    public ItemStore(){
        myitem = new ArrayList<Item>();
    }
    public void addItem(Item item)throws ItemExists{
        if(myitem.contains((Object)item))
            throw new ItemExists();
        else
            myitem.add(item);
    }
    public Item getItem(int item_code)throws ItemNotFound{
        for(Item i:myitem){
            if(i.getCode()==item_code)
                return i;
        }
        throw new ItemNotFound();
    }
    public void updateItem(Item item)throws ItemNotFound{
        if(myitem.contains((Object)item))
        {
            Item updItem = this.getItem(item.getCode());
            myitem.remove(updItem);
            myitem.add(item);
        }
        else{
            throw new ItemNotFound();
        }
    }
    public void removeItem(int item_code)throws ItemNotFound{
        Item rmItem = this.getItem(item_code);
        if(myitem.contains((Object)rmItem)){
            myitem.remove(rmItem);
        }else{
            throw new ItemNotFound();
        }
    }
}
