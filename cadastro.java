import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class FichaCadastral {
    private String nome;
    private String endereco;
    private String cpf;
    private String telefone;

    public FichaCadastral(String nome, String endereco, String cpf, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Endereço: " + endereco + ", CPF: " + cpf + ", Telefone: " + telefone;
    }
}

public class SistemaCadastro {
    private List<FichaCadastral> fichas;

    public SistemaCadastro() {
        this.fichas = new ArrayList<>();
    }

    public void adicionarFicha(FichaCadastral ficha) {
        fichas.add(ficha);
    }

    public void mostrarFichas() {
        for (FichaCadastral ficha : fichas) {
            System.out.println(ficha);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaCadastro sistema = new SistemaCadastro();

        while (true) {
            System.out.println("Digite o nome (ou 'sair' para encerrar): ");
            String nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("sair")) break;

            System.out.println("Digite o endereço: ");
            String endereco = scanner.nextLine();

            System.out.println("Digite o CPF: ");
            String cpf = scanner.nextLine();

            System.out.println("Digite o telefone: ");
            String telefone = scanner.nextLine();

            FichaCadastral ficha = new FichaCadastral(nome, endereco, cpf, telefone);
            sistema.adicionarFicha(ficha);
        }

        System.out.println("\nFichas Cadastrais:");
        sistema.mostrarFichas();

        scanner.close();
    }
}