import java.util.*;
public class elementsarray{
    public static void main(String[] args){
        int[] arr = takeinput();
        display(arr);
    }

private static int[] takeinput(){
    Scanner sc = new Scanner(System.in);
     System.out.println("enter size of array: ");
     int n = sc.nextInt();

     int[] arr = new int[n];

    for(int i =0 ; i<arr.length ; i++){
        System.out.println("enter the value of"+i+"th index");
        arr[i] = sc.nextInt();
    }
    return arr;

}
private static void display(int[] arr){
    System.out.println("elements in array are: ");
    for(int i = 0 ; i<arr.length ; i++){
        System.out.print(arr[i]+" ");
    }
    
}



}