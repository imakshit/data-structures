#include<iostream>
#include<vector>
#include<string>

using namespace std;


vector<string> gsp(int src){

if(src == 0)
   {
       vector<string> bp;
       bp.push_back("");
       return bp;
   }


    vector<string> stod;
    for(int step = 1 ; step<=3 ; step++){

        if(src>=step)//dont go in basement
        {

        int nbr = src - step; // calc neighbour
        vector<string> ntod = gsp(nbr); // paths from neighbour to destination

        for(int i =0 ; i<ntod.size() ; i++){
            string ntodpath = ntod[i]; // select a path from neighbour to destination
            string stodpath = to_string(step)+ntodpath; //add effort from source to neghbour to the path from neighbour to destination
            stod.push_back(stodpath);//add the result to resultant vector

        }
        }

    }
    return stod;
}

int main(int argc , char** argv){

   vector<string> paths = gsp(7);
   int counter = 0;

    for(int i = 0; i < paths.size(); i++)
    {
        cout << paths[i] << endl;
        counter++;
    }

    cout<<"total paths are: "<<counter;
}
