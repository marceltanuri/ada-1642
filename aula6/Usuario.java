public class Usuario {
    
    private String nome;
    private String email;
    private String senha;
    private String cpf;

    public Usuario(String nome, String email, String senha, String cpf) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        validarCPF();
        validaEmail();
        validaSenha();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void validarCPF() throws RuntimeException{
        if(this.cpf.length() < 11){
            throw new RuntimeException("CPF inválido");
        }
    }

    public void validaEmail() throws RuntimeException{
        if(!this.email.contains("@")){
            throw new RuntimeException("Email inválido");
        }
    }

    public void validaSenha() throws RuntimeException{
        if(this.senha.length() < 8){
            throw new RuntimeException("Senha inválida");
        }
    }


}