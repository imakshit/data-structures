#include<iostream>
using namespace std;
int main(int argc , char** argv){
    int arr[5] = {1,2,3,4,5};
    for(int i = 0 ; i<5/2; i++){
        int x = arr[i];
        arr[i] = arr[5-1-i];
        arr[5-1-i] = x;

    }for(int i= 0 ; i<5 ; i++){
        cout<<arr[i]<<" ";
    }
}