import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

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

    public static void displayNameByInitial(String dateiName) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geben Sie einen Großbuchstaben ein: ");
        String buchstabe = scanner.nextLine();

        if (buchstabe.length() != 1 || !Character.isUpperCase(buchstabe.charAt(0))) {
            System.out.println("Bitte geben Sie einen gültigen Großbuchstaben ein.");
            return;
        }

        char filterBuchstabe = buchstabe.charAt(0);

        try (BufferedReader br = new BufferedReader(new FileReader(dateiName))) {
            String zeile;
            System.out.println("Namen beginnend mit '" + filterBuchstabe + "':");

            while ((zeile = br.readLine()) != null) {
                String[] felder = zeile.split("\t");

                if (felder.length > 1) {
                    String name = felder[1].trim();
                    if (name.charAt(0) == filterBuchstabe) {
                        System.out.println(name);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Die Datei " + dateiName + " wurde nicht gefunden.");
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei: " + e.getMessage());
        }
    }

}
