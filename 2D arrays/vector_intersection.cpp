#include<iostream>
#include<vector>

using namespace std;

int main(int argc , char** argv){
    vector<int> a {1,1,2,2,2,3,5};
    vector<int> b {1,1,1,2,2,4,5};
   
int i = 0;
int j =0;
    while( i<a.size() && j <b.size()){
        if(a[i]==b[j]){
            cout<<a[i]<<" ";
            i++;
            j++;
        }
        else if(a[i]>b[j]){
            j++;
        }else if(a[i]<b[j]){
            i++;
        }


    }
}