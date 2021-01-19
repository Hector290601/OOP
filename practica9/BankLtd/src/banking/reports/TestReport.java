package banking.reports;
import banking.data.DataSource;
import java.io.IOException;
public class TestReport {
   private static final String USO
         = "Este programa necesita como argumento la ruta al archivo de datos";
   public static void main(String[] args) {
      if (args.length != 1) {
         System.err.println(USO);
      } else {
         String dataFilePath = args[0];
         try {
            System.out.println("Leyendo el archivo: " + dataFilePath + "\n");
            DataSource dataSource = new DataSource(dataFilePath);
            dataSource.loadData();
            CustomerReport report = new CustomerReport();
            report.generateReport();
         } catch (IOException ioe) {
            System.out.println("No se pudo cargar el archivo.");
            System.out.println(ioe.getMessage());
            ioe.printStackTrace(System.out);
         }
      }
   }
}
