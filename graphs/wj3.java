import java.util.*;

public class wj3 {
    static class Pair {
        int j1;
        int j2;
        int level;
        String psf;
    }

    public static void main(String[] args){
        int j1 = 3;
        int j2 = 5;
        int m = 4;

        boolean[][] visited = new boolean[j1 + 1][j2 + 1];

        ArrayDeque<Pair> q = new ArrayDeque<>();
        Pair p = new Pair();
        p.j1 = 0;
        p.j2 = 0;
        p.level = 0;
        p.psf = "";
        q.addLast(p);

        while(q.size() > 0){
            Pair rem = q.getFirst();
            q.removeFirst();

            if(visited[rem.j1][rem.j2] == true){
                continue;
            }
            visited[rem.j1][rem.j2] = true;

            if(rem.j1 == m || rem.j2 == m){
                System.out.println(rem.psf + "@" + rem.level);
                break;
            }

            // fj1
            if(rem.j1 < j1){
                Pair np = new Pair();
                np.j1 = j1;
                np.j2 = rem.j2;
                np.level = rem.level + 1;
                np.psf = rem.psf + "f" + j1 + " ";
                if(visited[np.j1][np.j2] == false){
                    q.addLast(np);
                }
            }


            // fj2
            if(rem.j2 < j2){
                Pair np = new Pair();
                np.j1 = rem.j1;
                np.j2 = j2;
                np.level = rem.level + 1;
                np.psf = rem.psf + "f" + j2 + " ";
                if(visited[np.j1][np.j2] == false){
                    q.addLast(np);
                }
            }


            // ej1
            if(rem.j1 > 0){
                Pair np = new Pair();
                np.j1 = 0;
                np.j2 = rem.j2;
                np.level = rem.level + 1;
                np.psf = rem.psf + "e" + j1 + " ";
                if(visited[np.j1][np.j2] == false){
                    q.addLast(np);
                }
            }

            // ej2
            if(rem.j2 > 0){
                Pair np = new Pair();
                np.j1 = rem.j1;
                np.j2 = 0;
                np.level = rem.level + 1;
                np.psf = rem.psf + "e" + j2 + " ";
                if(visited[np.j1][np.j2] == false){
                    q.addLast(np);
                }
            }

            //mj1j2
            if(rem.j1 > 0 && rem.j2 < j2){
                int space = j2 - rem.j2;

                Pair np = new Pair();
                if(space > rem.j1){
                    np.j1 = 0;
                    np.j2 = rem.j2 + rem.j1;
                } else {
                    np.j1 = rem.j1 - space;
                    np.j2 = j2;
                }

                np.level = rem.level + 1;
                np.psf = rem.psf + "m" + j1 + j2 + " ";
                if(visited[np.j1][np.j2] == false){
                    q.addLast(np);
                }
            }

            //mj2j1
            if(rem.j2 > 0 && rem.j1 < j1){
                int space = j1 - rem.j1;

                Pair np = new Pair();
                if(space > rem.j2){
                    np.j1 = rem.j1 + rem.j2;
                    np.j2 = 0;
                } else {
                    np.j1 = j1;
                    np.j2 = rem.j2 - space;
                }

                np.level = rem.level + 1;
                np.psf = rem.psf + "m" + j2 + j1 + " ";
                if(visited[np.j1][np.j2] == false){
                    q.addLast(np);
                }
            }
        }
    }
}









