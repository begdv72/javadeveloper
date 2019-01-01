public class BodyMassIndex {
    public static void main(String[] args) {
        double m = 61.5;
        double h = 171.2;
        double bodyMassIndex = calcBodyMassIndex(m ,h);
        System.out.printf("рост = %.1f см., вес = %.1f кг., индекс массы тела = %.3f", h, m, bodyMassIndex);
    }

    private static double calcBodyMassIndex(double m, double h) {
        h = h / 100;
        double bodyMassIndex = m / (h * h);
        return bodyMassIndex;
    }
}
