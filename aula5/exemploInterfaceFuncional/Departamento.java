public class Departamento {

	private String nome;

	public Departamento(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Departamento that = (Departamento) o;

		return nome != null ? nome.equals(that.nome) : that.nome == null;
	}

	@Override
	public int hashCode() {
		return nome != null ? nome.hashCode() : 0;
	}

}