#include<iostream>
using namespace std;


   void swap(int* arr  , int left , int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }


  void rev(int* arr , int size){
        int left  = 0;
        int right = size-1;
        while(left<right){
            swap(arr , left , right);
            left++;
            right--;
        }

    }




 void display(int* arr , int size){
           for(int i =0 ;  i<size ; i++){
            cout<<arr[i]<<" ";
        }
 }

int main(int argc , char** argv)
{
     int* arr = new int[6] {10,20,30,40,50,60};
        rev(arr ,6);
        display(arr , 6);
}