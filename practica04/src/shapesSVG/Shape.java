package shapesSVG;

/**
 * Clase abstracta que modela una cuerpo geométrico en el plano.
 */
public abstract class Shape implements Comparable <Shape> {

    protected Vector2 inicio;

    /**
     * Constructor de la posición inicial de un cuerpo geométrico
     * @param a - Posición inicial
     */
    public Shape(Vector2 a) {
        this.inicio = a;
    }

    /**
     * Metodo para asignarle una posición inicial al cuerpo geométrico
     * @param a - Vector de la posición inicial del cuerpo geométrico
     */
    public void setA(Vector2 a) {
        this.inicio = a;
    }

    /**
     * Metodo para obtener la posición inicial del cuerpo geométrico
     * @return Vector de la posición inicial del cuerpo geométrico
     */
    public Vector2 getA() {
        return this.inicio;
    }

    /**
     * Metodo para obtener el área del cuerpo geométrico
     * @return Área del cuerpo geométrico
     */
    public abstract double getArea();

    /**
     * Metodo para obtener el perímetro del cuerpo geométrico
     * @return Perímetro del cuerpo geométrico
     */
    public abstract double getPerimetro();

    /**
     * Metodo para representar el cuerpo geométrico en SVG
     * @return Código SVG para representar el cuerpo geométrico
     */
    public abstract String toSVG();

    /**
     * Metodo para comparar el área de dos cuerpos geométricos
     * @param p - Cuerpo geométrico con el que se comparará
     * @return Regresa 1 si la figura actual tiene un area mayor, 0 si tienen la misma area ó -1 si la figura tiene menor area
     */
    @Override
    public int compareTo(Shape p) {
        if (this.getArea() > p.getArea()) {
            return 1;
        } else {
            if (this.getArea() < p.getArea()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
