import java.util.Optional;

public class UsuarioService{

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<Usuario> pesquisaPorCpf(String cpf){
        return this.usuarioRepository.buscarPorCpf(cpf);
    }


    

}