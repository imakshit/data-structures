import java.util.*;
public class targetdp{
    
    public static void allsubs(boolean[][] local , int i , int j , int[] arr , String asf){
        if(i==0){
            if(j==0){
                System.out.println(asf);
            }
            else if(j == arr[0]){
                System.out.println(asf+arr[0]);
            }
        }
        else{
            if(local[i-1][j]==true){
                allsubs(local , i-1 , j , arr , asf);
            }

            if(j>=arr[i]){
                if(local[i-1][j-arr[i]]==true){
                    allsubs(local , i-1 , j-arr[i] , arr , asf+arr[i]+" ");
                }
            }
        }

    }





    public static boolean target(int[] arr , int target){

           boolean[][] local = new boolean[arr.length][target+1];
           
           for(int i =0 ; i<arr.length ; i++){
               for(int j = 0 ; j<=target ; j++){              

                if(i==0 && j==0){
                    local[i][j] = true;                
                }
                else if(i==0){
                    if(j==arr[0]){
                        local[i][j] = true;
                    }
                }
                else if(j==0){
                    local[i][j] = true;
                }
                else{
                    if(local[i-1][j]==true){
                        local[i][j] = true;
                    }

                    else{
                        if(j>=arr[i]){
                        if(local[i-1][j-arr[i]] == true){
                            local[i][j] = true;
                        }
                        }
                    }
                }                
            }
        }
        allsubs(local , arr.length-1 , target , arr , "");
        return local[arr.length-1][target];
    }

    public static void main(String[] args){
        int target = 9;
        int[] arr = {3,2,5,1,8};
        boolean k = target(arr , target);
        System.out.println(k);
     
    }
}