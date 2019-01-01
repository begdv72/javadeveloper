public class InputTwoNumbers {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
  /*      int firstNumber = readIntNumber("Введите целое число");
        int secondNumber = readIntNumber("Введите еще одно целое число");*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("Упражнение 1");
        System.out.print("Введите первое число ");
        int firstNumber = scanner.nextInt();
        System.out.print("Введите второе число ");
        int secondNumber = scanner.nextInt();
        if((firstNumber < 0 && secondNumber > 0) || (firstNumber > 0 && secondNumber < 0)) {
            System.out.printf("firstNumber * secondNumber = %d",(int)(firstNumber * secondNumber));
        }
        else if(firstNumber > secondNumber){
            System.out.printf("firstNumber - secondNumber = %d",(int)(firstNumber - secondNumber));
        }
        else if ((firstNumber < 0 && secondNumber < 0)){
            System.out.printf("firstNumber + secondNumber = %d",(int)(firstNumber + secondNumber));
        }
        else {
            System.out.printf("firstNumber % secondNumber = %d",(int)(firstNumber % secondNumber));
        }
    }

    private static int readIntNumber(String prompt) {
        System.out.println(prompt);
        int i;
        while (true) {
            if(scanner.hasNextInt()){
                i = scanner.nextInt();
                break;
            }
            else {
                scanner.nextLine();
            }
        }
        System.out.println("echo: " + i);
        return i;
    }
}
