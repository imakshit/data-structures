import java.util.*;

public class magnets {
    static int[] left;
    static int[] top;
    static int[] bottom;
    static int[] right;

    static boolean cph(char[][] board, int i, int j, String pat){
        if(j - 1 >= 0 && 
           board[i][j - 1] == pat.charAt(0)){
            return false;
        } else if(i - 1 >= 0 && 
                  board[i - 1][j] == pat.charAt(0)){
            return false;
        } else if(i - 1 >= 0 && 
                  j + 1 < board[0].length && 
                  board[i - 1][j + 1] == pat.charAt(1)){
            return false;
        } else if(j + 2 < board[0].length && 
                  board[i][j + 2] == pat.charAt(1)){
            return false;
        }

        return true;
    }

    static boolean cpv(char[][] board, int i, int j, String pat){
        if(j - 1 >= 0 && 
           board[i][j - 1] == pat.charAt(0)){
            return false;
        } else if(i - 1 >= 0 && 
                  board[i - 1][j] == pat.charAt(0)){
            return false;
        } else if(j + 1 < board[0].length && 
                  board[i][j + 1] == pat.charAt(0)){
            return false;
        }

        return true;
    }

    static void solve(char[][] board, int i , int j){
        if(i == board.length && j == 0){
            for(int r = 0; r < board.length; r++){
                int pcount = 0;
                int ncount = 0;
                for(int c = 0; c < board[0].length; c++){
                    if(board[r][c] == '+')
                        pcount++;
                    else if(board[r][c] == '-')
                        ncount++;
                }

                if(left[r] != pcount && left[r] != 0)
                {
                    return;
                }
                if(right[r] != ncount && right[r] != 0)
                {
                    return;
                }
            }

            for(int c = 0; c < board[0].length; c++){
                int pcount = 0;
                int ncount = 0;
                for(int r = 0; r < board.length; r++){
                    if(board[r][c] == '+')
                        pcount++;
                    else if(board[r][c] == '-')
                        ncount++;
                }

                if(top[c] != pcount && top[c] != 0)
                {
                    return;
                }
                if(bottom[c] != ncount && bottom[c] != 0)
                {
                    return;
                }
            }

            for(int r = 0; r < board.length; r++){
                for(int c = 0; c < board[0].length; c++){
                    System.out.print(board[r][c] + " ");
                }
                System.out.println();
            }
            return;
        } else if(j == board[0].length - 1){
            if(board[i][j] == 'h')
            {
                // o1 -> +-
                if(cph(board, i, j, "+-"))
                {
                    board[i][j] = '+';
                    board[i][j + 1] = '-';
                    solve(board, i + 1, 0);
                    board[i][j] = 'h';
                    board[i][j + 1] = 'h';
                }

                // o2 -> -+
                if(cph(board, i, j, "-+"))
                {
                    board[i][j] = '-';
                    board[i][j + 1] = '+';
                    solve(board, i + 1, 0);
                    board[i][j] = 'h';
                    board[i][j + 1] = 'h';
                }

                // o3 -> **
                board[i][j] = '*';
                board[i][j + 1] = '*';
                solve(board, i + 1, 0);
                board[i][j] = 'h';
                board[i][j + 1] = 'h';
            } else if(board[i][j] == 'v')
            {
                // o1 -> +-
                if(cpv(board, i, j, "+-"))
                {
                    board[i][j] = '+';
                    board[i + 1][j] = '-';
                    solve(board, i + 1, 0);
                    board[i][j] = 'v';
                    board[i + 1][j] = 'v';
                }

                // o2 -> -+
                if(cpv(board, i, j, "-+"))
                {
                    board[i][j] = '-';
                    board[i + 1][j] = '+';
                    solve(board, i + 1, 0);
                    board[i][j] = 'v';
                    board[i + 1][j] = 'v';
                }

                // o3 -> **
                board[i][j] = '*';
                board[i + 1][j] = '*';
                solve(board, i + 1, 0);
                board[i][j] = 'v';
                board[i + 1][j] = 'v';
            }
            else {
                solve(board, i + 1, 0);
            }
        } else {
            if(board[i][j] == 'h')
            {
                // o1 -> +-
                if(cph(board, i, j, "+-"))
                {
                    board[i][j] = '+';
                    board[i][j + 1] = '-';
                    solve(board, i, j + 1);
                    board[i][j] = 'h';
                    board[i][j + 1] = 'h';
                }

                // o2 -> -+
                if(cph(board, i, j, "-+"))
                {
                    board[i][j] = '-';
                    board[i][j + 1] = '+';
                    solve(board, i, j + 1);
                    board[i][j] = 'h';
                    board[i][j + 1] = 'h';
                }

                // o3 -> **
                board[i][j] = '*';
                board[i][j + 1] = '*';
                solve(board, i, j + 1);
                board[i][j] = 'h';
                board[i][j + 1] = 'h';
            } else if(board[i][j] == 'v')
            {
                // o1 -> +-
                if(cpv(board, i, j, "+-"))
                {
                    board[i][j] = '+';
                    board[i + 1][j] = '-';
                    solve(board, i, j + 1);
                    board[i][j] = 'v';
                    board[i + 1][j] = 'v';
                }

                // o2 -> -+
                if(cpv(board, i, j, "-+"))
                {
                    board[i][j] = '-';
                    board[i + 1][j] = '+';
                    solve(board, i, j + 1);
                    board[i][j] = 'v';
                    board[i + 1][j] = 'v';
                }

                // o3 -> **
                board[i][j] = '*';
                board[i + 1][j] = '*';
                solve(board, i, j + 1);
                board[i][j] = 'v';
                board[i + 1][j] = 'v';
            }
            else {
                solve(board, i, j + 1);
            }
        }
    }

    public static void main(String[] args){
        top = new int[] {1, 0, 0, 2, 1, 0};
        bottom = new int[] {2, 0, 0, 2, 0, 3};
        left = new int[] {2, 3, 0, 0, 0};
        right = new int[] {0, 0, 0, 1, 0};

        char[][] board = {
            "hhhhvv".toCharArray(),
            "hhhhvv".toCharArray(),
            "vvvvhh".toCharArray(),
            "vvvvvv".toCharArray(),
            "hhhhvv".toCharArray(),
        };
        solve(board, 0, 0);
    }
}