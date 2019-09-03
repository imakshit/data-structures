public class BitManipulation{

    public static void SetBit(int x, int k){
        System.out.println(x+" = "+ Integer.toBinaryString(x));
        int bm = 1<<k;
        x = (x|bm);     
        System.out.println(x+" = "+ Integer.toBinaryString(x));
    }

    public static void unsetBit(int x , int k){        
        System.out.println(x+" = "+ Integer.toBinaryString(x));
        int bm = 1<<k;
        int nbm = ~bm;
        x = (x&nbm);        
        System.out.println(x+" = "+ Integer.toBinaryString(x));
    }

    public static void ToggleBit(int x , int k){        
        System.out.println(x+" = "+ Integer.toBinaryString(x));
        int bm = 1<<k;
        x = x^bm;        
        System.out.println(x+" = "+ Integer.toBinaryString(x));
    }



    public static void main(String[] args){
        SetBit(57, 2);
        System.out.println();
        unsetBit(57, 3);
        System.out.println();
        ToggleBit(57, 2);
        System.out.println();
    }
} 