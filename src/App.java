package src;
import java.util.InputMismatchException;
import java.util.Scanner;
import src.Controle.Impl.Piloto;
import src.Controle.Impl.Excecoes.PilotoNaoEncontradoException;

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
            case 3: {
                localizarPilotoCPF();
                break;
            }
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

    private static Piloto localizarPilotoCPF() throws PilotoNaoEncontradoException {

        System.out.println("Digite o CPF do piloto: ");
        //percorre lista para encontrar piloto 
        pesquisa = scanner.nextLine();
        for (Piloto piloto: _pilotos) {
            if (piloto != null && piloto.getCpf().equals(pesquisa)) {
                System.out.println(piloto);
                return (piloto);
            }
        }
        // se não encontra chama exceção
        throw new PilotoNaoEncontradoException(pesquisa);
        }
    private static void aumentarEspaçoArmazenamento(){
        System.out.println("Aumento capacidade de armazenamento");
        System.out.println("Informe a capacidade de armazenamento desejada:");
        capacidadeSolicitada = scanner.nextInt();
        //Valida se armazenamento solicitado não é inferior ao atual
        if(capacidadeSolicitada<=capacidadeArmazanamento){
            System.out.println("\nA capacidade atual de armazenamento é igual ou superior a solicitada.");    
        }
        else {capacidadeArmazanamento = capacidadeSolicitada;
        System.out.println("\nCapacidade aumentada para " + capacidadeArmazanamento);
    }
    }
    private static void listarPilotosCadastrados(){
        //Valida se tem piloto cadastrado na lista
        if (_numeroPilotos == 0) {
            System.out.println("\nNão há pilotos cadastrados para exibir.");
        }
        else{System.out.println("Lista de pilotos cadastrados:");
        for (int i = 0; i <= _numeroPilotos; i++) {
        System.out.println(_pilotos[i]);}}
    }
    private static void adicionarPilotoNaLista(Piloto piloto) {
        // Adiciono o piloto a lista.
        _pilotos[_numeroPilotos] = piloto;
        _numeroPilotos++;
    }
    private static void cadastrarPiloto() throws InputMismatchException {
    // Verifica espaço de armaznamento
        if (_numeroPilotos== _pilotos.length) {
            System.out.println("\nNão há espaço para cadastrar novos pilotos.");
        }
        //Cadastro do piloto
        else{System.out.println("Cadastrar Piloto");
            System.out.println("Nome: ");
            String nome = scanner.nextLine();
            System.out.println("CHT: ");
            String cht = scanner.nextLine();
            System.out.println("CPF: ");
            String cpf = scanner.nextLine();

            //Salvando piloto na lista
            Piloto piloto = new Piloto(nome, cht, cpf);
            adicionarPilotoNaLista(piloto);
            System.out.println("Piloto cadastrado com sucesso");}
        }
    //Menu inicial
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
    //Validando opção informada
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