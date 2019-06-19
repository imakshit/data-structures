#include<iostream>
using namespace std;
int main(int argc , char** argv){
    cout<<"enter size of arr: "<<endl;
    int n ;
    int arr[n];
    cin>>n;
    for(int i = 0 ; i<n ; i++){
        cout<<"enter the"<<i<<"th element : "<<endl;
        cin>>arr[i];
    }

   
    int max = arr[0];
    for(int j = 1 ; j<n ;j++ ){
        
        if(max<arr[j]){
            max = arr[j];
        }
    }
     cout<<"max of arr is: "<<max<<endl;
}