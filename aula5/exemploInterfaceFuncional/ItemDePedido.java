public class ItemDePedido{

	private Produto produto;
	private int quantidade;

	public ItemDePedido(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public Produto produto() {
		return produto;
	}

	public int quantidade() {
		return quantidade;
	}

}
