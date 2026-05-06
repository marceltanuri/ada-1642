public class Pedido {

  private List<ItemDePedido> itens;

  // construtor.....
  
  public double calcularValorTotalPorDepartamento(Departamento departamento) {
          final double valorInicial = 0.0;
          Double resultado = itens.stream()
                  .filter(
                      new Predicate<ItemDePedido>() {
                          @Override
                          public boolean test(ItemDePedido item) {
                              return item.produto().getDepartamento().equals(departamento);
                          }
                       }
                      //item -> item.produto().getDepartamento().equals(departamento)
                  )
                  .map(
                      new Function<ItemDePedido, Double>() {
                          @Override
                          public Double apply(ItemDePedido item) {
                              return item.produto().getPreco() * item.quantidade();
                          }
                      }
                      //item -> item.produto().getPreco() * item.quantidade()
                  )
                  .reduce(
                      valorInicial, 
                      new BinaryOperator<Double>() {
                          @Override
                          public Double apply(Double contador, Double preco) {
                              return contador + preco;
                          }
                      }
                      //(contador, preco) -> contador + preco
                  );
  
          return resultado;
      }
}