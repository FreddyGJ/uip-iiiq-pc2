import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        String nom = "";
        double nota;
        BufferedReader x = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.print("Introduce tu nombre: ");
            try {
                nom = x.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (nom.matches(".*\\d+.*")) {
                System.out.println("Tienes un numero por ahi");
            }
        } while (nom.matches(".*\\d+.*"));

        System.out.print("Favor introduzca su nota: ");
        try {
            nota = Double.parseDouble(x.readLine());
        } catch (Exception e) {
            System.out.print("Valor incorrecto.");
            nota = -1;
        }

        if (nota < 0 || nota > 150) {
            System.out.println("No es una nota valida...");
        } else if (nota >= 91) {
            System.out.println("Su nombre es " + nom + " y obtuvo una A.");
        } else if (nota >= 81){
            System.out.println("Su nombre es " + nom + " y obtuvo una B.");
        } else if (nota >= 71) {
            System.out.println("Su nombre es " + nom + " y obtuvo una C.");
        } else if (nota < 70){
            System.out.println("Su nombre es " + nom + " y obtuvo una F.");
        }
    }
}