import java.util.*;
public class fract_knapsack{

    public static class products implements Comparable<products>{
        int wts;
        int price;
        double pwratio;

        products(int wts, int price){
            this.wts = wts;
            this.price = price;
            this.pwratio = price * 1.0 / wts;

        }

        public int compareTo(products other){
            if(this.pwratio > other.pwratio){
                return +1;
            }
            else if(this.pwratio<other.pwratio){
                return -1;
            }else{
                return 0;
            }
        }
    }



    public static double frac_knap(int[] wts , int[] prices , int cap){
        products[] prds = new products[wts.length];
        for(int i =0 ; i<prds.length ; i++){
            prds[i] = new products(wts[i], prices[i]);
        }
        Arrays.sort(prds);
        double vib = 0;
        int rc = cap;
        int i = prds.length-1;
        while(rc>0){
            if(prds[i].wts<rc){
                rc -= prds[i].wts;
                vib+=prds[i].price;

            }else{
                vib += prds[i].pwratio * rc; 
                rc = 0;
            }
            i--;
        }
        return vib;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      

        
    }


    public static void main(String[] args){
        int[] wt = {10,40,20,30};
        int[] p = {60,40,100,120};
        System.out.println(frac_knap(wt,p,50));

    }
}