import java.util.*;
public class firestorm3{

    static class point{
        int x;
        int y;
        int t;
    }

    static void solve(int[][] arr , int time){
        //QUEUE INTIALISATION
        ArrayDeque<point> q = new ArrayDeque<>();
        //ADDING ELEMENTS TO QUEUE
        for(int i = 0 ; i<arr.length; i++){
            for(int j = 0 ; j<arr[0].length ; j++){
                if(arr[i][j]==1){
                    point t0 = new point();
                    t0.x = i;
                    t0.y = j;
                    t0.t = 1;
                    q.addLast(t0);
                }
            }
        }
        while(q.size()>0){
            point rem = q.getFirst();//ET
            q.removeFirst();//REMOVE
            if(rem.t==time+2){
                break;
            }
            //for already burnt , we put -ve value
            if(arr[rem.x][rem.y]<0){
                continue;
            }
            arr[rem.x][rem.y] = -rem.t;

            //top pos
            if(rem.x-1>=0 && arr[rem.x-1][rem.y]==0){
                point np = new point();
                np.x = rem.x-1;
                np.y = rem.y;
                np.t = rem.t+1;
                q.addLast(np);
            }
            //left pos
            if(rem.y-1>=0 && arr[rem.x][rem.y-1]==0){
                point np = new point();
                np.x = rem.x;
                np.y = rem.y-1;
                np.t = rem.t+1;
                q.addLast(np);
            }
            //down pos
            if(rem.x+1 < arr.length && arr[rem.x+1][rem.y]==0){
                point np = new point();
                np.x = rem.x+1;
                np.y = rem.y;
                np.t = rem.t+1;
                q.addLast(np);
            }
            //right pos
            if(rem.y+1<arr[0].length && arr[rem.x][rem.y+1]==0){
                point np = new point();
                np.x = rem.x;
                np.y = rem.y+1;
                np.t = rem.t+1;
                q.addLast(np);
            }

        }
    }




    public static void main(String[] args){
        int[][] arr = {
            {1,2,0,2,0,0,0},
            {0,2,0,2,0,1,0},
            {0,0,0,2,0,0,0},
            {2,2,2,2,2,2,0},
            {0,2,1,0,0,0,0},
            {0,2,0,0,0,0,0},
            {0,2,0,0,0,0,0}
        };

        solve(arr,3);
        for(int i =0 ; i<arr.length ; i++){
            for(int j = 0 ; j<arr[0].length ; j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }

    }
}