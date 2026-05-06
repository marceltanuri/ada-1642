import java.util.Arrays;
import java.util.List;

public class Solucao {

    public static void main(String[] args) {
        List<Postagem> postagens = Arrays.asList(
            new Postagem("Aprendendo Java", 100, 50),
            new Postagem("Streams em Java", 500, 200),
            new Postagem("Desafio de Programação", 50, 10),
            new Postagem("Java Avançado", 1000, 450),
            new Postagem("Functional Programming", 300, 150),
            new Postagem("Object Oriented Programming", 200, 100),
            new Postagem("Design Patterns", 150, 75)
        );

        int totalCurtidasPopulares = postagens.stream()
            .filter(p -> p.visualizacoes > 100)
            .map(p -> p.curtidas)
            .reduce(0, (subtotal, curtidas) -> subtotal + curtidas);

        System.out.println("Total de curtidas em postagens com mais de 100 visualizações: " + totalCurtidasPopulares);
    }


}