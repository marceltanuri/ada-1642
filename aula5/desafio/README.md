# Análise de Dados de Redes Sociais. 

Dada uma lista de postagens, identifique quais foram virais (mais de 100 visualizações), extraia apenas o número de curtidas dessas postagens e calcule o total de engajamento somando essas curtidas

```java

class Postagem {
    String conteudo;
    int visualizacoes;
    int curtidas;

    Postagem(String conteudo, int visualizacoes, int curtidas) {
        this.conteudo = conteudo;
        this.visualizacoes = visualizacoes;
        this.curtidas = curtidas;
    }
}

```

```java
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class DadosDinamicos {
  
    public static void main(String[] args) {
        Random random = new Random();
        List<Postagem> feed = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            int views = random.nextInt(2000); 
            int likes = random.nextInt(500);
            feed.add(new Postagem("Post #" + i, views, likes));
        }

        // continuação do desafio....

    }
}

```