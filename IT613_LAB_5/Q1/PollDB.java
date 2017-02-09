/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Map.Entry;
/**
 *
 * @author dhiral
 */
public class PollDB {
    private int totalCandidate;
    private HashMap<String,Integer> candidate;
    public PollDB(String[] candidate){
        this.candidate = new HashMap<String,Integer>();
           this.totalCandidate = candidate.length;
           for(int i=0;i<totalCandidate;i++){
               this.candidate.put(candidate[i], 0);
           }
    }
    public PollDB(){
        this.candidate = new HashMap<String,Integer>();
    }
    public void addCandidate(String candidateName){
        this.candidate.put(candidateName,0);
    }
    public int getVoteCount(int candidateNo)throws UserDefineException{
        int currentVote = 0;
        Iterator iterator = this.candidate.entrySet().iterator();
        int n = 0;
        while(iterator.hasNext()){
            Entry entry =(Entry) iterator.next();
            if(n==candidateNo-1){
                currentVote = (Integer) entry.getValue();
            }
            n++;
        }
        return currentVote;
    }
    public String getCandidateName(int candidateNo)throws UserDefineException{
        String CandidateName = new String();
        Iterator iterator = this.candidate.entrySet().iterator();
        int n = 0;
        while(iterator.hasNext()){
            Entry entry =(Entry) iterator.next();
            if(n==candidateNo-1){
                CandidateName = (String) entry.getKey();
            }
            n++;
        }
        return CandidateName;
    }
    public HashMap<String,Integer> getAllCandidate(){
        return this.candidate;
    }
    public String[] getCandidate(){
        String temp[] = new String[this.candidate.size()];
        int i = 0;
        for(Map.Entry<String,Integer> s : this.candidate.entrySet()){
            temp[i] = s.getKey();
            i++;
        }
        return temp;
    }
    public Integer[] getVotes(){
        Integer temp[] = new Integer[this.candidate.size()];
        int i = 0;
        for(Map.Entry<String,Integer> s : this.candidate.entrySet()){
            temp[i] = s.getValue();
            i++;
        }
        return temp;
    }
    public void voteTo(int candidateNo) throws UserDefineException{
        Iterator iterator = this.candidate.entrySet().iterator();
        int n=0;
        String candidateName=new String();
        int candidateCurrentVote=0;
        boolean flag = false;
        while(iterator.hasNext()){
            Entry entry = (Entry) iterator.next();
            if(n==candidateNo-1){
                Entry currentCandidate = entry ;
                candidateName = (String)currentCandidate.getKey();
                candidateCurrentVote = (Integer)currentCandidate.getValue();
                flag = true;
                break;
            }
            n++;
        }
        if(flag == true){
            candidateCurrentVote += 1;
            this.candidate.put(candidateName,candidateCurrentVote);
        }else{
            throw new UserDefineException("Candidate Not Founded");
        }   
    }
    public int getNumberOfCandidates(){
        return this.totalCandidate;
    }
   public String getWinner(){
       Iterator iterator = this.candidate.entrySet().iterator();
       String winner = new String();
       int max = 0;
       while(iterator.hasNext()){
           Entry entry = (Entry) iterator.next();
           if((Integer)entry.getValue() >= max){
               max = (Integer) entry.getValue();
               winner = (String) entry.getKey();
           }
       }
       return winner;
   }
}
