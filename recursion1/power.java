public class power{

    public static int powernum(int n , int k){
        if(k==0){
            return 1;
        }

        int res = n* powernum(n ,k-1 );
        return res;

    }



    public static int smartpower(int n , int k){

    
        int res = 0;


        if(k==0){
            return 1;
        }

        if(k%2==0){           


             res = smartpower(n,k/2) * smartpower(n,k/2);
         
        }else if(k%2!=0){            
             res = n* smartpower(n,k/2) * smartpower(n,k/2);           

        }
            return res;
     

    }


    public static void main(String[] args){
         System.out.println(powernum(5,3));
          System.out.println(smartpower(5,0));

    }
}