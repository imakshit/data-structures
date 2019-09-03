import java.util.*;
public class GenericTrees{


    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();

        public Node(int data){
            this.data = data;
        }
    }

    public static Node constructor(int[] arr){
        LinkedList<Node> st = new LinkedList<>(); //linked list defined
        Node root = null; //root node initialise
        for(int i =0; i<arr.length; i++){
        if(arr[i]==-1){
            st.removeFirst(); //if -1 , pop
            }else{
                Node node = new Node(arr[i]); //initialise node
                if(st.size()==0){
                    root = node; //first node will be root
                }else{
                    st.getFirst().children.add(node); //push children
                }
                st.addFirst(node); //add the node to tree

            }
        }
        return root; //return root , we can use root now to iterate through the tree
    }


    public static void display(Node root){

        System.out.print(root.data+" -> ");
        for(Node child : root.children){
            System.out.print(child.data+" ");
        }
        System.out.println();


        for(Node child:root.children){
            display(child);
        }
    }


    public static boolean find(Node root , int data){
        if(root.data == data){
            return true;
        }
        for(Node child : root.children){
            boolean res = find(child , data);
            if(res){
                return true;
            }
        }
        return false;
    }

    public static int minimum(Node root){
        int minoverall = root.data;
        for(Node child : root.children){
            int allelements = minimum(child);
            minoverall = Math.min(minoverall , allelements);
        }
    
        return minoverall;
    }
    public static int max(Node root){
        int maxoverall = root.data;
        for(Node child : root.children){
            int allelements = max(child);
            maxoverall = Math.max(maxoverall , allelements);
        }
    
        return maxoverall;
    }



    public static int height(Node root){
        //initialise height with 0 to get height in terms of nodes 
       // with -1 to get in terms of edges
        int height = -1;
        for(Node child : root.children){
        
        int recAns = height(child);
        height = Math.max(height ,recAns);
        }
        return height+1;
    }

    public static int sizeoftree(Node root){
        int size = 0;        
        for(Node child: root.children){
           size+=sizeoftree(child);         
        } 
         return size+1;
    }

    public static ArrayList<Node> RootToNodePath(Node root , int data){
        
        if(root.data==data){       
            ArrayList<Node> bres = new ArrayList<>();
            bres.add(root);
            return bres;
        }       
            for(Node child : root.children){
                ArrayList<Node> res=  RootToNodePath(child, data);
                if(res.size()>0){
                    res.add(root);
                    return res;
                }
            }
            
        return new ArrayList<>();      
    }

    public static int lowestcomans(Node root ,int n1 , int n2){
        if(find(root , n1) && find(root , n2)){
                        
            ArrayList<Node> path1 = RootToNodePath(root, n1);
            ArrayList<Node> path2 = RootToNodePath(root, n2);
            for(int i = path1.size()-1  , j=path2.size()-1 ; i>=0 && j>=0 ; i-- , j--){
               
                if(path1.get(i)!=path2.get(j)){
                    return path1.get(i+1).data;            
                } 
                else if(i==0){
                    return path1.get(0).data;    
                }else if(j==0){
                    return path2.get(0).data;
                }
            }
            return 0;           
        }
        else{
            return -1;
        }       
    }

    public static void levelOrderTrav(Node root){
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            //remove first
            //print first
            //add children
            
            Node node = queue.removeFirst();
            System.out.print(node.data+" ");

            for(Node child : node.children){
                queue.addLast(child);
            }  
        }

             
    }
    //level order line wise
    public static void levelOrderLineWise(Node root){
        LinkedList<Node> queue1 = new LinkedList<>();
        LinkedList<Node> queue2 = new LinkedList<>();
        queue1.addLast(root);
        while(!queue1.isEmpty()){
            Node node = queue1.removeFirst();
            System.out.print(node.data+" ");

            for(Node child : node.children){
                queue2.addLast(child);
            } 

            if(queue1.size()==0){
                System.out.println();
                LinkedList<Node> temp = queue1;
                queue1 = queue2;
                queue2 = temp;      
            }
        }
        }         
      
    
    public static void levelOrderLineWiseType2(Node root){
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);
        queue.addLast(null);
        while(queue.size()>1)
        {
            Node node = queue.removeFirst();            
            System.out.print(node.data+" ");
            for(Node child:node.children){
                queue.addLast(child);
            }
            if(queue.getFirst()==null){
                System.out.println();
                queue.removeFirst();            
                queue.addLast(null);
            }
        }
        }
    

    public static void levelOrderLineWiseType3(Node root){
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);
        while(queue.size()>0){
            int size = queue.size();
            while(size-->0){
                Node node = queue.removeFirst();
                System.out.print(node.data+" ");
                for(Node child : node.children){
                    queue.addLast(child);
                    
                }
            }System.out.println();
        }
    }


    public static void zigzagTrav(Node root){
        LinkedList<Node> st1 = new LinkedList<>();
        LinkedList<Node> st2 = new LinkedList<>();
        boolean flag = false;
        st1.addFirst(root);
        while(st1.size()>0){
            Node node  = st1.removeFirst();
            System.out.print(node.data+" ");
            if(flag){
                for(Node child : node.children){
                    st2.addFirst(child);
                }
            }else{
                for(int i =node.children.size()-1 ; i>=0 ; i--){
                    Node child = node.children.get(i);
                    st2.addFirst(child);
                }

            }

            if(st1.isEmpty()){
                System.out.println();
                LinkedList<Node> temp = st1;
                st1 = st2;
                st2 = temp;

                flag = !flag;
            }
        }       
       
    }

    public static void kthlargest(Node root , int k){
          int largest =Integer.MAX_VALUE;
          HeapMovePair pair = new HeapMovePair();
          for(int i = 0  ; i<k ; i++){
              multiSolver(root, largest, pair);
              largest = pair.floor;
              pair.floor = Integer.MIN_VALUE;
          } 
          System.out.println(largest);
    }

    public static void kthsmallest(Node root, int k){
        int smallest =Integer.MIN_VALUE;
        HeapMovePair pair = new HeapMovePair();
        for(int i = 0  ; i<k ; i++){
            multiSolver(root, smallest, pair);
            smallest = pair.floor;
            pair.ceil = Integer.MAX_VALUE;
        } 
        System.out.println(smallest);

    }


    public static class HeapMovePair{
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        boolean find = false;

        int pred = -1;
        int succ = -1;

        int prev = -1;

        int ceil = Integer.MAX_VALUE;
        int floor = Integer.MIN_VALUE;
    }

    public static void multiSolver(Node root , int data , HeapMovePair pair){
        if(pair.find==false && root.data == data){
            pair.find = true;
            pair.pred = pair.prev;
        }

        if(pair.find && pair.prev==data){
            pair.succ = root.data;
        }
        
        pair.max = Math.max(pair.max, root.data);
        pair.min = Math.min(pair.min , root.data);

        if(root.data>data){
            pair.ceil = Math.min(root.data , pair.ceil);
        }

        if(root.data<data){
            pair.floor = Math.max(root.data , pair.floor);
        }

        pair.prev = root.data;

        for(Node child : root.children){
            multiSolver(child, data, pair);
        }

    }

    public static void multisolver(Node root){
        HeapMovePair pair = new HeapMovePair();
        multiSolver(root,80 , pair);
        System.out.println();
        System.out.println("for data = 80: ");
        System.out.println("max is: "+pair.max);
        System.out.println("min is: "+pair.min);
        System.out.println("find is: "+pair.find);
        System.out.println("predecessor is: "+pair.pred);
        System.out.println("successor is: "+pair.succ);
        System.out.println("ceil is: "+pair.ceil);
        System.out.println("floor is: "+pair.floor);
    }





    public static void main(String[] args){
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = constructor(arr);
        display(root);
        System.out.println();
        System.out.println("Is 30 present in the given tree? "+find(root , 30));
        System.out.println("minimum element is: "+ minimum(root));
        System.out.println("maximum element is: "+max(root));
        System.out.println("height of tree is: "+height(root));
        System.out.println("size is: "+sizeoftree(root));
        System.out.println("Lowest common ancestor of 70 and 110 is: "+  lowestcomans(root, 70 , 110));       
        System.out.println("Level order traversal: ");
        levelOrderTrav(root);       
        System.out.println("\nLevel order traversal line wise: ");
        levelOrderLineWise(root);
        System.out.println("\ntype 2: ");
        levelOrderLineWiseType2(root);
        System.out.println("\ntype 3: ");
        levelOrderLineWiseType3(root);
        System.out.println("\nzig-zag traversal: ");
        zigzagTrav(root);
        multisolver(root);

    }

}