package src;
import java.util.InputMismatchException;
import java.util.Scanner;
import src.Controle.Impl.Piloto;

public class App{
    private static Scanner scanner = new Scanner(System.in);
    private static int capacidadeArmazanamento = 10;
    private static int capacidadeSolicitada = 0;
    private static Piloto[] _pilotos = new Piloto[capacidadeArmazanamento];
    private static int _numeroPilotos = 0;
    private static String pesquisa = "0";
    public static void main(String[] args) throws Exception {
        boolean continuarExecutando = true;
        do {
            try {
                imprimirMenu();
                int opcao = lerOpcao();
                continuarExecutando = executarOpcao(opcao);
            } catch (Exception e) {
                System.out.println("Ocorreu um erro durante a operação: " + e.getMessage());
                continuarExecutando = true;
            }
        } while (continuarExecutando);
    }

    private static boolean executarOpcao(int opcao) throws Exception {
        switch (opcao) {
            case 1: {
                cadastrarPiloto();
                break;
            }
            case 2: {
                listarPilotosCadastrados();
                break;
            }
            /*case 3: {
                localizarPilotoCPF();
                break;
            }*/
            case 4: {
                aumentarEspaçoArmazenamento();
                break;
            }
            case 0: {
                System.out.println("Saindo do sistema...");
                return false;
            }
            default: {
                System.out.println("Ainda não implementado!");
                break;
            }
        }

        return true;
    }

    /*private static void localizarPilotoCPF(){
        System.out.println("Digite o nome do contato a ser pesquisado: ");
        String pesquisa = scanner.nextLine();
        if (Piloto.contains(pesquisa));
            System.out.println(_pilotos[i]);
            System.out.println(pesquisa + "não contém na lista: ");
    }*/

    private static void aumentarEspaçoArmazenamento(){
        System.out.println("Aumento capacidade de armazenamento");
        System.out.println("Informe a capacidade de armazenamento desejada:");
        capacidadeSolicitada = scanner.nextInt();
        if(capacidadeSolicitada<=capacidadeArmazanamento){
            System.out.println("\nA capacidade atual de armazenamento é igual ou superior a solicitada.");    
        }
        else {capacidadeArmazanamento = capacidadeSolicitada;
        System.out.println("\nCapacidade aumentada para " + capacidadeArmazanamento);}
    }
    private static void listarPilotosCadastrados() {
        if (_numeroPilotos == 0) {
            System.out.println("\nNão há pilotos cadastrados para exibir.");
        }
        else{System.out.println("Lista de pilotos cadastrados:");
        for (int i = 0; i < _numeroPilotos; i++) {
        System.out.println(_pilotos[i]);}}
    }
    private static void adicionarPilotoNaLista(Piloto piloto) {
        // Adiciono o piloto a lista.
        _pilotos[_numeroPilotos] = piloto;
        _numeroPilotos++;
    }
    private static void cadastrarPiloto() throws InputMismatchException {
    // Se não tem mais espaço no vetor, caio fora
        if (_numeroPilotos== _pilotos.length) {
            System.out.println("\nNão há espaço para cadastrar novos pilotos.");
            imprimirMenu();
        }
        else{System.out.println("Cadastrar Piloto");
            System.out.println("Nome: ");
            String nome = scanner.nextLine();
            System.out.println("CHT: ");
            String cht = scanner.nextLine();
            System.out.println("CPF: ");
            String cpf = scanner.nextLine();

            Piloto piloto = new Piloto(nome, cht, cpf);
            adicionarPilotoNaLista(piloto);}
        }

    private static void imprimirMenu() {
        System.out.println("\n****\nMENU\n****\n");
        System.out.println("1 - Cadastrar piloto");
        System.out.println("2 - Listar pilotos cadastrados");
        System.out.println("3 - Localizar piloto pelo CPF");
        System.out.println("4 - Aumentar espaço de armazenamento");
        System.out.println("0 - Sair");
        System.out.print("Opção: ");
    }
    private static boolean validarOpcaoMenu(int opcao) {
        return (opcao >= 0 && opcao <= 4);
    }

    private static int lerOpcao() {
        int opcao = 0;
        do {
            System.out.println("Selecione a opção desejada: ");
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                if (!validarOpcaoMenu(opcao)) {
                    System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Opção inválida!");
                scanner.nextLine();
            }
        } while (!validarOpcaoMenu(opcao));

        return opcao;
    }
}