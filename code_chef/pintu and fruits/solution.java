/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class code_chef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
    while(t!=0){
		    int sum = 0;
		    t--;
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    int[] arr1= new int[n];
		    int[] arr2 = new int[n];
		    int g = 2;
		    
		    
		    for(int i =0 ; i<n ; i++){
                arr1[i] = sc.nextInt();
                //System.out.print(arr1[i]+" ");
		        
		    }
		    
		    for(int i = 0; i<n ; i++){
                arr2[i] = sc.nextInt();
                //System.out.print(arr2[i]+" ");
		        
            }
            
            for(int i =0 ; i<n ; i++){
                if(arr1[i]==1){
                    sum+=arr2[i];
                }
            }
            //System.out.println(sum);
		    
		    while(g<=m){
                
                int sum1=0;
                for(int i =0 ; i<n ; i++){
                    if(arr1[i]==g){
                        sum1+=arr2[i];
                    }
                }
                //System.out.println(sum1);
                    if(sum>sum1 && sum1!=0){
                        sum=sum1;
                    }
                    g++;
                }
                System.out.println(sum);
            }
		    
		    
		}
		
	}

