class HistoricoTreino {

    Atleta atleta;
    Modalidade modalidade;
    double tempo, distancia;

    public HistoricoTreino(Atleta atleta, Modalidade modalidade, double tempo, double distancia){
        this.atleta = atleta;
        this.modalidade = modalidade;
        this.tempo = tempo;
        this.distancia = distancia;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public double getTempo() {
        return tempo;
    }

    public double getDistancia() {
        return distancia;
    }

    @Override
    public String toString() {
        return String.format("Atleta: %s, Modalidade: %s, Tempo: %.2f, Distância: %.2f", 
                atleta.getNome(), modalidade, tempo, distancia);
    }
}
