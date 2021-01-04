package ejercicio1;
//  @author adanz
import java.util.Scanner;
public class ConsultaDiccionario {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      Diccionario dic = new Diccionario();
      String ingles;
      while (true) {
         System.out.println("Teclee una palabra en inglés (para terminar teclee 00)");
         ingles = sc.next();
         if (ingles.equals("00")) {
            System.exit(0);
         }
         String espanol = dic.get(ingles);
         if (espanol != null) {
            System.out.println(ingles + " en español se dice: " + espanol);
         } else {
            System.out.println(ingles + " no se encontró en el diccionario");
         }
      }
   }
}
