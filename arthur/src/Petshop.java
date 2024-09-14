import java.util.ArrayList;
import java.util.Scanner;

public class Petshop {

    // Mantenha a lista de tutores fora do método, para que seja acessível globalmente
    static ArrayList<Tutor> listaDeTutores = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
                    cadastroTutor(scanner);  // Passe o scanner como argumento
                    break;
                case "i":
                    imprimirTutores();  // Função para imprimir todos os tutores cadastrados
                    break;
                case "b":
                    System.out.println("Função buscar ainda não implementada.");
                    break;
                case "e":
                    System.out.println("Função excluir ainda não implementada.");
                    break;
                case "x":
                    scanner.close();  // Fechar o scanner ao encerrar
                    return;  // Termina a execução do método main
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    // Método para cadastrar tutores
    static void cadastroTutor(Scanner scanner) {
        System.out.println("Digite o nome do tutor:");
        String nome = scanner.nextLine();
        System.out.println("Digite a idade do tutor:");
        int idade = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite o endereço do tutor:");
        String endereco = scanner.nextLine();
        System.out.println("Digite o código do tutor:");
        String codigo = scanner.nextLine();

        // Criando um novo tutor
        Tutor tutor = new Tutor(nome, idade, endereco, codigo);
        listaDeTutores.add(tutor);

        System.out.println("Tutor cadastrado com sucesso!");
    }

    // Método para imprimir todos os tutores
    static void imprimirTutores() {
        if (listaDeTutores.isEmpty()) {
            System.out.println("Nenhum tutor cadastrado.");
        } else {
            for (Tutor tutor : listaDeTutores) {
                System.out.println("Nome: " + tutor.nome + ", Idade: " + tutor.idade 
                        + ", Endereço: " + tutor.endereco + ", Código: " + tutor.codigo);
            }
        }
    }

	static void cadastrarPets(){
		
	}
}
