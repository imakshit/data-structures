#include<iostream>
using namespace std;
int main(int argc , char** argv){
    int arr[5] = {1,12,32,42,33};
    cout<<"enter the element to search: "<<endl;
    int n;
    cin>>n;
    int low = 0;
    int high = 5;
  
    while(low<=high){
        int mid = (low+high)/2;
        if(arr[mid]==n){
            cout<<"found at: "<<mid;
            return 1;
        }
       
        else if(n>arr[mid]){
            low = mid+1;
            
        }else{
            high = mid-1;
        }
        
    }
    cout<<"data not found!!!";
    


    }

    
