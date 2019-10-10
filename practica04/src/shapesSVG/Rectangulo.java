package shapesSVG;

/**
 *Clase que modela un Rectángulo
 *@author Ayala Morales Mauricio
 */
public class Rectangulo{

    private Vector2 a;
    private double ancho;
    private double alto;
    private double peri;
    private double area;
    
    /**
     *Método que le asigna un valor al vector a
     *(coordenada de la esquina superior izquierda del rectángulo)
     *@param a - nuevo valor del vector a
     */
    public void setA(Vector2 a){
	this.a = a;
    }

    /**
     *Método para obtener el valor del vector a
     *(coordenada de la esquina superior izquierda del rectángulo)
     *@return coordenadas del vector a
     */
    public Vector2 getA(){
	return this.a;
    }

    /**
     *Método para asignar el ancho del rectángulo
     *(medida desde el vector inicial hacia la derecha)
     *@param ancho - ancho del rectágulo
     */
    public void setAncho(double ancho){
	this.ancho = ancho;
    }

    /**
     *Método para obtener el ancho del rectángulo
     *@return ancho del rectángulo
     */
    public double getAncho(){
	return this.ancho;
    }

    /**
     *Método para asignar la altura al rectángulo
     *(medida desde el vetor inicial hacia abajo)
     *@param alto - altura del rectángulo
     */
    public void setAlto(double alto){
	this.alto = alto;
    }

    /**
     *Método para obtener la altura del rectangulo
     *@return altura del rectángulo
     */
    public double getAlto(){
	return this.alto;
    }

    /**
     *Método para obtener el perímetro del rectángulo
     *@return perímetro del rectángulo
     */
    public double getPerimetro(){
	return ((2 * getAncho()) + (2 * getAlto()));
    }

    /**
     *Método para obtener el área del rectángulo
     *@return área del rectángulo
     */
    public double getArea(){
	return ((getAncho()) * (getAlto()));
    }

    /**
     *Constructor que crea un rectángulo
     *@param a - vector de la esquina superior izquierda del rectángulo
     *@param ancho - ancho del rectángulo
     *@param alto - altura del rectángulo
     */
    public Rectangulo(Vector2 a, double ancho, double alto){
	this.a = a;
	this.ancho = ancho;
	this.alto = alto;
    }

    /**
     *Constructor que crea un rectángulo
     *@param x - coordenada x de la esquina superior izquierda
     *@param y - coordenada y de la esquina superior izquierda
     *@param ancho - ancho del rectángulo
     *@param alto - altura del rectángulo
     */
    public Rectangulo(double x, double y, double ancho, double alto){
	this.a = new Vector2(x, y);
	this.ancho = ancho;
	this.alto = alto;
    }

    /**
     *Constructor que crea un rectángulo
     *con coordenadas (10, 10), ancho = 100 y alto = 200
     */
    public Rectangulo(){
	this.a = new Vector2(10, 10);
	this.ancho = 100;
	this.alto = 200;
    }

    /**
     *Método para representar un rectángulo en SVG
     *@return codigo para representar en SVG
     */
    public String toSVG(){
	double cx = 250 + a.getX();
	double cy = 250 - a.getY();
	return "<rect x=\"" + cx + "\" y=\"" + cy + "\" width=\"" + getAncho() + "\" height=\"" + getAlto() + "\" fill=\"red\" stroke=\"black\" stroke-width=\"2\" />";
    }

    /**
     *Método para representar los datos del rectángulo en un string
     *@return String con las coordenadas del vector, ancho, alto, perímetro y área
     */
    @Override
    public String toString(){
	return "(" + a.getX() + ", " + a.getY() + ")" + "\n" + "Ancho = " + getAncho() + "\n" + "Alto = " + getAlto() + "Perímetro = " + getPerimetro() + "\n" + "Área = " + getArea();
    }

    /**
     *Método para saber si dos rectángulos tienen mismo perímetro y área
     *@return true si los rectángulos tienen mismo perimetro y área, false en otro caso
     */
    public boolean equals(Object q){
	if(q instanceof Rectangulo){
	    Rectangulo p = (Rectangulo)q;
	    return ancho == p.getAncho() && alto == p.getAlto();
	} else return false;
    }
}
