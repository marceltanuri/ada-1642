class LoadHistorico {

    static void load() {
        Atleta atleta = new Atleta();
        atleta.nome = "João";
        atleta.nacionalidade = "Brasileiro";
        atleta.altura = 1.80;
        atleta.peso = 75.0;

        for (int i = 0; i < 150; i++) {
            Modalidade mod = Modalidade.values()[i % Modalidade.values().length];
            HistoricoTreino ht = new HistoricoTreino(atleta, mod, 60.0 + (i % 20), 100.0 + (i * 10));
            RepositorioHistoricoTreino.adicionar(ht);
        }
    }

}
