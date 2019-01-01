public class Test1 {
    public static void main(String[] args) {
        testStackOverflow(1 );
    }

    private static void testStackOverflow() {
    }

    private static void testStackOverflow(int i) {
        System.out.println(i);
        testStackOverflow(i+1);
    }
}
