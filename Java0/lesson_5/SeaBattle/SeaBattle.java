import java.util.Scanner;
import java.util.Arrays;

public class SeaBattle {
    public static void main(String[] args) {
        doGame();
    }

    private static void doGame() {
        Scanner scanner = new Scanner(System.in);
        char[] cells;
        int FIELD_SIZE = 10;
        cells = new char[FIELD_SIZE];
        Arrays.fill(cells, '.');
        int SHIP_SIZE = 3;

        int shipZize = (int) (Math.random() * SHIP_SIZE) + 1;
        int shipPosition;
        do {
            shipPosition = (int) (Math.random() * FIELD_SIZE) + 1;
        } while (((shipPosition - shipZize - 1) < 0) || ((shipPosition + shipZize + 1) > FIELD_SIZE));
        Ship ship = new Ship(shipZize, shipPosition);
        ship.show(cells);


        do {
            System.out.println(cells);
            int shoot;
            System.out.println("Ваш ход: введите число от 1 до " + FIELD_SIZE);
            while (true) {
                if (scanner.hasNextInt()) {
                    shoot = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } else {
                    scanner.nextLine();
                }
            }
            System.out.println("Ваш выстрел: " + shoot);

            switch (cells[shoot - 1]) {
                case '.':
                    System.out.println("Промах");
                    cells[shoot - 1] = '*';
                    break;
                case 'X':
                    System.out.println("Попал");
                    cells[shoot - 1] = '#';
                    break;
                case '*':
                    System.out.println("Уже стреляли");
                    break;
            }
        } while (!ship.hitted(cells));

        System.out.println("Потоплен!");
        System.out.println(cells);
    }
}
