class RespiracaoHumana implements Respiracao{

    @Override
    public void inspirar(double oxigenio) {
        System.out.println("Inspirando " + oxigenio + " ml de oxigênio pelos pulmões humanos.");
    }

    @Override
    public void expirar() {
        System.out.println("Expirando gás carbônico.");
    }


}