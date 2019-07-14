#include<iostream>
#include<vector>
#include<sstream>

using namespace std;

void encodings(string ques , string asf){
    //if length is 0
    if(ques.length()==0){
        cout<<asf<<endl;
        return;
    }
    //if length is 1
    else if(ques.length()==1){
        char ch = ques[0];
        string roq = ques.substr(1,ques.length()-1);
        if(ch!='0'){
        int num = ch-48;
        char code = num+96;
        encodings(roq , asf+code);
        }

    }
    //if length is more than 1
    else{

        char ch0 = ques[0];
        string roq0 = ques.substr(1 , ques.length()-1);
        if(ch0!='0'){
            //change int to char
        int num = ch0 - 48; 
        char code = num+96;
        //call
        encodings(roq0 , asf+code);
        }

        char ch1 = ques[1];
        string roq1 = ques.substr(2 , ques.length()-2);
        if(ch0!='0'){
            int num = (ch0-48)*10+(ch1-48);
            if(num>=10 && num<=26){
            char code = num+96;
            encodings(roq1 , asf+code);
            }
        }
    }

    /*
    converting string to integer

    string s = "1123" ;
    stringstream sin(s);
    int i =0;
    sin>>i;
    cout<<i<<endl;
    */
}

int main(int argc , char** argv){
    encodings("1203~" , "");
}