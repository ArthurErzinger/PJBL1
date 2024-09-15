import java.util.ArrayList;
import java.util.Scanner;

public class Tutor {

    static ArrayList<Tutor> listaDeTutores = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    private String nome;
    private String endereco;
    private int codigo;
    private String dataDeNascimento;
    public int idade;
    public ArrayList<Pet> pets;

    // Contador para gerar códigos únicos e sequenciais
    private static int contadorCodigo = 1;

    public Tutor(String nome, String endereco, String dataDeNascimento, int idade) {
        this.codigo = contadorCodigo++;
        this.nome = nome;
        this.endereco = endereco;
        this.dataDeNascimento = dataDeNascimento;
        this.idade = idade;
        this.pets = new ArrayList<>();
    }

    public static void cadastroTutor() {
        // Solicita e verifica a entrada do nome do tutor
        System.out.print("Digite o nome do tutor (vazio encerra cadastro): ");
        String nome = scanner.nextLine();
        if (nome.isEmpty()) {
            System.out.println("Cadastro do tutor encerrado.");
            return;
        }

        System.out.print("Digite endereço do tutor/pet: ");
        String endereco = scanner.nextLine();
        System.out.print("Digite dia (dd), mês (mm) e ano (aaaa) de nascimento do tutor:\n"
                        + "(separados por espaços)");
        String dataDeNascimento = scanner.nextLine();

        String[] partes = dataDeNascimento.split(" ");
        if (partes.length != 3) {
            System.out.println("Formato inválido para a data de nascimento. Utilize o formato: dd mm aaaa");
            return;
        }
        int ano = Integer.parseInt(partes[2]);
        int idade = 2024 - ano;

        Tutor tutor = new Tutor(nome, endereco, dataDeNascimento, idade);
        listaDeTutores.add(tutor);

        while (true) {
            tutor.cadastrarPets(); 
            System.out.print("Deseja cadastrar mais pets para este tutor (s/n)? ");
            String maisPets = scanner.nextLine();
            
            if (maisPets.equalsIgnoreCase("s")) {
                System.out.println("-- Pet cadastrado ---");
            } else if (maisPets.equalsIgnoreCase("n")) {
                System.out.println("--- Tutor cadastrado ---");
                break;
            } else {
                System.out.println("Opção inválida. Digite 's' para sim ou 'n' para não.");
            }
        }

        System.out.println("Tutor cadastrado com sucesso!");
    }

    public void cadastrarPets() {
        System.out.print("Digite o nome do pet: ");
        String nome = scanner.nextLine();
        if (nome.isEmpty()) {
            System.out.println("Cadastro do tutor encerrado.");
            return;
        }
        System.out.print("Digite o tipo do pet: ");
        String tipo = scanner.nextLine();

        Pet pet = new Pet(nome, tipo);
        pets.add(pet);
    }

    public static void imprimirTutores() {
        if (listaDeTutores.isEmpty()) {
            System.out.println("Nenhum tutor cadastrado.");
        } else {
            System.out.println("--- CADASTRO DE TUTORES E PETS ------------------------------------------------------");
            for (Tutor tutor : listaDeTutores) {
                System.out.println("Cod. do tutor: " + tutor.getCodigo() + "\n"
                + "\tNome...........: " + tutor.getNome() + "\n"
                + "\tData nascimento: " + tutor.dataDeNascimento + "( "+ tutor.idade + "    anos)" +"\n"
                + "\tEndereço.......: " + tutor.endereco + "\n"
                + "\tRelação de Pets:");

                for (Pet pet : tutor.getPets()) {
                    System.out.println("\t- Nome: " + pet.getNome() + ", Tipo: " + pet.getTipo() + "\n");
                }
            }
        }
    }

    public static void buscarCodigo() {
        System.out.print("Digite o código do tutor: ");
        int numero = scanner.nextInt();
        for (Tutor tutor : listaDeTutores) {
            if (tutor.codigo == numero) {
                System.out.println("Cod. do tutor: " + tutor.getCodigo() + "\n"
                + "\tNome...........: " + tutor.getNome() + "\n"
                + "\tData nascimento: " + tutor.dataDeNascimento + "\n"
                + "\tEndereço.......: " + tutor.endereco + "\n"
                + "\tRelação de Pets:");

                for (Pet pet : tutor.getPets()) {
                    System.out.println("\t- Nome: " + pet.getNome() + ", Tipo: " + pet.getTipo() + "\n");
                }
            }
        }
        System.out.println("Tutor não encontrado.");
    }

    public static void excluirCodigo(){
        System.out.print("Digite o código do tutor: ");
        int numero = scanner.nextInt();

        for (Tutor tutor : listaDeTutores) {
            if (tutor.codigo == numero) {
                listaDeTutores.remove(tutor);
                break;
            }
        }
    }

    public String getNome() {
        return nome;
    }


    public String getEndereco() {
        return endereco;
    }

    public int getCodigo() {
        return codigo;
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }
}

class Pet {
    private String nome;
    private String tipo;

    public Pet(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }
}
