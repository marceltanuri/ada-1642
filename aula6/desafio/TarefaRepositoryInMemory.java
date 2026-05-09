import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TarefaRepositoryInMemory implements TarefaRepository {

    private List<Tarefa> tarefas = new ArrayList<>();

    public TarefaRepositoryInMemory() {
        Tarefa t1 = Tarefa.novaTarefaPendentePrioridadeBaixa("T001", "Estudar Java", "Revisar conceitos de OO e interfaces");
        Tarefa t2 = Tarefa.novaTarefaPendentePrioridadeMedia("T002", "Fazer exercícios", "Resolver os desafios da aula 6");
        Tarefa t3 = Tarefa.novaTarefaPendentePrioridadeAlta("T003", "Revisar código", "Revisar as pull requests pendentes");
        Tarefa t4 = Tarefa.novaTarefaPendentePrioridadeAlta("T004", "Deploy em PRD", "Realizar o deploy da aplicação em produção");
        Tarefa t5 = Tarefa.novaTarefaPendentePrioridadeBaixa("T005", "Ler documentação", "Ler a documentação do novo framework");

        // Ajustando status
        t2.atualizarStatus(Tarefa.Status.EM_ANDAMENTO);
        
        t3.atualizarStatus(Tarefa.Status.EM_ANDAMENTO);
        t3.atualizarStatus(Tarefa.Status.CONCLUIDA);
        
        t4.atualizarStatus(Tarefa.Status.EM_ANDAMENTO);
        t4.atualizarStatus(Tarefa.Status.CONCLUIDA);

        // Usando reflection para definir datas que não possuem setters na classe Tarefa
        // para cobrir os casos de uso de datas expiradas e concluídas no passado
        setField(t1, "dataPrevista", LocalDateTime.now().minusDays(2)); // Expirada
        setField(t2, "dataPrevista", LocalDateTime.now().plusDays(5)); // No prazo
        setField(t3, "dataPrevista", LocalDateTime.now().minusDays(1)); // Expirada
        setField(t3, "dataConclusao", LocalDateTime.now().minusDays(10)); // Concluida há 10 dias
        setField(t4, "dataPrevista", LocalDateTime.now().plusDays(2)); 
        setField(t4, "dataConclusao", LocalDateTime.now().minusDays(2)); // Concluida há 2 dias

        tarefas.add(t1);
        tarefas.add(t2);
        tarefas.add(t3);
        tarefas.add(t4);
        tarefas.add(t5);
    }

    private void setField(Object obj, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salvar(Tarefa tarefa) {
        // TODO: Implementar
        throw new UnsupportedOperationException("Método não implementado. Alunos, divirtam-se!");
    }

    @Override
    public List<Tarefa> listar() {
        // TODO: Implementar
        throw new UnsupportedOperationException("Método não implementado. Alunos, divirtam-se!");
    }

    @Override
    public Optional<Tarefa> buscarPorCodigo(String codigo) {
        // TODO: Implementar
        throw new UnsupportedOperationException("Método não implementado. Alunos, divirtam-se!");
    }

    @Override
    public List<Tarefa> buscarPorStatus(Tarefa.Status status) {
        // TODO: Implementar
        throw new UnsupportedOperationException("Método não implementado. Alunos, divirtam-se!");
    }

    @Override
    public List<Tarefa> buscarPorPrioridade(Tarefa.Prioridade prioridade) {
        // TODO: Implementar
        throw new UnsupportedOperationException("Método não implementado. Alunos, divirtam-se!");
    }

    @Override
    public List<Tarefa> buscarTarefasComDataPrevistaExpirada() {
        // TODO: Implementar
        throw new UnsupportedOperationException("Método não implementado. Alunos, divirtam-se!");
    }

    @Override
    public List<Tarefa> buscarTarefasConcluidasNoPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal) {
        // TODO: Implementar
        throw new UnsupportedOperationException("Método não implementado. Alunos, divirtam-se!");
    }
}