import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.concurrent.atomic.AtomicInteger;

public class BuscadorLog {

    public static void main(String[] args) {
        // --- 1. VALIDAÇÃO DOS ARGUMENTOS ---
        if (args.length < 2) {
            System.out.println("Uso: java BuscadorLog <arquivo.log> <Excecao>");
            return;
        }

        Path caminho = Paths.get(args[0]);
        String alvo = args[1];

        // --- 2. CONTADOR ATÔMICO ---
        // Usamos AtomicInteger porque variáveis locais simples não podem ser 
        // alteradas dentro de um Stream (devem ser 'effectively final').
        AtomicInteger contador = new AtomicInteger(0);

        // --- 3. LEITURA EFICIENTE (NIO + STREAMS) ---
        // Try w/ resources (Aprofundar nessa técnica)
        // Files.lines abre o arquivo como um fluxo (não carrega o arquivo todo na RAM)
        try (Stream<String> linhas = Files.lines(caminho)) {
            
            System.out.println("Buscando '" + alvo + "' em: " + caminho.toAbsolutePath());

            // O Pipeline do Stream:
            Optional<String> encontrada = linhas
                .peek(linha -> contador.incrementAndGet()) // Incrementa o número da linha atualStream<String> linhas = Files.lines(caminho)
                .filter(linha -> linha.contains(alvo))     // Testa se a exceção está na linha
                .findFirst();                              // Para TUDO assim que achar a primeira

            // --- 4. EXIBIÇÃO DOS RESULTADOS ---
            if (encontrada.isPresent()) {
                System.out.println("\n✅ OCORRÊNCIA ENCONTRADA!");
                System.out.println("--------------------------------------");
                System.out.println("Linha: " + contador.get());
                System.out.println("Conteúdo: " + encontrada.get().trim());
                System.out.println("--------------------------------------");
            } else {
                System.out.println("\n❌ A exceção '" + alvo + "' não foi encontrada no arquivo.");
            }

        } catch (IOException e) {
            // Tratamento de erro caso o arquivo não exista ou esteja inacessível
            System.err.println("Erro ao ler o arquivo de log: " + e.getMessage());
        }
    }
}