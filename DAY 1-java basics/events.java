import java.util.*;
public class events{
    public static void main(String[] args){
        int e1s = 0;
        int e1e =10;
        int e2s = 5;
        int e2e = 15;

        if(e2s>e1e || e1s>e2e){
            System.out.println("no overlap");
        }else{
            if((e2s>e1s && e2e<e1e)||(e1s>e2s && e1e<e2e)){
                System.out.println("full overlap");
            }else{
                System.out.println("partial overlap");
            }
        }
    }
}