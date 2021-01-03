package ejercicio1;
public class TestExceptions {
  public static void main(String[] args) {
      for ( int i = 0; true; i++ ) {
        try{
            System.out.println("args[" + i + "] is '" + args[i] + "'");
          }
        catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("Algo salió mal :(, terminando programa de manera segura");
            System.out.println("Exception: " + ex.getMessage());
            System.out.println("Bueno bai c:");
            System.exit(4);
        }
    }
  }
}
