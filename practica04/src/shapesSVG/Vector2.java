package shapesSVG;

/**
 *Clase que modela un vector
 *@author Ayala Morales Mauricio
 */
public class Vector2{

    private double x;
    private double y;
    private double magnitud;

    /**
     *Método para obtener coordenada x
     */
    public double getX(){
	return this.x;
    }

    /**
     *Método para obtener cooredenada y
     */
    public double getY(){
	return this.y;
    }

    /**
     *Método para asignar valor a la coordenada x
     *@param x - nuevo valor de la coordenada x
     */
    public void setX(double x){
	this.x = x;
    }
    
    /**
     *Método para asignar valor a la coordenada y
     *@param y - nuevo valor de la coorednada y
     */
    public void setY(double y){
	this.y = y;
    }

    /**
     *Método para obtener la magnitud de un vector
     */
    public double getMagnitud(){
	return (Math.sqrt((getX() * getX()) + (getY() * getY())));
    }
    
    /**
    *Contructor que recibe una coordenada (x, y) y crea un punto
    *@param x - coordenada en el eje de las abscisas
    *@param y - coordenada en el eje de las ordenadas
    */
    public Vector2(double x, double y){
	this.x = x;
	this.y = y;
    }

    /**
     *Constructor que crea un punto en la coorednada (0, 0)
     */
    public Vector2(){
	this.x = 0;
	this.y = 0;
    }

    /**
     *Método que  mide la distancia a otro vector
     *@param z - recibe un valor del tipo Vector2
     */
    public double distancia(Vector2 z){
	return (Math.sqrt((z.getX() - x)*(z.getX() - x) + (z.getY() - y)*(z.getY() - y)));
    }
    
    /**
     *Método para representar un vector en SVG
     *@return String del codigo para representar en SVG
     */
    public String toSVG(){
        double cx = 250 + getX();
        double cy = 250 - getY();
	return "<circle cx=\"" + cx + "\"  cy=\"" + cy + "\"  r=\"4\"  fill=\"blue\" />";
    }
    
    /**
     *Método para convertir una coordenada a cadena de caracteres
     *@return String de las coordenadas del vector, (x, y)
     */
    @Override
    public String toString(){
	return "(" + getX() + ", " + getY() + ")";
    }

    /**
     *Método para saber si dos vectores son iguales
     *@param p - vector con el que se quiere comparar
     *@return true si los puntos son iguales, false e otro caso
     */
    public boolean equals(Object p){
	if (p instanceof Vector2){
	    Vector2 v = (Vector2)p;
	    return x == v.getX() && y == v.getY();
	} else return false;
    }
}
