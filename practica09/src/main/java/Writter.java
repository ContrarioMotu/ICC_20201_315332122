import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;
import processing.core.PApplet;
import processing.core.PImage;

/**
*Clase que lee coordenadas de un archivo externo, grafica los puntos en un plano
*e imprime sus coordenadas polares en la terminal
*@author Ayala Morales Mauricio
*/
public class Writter extends PApplet {

    public static void main(String[] args) {
        PApplet.main("Writter");
    }

    @Override
    public void settings() {
        size(200, 200);
    }

    @Override
    public void setup() {
        fill(125, 0, 0);
        String file = getClass().getResource("coord.txt").getPath();
        draw2(file);
    }

    @Override
    public void draw() {
    }

    public void draw2(String file) {
        try {
            float radio = 3;
            List<String> lines = Files.readAllLines(Paths.get(file));
            for (String string : lines) {
                String row[] = string.split(",");
                ellipse(Float.parseFloat(row[0]), Float.parseFloat(row[1]), radio, radio);
                float r = sqrt((Float.parseFloat(row[0]))*(Float.parseFloat(row[0])) + (Float.parseFloat(row[1]))*(Float.parseFloat(row[1])));
                double theta = Math.atan((Double.parseDouble(row[1]))/(Double.parseDouble(row[0])));
                System.out.println("r = " + r + ", θ = " + theta);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
