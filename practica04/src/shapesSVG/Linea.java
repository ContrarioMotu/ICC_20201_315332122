package shapesSVG;

/**
 *Método que moldea una línea a partir de la clase Vector2
 *@author Ayala Morales Mauricio
 */
public class Linea extends Shape{
    private Vector2 fin;
    private double magnitud;

    /**
     *Método para asignar valor a un vector B
     *@param b - nuevas coordenadas del vector
     */
    public void setB(Vector2 b){
      this.fin = b;
    }

    /**
     *Método para obtener el valor del vector B
     *@return coordenadas del vector
     */
    public Vector2 getB(){
      return this.fin;
    }

    /**
     *Método para medir la longitud de una linea,
     *de un vector A a un vector B
     *@return longitud de la línea
     */
    public double getLongitud(){
      return Math.sqrt((inicio.getX() - fin.getX())*(inicio.getX() - fin.getX()) + (inicio.getY() - fin.getY()) * (inicio.getY() - fin.getY()));
    }

    /**
     *Constructor para crear una línea del vector "a" al vector "b"
     *@param a - coordenadas del vector inicial
     *@param b - coordenadas del vector final
     */
    public Linea(Vector2 a, Vector2 b){
      super(a);
      this.fin = b;
    }

    /**
     *Constructor para crear una línea usando coordenadas de dos vectores
     *@param x1 - coordenada x del primer vector
     *@param y1 - coordenada y del primer vector
     *@param x2 - coordenada x del segundo vector
     *@param y2 - coordenada y del segundo vector
     */
    public Linea(double x1, double y1, double x2, double y2){
      super(new Vector2 (x1, y1));
      this.fin = new Vector2 (x2, y2);
    }

    /**
     *Constructor para crear una línea del punto (0, 0) al punto (10, 10)
     */
    public Linea(){
      super(new Vector2 (0, 0));
      this.fin = new Vector2 (10, 10);
    }

    /**
    *Método para calcular el área de una línea
    *@return 0 ya que las líneas no tienen Área jejeje
    */
    public double getArea(){
      return 0;
    }

    /**
    *Método para obtener el perímetro de la línea
    *@return El perímetro de la línea, que es lo mismo que su longitud
    */
    public double getPerimetro(){
      return getLongitud();
    }

    /**
     *Método para representar una línea en SVG
     *@return String del codigo para representar en SVG
     */
    public String toSVG(){
        double cx1 = 250 + inicio.getX();
        double cy1 = 250 - inicio.getY();
        double cx2 = 250 + fin.getX();
        double cy2 = 250 - fin.getY();
        return "<line x1=\"" + cx1 + "\" y1=\"" + cy1 + "\" x2=\"" + cx2 + "\" y2=\"" + cy2 + "\" stroke=\"blue\" stroke-width=\"4\" />";
    }

    /**
     *Método para convertir las coordenadas de los extremos de una línea a cadena de caracteres
     *@return String de las coordenadas de los extremos de la recta
     */
    @Override
    public String toString(){
      return "(" + inicio.getX() + ", " + inicio.getY() + ") , (" + fin.getX() + ", " + fin.getY() + ")";
    }
    /**
     *Método para saber si dos líneas son iguales
     *@param s - línea con la que se quiere comparar
     *@return true si las líneas son iguales, false en otro caso
     */
    public boolean equals(Object s){
      if (s instanceof Linea){
        Linea l = (Linea)s;
        return inicio == l.getA() && fin == l.getB();
      } else return false;
    }
  }
