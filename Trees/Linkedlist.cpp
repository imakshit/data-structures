#include<iostream>
using namespace std;
class Node{
    public:
    int data;
    Node* next;

    Node(){
        this->data = 0;
        this->next = NULL; 
    }
    Node(int data,Node* next){
        this->data = data;
        this->next = next; 
        
    }
};

void display(Node* head){
    for(Node* i=head; i!=NULL; i=i->next){
        cout<<i->data<<" ";
    }cout<<endl;
}

void addLast(Node*& head,Node*& tail,int data){
    if(head==NULL){
        head = tail = new Node(data,NULL);
    }else{
        Node* nn = new Node(data,NULL);
        tail->next = nn;
        tail = nn;
    }
}
void addFirst(Node*& head,Node*& tail,int data){
    if(head==NULL){
        head = tail = new Node(data,NULL);
    }
    else{
        Node* nn = new Node(data,head);
        head = nn;
    }

}

int getFirst(Node* head){
    if(head==NULL){
        return 0;
    }
    return head->data;
}


int getLast(Node* tail){
    if(tail==NULL){
        return 0;
    }
    return tail->data;
}

int getAt(Node* head,int idx){
    if(head == NULL){
        return 0;
    }
    int j=0;
    for(Node* i=head; i!=NULL ; i = i->next){
        if(j==idx){
            return i->data;
        }
        j++;
    }
    return 0;
}

Node* getNodeAt(Node* head,int idx){
    if(head == NULL){
        return NULL;
    }
    int j=0;
    for(Node* i=head; i!=NULL ; i = i->next){
        if(j==idx){
            return i;
        }
        j++;
    }
    return NULL;
}

int getsize(Node* head){
    int counter = 0;
    Node* temp = head; 
    while(temp!=NULL){
        temp = temp->next;
        counter ++;
    }
    return counter;
}


void addAt(Node*& head,Node*& tail,int data,int idx){
    int sz=getsize(head);
   
    if(idx<0 || idx>sz){
        cout<<"Invalid index"<<endl;
    }
    else if(idx==0){
        addFirst(head,tail,data);
    }
    else if(idx==sz){
        addLast(head,tail,data);
    }else{
        Node* nm1 = getNodeAt(head,idx-1);
        nm1->next = new Node(data,nm1->next);
    }
    
}

void removeFirst(Node*& head,Node*& tail){
    if(head==NULL){//when size of ll is 0
        return;
    }
    else if(head->next == NULL){//when size of ll is 1
        Node* temp = head;
        head = tail = NULL;
        delete temp;
    }
    else{//when size of ll is >1
        Node* temp = head;
        head = head->next;
        delete temp;
    }
}

void removeLast(Node*& head,Node*& tail){
    if(head==NULL){//when size of ll is 0
    return;
    }
    else if(head->next == NULL){//when size of ll is 1
        Node* temp = head;
        head = tail = NULL;
        delete temp;
    }
    else{//when size of ll is >1
        int sz = getsize(head);
        Node* sl = getNodeAt(head,sz-2);//sl is second last node of ll

        sl->next = NULL;
        delete tail;//this will delete the last node of ll which is pointed by tail and tail become dangling pointer now
        tail = sl;//now tail will point to second last node of ll

    }

}

void removeAt(Node*& head,Node*& tail,int idx){
    int sz = getsize(head);
    if(idx<0 || idx>=sz){
        cout<<"Invalid index"<<endl;
    }
    else if(idx==0){
        removeFirst(head,tail);
    }
    else if(idx==sz-1){
        removeLast(head,tail);
    }
    else{
        Node* nm1 = getNodeAt(head,idx-1);
        Node* n = getNodeAt(head,idx);
        Node* np1 = getNodeAt(head,idx+1);

        nm1->next = np1;
        delete n;
    }
}

void ReverseDataIterative(Node* head,Node* tail){
    int sz = getsize(head);

    for(int i=0,j=sz-1;i<=j;i++,j--){
        Node* ni = getNodeAt(head,i);
        Node* nj = getNodeAt(head,j);

        int temp = ni->data;
        ni->data = nj->data;
        nj->data = temp;
    }
}

void ReversePointerIterative(Node*& head,Node*& tail){
    Node* prev = NULL;
    Node* curr = head;

    while(curr != NULL){
        Node* nxt = curr->next;
        curr->next = prev;

        prev = curr;
        curr = nxt;
    }
    Node* temp  = head;
    head = tail;
    tail = temp;
}


void DataRecursive(Node*& left , Node* right , int floor , int &sz){
    if(right==NULL){
        return;
    }
    sz++;
    DataRecursive(left , right->next , floor+1 , sz);
    if(floor>=sz/2){
        int temp = left->data;
        left->data = right->data;
        right->data = temp;
    }
    left = left->next;
}

