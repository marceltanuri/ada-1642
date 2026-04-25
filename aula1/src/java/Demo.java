import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Demo {
    public static void main(String[] args) {
        
        LocalDateTime agora = LocalDateTime.now();
        
        System.out.println("Hello, World!");
        System.out.println("Formato Padrão: " + agora);
        
        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("Formato 1 (dd/MM/yyyy HH:mm:ss): " + agora.format(formato1));
        
        DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Formato 2 (yyyy-MM-dd): " + agora.format(formato2));
        
        DateTimeFormatter formato3 = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("Formato 3 (HH:mm:ss): " + agora.format(formato3));
    }
}
