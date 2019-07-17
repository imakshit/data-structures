import java.util.*;

public class crossword {
    static boolean cpwv(char[][] board, int i, int j, String word){
        for(int r = 0; r < word.length(); r++){
            if(i + r == board.length){
                return false;
            }

            char chb = board[i + r][j];
            char chw = word.charAt(r);

            if(chb != '-' && chb != chw){
                return false;
            }
        }

        if(i - 1 >= 0 && board[i - 1][j] != '+')
        {
            return false;
        } 
        else if(i + word.length() < board.length &&
                board[i + word.length()][j] != '+')
        {
            return false;
        }

        return true;
    }

    static boolean cpwh(char[][] board, int i, int j, String word){
        for(int c = 0; c < word.length(); c++){
            if(j + c == board.length){
                return false;
            }

            char chb = board[i][j + c];
            char chw = word.charAt(c);

            if(chb != '-' && chb != chw){
                return false;
            }
        }

        if(j - 1 >= 0 && board[i][j - 1] != '+')
        {
            return false;
        } 
        else if(j + word.length() < board.length &&
                board[i][j + word.length()] != '+')
        {
            return false;
        }

        return true;
    }

    static boolean[] pwv(char[][] board, int i, int j, String word){
        boolean[] dipit = new boolean[word.length()];

        for(int r = 0; r < word.length(); r++){
            char chb = board[i + r][j];
            char chw = word.charAt(r);
            if(chb == '-'){
                board[i + r][j] = chw;
                dipit[r] = true;
            }
        }

        return dipit;
    }

    static boolean[] pwh(char[][] board, int i, int j, String word){
        boolean[] dipit = new boolean[word.length()];

        for(int c = 0; c < word.length(); c++){
            char chb = board[i][j + c];
            char chw = word.charAt(c);
            if(chb == '-'){
                board[i][j + c] = chw;
                dipit[c] = true;
            }
        }

        return dipit;
    }

    static void upwv(char[][] board, int i, int j, boolean[] dipit){
        for(int r = 0; r < dipit.length; r++){
            if(dipit[r] == true){
                board[i + r][j] = '-';
            }
        }
    }

    static void upwh(char[][] board, int i, int j, boolean[] dipit){
        for(int c = 0; c < dipit.length; c++){
            if(dipit[c] == true){
                board[i][j + c] = '-';
            }
        }
    }

    static void solve(String[] words, char[][] board, int widx){
        if(widx == words.length){
            System.out.println("***************************");
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board.length; j++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("***************************");
            return;
        }

        String word = words[widx];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(cpwv(board, i, j, word) == true){
                    boolean[] dipit = pwv(board, i, j, word);
                    solve(words, board, widx + 1);
                    upwv(board, i, j, dipit);
                }

                if(cpwh(board, i, j, word) == true){
                    boolean[] dipit = pwh(board, i, j, word);
                    solve(words, board, widx + 1);
                    upwh(board, i, j, dipit);
                }
            }
        }
    }


    public static void main(String[] args){
        char[][] board = {
            "+-++++++++".toCharArray(),
            "+-++++++++".toCharArray(),
            "+-------++".toCharArray(),
            "+-++++++++".toCharArray(),
            "+-++++++++".toCharArray(),
            "+------+++".toCharArray(),
            "+-+++-++++".toCharArray(),
            "+++++-++++".toCharArray(),
            "+++++-++++".toCharArray(),
            "++++++++++".toCharArray(),
        };
        String[] words = {"agra", "england", "gwalior", "norway"};
        solve(words, board, 0);
    }
}