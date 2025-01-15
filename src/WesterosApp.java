import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WesterosApp {
    public static void readFile(String dateiName) {
        try (BufferedReader br = new BufferedReader(new FileReader(dateiName))) {
            String zeile;
            System.out.println("Inhalt der Datei:");

            while ((zeile = br.readLine()) != null) {
                System.out.println(zeile);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Die Datei " + dateiName + " wurde nicht gefunden.");
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei: " + e.getMessage());
        }
    }
}
