import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o número de pontos: ");
        int numPontos = scanner.nextInt();

        double[] x = new double[numPontos];
        double[] y = new double[numPontos];

        System.out.println("Informe as coordenadas dos pontos:");
        for (int i = 0; i < numPontos; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = scanner.nextDouble();
            System.out.print("y[" + i + "]: ");
            y[i] = scanner.nextDouble();
        }

        double[] coeficientes = calcularMinimosQuadrados(x, y);

        System.out.println("Coeficiente a: " + coeficientes[0]);
        System.out.println("Coeficiente b: " + coeficientes[1]);

        scanner.close();
    }

    public static double[] calcularMinimosQuadrados(double[] x, double[] y) {
        int n = x.length;

        double somaX = 0;
        double somaY = 0;
        double somaXY = 0;
        double somaXQuadrado = 0;

        for (int i = 0; i < n; i++) {
            somaX += x[i];
            somaY += y[i];
            somaXY += x[i] * y[i];
            somaXQuadrado += x[i] * x[i];
        }

        double a = (n * somaXY - somaX * somaY) / (n * somaXQuadrado - somaX * somaX);
        double b = (somaY - a * somaX) / n;

        double[] coeficientes = {a, b};
        return coeficientes;
    }
}
