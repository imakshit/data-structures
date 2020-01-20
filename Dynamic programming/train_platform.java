import java.util.*;
public class train_platform{

    public static int maxplatform(int[] arrival , int[] departure){
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int i = 0 ; 
        int j = 0 ;
        int count = 0 ;
        int max = 0;
        while(i<arrival.length){
            if(arrival[i]<=departure[j]){
                count++;
                i++;
            }else if(arrival[i]>departure[j]){
                j++;
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }
    
    public static void main(String[] args){
        int[] arrival = {900 , 940 , 950 , 1100 , 1500 , 1800};
        int [] departure = {910 , 1200 , 1120 , 1130 , 1900 , 2000};
        System.out.println(maxplatform(arrival, departure));
    }
}