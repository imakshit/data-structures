//21 outputs

import java.util.*;
public class pzz{

    public static void pzz(int n){
        if(n==0){
            return;
        }
        System.out.println(n+" pre");
        pzz(n-1);
        System.out.println(n+" in"); 
        pzz(n-1);
        System.out.println(n+" post");  
    }

    public static void main(String[] args){
        pzz(3);

    } 
}