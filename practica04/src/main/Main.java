package shapesSVG;

/**
 *Main que imprime un ejemplo de cada una de las clases de la carpeta shapesSVG
 *@author Ayala Morales Mauricio
 */
public class Main{
    
    public static void main(String[] args){

	Vector2 pt = new Vector2(-30, -60);
	Linea l = new Linea(-100, 100, -20, 20);
	Rectangulo r = new Rectangulo(150, -60, 70, 20);
	Triangulo t = new Triangulo(0, 0, -50, -20, 20, -40);
        Circulo A = new Circulo(50, 50, 50);
	String htmlInicio = "<!DOCTIPE html>" + "\n" + "    <html>" + "\n" + "        <body>";

	//Fondo de 500px por 500px
	String svgInicio = "<svg width=\"500\" height=\"500\">";

	//Líneas de los ejes
	String ejes = "<line x1=\"0\" y1=\"250\" x2=\"500\" y2=\"250\" stroke=\"black\" stroke-width=\"2\" />" + "\n" + "<line x1=\"250\" y1=\"0\" x2=\"250\" y2=\"500\" stroke=\"black\" stroke-width=\"2\" />";
        String svgFin = "</svg>";
        String htmlFin = "        </body>" + "\n" + "    </html>";

        System.out.println(htmlInicio + "\n" + svgInicio);
	System.out.println(ejes);
	System.out.println(A.toSVG());
	System.out.println(pt.toSVG());
	System.out.println(l.toSVG());
	System.out.println(r.toSVG());
	System.out.println(t.toSVG());
	System.out.println(svgFin + "\n" + htmlFin);
    }
}

