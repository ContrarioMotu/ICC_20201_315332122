package shapesSVG;
import shapesSVG.Function;
/**
 *Clase para modelar un triángulo
 *@author Ayala Morlaes Mauricio
 */
public class Triangulo extends Shape{
    private Vector2 b;
    private Vector2 c;
    private double peri;
    private double area;

    /**
     *Método para asignar valor al vector b
     *@param b - nuevas coordenadas del vector b
     */
    public void setB(Vector2 b){
      this.b = b;
    }

    /**
     *Método para obtener el valor del vector b
     *@return coordenadas del vector b
     */
    public Vector2 getB(){
      return this.b;
    }

    /**
     *Método para asignar valor al vector c
     *@param c - nuevas cordenadas del vector c
     */
    public void setC(Vector2 c){
      this.c = c;
    }

    /**
     *Método para obtener el valor del vector c
     *@return coordenadas del vector c
     */
    public Vector2 getC(){
      return this.c;
    }

    /**
     *Método para obtener el perímetro del triángulo
     *@return perímetro del triángulo
     */
    public double getPerimetro(){
      Linea s = new Linea(inicio.getX(), inicio.getY(), b.getX(), b.getY());
      Linea t = new Linea(b.getX(), b.getY(), c.getX(), c.getY());
      Linea u = new Linea(c.getX(), c.getY(), inicio.getX(), inicio.getY());
      return s.getLongitud() + t.getLongitud() + u.getLongitud();
    }

    /**
     *Método para obtener el área del triángulo
     *(fórmula de Herón)
     *@return area del triángulo
     */
    public double getArea(){
      Linea h = new Linea(inicio.getX(), inicio.getY(), b.getX(), b.getY());
      Linea i = new Linea(b.getX(), b.getY(), c.getX(), c.getY());
      Linea j = new Linea(c.getX(), c.getY(), inicio.getX(), inicio.getY());
      double k = (h.getLongitud() + i.getLongitud() + j.getLongitud())/2;
      return Math.sqrt(k *(k - h.getLongitud()) * (k - i.getLongitud()) * (k - j.getLongitud()));
    }

    /**
     *Constructor que crea un triángulo
     *@param a - vector del primer vértice
     *@param b - vector del segundo vértice
     *@param c - vector del tercer vértice
     */
    public Triangulo(Vector2 a, Vector2 b, Vector2 c){
      super(a);
      this.b = b;
      this.c = c;
    }

    /**
     *Constructor que crea un triángulo
     *@param x1 - coordenada x del primer vértice
     *@param y1 - coordenada y del primer vértice
     *@param x2 - coordenada x del segundo vértice
     *@param y2 - coordenada y del segundo vértice
     *@param x3 - coordenada x del tercer vértice
     *@param y3 - coordenada y del tercer vértice
     */
    public Triangulo(double x1, double y1, double x2, double y2, double x3, double y3){
      super(new Vector2(x1, y1));
      this.b = new Vector2(x2, y2);
      this.c = new Vector2(x3, y3);
    }

    /**
     *Constructor que crea un triángulo
     *con coordenadas a = (100, 100), b = (200, 50 ), c = (0, 50)
     */
    public Triangulo(){
      super(new Vector2(100, 100));
      this.b = new Vector2(200, 50);
      this.c = new Vector2(0, 50);
    }

    /**
     *Método para representar en SVG
     *@return codigo para representar en SVG
     */
    public String toSVG(){
      double cx1 = 250 + inicio.getX();
      double cy1 = 250 - inicio.getY();
      double cx2 = 250 + b.getX();
      double cy2 = 250 - b.getY();
      double cx3 = 250 + c.getX();
      double cy3 = 250 - c.getY();
      return "<polygon points=\"" + cx1 + ", " + cy1 + " " + cx2 + ", " + cy2 + " " + cx3 + ", " + cy3 + "\" fill=\"green\" stroke=\"black\" stroke-width=\"2\" />";
    }

    /**
     *Método para representar en string los vertices del triángulo
     *@return String con las coordenadasde los vertices del triángulo
     */
    @Override
    public String toString(){
      return "Vertices en: (" + inicio.getX() + ", " + inicio.getY() + ") , (" + b.getX() + ", " + b.getY() + ") , (" + c.getX() + ", " + c.getY() + ")";
    }

    /**
     *Método para saber si dos triángulos tienen mismo perímetro y área
     *@param triángulo con el que se quiere comparar
     *@return true si tienen mismo perímetro y área, false en otro caso
     */
    public boolean equals(Object s){
      if(s instanceof Triangulo){
        Triangulo t = (Triangulo)s;
        return peri == t.getPerimetro() && area == t.getArea();
      } else return false;
    }

    /**
     * Metodo que recibe una interfaz funcional y aplica esa función a los vertices del triángulo
     * @param p Función que se le aplicará al triangulo
     */
    public void transform(Function p) {
        this.inicio = p.transform(inicio);
        this.b = p.transform(b);
        this.c = p.transform(c);
    }
  }
