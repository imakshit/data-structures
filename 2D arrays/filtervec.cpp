#include<iostream>
#include<vector>
using namespace std;

void filter(vector<int> &v){
    for(int i = v.size()-1 ; i>=0 ; i--){
        if(v[i]>50){
          v.erase(v.begin()+i);
        }

    } 

    for(int i =0 ; i<v.size() ; i++){
        cout<<v[i]<<" ";
    }


}


int main(int argc , char** argv){
    vector<int> v {10,20,30,40,50,60,70};
    //remove number larger than 50

    filter(v);

    cout<<endl;

      for(int i =0 ; i<v.size() ; i++){
        cout<<v[i]<<" ";
    }

}
