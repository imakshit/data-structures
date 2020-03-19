#include<iostream>
#include<stack>
#include<vector>

using namespace std;



bool hasDuplicateBrackets(string& exp){
    stack<char> st;
    for(int i =0 ; i<exp.length() ; i++){
        if(exp[i]==')'){
            if(st.top()=='('){
                return true;
            }else{
                while(st.top()!='('){
                    st.pop();
                }st.pop();
            }
        }else{
            st.push(exp[i]);
        }
    }
    return false;

}

// bool BalancedBrackets(string& exp){
//     stack<char> st;
//     int count = 0;
//     for(int i =0 ; i<exp.length() ; i++){
//         if(exp[i]=='('){
//             st.push(exp[i]);
//             count+=1;
//         }else if(exp[i]==')'){
//             st.pop();
//             count-=1;
//         }
//     }
//     if(count==0){
//         return true;
//     }else{
//         return false;
//     }
// }

bool hasBalancedBrackets(string& str){
    stack<char> st;
    
    for(int i =0 ; i<str.length() ; i++){
        if(str[i]=='(' ||  str[i]=='{' || str[i]=='['){
            st.push(str[i]);
        }
        else if(str[i]==')'){
            if(st.size()==0 || st.top()!='('){
                return false;
            }else{
                st.pop();
            }
        }
        
        else if(str[i]=='}'){
            if(st.size()==0 || st.top()!='{'){
                return false;
            }else{
                st.pop();
            }
        }

        else if(str[i]==']'){
            if(st.size()==0 || st.top()!='['){
                return false;
            }else{
                st.pop();
            }
        }
   }
   if(st.size()>0){
       return false;
   }else{
       return true;
   }    
}

vector<int> nextgreater(vector<int>& arr){
    vector<int> res(arr.size());
    stack<int> st;
    for(int i =0  ; i<arr.size() ; i++){
        while(st.size()>0 && arr[st.top()] < arr[i]){
            res[st.top()] = arr[i];
            st.pop();
        }
        st.push(i);
    }

    while(st.size()>0){
        res[st.top()] = -1;
        st.pop();
    }

    return res; 

}

vector<int> nextgreater2(vector<int>& arr){
    vector<int> res(arr.size());
    stack<int> st;

    res[arr.size()-1] = -1;
    st.push(arr[arr.size()-1]);

    for(int i = arr.size()-2 ; i>=0 ; i--){
        while(st.size()!=0 && arr[i] > st.top()){
            st.pop();
        }
    res[i] = st.size() == 0? -1: st.top();
    st.push(arr[i]);
    }
    return res;
}

int histogram_Area( vector<int>& bars){
    //right smallest

    vector<int> rb(bars.size());
    vector<int> lb(bars.size());
    stack<int> st;

    for(int i =0  ; i<rb.size() ; i++){
        while(st.size()>0 && bars[st.top()] > bars[i]){
            rb[st.top()] = i;
            st.pop();
        }
        st.push(i);
    }

    while(st.size()>0){
        rb[st.top()] = -1;
        st.pop();
    }

    for(int i =lb.size()-1  ; i>=0 ; i--){
        while(st.size()>0 && bars[st.top()] > bars[i]){
            lb[st.top()] = i;
            st.pop();
        }
        st.push(i);
    }

    while(st.size()>0){
        lb[st.top()] = -1;
        st.pop();
    }

    int max = 0;
    for(int i = 0 ; i<bars.size() ; i++){
        int width = rb[i] - lb[i] - 1;
        int area = bars[i]*width;
        if(area>max){
            max = area;
        }
    }
    return max;
}

vector<int> slidingWindow(vector<int> arr){
    int k = 5;
    vector<int> nge(arr.size());
    stack<int> st;
    for(int i =0  ; i<arr.size() ; i++){
        while(st.size()>0 && arr[st.top()] < arr[i]){
            nge[st.top()] = i;
            st.pop();
        }
        st.push(i);
    }

    while(st.size()>0){
        nge[st.top()] = arr.size();
        st.pop();
    }

    int i = 0;
    int j = 0;

    vector<int> res(arr.size()-k+1);
    while(i<res.size()){
    if(i>j){
        j = i;
    }

    while(nge[j] < i+k){
        j = nge[j];
        
    }
    res[i] = arr[j];
    i++;
    }
    

    return res;
}

void ddiid(string& s){
    stack<int> st;
    int val = 1;
    for(int i =0 ; i<=s.length() ; i++){
        st.push(val++);
        if(i==s.length() || s[i]=='i'){
            while(st.size()>0){
                cout<<st.top()<<" ";
                st.pop();
            }
        }     
    }
}



int main(int args , char** argv){
    //string exp = "(a*(b+c))";
    //cout<<hasDuplicateBrackets(exp)<<endl;

    // string exp = "(a*(b+c)))";
    // cout<<BalancedBrackets(exp)<<endl;

    // string exp = "[a+{b+(d+e)}]";
    // cout<<hasBalancedBrackets(exp)<<endl;

    // vector<int> arr {5,9,8,3,2,7,16,4,14,19,3};
    //  vector<int>res  = nextgreater(arr);
    // //vector<int> res = nextgreater2(arr);
    // for(int i = 0 ; i<res.size() ; i++){
    //     cout<<res[i]<<+" ";
    // }

    // vector<int> arr {6,2,5,4,5,1,6};
    // cout<<histogram_Area(arr);

    // vector<int> arr {5,3,9,1,8,6,7,2,11,4,17,9};
    // vector<int> op = slidingWindow(arr);
    // for(int i = 0 ; i<op.size() ; i++){
    //     cout<<op[i]<<+" ";
    // }

    string s = "didididi";
    ddiid(s);

}
