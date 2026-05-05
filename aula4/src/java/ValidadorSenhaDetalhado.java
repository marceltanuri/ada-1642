import java.util.Map;
import java.util.LinkedHashMap;
import java.util.function.Predicate;
import java.util.ArrayList;

import java.util.List;
public class ValidadorSenhaDetalhado {
    public static void main(String[] args) {
        
        Predicate<String> temTamanhoMinimo = s -> s != null && s.length() >= 8;
        Predicate<String> temNumero = s -> s != null && s.matches(".*\\d.*");
        Predicate<String> temLetra = s -> s != null && s.matches(".*[a-zA-Z].*");
        Predicate<String> temLetraMaiuscula = s -> s != null && s.matches(".*[A-Z].*");
        Predicate<String> temCaractereEspecial = s -> s != null && s.matches(".*[!@#$%^&*()_+\\-=].*");

        Map<Predicate<String>, String> regras = new LinkedHashMap<>();
        regras.put(temTamanhoMinimo, "A senha deve ter pelo menos 8 caracteres.");
        regras.put(temNumero, "A senha deve conter pelo menos um número.");
        regras.put(temLetra, "A senha deve conter pelo menos uma letra.");
        regras.put(temLetraMaiuscula, "A senha deve conter pelo menos uma letra maiúscula.");
        regras.put(temCaractereEspecial, "A senha deve conter pelo menos um caracter");

        String senhaParaTestar = "user123";

        List<String> erros = new ArrayList<>();

        regras.forEach((predicado, mensagem) -> {
            if (!predicado.test(senhaParaTestar)) {
                erros.add(mensagem);
            }
        });

        if (erros.isEmpty()) {
            System.out.println("Senha válida!");
        } else {
            System.out.println("Falha na validação");
            erros.forEach(e -> System.out.println("- " + e));
        }
    }
}