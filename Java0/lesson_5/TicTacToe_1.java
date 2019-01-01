import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Упражнение 7");

        // Символ, которым заполним пустое поле
        final char BLANK_SYMBOL = '_';
        // Определим размер таблицы, например 3 на 3
        final int ROW_SIZE = 3;
        // создадим массив символов под размер таблицы
        char[] field = new char[ROW_SIZE * ROW_SIZE];

        final char FIRST_PLAYER_PIECE = 'X';
        final char SECOND_PLAYER_PIECE = 'O';

        // Заполняем поле символом с подчеркиванием в цикле
        for (int i = 0; i < field.length; i++) {
            field[i] = BLANK_SYMBOL;
        }
        // Или можем это сделать с помощью библиотечного метода Arrays.fill();
        // которому передается массив для заполнения первым параметром и символ для заполнения вторым параметром
        Arrays.fill(field, BLANK_SYMBOL);

        int currentPlayer = 1;

        while (true) {
            // Выводим поле на экран
            for (int i = 0; i < field.length; i++) {
                System.out.print(field[i] + " ");
                if ((i + 1) % ROW_SIZE == 0) {
                    System.out.println();
                }
            }

            System.out.println("Игрок " + currentPlayer + " ваш ход");

            // В userInput сохраним номер ячейки, который ввел пользователь
            int userInput = -1; // по умолчанию присвоим, например, -1
            // будем крутиться в вечном цикле, пока пользователь не введет все так, как положено
            do {
                System.out.print("Выберите номер ячейки (от 1 до " + ROW_SIZE * ROW_SIZE + ", кроме занятых) или 0 для выхода ");
                userInput = scanner.nextInt();
                // считываем перевод строчки, чтобы очистить буффер
                // иначе он из буффера прочитается при следующем вводе символа
                scanner.nextLine();
                // здесь хитрое сравнение
                // если пользователь введет 0, то мы выйдем из цикла и не будем проверять остаток условия
                // если введет меньше 1 или больше 9, то тоже выйдем из цикла
                // и не будем лезть в массив field[userInput - 1]
                // поэтому не выйдем за его пределы
            } while (!(userInput == 0 ||
                    (userInput >= 1 && userInput <= ROW_SIZE * ROW_SIZE && field[userInput - 1] == BLANK_SYMBOL)));

            // Выходим, если пользователь ввел 0
            if (userInput == 0) {
                break;
            }

            if (currentPlayer == 1) {
                field[userInput - 1] = FIRST_PLAYER_PIECE;
            } else {
                field[userInput - 1] = SECOND_PLAYER_PIECE;
            }

            // Проверяем, есть ли выстроенные линии
            // будем хранить в state результат: 0 если ничья, 1 если первый выиграл, 2 если второй выиграл
            int state = -1;

            for (int i = 0; i < field.length; i += ROW_SIZE) {
                if (field[i] == field[i + 1] && field[i + 1] == field[i + 2]) {
                    if (field[i] == FIRST_PLAYER_PIECE) {
                        state = 1;
                    }
                    if (field[i] == SECOND_PLAYER_PIECE) {
                        state = 2;
                    }
                }
            }
            for (int i = 0; i < ROW_SIZE; i++) {
                if (field[i] == field[i + ROW_SIZE] && field[i] == field[i + 2 * ROW_SIZE]) {
                    if (field[i] == FIRST_PLAYER_PIECE) {
                        state = 1;
                    }
                    if (field[i] == SECOND_PLAYER_PIECE) {
                        state = 2;
                    }
                }
            }
            if (field[0] == field[ROW_SIZE + 1] && field[0] == field[field.length - 1]) {
                if (field[0] == FIRST_PLAYER_PIECE) {
                    state = 1;
                }
                if (field[0] == SECOND_PLAYER_PIECE) {
                    state = 2;
                }
            }
            if (field[ROW_SIZE - 1] == field[ROW_SIZE + 1] && field[ROW_SIZE + 1] == field[2 * ROW_SIZE]) {
                if (field[ROW_SIZE - 1] == FIRST_PLAYER_PIECE) {
                    state = 1;
                }
                if (field[ROW_SIZE - 1] == SECOND_PLAYER_PIECE) {
                    state = 2;
                }
            }
            
            // поищем, остались ли пустые ячейки?
            boolean hasEmpty = false;
            for (char c : field) {
                if (c == BLANK_SYMBOL) {
                    hasEmpty = true;
                    break;
                }
            }
            // если пустых ячеек не осталось, то значит ничья
            if (!hasEmpty) {
                state = 0;
            }

            switch (state) {
                case 0:
                    System.out.println("Ничья");
                    return;
                case 1:
                    System.out.println("Первый игрок выиграл");
                    return;
                case 2:
                    System.out.println("Второй игрок выиграл");
                    return;
            }

            // Если вы помните тернарный оператор из 3-го занятия,
            // то можно сделать так, чтобы сменить игрока
            currentPlayer = (currentPlayer == 1) ? 2 : 1;
        }

    }
}
