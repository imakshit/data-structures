import java.util.*;
public class job_sequencing{

    public class job implements Comparable<job>{
        char name;
        int deadline;
        int profit;
        
        job(char name , int deadline , int profit){
            this.name = name;
            this.deadline = deadline;
            this .profit = profit;
        }
        public int compareTo(job other){
            return this.profit - other.profit;
        }
    }

    public static void sequence(int[] deadline , int[] profit , char[] name){
        job[] jobs = new job[name.length];
        for(int i =0 ; i<jobs.length ; i++){
            jobs[i] = new job( name.charAt(i) , deadline[i] , profit[i]);
            
        }

    }



    public static void main(String[] args){
        int[] deadline = {2,1,2,1,3};
        int[] profit = {100 , 19 , 27 , 25 , 14};
        String name = "abcd";
        sequence(deadline, profit, name);


    }
}