bool ispalindrome(Node*& left , Node* right){
    if(right==NULL){
        return true;
    }
    bool res = ispalindrome(left , right->next);
    res = res && left->data==right->data;
    left = left->next;
    return res;
    
}

void fold(Node* &left , Node* right , int floor , int &size , Node* tail){
    if(right==NULL){
        return;
    }

    size++;
    fold(left , right->next , floor+1 , size  ,tail);
    if(floor>size/2){
        Node* temp = left->next;
        left->next = right;
        right->next = temp;
        left = temp;
    }else if(floor==size/2){
        tail = right;
        tail->next = NULL;
    }
}

int mid(Node* head ){
    Node* slow = head;
    Node* fast = head;
    while(fast->next!=NULL && fast->next->next!=NULL){
        slow = slow->next;
        fast = fast->next->next;
    }
    return slow->data;
}

int Kthfromlast(Node* head , int k){
    Node* slow  =head;
    Node* fast = head;
    int temp = 0;
    while(temp!=k){
        fast = fast->next;
        temp++;
    }
    while(fast!=NULL){
        slow = slow->next;
        fast = fast->next;
    }
    return slow->data;

}


Node* krevhelp(Node* &th , int k){
    Node* prev = NULL;
    Node* curr = th;
    for(int i =0 ; i<k; i++){

        Node* nxt = curr->next;
        curr->next = prev;
        prev = curr;
        curr = nxt;
    }
    th->next= curr;
    return prev;


}

void Kreverse(Node* &head , Node* &tail,int k){
    int sz = getsize(head);
    if(k>sz){
        return;
    }
    int counter = 0 ;
    Node* t1 = head;
    Node* t2 = krevhelp(head , k);
    head = t2;
    counter+=k;
    while(sz-counter>=k){
        Node* nt1= t1->next;
        Node* nt2 = krevhelp(nt1,k);
        t1->next = nt2;
        t1=nt1;
        counter+=k;
    }

    if(counter==sz){
        tail=t1;
    }  

}

// void kreverse2(Node* &head , Node* &tail , int k){
//     int sz = getsize(head);
//     Node* phead = NULL;
//     Node* ptail = NULL;
//     if(k>sz){
//         return;
//     }
//     while(head!=NULL && sz>=k){
//         Node* chead = NULL;
//         Node* ctail = NULL;

//         for(int i =0 ; i<k ; i++){
//             int temp = head->data;
//             removeFirst(head , tail);
//             addFirst(head , tail , temp);
//             sz--;
//         }
//         if(phead==NULL){
//             phead = chead;
//             ptail = ctail;
//         }else{
//             tail->next = chead;
//             ptail = ctail;
//         }

//          if(head==NULL){
            
//             head = phead;
//             tail = ptail;
//         }
//         else{
//           ptail->next = head;
//           head = phead;
//         }
       
//     }
   
// }


// void oddeven(Node* &head , Node* &tail){

//     Node* oh = NULL;
//     Node* ot = NULL;
//     Node* eh = NULL;
//     Node* et = NULL;

//     while(head!=NULL){
//         int temp = head->data;
//         removeFirst(head , tail);
//         if(temp%2==0){
//             addLast(eh , et ,temp);
//         }else{
//             addLast(oh ,ot , temp);
//         }
//     }

// }

// void removeDuplicate(Node* &head , Node* &tail){

//     Node* nh = NULL;
//     Node* nt = NULL;

//     while(head!=NULL){
//         int temp = head->data;
//         removeFirst(head , tail);
//         if(nh==NULL || nt->data!=temp){
//             addLast(nh , nt , temp);
//         }
//     }
//     head = nh;
//     tail = nt;
//     }

void floydwarshall(Node* head){

    Node* slow = head;    
    Node* fast = head;

    while(fast!=NULL && fast->next != NULL){
        slow = slow->next;
        fast = fast->next->next;

        if(slow==fast){
            cout<<"loop found!"<<endl;
            if(slow==head){
                while(slow->next!=head){
                    slow = slow->next;
                }
            }

            else{
            fast = head;
            while(slow->next!=fast->next){
                slow = slow->next;
                fast = fast->next;
            }
            }
            slow->next = NULL;
            display(head);
            break;
            
        }
    }


}
int intersection(Node* h1 , Node* h2){
    int sz1 = getsize(h1);
    int sz2 = getsize(h2);
    int diff = abs(sz1-sz2);
    Node* left = h1;
    Node* right = h2;

    //diff 0 case yet to be handled

    if(sz1>sz2){
        while(diff!=0){
            diff--;
            right = right->next;
        }
        return right->data;        
    }else{
         while(diff!=0){
            diff--;
            left = left->next;
        }
        return left->data;    

    }
    return 0;
}


