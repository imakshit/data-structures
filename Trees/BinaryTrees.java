import java.util.*;

public class BinaryTrees{

    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(){

        }
        public Node(int data , Node left , Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static Node construct(int[] arr){
        Stack<Node> stack = new Stack<>();
        Node root = null;
        for(int val:arr){
           
            if(val==-1){
                stack.pop();
            }else{
                Node node = new Node();
                node.data = val;
                if(stack.isEmpty()){
                    root = node;
                }else{
                    if(stack.peek().left==null){
                        stack.peek().left = node;
                    }else{
                        stack.peek().right = node;
                    }
                }
                stack.push(node);
            }
        }
        return root;
    }

    public static void display(Node node){
        if(node == null){
            return;
        }
        String str = "";
        str += node.left != null? node.left.data+" -> " : ". -> ";
        str += node.data;
        str += node.right != null? " <- "+node.right.data : " <- .";
        System.out.println(str);
        
        display(node.left);
        display(node.right);

    }

    public static int size(Node node){
        int size = 0;
        if(node == null){
            return 0;
        }
        size+=size(node.left);
        size+=size(node.right);
        return size+1;
    }

    public static int max(Node node){
        if(node == null){
            return Integer.MIN_VALUE;
        }
        int max = node.data;
       
        int leftmax = max(node.left);
        int rightmax = max(node.right);
        int maxoftwo = Math.max(leftmax, rightmax);
        max = Math.max(max, maxoftwo);

        return max;
    }

    public static int height(Node node){
        if(node==null){
            return 0;
        }
        int ht = -1;
        int lht = height(node.left);
        int rht = height(node.right);
        ht = Math.max(lht,rht);

        return ht+1;

    }

    public static boolean find(Node node , int data){
        if(node==null){
            return false;
        }
        if(node.data==data){
            return true;
        }
        boolean lr = find(node.left, data);
        if(lr){
            return true;
        }
        boolean rr = find(node.right, data);
        if(rr){
            return true;
        }
        return false;
    }

    public static ArrayList<Integer> NodeToRootPath(Node node , int data){
        if(node==null){
            ArrayList<Integer> res = new ArrayList<>();
            return res;
        }
        if(node.data==data){
            ArrayList<Integer> bres = new ArrayList<>();
            bres.add(node.data);
            return bres;
        }
        if(node.left!=null){
            ArrayList<Integer> lc = NodeToRootPath(node.left , data);
            if(lc.size()>0){
                lc.add(node.data);
                return lc;
            }
        }if(node.right!=null){
            ArrayList<Integer> rc = NodeToRootPath(node.right , data);
            if(rc.size()>0){
                rc.add(node.data);
                return rc;
            }
        }     
       
        ArrayList<Integer> lis = new ArrayList<>();      

        return lis;
    }

    public static void removeleaves(Node node){
        if(node==null){
            return;
        }
        if(node.left!=null && node.left.left==null && node.left.right==null){
            node.left=null;
            
        }  
        if(node.right!=null && node.right.left==null && node.right.right==null){
            node.right=null;
            
        }      
        removeleaves(node.left);
        removeleaves(node.right);   
       }

    public static void printsinglechild(Node node){
        if(node==null){
            return;
        }
        if(node.left==null && node.right==null){
            System.out.println(node.data);
        }
        printsinglechild(node.left);
        printsinglechild(node.right);
    }

    public static Node rigth2(Node node){
        if(node == null){
            return null;
        }else if(node.left==null && node.right==null){
            return null;
        }else{
            node.left = rigth2(node.left);
            node.right = rigth2(node.right);
            return node;
        }
    }


    public static void pir(Node node  , int lo , int hi , int ssf , String psf)
    {
        if(node==null){
            return;
        }        
        if(node.left==null && node.right==null){
            ssf += node.data; //add last node data to sum
            psf+= " "+node.data; //add last node data to path and then compare
            if(ssf>=lo && ssf<=hi){
                System.out.println(psf);
            }
        }
        pir(node.left , lo , hi , ssf+node.data , psf+" "+node.data);
        
        pir(node.right , lo , hi , ssf+node.data , psf+" "+node.data);
    }

    public static Node transformLD(Node root){
        if(root==null){
            return null;
        }        
        root.left = transformLD(root.left);
        root.right = transformLD(root.right);
        root.left = new Node(root.data ,root.left , null);         
        return root;
    }

    public static Node tranformfromLD(Node node){
        if(node==null){
            return null;
        }
        node.left = tranformfromLD(node.left.left);
        node.right = tranformfromLD(node.right);
        return node;
    }

    public static Node construct2(int[] pre , int psi , int pei , int[] in , int isi , int iei){
        if(psi>pei || isi>iei){
            return null;
        }
        
        Node node = new Node();

        node.data = pre[psi];

        int x = 0;
        for(int i = isi ; i<=iei ; i++){
            if(in[i]==node.data){
                x = i;
                break;
            }
        }
        int lhs = x-isi;
        node.left = construct2(pre , psi+1 , psi+lhs , in , isi , x-1);        
        node.right = construct2(pre , psi+lhs, pei , in , x+1 , iei);


        return node;
    }

    static Node constructPostIn(int[] post,int psi,int pei,int[] in,int isi,int iei){
        if(psi>pei || isi>iei){
            return null;
        }
        
        Node node = new Node();
        node.data = post[pei];
    
        int x=0;
        for(int i=isi;i<=iei;i++){
            if(in[i] == post[pei]){
                x=i;
                break;
            }
        }
        int lhs = x-isi;
        node.left = constructPostIn(post, psi, psi+lhs-1, in, isi, x-1);
        node.right = constructPostIn(post, psi+lhs, pei-1, in, x+1, iei);
        return node;
        }
   
        static Node constructPrePost(int[] pre,int presi,int preei,int[] post,int postsi,int postei){
            //base case work remain
            // if(presi>preei || postsi>postei){
            //     return null;
            // }
            

            Node node = new Node();
            node.data = post[postei];
        
            int x=0;
            for(int i=postsi;i<=postei;i++){
                if(pre[presi+1]==post[i]){
                    x=i;
                    break;
                }
            }
            int lhs = x-postsi+1;
            node.left = constructPostIn(pre,presi+1,presi+lhs, post, postsi,x);
            node.right = constructPostIn(pre, presi+lhs+1, preei,post, x+1,postei-1);
            return node;
            }

            static class Pair{
                Node node;
                int state = 0;

                public Pair(Node node,int state){
                    this.node = node;
                    this.state = state;
                }
            }
            

            static void iterativeDFTraversals(Node root){
                ArrayList<Integer> pre = new ArrayList<>();
                ArrayList<Integer> in = new ArrayList<>();
                ArrayList<Integer> post = new ArrayList<>();

                Stack<Pair> st = new Stack<>();
                Pair rtp = new Pair(root,0);
                st.push(rtp);

                while(st.size()>0){
                    Pair top = st.peek();
                    if(top.node==null){
                        st.pop();
                        continue;
                    }
                    if(top.state==0){
                        pre.add(top.node.data);
                        top.state++;
                        
                        st.push(new Pair(top.node.left,0));
                    }else if(top.state==1){
                        in.add(top.node.data);
                        top.state++;
                        
                        st.push(new Pair(top.node.right,0));
                    }else if(top.state==2){
                        post.add(top.node.data);
                        st.pop();    
                    }                    
                }
                System.out.println("Pre ->"+ pre);
                System.out.println("In ->"+ in);
                System.out.println("Post ->"+ post);
            }

            static class Diapair{
                int dia;
                int ht;
            }

            public static Diapair diameter2(Node node){
                if(node==null){
                    Diapair bp = new Diapair();
                    bp.ht=0;
                    bp.dia=0;
                    return bp;
                }
                Diapair lp = diameter2(node.left);
                Diapair rp = diameter2(node.right);
                Diapair mp = new Diapair();
                mp.dia = Math.max(lp.ht+rp.ht+1 , Math.max(lp.dia, rp.dia));
                mp.ht = Math.max(lp.ht,rp.ht)+1;
                return mp;
            }


            static class Balpair{
                boolean isBal;
                int ht;
            }

             static Balpair isBalanced(Node node){
                 if(node==null){
                     Balpair bp = new Balpair();
                     bp.ht = 0;
                     bp.isBal = true;
                     return bp;
                 }

                Balpair lp = isBalanced(node.left);
                Balpair rp = isBalanced(node.right);
                Balpair mp = new Balpair();
                mp.ht = Math.max(lp.ht, rp.ht)+1;
                mp.isBal = lp.isBal && rp.isBal && Math.abs(lp.ht-rp.ht) <=1;

                return mp;
             }

            static boolean isBal = true;

            static int HeightForisBal(Node node ){
                if(node==null){
                    return 0;
                }               

                int lh = HeightForisBal(node.left);
                int rh= HeightForisBal(node.right);

                if(Math.abs(lh-rh)>1){
                    isBal = false;
                }               

                return Math.max(lh,rh)+1;

            }

        static class BSTpair{
            int min;
            int max;
            boolean isBst;
            Node lbstnode;
            int lbstsize;
            //lbst = largest binary search tree
        }

        static BSTpair isBST(Node node){
            if(node == null){
                BSTpair bp = new BSTpair();
                bp.min = Integer.MAX_VALUE;
                bp.max = Integer.MIN_VALUE;
                bp.isBst = true;
                bp.lbstnode = null;
                bp.lbstsize = 0;
                return bp;            
            }

            BSTpair lp = isBST(node.left);
            BSTpair rp = isBST(node.right);

            BSTpair mp = new BSTpair();

            mp.min = Math.min(node.data , Math.min(lp.min , rp.min));
            mp.max = Math.max(node.data , Math.max(lp.max , rp.max));

            mp.isBst = lp.isBst && rp.isBst && node.data>lp.max && node.data<rp.min;
            
            if(mp.isBst){
                mp.lbstnode = node;
                mp.lbstsize = lp.lbstsize + rp.lbstsize + 1;
            }else{
                if(lp.lbstsize > rp.lbstsize){
                    mp.lbstnode = lp.lbstnode;
                    mp.lbstsize = lp.lbstsize;
                }else{
                    mp.lbstnode = rp.lbstnode;
                    mp.lbstsize = rp.lbstsize;
                }
            }
            return mp;
        }


        public static ArrayList<Node> NodeToRootPath2(Node node , int data){
            if(node==null){
                ArrayList<Node> res = new ArrayList<>();
                return res;
            }
            if(node.data==data){
                ArrayList<Node> bres = new ArrayList<>();
                bres.add(node);
                return bres;
            }
            if(node.left!=null){
                ArrayList<Node> lc = NodeToRootPath2(node.left , data);
                if(lc.size()>0){
                    lc.add(node);
                    return lc;
                }
            }if(node.right!=null){
                ArrayList<Node> rc = NodeToRootPath2(node.right , data);
                if(rc.size()>0){
                    rc.add(node);
                    return rc;
                }
            } 
            return new ArrayList<>();
        }
        public static void printkfar(Node node , int data , int k){

            ArrayList<Node> path = NodeToRootPath2(node, data);
            printKdown(path.get(0), k, null);
            for(int i = 1 ; i<path.size() ; i++){
                printKdown(path.get(i), k-1, path.get(i-1));
            }

        }

        public static void printKdown(Node node , int k, Node blocker){
            if(node==null || k<0 || node == blocker){
                return;
            }
            if(k==0){
                System.out.println(node.data);
                return;
            }if(node.left!=null){
                printKdown(node.left, k-1, blocker);

            }if(node.right!=null){
                printKdown(node.right, k-1, blocker);
            }
            return;
        }



    public static void main(String[] args){
       // int[] arr = {50,25,12,-1,37,30,-1, 40,-1,-1,-1,75,62,60,-1,70,-1,-1,87,-1,-1,-1};
        //int[] arr = {10,20,30,-1,-1,40,50,60,-1,-1,-1,-1};
        //int[] arr = {10,20,30,-1,40,-1,-1,50,-1,-1};
        int[] arr = {50 , 25 , 12 , -1, 37 , 30 , -1 , 49 , -1, -1, -1, 75 , 62 , 60 , -1 , 70 , -1 ,-1 ,87 , 80 , -1 , 90 , -1 , -1, -1};
        int[] pre = {50,25,12,37,30,75,62,70,87};
        int[] in = {12,25,30,37,50,62,70,75,87};
        int[] post = {12,30,37,25,70,62,87,75,50};
        Node root = construct(arr);
        //System.out.println(root.data+" "+root.left.data+" "+root.right.data);
        // System.out.println("Elements in tree are: ");
        // display(root);
        // System.out.println("size of tree is: " + size(root));
        // System.out.println("Max is: " + max(root));
        // System.out.println("Height is: "+ height(root));
        // System.out.println("find 87: "+find(root,87 ));
        // System.out.println("path from 40 to root: "+ NodeToRootPath(root, 40));
        // System.out.println("removed leaves display: ");
        // removeleaves(root);
        // display(root);

        // System.out.println("tranform to left: ");
        // transformLD(root);
        // display(root);

        // System.out.println("transform from left: ");
        // tranformfromLD(root);
        // display(root);
        
        // System.out.println("single childs: ");
        // printsinglechild(root);
        // System.out.println("pir for 150 to 250: ");
        // pir(root, 150, 250, 0,"");

        // Diapair rp = diameter2(root);
        // System.out.println("diameter 2: "+rp.dia);

        Balpair bp = isBalanced(root);
        System.out.println("is balanced: "+bp.isBal);

        System.out.println("Height for is balanced: "+HeightForisBal(root) +" "+ isBal);

        BSTpair tbp = isBST(root);
        System.out.println("isBST: "+ tbp.isBst);
        System.out.println("largest bst: "+tbp.lbstnode.data);
        System.out.println("largest bst size: "+tbp.lbstsize);
        System.out.println("k down where k = 2 : ");
        printKdown(root,2, null);
        System.out.println("Kfar from 75 where k = 2: ");
        printkfar(root,75 , 2 );
    }
    
}