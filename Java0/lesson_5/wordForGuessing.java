import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Упражнение 4");

        String wordForGuessing = "program";
        System.out.println("Отгадайте слово из " + wordForGuessing.length() + " букв");

        // для разгадывания слова делаем такого же размера массив символов
        // и заполняем его подчеркиваниями, раз пока ни одной буквы не угаданно
        String guessedWord = "";
        for (int i = 0; i < wordForGuessing.length(); i++) {
            // складывать строки в цикле плохая идея (в Java),
            // так как нерационально расходуется память
            // нужно использовать StringBuilder, который вы изучите позже
            // а пока сделаем временный вариант
            guessedWord = guessedWord + "_";
        }

        // обнуляем счетчик попыток
        int tryCount = 0;

        // крутимся в цикле, пока массивы не совпадают, помним, что знак ! – это частичка "НЕ",
        // которая означает отрицание
        // Objects.equals() – позволяет сравнить две строчки, возвращает true, если они совпадают
        // Сравнивать строчки через двойное равенство == не стоит, про это детально вы узнаете на 7-м занятии
        while (!Objects.equals(guessedWord, wordForGuessing)) {
            tryCount = tryCount + 1;
            System.out.println("Попытка " + tryCount);
            System.out.println(guessedWord);
            System.out.println("Введите букву (или 0 для выхода)");

            String userInput = scanner.nextLine();

            // выходим из игры, если введен 0
            if (Objects.equals(userInput, "0")) {
                break;
            }

            // перебираем все буквы в слове
            for (int i = 0; i < wordForGuessing.length(); i++) {
                // проверяем, есть ли такая буква в загаданном слове
                // вырезаем из строки букву под индексом i
                // у метода substring() первый параметр – это номер буквы с которого начинаем вырезать
                // а второй параметр – номер на 1 больше, чем буква, на которой должны остановиться
                String letter = wordForGuessing.substring(i, i + 1);
                if (Objects.equals(letter, userInput)) {
                    // меняем знак _ на угаданную букву
                    // строки в Java - неизменяемые, то есть мы не можем залезть
                    // внутрь строки и поменять в ней какой-то символ
                    // поэтому приходится резать строку на части и собирать заново
                    String leftPart = "";
                    String rightPart = "";
                    // левую часть вырежем только если она есть, чтобы не получить ошибку
                    if (i > 0) {
                        leftPart = guessedWord.substring(0, i);
                    }
                    // и правую часть вырежем только если она есть, чтобы не получить ошибку
                    if (i < wordForGuessing.length() - 1) {
                        rightPart = guessedWord.substring(i + 1);
                    }
                    // склеим слово заново
                    // пока будем использовать знак +, но в будущем вы его замените
                    // на использование класса StringBuilder
                    guessedWord = leftPart + userInput + rightPart;
                }
            }
        }

        if (Objects.equals(guessedWord, wordForGuessing)) {
            System.out.println("Слово " + String.valueOf(wordForGuessing) + " отгадано за " + tryCount + " попыток");
        } else {
            System.out.println("Попробуйте еще раз");
        }
    }
}
