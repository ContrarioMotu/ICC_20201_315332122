package shapesSVG;

/**
 *Método que moldea una línea a partir de la clase Vector2
 *@author Ayala Morales Mauricio
 */
public class Linea{
    private Vector2 a;
    private Vector2 b;
    private double lg;

    /**
     *método para asignar valor a un vector A
     *@param a - nuevas coordenadas del vector
     */
    public void setA(Vector2 a){
	this.a = a;
    }

    /**
     *Método para obtener las coordenadas del vector A
     *@return coordenadas del vector
     */
    public Vector2 getA(){
	return this.a;
    }

    /**
     *Método para asignar valor a un vector B
     *@param b - nuevas coordenadas del vector
     */
    public void setB(Vector2 b){
	this.b = b;
    }

    /**
     *Método para obtener el valor del vector B
     *@return coordenadas del vector
     */
    public Vector2 getB(){
	return this.b;
    }

    /**
     *Método para medir la longitud de una linea,
     *de un vector A a un vector B
     *@return longitud de la línea
     */
    public double getLongitud(){
	return Math.sqrt((a.getX() - b.getX())*(a.getX() - b.getX()) + (a.getY() - b.getY()) * (a.getY() - b.getY()));
    }

    /**
     *Constructor para crear una línea del vector "a" al vector "b"
     *@param a - coordenadas del vector inicial
     *@param b - coordenadas del vector final
     */
    public Linea(Vector2 a, Vector2 b){
	this.a = a;
	this.b = b;
    }

    /**
     *Constructor para crear una línea usando coordenadas de dos vectores
     *@param x1 - coordenada x del primer vector
     *@param y1 - coordenada y del primer vector
     *@param x2 - coordenada x del segundo vector
     *@param y2 - coordenada y del segundo vector
     */
    public Linea(double x1, double y1, double x2, double y2){
	this.a = new Vector2 (x1, y1);
	this.b = new Vector2 (x2, y2);
    }

    /**
     *Constructor para crear una línea del punto (0, 0) al punto (10, 10)
     */
    public Linea(){
	this.a = new Vector2 (0, 0);
	this.b = new Vector2 (10, 10);
    }

    /**
     *Método para representar una línea en SVG
     *@return String del codigo para representar en SVG
     */
    public String toSVG(){
        double cx1 = 250 + a.getX();
        double cy1 = 250 - a.getY();
        double cx2 = 250 + b.getX();
        double cy2 = 250 - b.getY();
	return "<line x1=\"" + cx1 + "\" y1=\"" + cy1 + "\" x2=\"" + cx2 + "\" y2=\"" + cy2 + "\" stroke=\"blue\" stroke-width=\"4\" />";
    }

    /**
     *Método para convertir las coordenadas de los extremos de una línea a cadena de caracteres
     *@return String de las coordenadas de los extremos de la recta
     */
    @Override
    public String toString(){
	return "(" + a.getX() + ", " + a.getY() + ") , (" + b.getX() + ", " + b.getY() + ")";
    }
    /**
     *Método para saber si dos líneas son iguales
     *@param s - línea con la que se quiere comparar
     *@return true si las líneas son iguales, false en otro caso
     */
    public boolean equals(Object s){
	if (s instanceof Linea){
	    Linea l = (Linea)s;
	    return a == l.getA() && b == l.getB();
	} else return false;
    }
}
	
