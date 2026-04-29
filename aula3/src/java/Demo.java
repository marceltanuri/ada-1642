import java.util.List;

class Demo {

    public static void main(String a[]){
        LoadHistorico.load();
        List<HistoricoTreino> historicos = RepositorioHistoricoTreino.listarTodos();
        for (HistoricoTreino ht : historicos) {
            System.out.println(ht.atleta.nome + " " + ht.modalidade + " " + ht.tempo + " " + ht.distancia);
        }

    }

}