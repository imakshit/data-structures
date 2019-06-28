#include<iostream>

using namespace std;


void swap(int* a , int* b){
    int temp = *a;
    *a = *b;
    *b = temp;
}

void reverse(int* arr , int left , int right){
    while(left<right){
        swap(&arr[left] , &arr[right]);
        left++;
        right--;

    }

}


void rotate(int* arr, int n , int k){
    k = k % n;
    k = k < 0 ? n+k : k;

    reverse(arr , 0 , n-k-1); //p1

    reverse(arr , n-k , n-1); //p2

    reverse(arr , 0 , n-1);//p1+p2


}


void display(int* arr , int n ){
    for(int i = 0 ; i<n ; i++){
        cout<<arr[i]<<" ";
    }
    cout<<endl;
}


int main(int argc , char** argv){
int* arr = new int[7] {1,2,3,4,5,6,7};
//int n = 7; 
//int k = 3;

rotate(arr , 7 , 3);
display( arr , 7);


rotate(arr , 7 , -17);
display( arr , 7);


rotate(arr , 7 , 51);
display( arr , 7);

}





