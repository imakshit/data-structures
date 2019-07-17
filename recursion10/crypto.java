import java.util.*;

public class crypto{
    static int counter;
    static String s1,s2,s3;


    private static int getnumber(String s , int[] map){
        int num = 0;
        int pv = 1;
        for(int i = s.length()-1 ; i>=0 ; i--){
            num+=pv*map[s.charAt(i)-97];
            pv *= 10;
        }
        return num;
        //change SEND to NUMBER
        //if S =1 ,E=2 , N = 3 , D = 4
        //this func will return 1234
    }


    private static void generatemapping(String unique , int[] map , boolean[] takenumber){

        if(unique.length()==0){
            int n1 = getnumber(s1 , map);
            int n2 = getnumber(s2 , map);
            int n3 = getnumber(s3 , map);
            if(n1+n2==n3){
                System.out.print(++counter+". ");
                for(int i = 0 ; i<26 ; i++){
                    if(map[i]!=-1){
                        System.out.print((char)(i+97)+"= "+map[i]+" ");

                    }
                }System.out.println();
            }return;
        }

        char ch = unique.charAt(0);
        String ros = unique.substring(1,unique.length());
        for(int o = 0 ; o<=9 ; o++){
            if(takenumber[o]==false){
            map[ch-97]=o;
            takenumber[o] = true;
            generatemapping(ros , map , takenumber);

            map[ch-97] = -1;
            takenumber[o] = false;
            }
        }

    }



    private static String unique(String s1 , String s2 , String s3){
        boolean[] duplicates = new boolean[26];
        String ans = "";
        

        for(char ch: s1.toCharArray()){
            if(duplicates[ch-97]==false){
                ans+=ch;
                duplicates[ch-97] = true;
            }
        }

        for(char ch:s2.toCharArray()){
            if(duplicates[ch-97]==false){
                ans+=ch;
                duplicates[ch-97] = true;
            }
        }

        for(char ch:s3.toCharArray()){
            if(duplicates[ch-97]==false){
                ans+=ch;
                duplicates[ch-97] = true;
            }
        }


        return ans;
        //ans = sendmory
    }



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        s1 = sc.next();
        s2 = sc.next();
        s3 = sc.next();

        String unique = unique(s1,s2,s3);

       
        int[] map = new int[26];
        Arrays.fill(map , -1);
        boolean[] takenumber = new boolean[10];

        generatemapping(unique , map , takenumber);
    }
}