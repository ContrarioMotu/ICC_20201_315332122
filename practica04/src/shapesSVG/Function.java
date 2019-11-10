package shapesSVG;

/**
 * Interfaz funcional para transformar los vertices de un triángulo
 */
public interface Function{

    /**
     * Funcion que transforma un punto en otro punto
     * @param p - El punto a transformar
     * @return Imágen del punto transformado
     */
    public Vector2 transform(Vector2 p);
}
