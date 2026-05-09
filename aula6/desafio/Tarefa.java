import java.time.LocalDateTime;

public class Tarefa {

    private String codigo;
    private String titulo;
    private String descricao;
    private LocalDateTime dataPrevista;
    private LocalDateTime dataConclusao;
    private Prioridade prioridade = Prioridade.BAIXA;
    private Status status = Status.PENDENTE;
    private int pontos = 0;



    private Tarefa(String codigo, String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.codigo = codigo;
        validarCodigo();
        validarTitulo();
        validarDescricao();
    }

    public static Tarefa novaTarefaPendentePrioridadeAlta(String codigo, String titulo, String descricao) {
        Tarefa tarefa = new Tarefa(codigo, titulo, descricao);
        tarefa.atualizarStatus(Status.PENDENTE);
        tarefa.atualizarPrioridade(Prioridade.ALTA);
        return tarefa;
    }

    public static Tarefa novaTarefaPendentePrioridadeMedia(String codigo, String titulo, String descricao) {
        Tarefa tarefa = new Tarefa(codigo, titulo, descricao);
        tarefa.atualizarStatus(Status.PENDENTE);
        tarefa.atualizarPrioridade(Prioridade.MEDIA);
        return tarefa;
    }

    public static Tarefa novaTarefaPendentePrioridadeBaixa(String codigo, String titulo, String descricao) {
        Tarefa tarefa = new Tarefa(codigo, titulo, descricao);
        tarefa.atualizarStatus(Status.PENDENTE);
        tarefa.atualizarPrioridade(Prioridade.BAIXA);
        return tarefa;
    }


    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    private void validarCodigo() throws RuntimeException{
        if(this.codigo.length() < 4){
            throw new RuntimeException("Codigo inválido");
        }
    }

    private void validarTitulo() throws RuntimeException{
        if(this.titulo.length() < 5){
            throw new RuntimeException("Titulo inválido");
        }
    }

    private void validarDescricao() throws RuntimeException{
        if(this.descricao.length() < 10){
            throw new RuntimeException("Descricao inválida");
        }
    }

    private void validarPontos() throws RuntimeException{
        if(this.pontos < 0 || this.pontos > 10){
            throw new RuntimeException("Pontos inválidos");
        }
    }


    public void atualizarStatus(Status status) throws RuntimeException{
        if(this.status == Status.PENDENTE && status == Status.CONCLUIDA){
            throw new RuntimeException("Atualização de status inválida");
        }
        if(status == Status.CONCLUIDA){
            this.dataConclusao = LocalDateTime.now();
        }
        this.status = status;
    }

    public void atualizarPrioridade(Prioridade prioridade){
        this.prioridade = prioridade;
    }

    enum Prioridade {
        BAIXA, MEDIA, ALTA
    }

    enum Status {
        PENDENTE, EM_ANDAMENTO, CONCLUIDA
    }

}