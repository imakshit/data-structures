#include <iostream>
#include <vector>
#include <climits>
#include<queue>

//haspath
//allpaths
//hamiltonian
//smallest distance
//largest distance
//ceil
//floor
//bfs
//getconnected components

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

//6
void display()
{
    for (int v = 0; v < graph.size(); v++)
    {
        cout << v << "->";
        for (int n = 0; n < graph[v].size(); n++)
        {
            Edge ne = graph[v][n];
            cout << "[" << ne.nbr << "-" << ne.wt << "]";
        }
        cout << endl;
    }
}
//7
bool haspath(int s, int d, vector<bool> &visited)
{
    if (s == d)
    {
        return true;
    }
    visited[s] = true;

    for (int n = 0; n < graph[s].size(); n++)
    {

        Edge ne = graph[s][n];
        if (visited[ne.nbr] == false)
        {
            bool hpfntod = haspath(ne.nbr, d, visited); //has path from neighbour to destination
            if (hpfntod == true)
            {
                return hpfntod;
            }
        }
    }
    return false;
}

int sd = INT_MAX; //min problem
int ld = INT_MIN;//max problem
string sdp;//smallest distance path
string ldp;//largest distance path
int cd = INT_MAX; //qualified min problem
string cdp;//ceil path
int fd = INT_MIN; //qualified max problem
string fdp;//floor path
int kd = INT_MAX;
string kdp;
//8
void printallpaths(int s, int d, vector<bool> &visited, string psf, int dsf, int factor )
{
    if (s == d)
    {
        psf = psf + to_string(d);
        cout << psf << "&" << dsf << endl;
        //smallest path
        if (dsf < sd)
        {
            sd = dsf;
            sdp = psf;
        }
        //largest path
        if (dsf > ld)
        {
            ld = dsf;
            ldp = psf;
        }
        //ceil
        if (dsf > factor && dsf < cd)
        {
            cd = dsf;
            cdp = psf;
        }
        //floor
        if (dsf < factor && dsf > fd)
        {
            fd = dsf;
            fdp = psf;
        }
       

        return;
    }
    visited[s] = true;
    for (int n = 0; n < graph[s].size(); n++)
    {
        Edge ne = graph[s][n];
        if (visited[ne.nbr] == false)
        {
            printallpaths(ne.nbr, d, visited, psf + to_string(s), dsf + ne.wt, factor);
        }
    }
    visited[s] = false;
}
//9
void hamiltonian(int s, vector<bool>& hamil, int csf, string hpsf, int os)
{
    if (csf == graph.size() - 1)
    {
        hpsf += to_string(s);
        cout << hpsf;

        for (int n = 0; n < graph[s].size(); n++)
        {
            Edge ne = graph[s][n];
            if (ne.nbr == os)
            {
                cout << "*" << endl;
                return;
            }
        }
        cout << "." << endl;
        return;
    }

    hamil[s] = true;
    for (int n = 0; n < graph[s].size(); n++)
    {
        Edge ne = graph[s][n];
        if (hamil[ne.nbr] == false)
        {
            hamiltonian(ne.nbr, hamil, csf + 1, hpsf + to_string(s), os);
        }
    }
    hamil[s] = false;
}


bool bfs(int s , int d){
    vector<bool> visited(graph.size() , false);
    queue<int> q;
    q.push(s);
    while(q.size()!=0){
        int rem = q.front();//get
        q.pop();//remove
        if(visited[rem]==true){
            continue;
        }
        visited[rem]=true;//mark

        if(rem==d){
            return true;//print / if destination reached just return
        }
        //mark* will be done if we will print
        //one check for marked or not will be added too
        for(int n =0 ; n<graph[rem].size() ; n++){
            Edge ne = graph[rem][n];
            if(visited[ne.nbr] == false){
                q.push(ne.nbr); //add neighbour
            }
        }         

    }
    return false;
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
    graph.push_back(vector<Edge>());
    graph.push_back(vector<Edge>());
    graph.push_back(vector<Edge>());
    graph.push_back(vector<Edge>());
    graph.push_back(vector<Edge>());
    graph.push_back(vector<Edge>());
    graph.push_back(vector<Edge>());
    

    //4
    addEdge(0, 1, 10);
    addEdge(1, 2, 10);
    addEdge(2, 3, 10);
    addEdge(0, 3, 40);
    addEdge(3, 4, 2);
    addEdge(4, 5, 3);
    addEdge(5, 6, 3);
    addEdge(4, 6, 8);
    //addEdge(2, 5, 5);

    //display();
    // bool k  = haspath(0,1);
    // cout<<k;

    // vector<bool> visited(7, false);
    // vector<bool> hamil (7,false);
    //cout<<haspath(0,6,visited);
     //printallpaths(0 , 6 , visited , "" , 0 , 45 );
    // cout<<"smallest path: "<<sdp<<" & "<<sd<<endl;
    // cout<<"largest path: "<<ldp<<" & "<<ld<<endl;
    // cout<<"ceil path: "<<cdp<<" & "<<cd<<endl;
    // cout<<"largest path: "<<fdp<<" & "<<fd<<endl;
    
    // hamiltonian(0, visited, 0, "", 0);
    
    //cout<<bfs(0,3);    
    cout<<endl;

    vector<string> comps = gcc();
    for(int i =0 ; i<comps.size() ; i++){
    cout<<comps[i]<<endl;
    }
}