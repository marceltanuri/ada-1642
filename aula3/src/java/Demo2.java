import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Demo2 {

    public static void main(String a[]) {
        LoadHistorico.load();
        List<HistoricoTreino> historicos = RepositorioHistoricoTreino.listarTodos();
        Scanner scanner = new Scanner(System.in);

        Modalidade filtroModalidade = null;
        Double filtroTempoMaximo = null;
        Double filtroDistanciaMinima = null;

        List<Integer> criteriosOrdenacao = new ArrayList<>();

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Adicionar filtro por Modalidade");
            System.out.println("2. Adicionar filtro por Tempo máximo");
            System.out.println("3. Adicionar filtro por Distância mínima");
            System.out.println("4. Adicionar ordenação");
            System.out.println("5. Limpar filtros e ordenação");
            System.out.println("6. Mostrar resultados");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida.");
                scanner.next();
                continue;
            }
            int opcao = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (opcao) {
                case 1:
                    System.out.print("Digite a modalidade (CRAWL, PEITO, COSTAS, BORBOLETA): ");
                    String modStr = scanner.nextLine().toUpperCase();
                    try {
                        filtroModalidade = Modalidade.valueOf(modStr);
                        System.out.println("Filtro adicionado.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Modalidade inválida.");
                    }
                    break;
                case 2:
                    System.out.print("Digite o tempo máximo: ");
                    if (scanner.hasNextDouble()) {
                        filtroTempoMaximo = scanner.nextDouble();
                        System.out.println("Filtro adicionado.");
                    } else {
                        System.out.println("Entrada inválida.");
                        scanner.next();
                    }
                    break;
                case 3:
                    System.out.print("Digite a distância mínima: ");
                    if (scanner.hasNextDouble()) {
                        filtroDistanciaMinima = scanner.nextDouble();
                        System.out.println("Filtro adicionado.");
                    } else {
                        System.out.println("Entrada inválida.");
                        scanner.next();
                    }
                    break;
                case 4:
                    System.out.println("1. Tempo (Crescente)");
                    System.out.println("2. Tempo (Decrescente)");
                    System.out.println("3. Distância (Crescente)");
                    System.out.println("4. Distância (Decrescente)");
                    System.out.println("5. Modalidade");
                    System.out.print("Escolha a ordenação: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Entrada inválida.");
                        scanner.next();
                        break;
                    }
                    int ord = scanner.nextInt();
                    if (ord >= 1 && ord <= 5) {
                        criteriosOrdenacao.add(ord);
                        System.out.println("Ordenação definida.");
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                case 5:
                    filtroModalidade = null;
                    filtroTempoMaximo = null;
                    filtroDistanciaMinima = null;
                    criteriosOrdenacao.clear();
                    System.out.println("Filtros e ordenação limpos.");
                    break;
                case 6:
                    // 1. Aplicar filtros manualmente (Programação Imperativa)
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
