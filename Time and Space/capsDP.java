import java.util.*;
public class capsDP{
    public static int countwaystoparty(ArrayList<Integer>[] pcmap , int pidx , int mask){
        if(pidx==pcmap.length){
            return 1;
        }
        
        int count = 0;
        for(int cap: pcmap[pidx]){
            if((mask&(1<<cap))==0){
                mask = mask^ (1<<cap);
               int cc = countwaystoparty(pcmap, pidx+1, mask);
               count+=cc;

               mask = mask ^ (1<<cap);
            }
        }
        return count;

    } 

    public static void main(String[] args){
        ArrayList<Integer>[] pcmap = new ArrayList[4];
        pcmap[0] =  new ArrayList<>(Arrays.asList(0,2,4));
           
            pcmap[1] = new ArrayList<>(Arrays.asList(0,1,2,3));
            pcmap[2]= new ArrayList<>(Arrays.asList(1,2,3));
           pcmap[3] =  new ArrayList<>(Arrays.asList(0,4));
        
        int caps = 5;
        System.out.println(countwaystoparty(pcmap, 0, 0));
      
    }
}