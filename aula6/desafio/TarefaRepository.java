import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TarefaRepository{

    void salvar(Tarefa tarefa);

    List<Tarefa> listar() ;

    Optional<Tarefa> buscarPorCodigo(String codigo);

    List<Tarefa> buscarPorStatus(Tarefa.Status status);

    List<Tarefa> buscarPorPrioridade(Tarefa.Prioridade prioridade);

    List<Tarefa> buscarTarefasComDataPrevistaExpirada();

    List<Tarefa> buscarTarefasConcluidasNoPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal);






}