/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;

/**
 *
 * @author ted
 */
public class Messages {

    ArrayList<Message> messages = new ArrayList<Message>();

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }
    
    public int averageRating(){
        int r=0;
        int numOfCustComment =0;
        if(messages!=null && messages.size()!=0){
            for(int i=0;i<messages.size();i++){
                
                if( messages.get(i).getManagerID() ==-1 )
                {
                    r += messages.get(i).getRating();
                    numOfCustComment++;
                }
            }
            //r = r/messages.size();
            r = r/numOfCustComment;
            if(messages.size()%r!=0){
                r += 1;
            }
        }
        return r;
    }
    
    public int averageRatingForCustomer(){
        int r=0;
        if(messages!=null && messages.size()!=0){
            for(int i=0;i<messages.size();i++){
                    r += messages.get(i).getRating();
            }
            r = r/messages.size();
            if(messages.size()%r!=0){
                r += 1;
            }
        }
        return r;
    }
    

}
