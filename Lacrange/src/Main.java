import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static String lagrangeInterpolation(double[] x, double[] y) {
        int n = x.length;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String term = new DecimalFormat("#.##").format(y[i]);

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    term = "(" + term + ") * (x - " + new DecimalFormat("#.##").format(x[j]) +
                            ") / (" + new DecimalFormat("#.##").format(x[i] - x[j]) + ")";
                }
            }

            result.append(term).append(" + ");
        }

        // Remover o último " + "
        result.setLength(result.length() - 3);
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe a quantidade de pontos: ");
        int n = scanner.nextInt();

        double[] x = new double[n];
        double[] y = new double[n];

        System.out.println("Informe x:");
        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = scanner.nextDouble();
        }

        System.out.println("Informe o y:");
        for (int i = 0; i < n; i++) {
            System.out.print("y[" + i + "]: ");
            y[i] = scanner.nextDouble();
        }

        String polynomial = lagrangeInterpolation(x, y);

        // Obtém o grau do polinômio
        int degree = x.length - 1;

        // Imprime o grau e o polinômio resultante
        System.out.println("Grau do polinômio: " + degree);
        System.out.println("Polinômio interpolador de Lagrange: P(x) = " + polynomial);
}
}