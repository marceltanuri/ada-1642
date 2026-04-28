class Humano{

	public Humano(Respiracao respiracao, int capacidadeOxigenio) {
		this.respiracao = respiracao;
        this.capacidadeOxigenio = capacidadeOxigenio;
	}

	public void respirarProfundo() {
		respiracao.inspirar(capacidadeOxigenio*0.9);
		respiracao.expirar();
	}

    public void respirar() {
		respiracao.inspirar(capacidadeOxigenio*0.6);
		respiracao.expirar();
	}

    public Respiracao getRespiracao() {
        return respiracao;
    }

    private int capacidadeOxigenio;

	private final Respiracao respiracao;
}