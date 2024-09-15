import java.util.ArrayList;
import java.util.Scanner;

public class Tutor {

    static ArrayList<Tutor> listaDeTutores = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    private String nome;
    private int idade;
    private String endereco;
    private String codigo;
    private String dataDeNascimento;
    public ArrayList<Pet> pets;

    public Tutor(String nome, int idade, String endereco, String codigo, String dataDeNascimento) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.codigo = codigo;
        this.dataDeNascimento = dataDeNascimento;
        this.pets = new ArrayList<>();
    }

    static void cadastroTutor() {
        System.out.println("Digite o nome do tutor:");
        String nome = scanner.nextLine();
        System.out.println("Digite a idade do tutor:");
        int idade = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite o endereço do tutor:");
        String endereco = scanner.nextLine();
        System.out.println("Digite o código do tutor:");
        String codigo = scanner.nextLine();
        System.out.println("Digite a data de nascimento do tutor:");
        String dataDeNascimento = scanner.nextLine();

        // Criando um novo tutor
        Tutor tutor = new Tutor(nome, idade, endereco, codigo, dataDeNascimento);
        listaDeTutores.add(tutor);

        while (true) {
            tutor.cadastrarPets(); 
            System.out.println("Deseja cadastrar mais pets para este tutor (s/n)? ");
            String maisPets = scanner.nextLine();
            
            if (maisPets.equals("s") || maisPets.equals("S")) {
                System.out.println("-- Pet cadastrado ---");
            } else if (maisPets.equals("n") || maisPets.equals("N")) {
                System.out.println("--- Tutor cadastrado ---");
                break;
            }
        }

        System.out.println("Tutor cadastrado com sucesso!");
    }

    public void cadastrarPets() {
        System.out.println("Digite o nome do pet:");
        String nome = scanner.nextLine();
        System.out.println("Digite o tipo do pet:");
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
                + "\tData nascimento: " + tutor.dataDeNascimento + "\n"
                + "\tEndereço.......: " + tutor.endereco + "\n"
                + "\tRelação de Pets:");

                for (Pet pet : tutor.getPets()) {
                    System.out.println("\t- Nome: " + pet.getNome() + ", Tipo: " + pet.getTipo() + "\n");
                }
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCodigo() {
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
