import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        try {
            short[] multas = {20, 50, 150};
            int totalPorPagar = 0;

            final HashMap<Short, VelocidadYMultas> velocidades = new HashMap<>();

            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nombre: ");
            final String nombre = br.readLine();
            System.out.print("Cantidad de velocidades: ");
            final int velocidadesTotales = Integer.parseInt(br.readLine());

            int velocidadTotal = 0;

            short keys = 0;
            for (int i = 0; i < velocidadesTotales; i++) {
                try {
                    final short velocidad = Short.parseShort(br.readLine());
                    if (!velocidades.containsKey(keys)) {
                        final VelocidadYMultas velocidadYMultas = new VelocidadYMultas();
                        short multa = 0;
                        if (velocidad >= 60 && velocidad <= 119) {
                            multa = multas[0];
                        } else if (velocidad >= 120 && velocidad <= 159) {
                            multa = multas[1];
                        } else if (velocidad >= 160) {
                            multa = multas[2];
                        }
                        totalPorPagar += multa;

                        velocidadTotal += velocidad;
                        velocidadYMultas.multa = multa;
                        velocidadYMultas.velocidad = velocidad;
                        velocidades.put(keys, velocidadYMultas);
                    }

                    keys++;
                } catch (NumberFormatException e) { // si el input tiene mal formato..
                    System.out.println("Al parecer la velocidad que colocaste tiene mal formato..");
                    i--;
                    continue;
                }
            }

            final StringBuilder builder = new StringBuilder();
            builder.append("Nombre: " + nombre + "\r\n");
            builder.append("Velocidades totales: " + velocidades.size() + "\r\n"); // las guardadas en el mapa
            for (Map.Entry<Short, VelocidadYMultas> entry : velocidades.entrySet()) {
                builder.append("#" + (entry.getKey() +1) + ": Velocidad -> " + entry.getValue().velocidad + ", Multa-> " + entry.getValue().multa + "\r\n");
            }

            builder.append("Multa total: " + totalPorPagar + "\r\n");
            builder.append("Velocidad total:" + velocidadTotal + "\r\n");

            try (final Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("ATTT.txt"), "utf-8"))) {
                writer.write(builder.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class VelocidadYMultas
{
    public short multa;
    public short velocidad;
}
