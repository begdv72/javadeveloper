import java.util.Scanner;

public class SeaBattle {
    public static void main(String[] args) {
        doGame();
    }

    private static void doGame() {
        Scanner scanner = new Scanner(System.in);
        char[] cells;
        cells = new char[10];

        for (int i = 0; i < 10; i++) {
            cells[i] = '.';
        }

        int shipPosition = 4;
        cells[shipPosition] = 'X';

        do {
            System.out.println(cells);
            int shoot;
            while (true) {
                if(scanner.hasNextInt()){
                    shoot = scanner.nextInt();
                    break;
                }
                else {
                    scanner.nextLine();
                }
            }
            System.out.println("Ваш выстрел: " + shoot);

            switch(cells[shoot]){
                case '.':
                    System.out.println("Промах");
                    cells[shoot] = '*';
                    break;
                case 'X':
                    System.out.println("Потопили");
                    cells[shoot] = '#';
                    break;
                case '*':
                    System.out.println("Уже стреляли");
                    break;
            }
        } while (cells[shipPosition] == 'X');

        System.out.println(cells);
    }
}
