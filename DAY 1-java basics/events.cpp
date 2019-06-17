#include<iostream>
using namespace std;
int main(int argc , char** argv){
       int e1s = 0;
        int e1e =10;
        int e2s = 1;
        int e2e = 8;

        if(e2s>e1e || e1s>e2e){
            cout<<"no overlap";
        }else{
            if((e2s>e1s&&e2e<e1e)||(e1s>e2s&&e1e<e2e)){
                cout<<"full overlap";
            }else{
                cout<<"partial overlap";
            }
        }
    }
