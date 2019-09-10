#include <iostream>
#include <vector>
#include <climits>
#include<queue>

using namespace std;
//1
class Edge
{
public:
    int nbr;
    int wt;
};
//2
vector<vector<Edge>> graph;

//5
void addEdge(int v1, int v2, int w)
{
    Edge e1;
    e1.nbr = v2;
    e1.wt = w;
    graph[v1].push_back(e1);

    Edge e2;
    e2.nbr = v1;
    e2.wt = w;
    graph[v2].push_back(e2);
}

string gscc(int r , vector<bool>& visited){
    string comp = "";
    queue<int> q;
    q.push(r);
    while(q.size()>0){
        int rem = q.front();
        q.pop();

        if(visited[rem]==true){
            continue;
        }
        visited[rem] = true;

        comp+=to_string(rem);

        for(int n=0 ; n<graph[rem].size() ; n++){
            Edge ne = graph[rem][n];
            if(visited[ne.nbr]==false){
                q.push(ne.nbr);
            }
        }

    }
    return comp;
    
}


vector<string> gcc(){
    vector<string> comps;
    vector<bool> visited(7,false);
    for(int v =0 ; v< graph.size() ; v++)
    {
        if(visited[v]==false){
            string comp = gscc(v , visited);
            comps.push_back(comp);
        }

    }
return comps;
}

int main(int argc, char **argv)
{
    //3
    // graph.push_back(vector<Edge>());
    // graph.push_back(vector<Edge>());
    // graph.push_back(vector<Edge>());
    // graph.push_back(vector<Edge>());
    // graph.push_back(vector<Edge>());
    // graph.push_back(vector<Edge>());
    // graph.push_back(vector<Edge>());
    

//     //4
//     addEdge(0, 1, 10);
//     addEdge(1, 2, 10);
//     addEdge(2, 3, 10);
//     addEdge(0, 3, 40);
//     addEdge(3, 4, 2);
//     addEdge(4, 5, 3);
//     addEdge(5, 6, 3);
//     addEdge(4, 6, 8);
//     //addEdge(2, 5, 5);
 
 int n = 10;
 vector<int> v1 = {9,5,2,3,6,1};
 vector<int> v2 = {4,3,0,7,8,4};

 for(int v = 0 ; v<n ; v++){
     graph.push_back(vector<Edge>());
 }

 for(int e =0 ; e<v1.size() ; e++){
     addEdge(v1[e] , v2[e] , 1);
 }

vector<string> nations = gcc();

int teams = 0;
for(int i =0 ; i<nations.size() ; i++){
    for(int j = i+1 ; j<nations.size() ; j++){
        teams+= nations[i].size() *nations[j].size();
    }
}

cout<<teams;



 
 }
