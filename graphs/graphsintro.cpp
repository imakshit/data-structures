#include<iostream>
#include<vector>

using namespace std;
//1
class Edge{
    public:
        int nbr;
        int wt;
};
//2
vector<vector<Edge>> graph;

//5
void addEdge(int v1 , int v2 , int w){
    Edge e1;
    e1.nbr = v2;
    e1.wt = w;
    graph[v1].push_back(e1);

    Edge e2;
    e2.nbr = v1;
    e2.wt = w;
    graph[v2].push_back(e2);
}

//6
void display(){
    for(int v = 0 ; v<graph.size() ; v++){
        cout<<v<<"->";
        for(int n =0 ; n<graph[v].size() ; n++){
            Edge ne = graph[v][n];
            cout<<"["<<ne.nbr<<"-"<<ne.wt<<"]";
        }
        cout<<endl;
    }
}

// bool haspath(int v1 , int v2){
//      bool temp = false;
// for(int n = 0 ; n<graph[v1].size() ; n++){
   
//     if(graph[v1][n].nbr==v2){
//         temp = true;
//     }
// }
// return temp;

// }


bool haspath(int s , int d , vector<bool>& visited){
    if(s==d){
        return true;
    }
    visited[s] = true;
    
    for(int n = 0 ; n<graph[s].size() ; n++){
      
            Edge ne = graph[s][n];
            if(visited[ne.nbr]==false){
            bool hpfntod = haspath(ne.nbr , d , visited); //has path from neighbour to destination
            if(hpfntod==true){
                return hpfntod;
            }
            
        }

    }
    return false;
    
}


void printallpaths(int s , int d , vector<bool>& visited , string psf , int dsf){
    if(s==d){
        cout<<psf<<"&"<<dsf<<endl;
        return;
    }
     visited[s] = true;
    for(int n =0 ; n<graph[s].size() ; n++){
        Edge ne = graph[s][n];
        if(visited[ne.nbr]==false){
            printallpaths(ne.nbr , d , visited , psf+to_string(s) , dsf+ne.wt);
        }
    }
    visited[s] = false;



}




int main(int argc , char** argv){
    //3
    graph.push_back(vector<Edge>());
    graph.push_back(vector<Edge>());
    graph.push_back(vector<Edge>());
    graph.push_back(vector<Edge>());
    graph.push_back(vector<Edge>());
    graph.push_back(vector<Edge>());
    graph.push_back(vector<Edge>());
    graph.push_back(vector<Edge>());

    //4
    addEdge(0,1,10);
    addEdge(1,2,10);
    addEdge(2,3,10);
    addEdge(0,3,40);
    addEdge(3,4,2);
    addEdge(4,5,3);
    addEdge(5,6,3);
    addEdge(4,6,8);

    display();
    // bool k  = haspath(0,1);
    // cout<<k;

    vector<bool> visited (7,false);
    //cout<<haspath(0,6,visited);
    printallpaths(1 , 6 , visited , "" , 0);
    

}