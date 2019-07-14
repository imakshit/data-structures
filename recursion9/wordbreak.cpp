#include<iostream>
#include<unordered_set>

using namespace std;

int counter = 0;

void wordbreak(string ques, string ans ,unordered_set<string> dict){
//base case
if(ques.length()==0){
    cout<<++counter<<". "<<ans<<endl;
    return;
}
//loop for size of prefix
for(int i = 1 ; i<=ques.length() ; i++){
    //find prefix
    string prefix = ques.substr(0 , i);
    //check if prefix is in dictionary
    if(dict.count(prefix)==1){
    //find roq
    string ros = ques.substr(i , ques.length()-prefix.length());
    //make call
    wordbreak(ros , ans+prefix+"-" , dict);
    }
}


}

int main(int argc , char** argv){
    //unordered set in cpp and hash se in java  are same
    unordered_set<string> dict;
    //add elements to unordered set dict
    dict.insert("man");
    dict.insert("go");
    dict.insert("mango");
    dict.insert("ice");
    dict.insert("cream");
    dict.insert("icecream");
    dict.insert("sam");
    dict.insert("sung");
    dict.insert("samsung");
    //make call
    wordbreak("mangoicecreamsamsung" , "" , dict);
}