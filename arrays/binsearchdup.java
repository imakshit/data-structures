import java.util.*;
public class binsearchdup{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = {10,10,10,20,20,30,30,40,50,50};

        int result = -1;
       // Arrays.sort(arr);

        
        
        System.out.println("Enter the data to find: ");
        int data = sc.nextInt();
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(data>arr[mid]){
                left = mid+1;
            }else if(data<arr[mid]){
                right = mid-1;
            }else {
             result = mid;
             right = mid-1; // to find first occurence
             //left = mid+1; //to find last occurence
            }
        }
        if(result==-1){
            System.out.println("data not found!");

        }else{
            System.out.println(data+" found at " + result);
        }
      
    }  
}