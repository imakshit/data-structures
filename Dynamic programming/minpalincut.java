import java.util.*;
public class minpalincut{

    public static int minpalindrome(String s){
        int[][] strg = new int[s.length()][s.length()];
        for(int g = 0 ; g<s.length() ; g++){
            for(int i = 0 ;  i<s.length()-g ; i++){
                int j = i+g;
                if(g==0){
                    strg[i][j] = 0;
                }else if(g==1) {
                    strg[i][j] = s.charAt(i) == s.charAt(j) ?0:1;                    
                }else{
                    int min = s.length();
                    if(s.charAt(i)==s.charAt(j) && strg[i+1][j-1]==0){
                        strg[i][j] = 0;
                    }
                  
                    else{
                    for(int k =0 ; k<g ; k++){
                        int left = strg[i][i+k];//row same
                        int right = strg[i+k+1][j];//col same
                        
                        if(left+right<min){
                            min = left+right;
                        }
                    }
                    strg[i][j] = min+1;
                    }
                }

            }
           
        }
        return strg[0][s.length()-1];
    }

    public static void main(String[] args){
        String str = "abccbc";
        System.out.println(minpalindrome(str));
        
    }
    
}