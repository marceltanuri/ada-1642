class SimulacaoAtleta{

    public static void main(String[] a){
        Respiracao respiracao = new RespiracaoHumana();
        Humano humano = new Humano(respiracao, 100);
        humano.getRespiracao().inspirar(100);
        humano.getRespiracao().expirar();
    }

}