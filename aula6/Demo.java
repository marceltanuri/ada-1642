import java.util.Optional;

public class Demo{

    public static void main(String[] args) {

        UsuarioRepository repository = new UsuarioRepositoryInMemory();
        UsuarioService service = new UsuarioService(repository);

        String cpfParaBuscar = args[0];
        Optional<Usuario> usuario = service.pesquisaPorCpf(cpfParaBuscar);

        usuario.ifPresentOrElse(
            u -> System.out.println("Usuario encontrado: " + u.getNome()),
            () -> System.out.println("Usuario nao encontrado")
        );
    }

}