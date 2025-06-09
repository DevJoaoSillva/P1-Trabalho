import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Sistema de Geração de Relatórios ===");
            System.out.println("Escolha o tipo de relatório para gerar:");
            System.out.println("1 - Relatório CSV");
            System.out.println("2 - Relatório PDF");
            System.out.println("3 - Relatório TXT");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir o Enter

            RelatorioTemplate relatorio = null;

            switch (opcao) {
                case 1:
                    relatorio = new RelatorioCSV("Relatório de Vendas CSV");
                    break;
                case 2:
                    relatorio = new RelatorioPDF("Relatório de Vendas PDF");
                    break;
                case 3:
                    relatorio = new RelatorioTXT("Relatório de Vendas TXT");
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Até mais!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
            }

            System.out.println();
            relatorio.gerarRelatorio();
            System.out.println();
        }
    }
}
