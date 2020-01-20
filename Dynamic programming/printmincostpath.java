import java.util.*;
public class printmincostpath{

    public static void pallpath(int[][] garr  ,  int i  , int j ,String psf){


         if(i==garr.length -1 && j==garr[0].length-1){
                    System.out.println(psf);
                    return;
                }

        if(i>=garr.length || j>=garr[0].length){
            return;
        }
        if(i==garr.length-1){
                    pallpath(garr,i,j+1 ,psf + "H" );
                }
                else if(j==garr[0].length-1){
                    pallpath(garr,i+1,j , psf + "V");
                }
                else{
                    if(garr[i][j+1]<garr[i+1][j]){
                        pallpath(garr,i,j+1 ,psf + "H" );
                    }
                    else if(garr[i][j+1]>garr[i+1][j]) {
                        pallpath(garr,i+1,j , psf + "V");
                    }
                    else{
                        pallpath(garr,i+1,j , psf + "V");
                        pallpath(garr,i,j+1 ,psf + "H" );                      

                    }

                }      
    }

    public static int allpath(int[][] larr){
         int[][] garr = new int[larr.length][larr[0].length];


        for(int i = garr.length-1; i>=0 ; i--){
            for(int j = garr[0].length-1 ; j>=0 ; j--){
                
                if(i==larr.length -1 && j==larr[0].length-1){
                    garr[i][j] = larr[i][j];
                }
                else if(i==larr.length-1){
                    garr[i][j] = larr[i][j]+garr[i][j+1];

                }
                else if(j==larr[0].length-1){
                    garr[i][j] = larr[i][j] + garr[i+1][j];
                }
                else{
                    garr[i][j] = larr[i][j] + Math.min(garr[i][j+1] , garr[i+1][j]);

                }

            }
        }
    
        pallpath(garr ,0 , 0, "");
        return garr[0][0];
    }

    public static int godlmine(int[][] larr){
         int[][] garr = new int[larr.length][larr[0].length];
       
             for(int j = garr[0].length-1 ; j>=0 ; j--){
               for(int i = 0 ; i<garr.length ; i++){

                   if(j==garr[0].length-1){
                       garr[i][j] = larr[i][j];
                   }
                   else if(i==garr.length-1){
                       {
                        garr[i][j] = larr[i][j] + Math.max(garr[i][j+1], garr[i-1][j+1]);

                        
                       }

                   }else if(i==0){

                     garr[i][j] = larr[i][j] + Math.max(garr[i+1][j+1], garr[i][j+1]);

                   }else{
                        int f1 = Math.max(garr[i+1][j+1], garr[i][j+1]);
                        int f2 =Math.max(f1, garr[i-1][j+1]);
                         garr[i][j] = larr[i][j] + f2;                  

             }
         }
         
         }
         int max = 0;
         
         for(int i =0 ; i<garr.length ; i++){
         max = Math.max(max , garr[i][0]);
    }
    return max;
    }

    


    public static void main(String[] args){
        int[][] larr = {
            {1,5,1,0,3},
            {1,4,0,2,3},
            {4,0,1,3,2},
            {2,4,0,4,1},
            {1,2,3,2,0},
            
        };

       
        long start = System.currentTimeMillis();        
        //int res = allpath( larr );
        int res = godlmine(larr);
        long end = System.currentTimeMillis();
        long dur = end-start;
        System.out.println(res+" in "+dur+"ms");
      
    }
}