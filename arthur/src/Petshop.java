import java.util.ArrayList;
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
                    Tutor.cadastroTutor();  // Passe o scanner como argumento
                    break;
                case "i":
                    Tutor.imprimirTutores();  // Função para imprimir todos os tutores cadastrados
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



    // Método para imprimir todos os tutores
    // static void imprimirTutores() {
    //     if (listaDeTutores.isEmpty()) {
    //         System.out.println("Nenhum tutor cadastrado.");
    //     } else {
    //         for (Tutor tutor : listaDeTutores) {
    //             System.out.println("Nome: " + tutor.getNome()+ ", Idade: " + tutor.getIdade() 
    //                     + ", Endereço: " + tutor.getEndereco() + ", Código: \n" + tutor.getCodigo()
	// 					+ "Pets: \n"
	// 					+ tutor);
    //         }
    //     }
    // }

	// static void cadastrarPets(){
	// 	System.out.println("Digite o nome do pet:");
    //     String nome = scanner.nextLine();
    //     System.out.println("Digite o tipo do pet:");
    //     String tipo = scanner.nextLine();

    //     // Criando um novo tutor
    //     Pet pet = new Pet(nome, tipo);
	// 	Tutor.pets.add(pet);
	// }
}
