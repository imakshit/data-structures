import java.util.*;
public class coinpermdp{

    public static int perm(int[] coins , int target){
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 1 ; i<=target ; i++){
            for(int j = 0 ; j<coins.length ; j++){

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
        System.out.println(perm(arr,target));
    }
}