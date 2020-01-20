import java.util.*;
public class coincombdp{

    public static int comb(int[] coins , int target){
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int j = 0 ; j<coins.length ; j++)
            {
           
            for(int i = 1 ; i<=target ; i++){

                if(i>=coins[j]){
                    dp[i] += dp[i-coins[j]];
                }

            }

        }

        return dp[target];      

    }

    public static void main(String[] args){
        int[] arr = {2,3,5,6};
        int target = 7;
        System.out.println(comb(arr,target));
    }
}