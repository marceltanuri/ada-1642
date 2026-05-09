import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class TarefaService{

    private TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public void salvar(Tarefa tarefa) {
        tarefaRepository.salvar(tarefa);
    }

    public List<Tarefa> listar() {
        return tarefaRepository.listar();
    }

    public Optional<Tarefa> buscarPorCodigo(String codigo) {
        return tarefaRepository.buscarPorCodigo(codigo);
    }

    public List<Tarefa> buscarPorStatus(Tarefa.Status status) {
        return tarefaRepository.buscarPorStatus(status);
    }

    public List<Tarefa> buscarPorPrioridade(Tarefa.Prioridade prioridade) {
        return tarefaRepository.buscarPorPrioridade(prioridade);
    }

    public int calcularPontosNoPeriodo(LocalDateTime dataInicialConclusao, LocalDateTime dataFinalConclusao){
        List<Tarefa> tarefasConcluidas = tarefaRepository.buscarTarefasConcluidasNoPeriodo(dataInicialConclusao, dataFinalConclusao);

        // TODO Implentar esse codigo
        return 0;
    }

}