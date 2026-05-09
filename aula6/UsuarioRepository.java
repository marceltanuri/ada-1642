import java.util.List;
import java.util.Optional;

public interface UsuarioRepository{

    void salvar(Usuario usuario);

    List<Usuario> listar() ;

    Optional<Usuario> buscarPorCpf(String cpf);

}