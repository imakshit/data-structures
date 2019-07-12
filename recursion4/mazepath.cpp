#include<iostream>
#include<string>
#include<vector>
using namespace std;

vector<string> gmp(int sr , int sc , int dr , int dc){
     if(sr == dr && sc == dc)
    {
        vector<string> bp;
        bp.push_back("");
        return bp;
    }

    vector<string> nh;//neighbour horizontal
    vector<string> nv;//neighbour vertical


     if(sc < dc )//calc all horizontal neighbours
    {
        nh = gmp(sr, sc + 1, dr, dc);
    }

    if(sr < dr)//calc all vertical neighbours
    {
        nv = gmp(sr + 1, sc, dr, dc);
    }

    vector<string> paths; //resultant vector
    for(int i = 0; i < nh.size(); i++)
    {
        paths.push_back("h" + nh[i]);//if nh , add H
    }

    for(int i = 0; i < nv.size(); i++)
    {
        paths.push_back("v" + nv[i]); // if nv , add V
    }

    return paths;

}


int main(int argc , char** argv){
    
    vector<string> paths = gmp(0, 0, 2, 2);
    for(int i = 0; i < paths.size(); i++)
    {
        cout << paths[i] << endl;
    }

}