public class TickTackToe {
    public static void main(String[] args) {
        char[][] cells;
        cells = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = '.';
            }
        }
        for (int i = 0; i < 9; i++) {
            int row = (int) (Math.random() * 3);
            int col = (int) (Math.random() * 3);
            char symbol = (int) (Math.random() * 3)  > 0 ? 'X' : 'O';
            cells[col][row] = symbol;
            showBoard(cells);
            pause(1000);
        }
    }
    private static void pause(int delay){
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static void showBoard(char[][] cells){
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(cells[col][row] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