void mergeSL(Node* h1 , Node* h2 , Node* &oh , Node* &ot){
    Node* t1 = h1;
    Node* t2 = h2;

    while(t1!=NULL && t2!=NULL){
        if(t1->data<t2->data){
            addLast(oh , ot , t1->data);
            //removeFirst instead of t1 = t1->next in order to handle memory leak
            //in case of merge sort
            //removeFirst will also set the head to next node
            //we not doing so cuz mergeSL will be used by other funcs too
            //make a new func to do so
            t1 = t1->next;
        }
        else{
            addLast(oh , ot , t2->data);
            t2 = t2->next;
        }
    }
    while(t1!=NULL){
        addLast(oh , ot , t1->data);
        t1 = t1->next;
    }
    while(t2!=NULL){
        addLast(oh , ot , t2->data);
        t2 = t2->next;

    }

    
}

//same as mid , just return Node and make use of tail 
Node* midNode(Node* head ,Node* tail){
    Node* slow = head;
    Node* fast = head;
    while(fast!=tail && fast->next!=tail){
        slow = slow->next;
        fast = fast->next->next;
    }
    return slow;
}

void mergesort(Node* &head , Node* &tail){

    if(head==tail){
        Node* nn = new Node(head->data , NULL);//make new node in order to preserve the older list
        head = tail = nn;
        return;
    }

    Node* mid = midNode(head, tail);//find mid

    Node* lh = head;
    Node* lt = mid;
    Node* rh = mid->next;
    Node* rt = tail;

    mergesort(lh , lt);//sort first half
    mergesort(rh ,rt);//sort second half

    Node* fh = NULL;
    Node* ft  =NULL;
    mergeSL(lh , rh , fh , ft);//sort the two lists
    head = fh;//re-initialise head
    tail = ft;//re-initialise tail

}




void imergeSL(Node* lh,Node* lt, Node* rh ,  Node* rt ,  Node* &oh , Node* &ot){
    Node* t1 = lh;
    Node* t2 = rh;
    Node* rm = NULL;
    while(t1!=NULL && t2!=NULL){        
        
        if(t1->data < t2->data){
            rm = t1;
            t1 = t1->next;
            rm->next = NULL;        
        }
        else{
            rm = t2;
            t2 = t2->next;
            rm->next = NULL;
        }

        if(oh==NULL){
            oh = ot = rm;
        }
        else{
            ot->next = rm;
            ot = rm;
        }
    }

    //if one of the lists is emptied and elements are left in second list
    if(t1!=NULL){
        ot->next = t1;
        ot = lt;
    }else{
        ot->next = t2;
        ot = rt;
    }

    

}


void imergesort(Node* &head , Node* &tail){

    if(head==tail){        
        return;
    }

    Node* mid = midNode(head, tail);//find mid

    Node* lh = head;
    Node* lt = mid;
    Node* rh = mid->next;
    Node* rt = tail;

    mid->next = NULL;//break them into two seperate lists
    imergesort(lh , lt);//sort first half
    imergesort(rh ,rt);//sort second half

    Node* fh = NULL;
    Node* ft  =NULL;
    imergeSL(lh , lt , rh , rt ,  fh , ft);//sort the two lists
    head = fh;//re-initialise head
    tail = ft;//re-initialise tail

}



int main(int argc,char** argv){
    Node* head = NULL;
    Node* tail  = NULL;
    
    addAt(head,tail,0,0);
    
    //removeFirst(head,tail);

    //addFirst(head,tail,60);

    addLast(head,tail,10);
    addLast(head,tail,20);
    addLast(head,tail,30);
    addLast(head,tail,40);
    addLast(head,tail,90);
    addLast(head,tail,60);

    //addFirst(head,tail,70);

    // addAt(head,tail,60,6);
    // //addAt(head,tail,200,3);
    // //display(head);
    // //removeLast(head,tail);
    // removeAt(head,tail,6);
    // removeAt(head,tail,3);

    //cout<<getsize(head)<<endl;

    display(head);
    //ReversePointerIterative(head,tail);
   // ReverseDataIterative(head,tail);
  //  display(head);

    
    // cout<<getFirst(head);
    // cout<<getLast(tail);
    // cout<<getAt(head,3);
    // cout<<getNodeAt(head,3)->data;


    // Node* left = head;
    // Node* right = head;
    // int sz = 0;
    // int floor = 0 ;

    // DataRecursive(left , right , floor , sz);
    // display(head);

    //cout<<"palindrome: "<<ispalindrome(left , right);

    // fold(left , right , floor , sz , tail);
    // display(head);

    // cout<<"mid is: "<<mid(head);
    // cout<<endl<<"kth from last: "<<Kthfromlast(head , 2)<<endl;
    // kreverse2(head, tail , 3);
    // display(head);
    //tail->next = head;
    //display(head);

    //floydwarshall(head);

    Node* nh = head;
    Node* nt = tail;
    // mergesort(oh , ot);
    // display(oh);
   // display(head);
   removeLast(head , tail);
    imergesort(nh , nt);
    display(nh);
    //display(head);









}