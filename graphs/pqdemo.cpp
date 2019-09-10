#include<iostream>
#include<queue>

using namespace std;

void demo1()
{
    // priority_queue<int> pq;
    priority_queue<int, vector<int>, less<int>> pq;
    pq.push(10);
    pq.push(50);
    pq.push(2);
    pq.push(8);
    pq.push(18);

    while(pq.size() > 0)
    {
        int val = pq.top();
        pq.pop();
        cout << val << " ";
    }
    cout << endl;
}

void demo2()
{
    priority_queue<int, vector<int>, greater<int>> pq;
    pq.push(10);
    pq.push(50);
    pq.push(2);
    pq.push(8);
    pq.push(18);

    while(pq.size() > 0)
    {
        int val = pq.top();
        pq.pop();
        cout << val << " ";
    }
    cout << endl;
}

class Event {
    public:
        int s;
        int e;

        bool operator<(const Event& other) const
        {
            return this->e - this->s < other.e - other.s;
        }

        bool operator>(const Event& other) const
        {
            return this->e - this->s > other.e - other.s;
        }
};

void demo3()
{
    priority_queue<Event, vector<Event>, greater<Event>> pq;

    Event e1;
    e1.s = 1005;
    e1.e = 1050;
    pq.push(e1);

    Event e2;
    e2.s = 1000;
    e2.e = 1130;
    pq.push(e2);

    Event e3;
    e3.s = 1040;
    e3.e = 1110;
    pq.push(e3);

    Event e4;
    e4.s = 1020;
    e4.e = 1030;
    pq.push(e4);

    Event e5;
    e5.s = 900;
    e5.e = 1000;
    pq.push(e5);

    while(pq.size() > 0)
    {
        Event e = pq.top();
        pq.pop();
        cout << e.s << " " << e.e << endl;
    }
}

int main(int argc, char** argv)
{
    demo3();
    // Event e1;
    // e1.s = 2;
    // e1.e = 5;

    // Event e2;
    // e2.s = 1;
    // e2.e = 6;

    // e1.operator<(e2); // e1 < e2
}







