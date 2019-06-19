#include<iostream>
using namespace std;
int main(int argc , char** argv){
    int a ;
    int b ;
    cout<<"enter the two numbers: "<<endl;
    cin>>a>>b;
    while(b%a!=0){
        int c = b%a;
        b=a;
        a=c;

    }cout<<a;
}
