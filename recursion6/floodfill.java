import java.util.*;

public class floodfill{

public static void flood(int sr , int sc , int[][] maze , String psf){


    if(sr==maze.length-1 && sc==maze[0].length-1){
        System.out.println(psf);
        return;
    }

   

    maze[sr][sc]=2;//mark visited



    //tldr

    //top
    if(sr>0 && maze[sr-1][sc]!=1 && maze[sr-1][sc]!=2){
        flood(sr-1,sc,maze, psf+"t-");        
    }
    //left
     if(sc>0 && maze[sr][sc-1]!=1 && maze[sr][sc-1]!=2){
        flood(sr,sc-1,maze, psf+"l-");        
    }
    //down
      if(sr<maze.length-1 && maze[sr+1][sc]!=1 && maze[sr+1][sc]!=2){
        flood(sr+1,sc,maze, psf+"d-");        
    }
    //right
      if(sc<maze[0].length-1 && maze[sr][sc+1]!=1 && maze[sr][sc+1]!=2){
        flood(sr,sc+1,maze, psf+"r-");        
    }

    maze[sr][sc]=0;
}


    public static void main(String[] args){
        int[][] maze = {
            {0,1,0,0,0,0,0,1},
            {0,1,0,1,1,1,0,1},
            {0,1,0,1,0,0,0,1},
            {0,0,0,0,0,1,1,1},
            {0,1,0,1,0,0,0,0},
            {0,1,0,1,1,1,1,0},
            {0,1,0,1,1,1,1,0},
            {0,1,0,0,0,0,0,0}
            
        };
        //call
        flood(0,0,maze,"");
        
    }
}