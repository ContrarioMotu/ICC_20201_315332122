package shapesSVG;

/**
 *Clase que moldea un círculo
 *@author Ayala Morales Mauricio
 */
public class Circulo extends Shape{
    private double r;
    private double peri;
    private double area;

    /**
     *Método para asignar valor al centro del circulo
     *@param c - nuevo vector del centro del círculo
     */
    public void setCentro(Vector2 c){
      super.setA(c);
    }

    /**
     *Método para obtener el vector del centro del círculo
     *@return coordenadas del centro del círculo
     */
    public Vector2 getCentro(){
      return super.getA();
    }

    /**
     *Método para asignar radio al círculo
     *@param r - nuevo radio del círculo
     */
    public void setRadio(double r){
      this.r = r;
    }

    /**
     *Método para obtener el radio del círculo
     *@return valor del radio
     */
    public double getRadio(){
      return this.r;
    }

    /**
     *Método para asignar un valor al radio
     *tal que el círculo tenga el perímetro deseado
     *@param p - perímetro deseado
     */
    public void setPerimetro(double p){
      this.r = (p)/(2 * Math.PI);
    }

    /**
     *Método para obtener el perímetro del círculo
     *@return valor del perímetro
     */
    public double getPerimetro(){
      return 2 * Math.PI * getRadio();
    }

    /**
     *Método para asignar un valor al radio
     *tal que el círculo tenga el área deseada
     *@param a - área deseada
     */
    public void setArea(double a){
      this.r = Math.sqrt(a/Math.PI);
    }

    /**
     *Método para obtener el área del círculo
     *@return valor del área
     */
    public double getArea(){
      return Math.PI * getRadio() * getRadio();
    }

    /**
     *Constructor que crea un círculo
     *@param c - vector del centro del círculo
     *@param r - radio del círculo
     */
    public Circulo(Vector2 c, double r){
      super(c);
      this.r = r;
    }

    /**
     *Constructor que crea un círculo
     *@param x - coordenada x del centro
     *@param y - coordenada y del centro
     *@param r - radio del círculo
     */
    public Circulo(double x, double y, double r){
      super(new Vector2(x, y));
      this.r = r;
    }

    /**
     *Constructor que crea un círculo
     *con centro en (50, 50) y radio = 200
     */
    public Circulo(){
      super(new Vector2(50, 50));
      this.r = 200;
    }

    /**
     *Método para representar en SVG
     *@return código para representar en SVG
     */
    public String toSVG(){
      double cx = 250 + inicio.getX();
      double cy = 250 - inicio.getY();
      return "<circle cx=\"" + cx + "\" cy=\"" + cy + "\" r=\"" + getRadio() + "\" fill=\"orange\" stroke=\"black\" stroke-width=\"2\" />";
    }

    /**
     *Método para convertir un círculo en string
     *@return String con las coordenadas del centro y el radio del círculo
     */
    @Override
    public String toString(){
      return "Centro en: (" + inicio.getX() + ", " + inicio.getY() + ")" + "\n" + "Radio = " + getRadio();
    }

    /**
     *Método para saber si dos círculos tienen mismo radio
     *y por lo tanto mismo perímetro y misma área
     *@param círculo con el que se quiere comparar
     *@return true si el radio es igual, false en otro caso
     */
    public boolean equals(Object s){
      if(s instanceof Circulo){
        Circulo t = (Circulo)s;
        return r == t.getRadio();
      } else return false;
    }
  }
