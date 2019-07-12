import java.util.*;
public class stair{

    public static void psp(int src , String psf){
        if(src==0){
            System.out.println(psf);
            return;
        }

        psp(src-1 , psf+1);

        if(src>=2){
            psp(src-2 , psf+2);
        }

        if(src>=3){
            psp(src-3 , psf+3);
        }
    }
    public static void main(String[] args){
        psp(7 , "");
    }
}