public class Exercise4 {
    /*
     **На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
     */


    public static void main(String[] args) {
        int [][] board = new int[8][8];
        final int size = 8;
        solveAndPrint(size, board);

    }
    public static void solveAndPrint(final int size, int[][] board){
        tryQueen(0,board, size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(board[i][j] == -1){
                    System.out.print("*");
                }
                else
                    System.out.print(".");
            }
            System.out.println();
        }
    }
    static void setQueen(int i, int j, int[][] board, final int size){
        for(int x = 0; x < size; x++){
            board[x][j]++;//horizontal
            board[i][x]++;//vertical
            int index;
            index = j - i + x;
            if(index >= 0 && index < size){
                board[x][index]++;
            }
            index = j + i - x;
            if(index >= 0 && index < size){
                board[x][index]++;
            }
        }
        board[i][j] = -1;
    }

    static void resetQueen(int i, int j, int[][] board, final int size){
        for(int x = 0; x < size; x++){
            board[x][j]--;//horizontal
            board[i][x]--;//vertical
            int index;
            index = j - i + x;
            if(index >= 0 && index < size){
                board[x][index]--;
            }
            index = j + i - x;
            if(index >= 0 && index < size){
                board[x][index]--;
            }
        }
        board[i][j] = 0;
    }
    static boolean tryQueen(int i, int[][] board, final int size){
        boolean flag = false;
        for(int j = 0; j < size; j++){
            if(board[i][j] == 0){
                //никто не бьет
                setQueen(i, j, board, size);
                if(i == size - 1){
                    //all figures of queen
                    flag = true;
                }
                else{
                    flag = tryQueen(i + 1, board, size);//попытка поставить на след столбец
                    if(!flag){
                        resetQueen(i, j, board, size);
                    }
                }
            }
            if(flag)
                break;
        }
        return flag;
    }



}
