#include<iostream>
#include<string>
#include<vector>
using namespace std;

string codes[10] = {
    ".",
    "abc",
    "def",
    "ghi",
    "jklm",
    "no",
    "pqrs",
    "tu",
    "vwxy",
    "z"
};

vector<string> getkpc(string str){
    
     if(str.length()==0)
     {
     vector<string> bres;
     bres.push_back(" ");
     return bres;
    }

    char ch = str[0];//8
    string ros = str.substr(1,str.length()-1);//35
    vector<string> rres  = getkpc(ros);//35 all combinations #faith
    vector<string> mres; //resultant vector

    string code = codes[ch-48]; //letters for 8

    for(int i =0 ; i<code.size() ; i++){
        //take first letter of 8 and add it to all the combinatiions of 35
        //repeat for all letters of 8
        char chcode = code[i];

        for(int j =0  ; j<rres.size() ; j++){
            string rstrr = rres[j];
            mres.push_back(chcode+rstrr);

        }
            }
            return mres;

}

int main(int argc , char** argv){
    vector<string> result = getkpc("835");
    int counter = 0;
    for(int i =0 ; i<result.size() ; i++){
        cout<<result[i]<<endl;
        counter++;
            }
            cout<< counter;
}