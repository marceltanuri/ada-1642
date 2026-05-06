import java.util.*;
import java.util.function.*;

public class GuiaInterfacesFuncionais {

    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>(Arrays.asList("Joao", "Jose", "Maria", "Ana"));

        System.out.println("--- 1. PREDICATE (Filtro) ---");
        nomes.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String n) {
                return n.length() < 4; // Remove nomes com menos de 4 letras
            }
        });

        // nomes.removeIf(n -> n.length() < 4);
        
        System.out.println("Após removeIf (Predicate): " + nomes);

        System.out.println("\n--- 2. UNARYOPERATOR (Transformação na Própria Lista) ---");
        // O UnaryOperator recebe um tipo e retorna o MESMO tipo. Usado no replaceAll.
        // Contrato: T apply(T t);
        nomes.replaceAll(new UnaryOperator<String>() {
            @Override
            public String apply(String n) {
                return n.toUpperCase(); // Transforma tudo em maiúsculo
            }
        });

        // nomes.replaceAll(n -> n.toUpperCase());

        System.out.println("Após replaceAll (UnaryOperator): " + nomes);

        System.out.println("\n--- 3. COMPARATOR (Ordenação) ---");
        // Compara dois objetos e retorna um inteiro. Usado no sort.
        // Contrato: int compare(T o1, T o2);
        nomes.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2); // Ordem alfabética
            }
        });

        // nomes.sort((s1, s2) -> s1.compareTo(s2));

        System.out.println("Após sort (Comparator): " + nomes);

        System.out.println("\n--- 4. CONSUMER (Ação/Consumo) ---");
        // Recebe um objeto e não retorna nada (void). Usado no forEach.
        // Contrato: void accept(T t);
        nomes.forEach(new Consumer<String>() {
            @Override
            public void accept(String n) {
                System.out.println("Elemento: " + n);
            }
        });

        // nomes.forEach(n -> System.out.println("Elemento: " + n));


        System.out.println("\n--- 5. FUNCTION (Mapeamento/Transformação de Tipo) ---");
        // Recebe um tipo e retorna outro. Muito usado no .map() de Streams.
        // Contrato: R apply(T t);
        nomes.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String n) {
                return n.length();
            }
        }).forEach(tam -> System.out.println("Tamanho mapeado: " + tam));

        //nomes.stream()
          //  .map(n -> n.length())
          //  .forEach(tam -> System.out.println("Tamanho mapeado: " + tam));


        System.out.println("\n--- 6. SUPPLIER (Provedor/Gerador) ---");
        // Não recebe nada e entrega um objeto.
        // Contrato: T get();
        Supplier<String> provedorMensagem = new Supplier<String>() {
            @Override
            public String get() {
                return "Nova String vinda do Supplier!";
            }
        };
        System.out.println("Mensagem do Supplier: " + provedorMensagem.get());

        System.out.println("\n--- 7. BINARYOPERATOR (Redução/Agregação) ---");
        // Recebe dois valores do mesmo tipo e retorna um do mesmo tipo. Usado no reduce.
        // Contrato: T apply(T t1, T t2);
        String resultadoConcat = nomes.stream().reduce("NOMES:", new BinaryOperator<String>() {
            @Override
            public String apply(String s1, String s2) {
                return s1 + " - " + s2;
            }
        });

        //nomes.stream()
          //  .reduce("Nomes: ", (s1, s2) -> s1 + " - " + s2)
            //.ifPresent(resultado -> System.out.println("Resultado do Reduce: " + resultado));


        System.out.println("Resultado do Reduce: " + resultadoConcat);
    }
}