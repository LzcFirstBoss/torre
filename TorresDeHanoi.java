import java.util.Scanner;

public class TorresDeHanoi {

    static long contadorMovimentos = 0;

    // Método para resolver o jogo das Torres de Hanoi
    public static void resolverTorresDeHanoi(long discos, char origem, char destino, char auxiliar) {
        if (discos == 1) {
            contadorMovimentos++;
            return;
        }

        resolverTorresDeHanoi(discos - 1, origem, auxiliar, destino);
        contadorMovimentos++;
        resolverTorresDeHanoi(discos - 1, auxiliar, destino, origem);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de discos: ");
        long numDiscos = scanner.nextInt();

        scanner.close();

        if (numDiscos <= 0) {
            System.out.println("O número de discos deve ser maior que zero.");
        } else {
            long inicio = System.currentTimeMillis();
            
            resolverTorresDeHanoi(numDiscos, 'A', 'C', 'B');
            
            long fim = System.currentTimeMillis();
            long tempoExecucao = fim - inicio;

            System.out.println("Total de movimentos realizados: " + contadorMovimentos);
            System.out.println("Tempo de execução: " + tempoExecucao + " milissegundos");
        }
    }
}
