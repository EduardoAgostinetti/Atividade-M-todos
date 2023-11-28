
import java.util.Scanner;
import static java.lang.Math.toRadians;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o ponto inicial: ");
        double pontoInicial = scanner.nextDouble();

        System.out.print("Informe a precisão desejada: ");
        double precisao = scanner.nextDouble();

        metodoNewton(pontoInicial, precisao);

        scanner.close();
    }

    public static void metodoNewton(double pontoInicial, double precisao) {
        double pontoAtual = pontoInicial;
        int iteracao = 0;
        double erro;

        do {
            double derivada = calcularDerivada(pontoAtual);
            if (derivada == 0) {
                System.out.println("A derivada é zero. Não é possível continuar o método de Newton.");
                return;
            }

            double pontoAnterior = pontoAtual;
            pontoAtual = pontoAnterior - calcularFuncao(pontoAnterior) / derivada;

            erro = Math.abs(pontoAtual - pontoAnterior);

            System.out.printf("Iteração %d: Ponto Inicial = %.6f, Ponto Encontrado = %.6f, Erro = %.6f\n",
                    iteracao + 1, pontoAnterior, pontoAtual, erro);

            iteracao++;

        } while (erro > precisao);

        System.out.println("Convergência alcançada após " + iteracao + " iterações.");
    }


    public static double calcularFuncao(double x) {
        //return (x * x * x * x) - x - 2;
        //return (Math.sin(2*x))/x;

        //return (x*x*x*x) - (3*(x*x)) + 5; //1
         return ( - Math.cos(Math.pow(3.14, x))); // 2
    }


    public static double calcularDerivada(double x) {
        //return 4*(x*x*x)-1 ;
        //return (((2*x) * Math.cos(2*x) - (Math.sin(2*x)))/(x*x));

        //return 4*(x*x*x) - (6*x); // 1
        return (Math.pow(3.14, x)) * (Math.log(3.14)) * (Math.sin(Math.pow(3.14, x))); // 2


    }
}
