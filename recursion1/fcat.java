public class fcat{

public static int factor(int n){

    if(n==0){
        return 1;
    }
     int res = n* factor(n-1);
     return res;
}


    public static void main(String[] args){
        System.out.println(factor(3));
    }
}