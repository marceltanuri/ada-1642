import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Demo {

    public static void main(String a[]){
        LoadHistorico.load();
        List<HistoricoTreino> historicos = RepositorioHistoricoTreino.listarTodos();
        Scanner scanner = new Scanner(System.in);

        Predicate<HistoricoTreino> filtro = ht -> true;
        Comparator<HistoricoTreino> ordenador = null;

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

            switch(opcao) {
                case 1:
                    System.out.print("Digite a modalidade (CRAWL, PEITO, COSTAS, BORBOLETA): ");
                    String modStr = scanner.nextLine().toUpperCase();
                    try {
                        Modalidade mod = Modalidade.valueOf(modStr);
                        filtro = filtro.and(ht -> ht.getModalidade() == mod);
                        System.out.println("Filtro adicionado.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Modalidade inválida.");
                    }
                    break;
                case 2:
                    System.out.print("Digite o tempo máximo: ");
                    if (scanner.hasNextDouble()) {
                        double tempoMax = scanner.nextDouble();
                        filtro = filtro.and(ht -> ht.getTempo() <= tempoMax);
                        System.out.println("Filtro adicionado.");
                    } else {
                        System.out.println("Entrada inválida.");
                        scanner.next();
                    }
                    break;
                case 3:
                    System.out.print("Digite a distância mínima: ");
                    if (scanner.hasNextDouble()) {
                        double distMin = scanner.nextDouble();
                        filtro = filtro.and(ht -> ht.getDistancia() >= distMin);
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
                    Comparator<HistoricoTreino> novoOrdenador = null;
                    switch(ord) {
                        case 1: novoOrdenador = Comparator.comparingDouble(HistoricoTreino::getTempo); break;
                        case 2: novoOrdenador = Comparator.comparingDouble(HistoricoTreino::getTempo).reversed(); break;
                        case 3: novoOrdenador = Comparator.comparingDouble(HistoricoTreino::getDistancia); break;
                        case 4: novoOrdenador = Comparator.comparingDouble(HistoricoTreino::getDistancia).reversed(); break;
                        case 5: novoOrdenador = Comparator.comparing(HistoricoTreino::getModalidade); break;
                        default: System.out.println("Opção inválida.");
                    }
                    
                    if (novoOrdenador != null) {
                        if (ordenador == null) {
                            ordenador = novoOrdenador;
                        } else {
                            ordenador = ordenador.thenComparing(novoOrdenador);
                        }
                        System.out.println("Ordenação definida.");
                    }
                    break;
                case 5:
                    filtro = ht -> true;
                    ordenador = null;
                    System.out.println("Filtros e ordenação limpos.");
                    break;
                case 6:
                    Stream<HistoricoTreino> stream = historicos.stream().filter(filtro);
                    if (ordenador != null) {
                        stream = stream.sorted(ordenador);
                    }
                    List<HistoricoTreino> resultados = stream.collect(Collectors.toList());
                    System.out.println("\n--- RESULTADOS (" + resultados.size() + ") ---");
                    for (HistoricoTreino ht : resultados) {
                        System.out.println(ht);
                    }
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
