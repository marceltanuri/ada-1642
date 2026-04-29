import java.util.ArrayList;
import java.util.List;

class RepositorioHistoricoTreino{

    static List<HistoricoTreino> historicos = new ArrayList<>();

    public static void adicionar(HistoricoTreino historico) {
        historicos.add(historico);
    }

    public static List<HistoricoTreino> listarTodos() {
        return historicos;
    }



}