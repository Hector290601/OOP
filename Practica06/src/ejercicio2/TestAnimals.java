package ejercicio2;
public class TestAnimals {
   public static void main(String[] args) {
      System.out.println("Se va a construir un Fish");
      Fish d = new Fish();
      System.out.println("Se va a construir un Cat con nombre");
      Cat c = new Cat("Fluffy");
      System.out.println("Se va a construir un Fish con variable de tipo Animal");
      Animal a = new Fish();
      System.out.println("Se va a construir un Spider con variable de tipo Animal");
      Animal e = new Spider();
      System.out.println("Se va a construir un Cat con variable de tipo Pet");
      Pet p = new Cat();
      System.out.println("Probando métodos del primer Fish... (sin nombre)");
      System.out.println("getName: " + d.getName());
      d.play();
      d.walk();
      d.eat();
      System.out.println("Probando métodos del Cat Fluffy...");
      System.out.println("getName: " + c.getName());
      c.play();
      c.walk();
      c.eat();
      System.out.println("Probando métodos del segundo Fish...");
      // System.out.println("getName: " + a.getName());   // OJO No compila porque Animal no tiene método play() y la variable es de tipo Animal
      // a.play();				                      // Sería necesario implementar play() en Animal aunque no se ejecutaría nunca
      a.walk();
      a.eat();
      System.out.println("Probando métodos del Spider...");
      // System.out.println("getName: " + e.getName());        // no compila porque Spider NO implementa Pet
      // e.play();				               // no compila porque Spider NO implementa Pet
      e.walk();
      e.eat();
   }
}