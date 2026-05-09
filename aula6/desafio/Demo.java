public class Demo{

    public static void main(String[] args) {
        TarefaRepository repository = new TarefaRepositoryInMemory();
        TarefaService service = new TarefaService(repository);

        System.out.println("--- Listagem de Tarefas ---");

        System.out.println("\n--- Buscando Tarefa T002 ---");

        System.out.println("\n--- Tarefas com Prioridade ALTA ---");

        System.out.println("\n--- Tarefas com Status PENDENTE ---");

        System.out.println("\n--- Total de pontos no período ---");



    }
    


}