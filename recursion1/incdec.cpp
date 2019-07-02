#include<iostream>
using namespace std;
void pi(int n){
    if(n==0){
        return;
    }
    cout<<n<<" ";
    pi(n-1);
    cout<<n<<" ";

}
int main(int argc , char** argv){
    pi(5);
}