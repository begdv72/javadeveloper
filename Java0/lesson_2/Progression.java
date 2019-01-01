public class Progression {
    public static void main(String[] args) {
        System.out.println("START");
        progression(10,9);
    }

    private static void progression(int start, int diff) {
        System.out.println(start);
        if(start < 100) {
            start += diff;
            progression(start, diff);
        }
    }
}
