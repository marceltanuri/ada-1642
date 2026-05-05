import java.util.function.Predicate;

public class Exemplo2{

    public static void main(String[] args) {

        // Sistema de validação de senha, com multiplos criterios

        Predicate<String> temTamanhoMinimo = s -> s != null && s.length() >= 8;
        Predicate<String> temNumero = s -> s != null && s.matches(".*\\d.*");
        Predicate<String> temLetra = s -> s != null && s.matches(".*[a-zA-Z].*");
        Predicate<String> temLetraMaiuscula = s -> s != null && s.matches(".*[A-Z].*");
        Predicate<String> temCaractereEspecial = s -> s != null && s.matches(".*[!@#$%^&*()_+\\-=].*");

        Predicate<String> senhaValida = temTamanhoMinimo.and(temNumero).and(temLetra).and(temCaractereEspecial).and(temLetraMaiuscula);

        String senha1 = "user123";
        String senha2 = "User123@2026";

        System.out.prinln("Senha 1 é valida: " + senhaValida.test(senha1));
        System.out.prinln("Senha 2 é valida: " + senhaValida.test(senha2));

    }

}