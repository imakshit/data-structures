import java.util.*;
public class activitySelection{

    public static class Interval implements Comparable<Interval>{
        int start;
        int end;

        Interval(int start , int end){
            this.start = start;
            this.end = end;

        }
        public int compareTo(Interval other){
            return this.start - other.start;
        }
    }

    public static int activity(int[] starts , int[] ends){
        Interval[] intvs = new Interval[starts.length];
        for(int i =0 ; i<starts.length ; i++){
            intvs[i] = new Interval(starts[i], ends[i]);
        }
        Arrays.sort(intvs);

        int[] strg = new int[intvs.length];

        strg[0] = 1;      

        for(int i =1 ; i<intvs.length ; i++){
            int imax = 0; //local max or initial max
            
            for(int j = 0 ; j<i ; j++){
                if(intvs[j].end < intvs[i].start){
                    if(strg[j]>imax){
                        imax = strg[j];
                    }
                }
            }    
            strg[i] = imax+1;
        }

        int max = strg[0];
        for(int i =1 ; i<strg.length; i++){
            if(strg[i]>max){
                max = strg[i];
            }
        }
        return max;

    }


    public static void main(String[] args){
        int[] starts = {12,2,6,7,9,1,3};
        int[] ends = {14,5,8,10,11,5,7};
        System.out.println(activity(starts , ends));
    }
}