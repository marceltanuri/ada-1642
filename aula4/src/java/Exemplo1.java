import java.time.LocalDate;
import java.time.Period;
import java.util.function.Predicate;



public class Exemplo1{

    public static void main(String[] args) {

        // Calcular o valor de entrada de um convidado em um sistema de Festa Infantil

        // Data de Nascimento, se menor que 7 anos é isento
        // Entre 7 e 12 é meia entrada
        // Acima de 12 é entrada inteira

        double valorEntrada = 100.0;

        LocalDate dataNascimento = LocalDate.of(2015, 5, 20);
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataNascimento, dataAtual);
        int idade = periodo.getYears();

        Predicate<Integer> isIsento = i -> i < 7;
        Predicate<Integer> isMeia = i -> i >= 7 && i <= 12;
        Predicate<Integer> isInteira = i -> i > 12;

        double valorASerPago = 0.0;

        if(isIsento.test(idade)){
            valorASerPago = 0.0;
        }else if(isMeia.test(idade)){
            valorASerPago = valorEntrada / 2;
        }else if(isInteira.test(idade)){
            valorASerPago = valorEntrada;
        }

        System.out.println("Valor a ser pago: " + valorASerPago);

    }
}