#include<iostream>
using namespace std;
int main(int argc , char** argv){
    int arr[5] = {1,12,32,42,3};
    cout<<"enter the element to search: ";
    int n;
    cin>>n;
    for(int i = 0 ; i<5 ; i++){
        if(arr[i]==n){
            cout<<"element is found at index: "<<i<<endl;
            break;
        }

    }
}