import java.util.Scanner;

public class Petshop {
	static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("***** ESCOLHER UMA OPÇÃO *****\n"
                   + "c: cadastrar tutor + pet(s)\n"
                   + "i: imprimir cadastro\n"
                   + "b: buscar pets por codigo tutor\n"
                   + "e: excluir pets por codigo tutor\n"
                   + "x: encerrar\n");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "c":
                    Tutor.cadastroTutor();
                    break;
                case "i":
                    Tutor.imprimirTutores();
                    break;
                case "b":
                    Tutor.buscarCodigo();
                    break;
                case "e":
                    Tutor.excluirCodigo();
                    break;
                case "x":
					System.out.println("--- Programa de cadastro encerrado ---");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

}
