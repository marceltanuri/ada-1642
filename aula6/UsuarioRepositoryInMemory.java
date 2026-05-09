import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UsuarioRepositoryInMemory implements UsuarioRepository{

    private List<Usuario> usuarios = new ArrayList<>();

    private void carregarLista(){
        usuarios.add(new Usuario("Marcel" , "marcel@test.com",  "admin123", "00123456789"));
        usuarios.add(new Usuario("Marcel2", "marcel2@test.com", "admin123", "01123456789"));
        usuarios.add(new Usuario("Marcel3", "marcel3@test.com", "admin123", "02123456789"));
        usuarios.add(new Usuario("Marcel4", "marcel4@test.com", "admin123", "03123456789"));
        usuarios.add(new Usuario("Marcel5", "marcel5@test.com", "admin123", "04123456789"));
        usuarios.add(new Usuario("Marcel6", "marcel6@test.com", "admin123", "05123456789"));
        usuarios.add(new Usuario("Marcel7", "marcel7@test.com", "admin123", "06123456789"));
    }

    public UsuarioRepositoryInMemory() {
        carregarLista();
    }

    @Override
    public void salvar(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public List<Usuario> listar() {
        return usuarios;
    }

    @Override
    public Optional<Usuario> buscarPorCpf(String cpf) {
        return usuarios.stream()
                .filter(usuario -> usuario.getCpf().equals(cpf))
                .findFirst();
    }



}