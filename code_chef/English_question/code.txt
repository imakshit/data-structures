import java.util.*;
public class code_chef{

    //func used to calc count of common char from start
    public static int wordstart(String s1,String s2){
        //calc the min length out of s1 and s2
        int len = s1.length()>=s2.length()?s2.length():s1.length();
        //initialise count to 0
        int count = 0;
        //loop through strings
        for(int i =0 ; i<len ; i++){
            //if char match, count incremented
            if(s1.charAt(i)==s2.charAt(i)){
                count++;
            }else{
                break;
            }
        }
        return count;
    }
    //func used to calc count of common words from end
    public static int wordend(String s1,String s2){
        int len = s1.length();
        int len2 = s2.length();
        int count = 0;
        //loop for i from end of s1 and j from end of s2
        for(int i =len-1, j = len2-1 ; i>=0 && j>=0 ; i-- , j--){
            char a = s1.charAt(i);
            char b = s2.charAt(j);
            //if char matchs, count incremented
            if(a==b){
                count++;
            }else{
                break;
            }
        }
        return count;
    }

    //main func of prog
    public static int fun(String[] arr , boolean[] arr2, int sum){

        
        for(int i = 0 ; i< arr.length ;i++){
          //selecting words one by one from array
            for(int j = 0 ; j<arr.length  ; j++){
                //comparing with each word in array
               
                //condition so that word does not compare with itself
                if(i==j){
                    break;
                }

                //if word already paired/used, continue
                if(arr2[j]==true){
                    continue;
                }
                //calc prefix and suffix
                int x = wordstart(arr[i], arr[j]);
                int y = wordend(arr[i], arr[j]);
                //if prefix is not zero ie it matches with some word, mark both the words as used/true
                if(x!=0){
                    arr2[i] = true;
                    arr2[j] = true;
                }
                //if no word matched from all the words, break
                if(x==0){
                    break;
                }
                //calc min of prefix and suffix
                int min = Math.min(x, y);
                //add to sum
                sum+=(min*min);
                
            }
        }       
        return sum;
    }

    public static void main(String[] args){
        String[] arr = {"contest","coolest","unused"};//input
        boolean[] arr1 = {false,false,false};//array used to mark words used
        System.out.println(fun(arr,arr1,0));//call
        
       
    }
}