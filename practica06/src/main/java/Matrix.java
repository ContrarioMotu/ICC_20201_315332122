public class Matrix{

    private int a;
    private int b;
    private double[][] x;

    public int getA(){
	return this.a;
    }

    public int getB(){
	return this.b;
    }

    //Construye una matriz vacia de n por m
    public Matrix(int n, int m){
	this.a = n;
	this.b = m;
	this.x = new double[a][b];
    }
    
    //Construye una matriz dado un arreglo
    public Matrix(double[][] array){
	this.x = array;
    }
    
    //Función que calcula producto escalar
    public void scalarProduct(double scalar){
        for (int a = 0;a < getA(); a++){
		for (int b = 0; b < getB(); b++){
			this.x[a][b] = this.x[a][b] * scalar;
			}
        }
    }
    
    //Función que calcula suma de matrices
    public void add(Matrix m){
	for(int i = 0; i < getA(); i++){
	    for(int j = 0; j < getB(); j++){
		this.x[i][j] = this.x[i][j] + m.getElement(i, j);
	    }
	}
    }
    
    //Función que calcula producto de matrices
    public void matrixProduct(Matrix m){
        int tc = m.getB(), tf = getB();
	double mat[][] = new double[tf][tc];
	for(int a = 0; a < getA(); a++){
	        for(int b = 0; b < m.getB(); b++){
		        for(int c = 0; c < m.getA(); c++){
			        mat[a][b] += this.x[c][b] * m.getElement(b, c);
			}
		}
	} this.x = mat;
    }
    
    //Función que obtiene el elemento i j
    public double getElement(int i, int j){
	return this.x[i][j];
    }
    
    //function set element
    public void setElement(int i, int j,double e){
	x[i][j] = e;
    }
    
    //Función que calcula el determinante si es nxn
    public double determinant(){
        if(getA() != getB()){
            return 0;   
        }
        double res = 0;
        if (getA() == 1){
            res = x[0][0];
            return res;
        }
        if (getA() == 2){
            res = ((x[0][0] * x[1][1]) - (x[0][1] * x[1][0]));
            return res;
        } return res;
    }
    
    //Función que te dice si 2 matrices son iguales
    @Override
    public boolean equals(Object o){
        if(o instanceof Matrix){
		Matrix mat = (Matrix)o;
		if(mat.getA() == getA()){
			if (mat.getB() == getB()){
				for (int a = 0; a < mat.getA(); a++){
					for (int b = 0; b < mat.getB(); b++){
						if(mat.getElement(a, b)!= this.x[a][b]){
							return false;
						}
					}	
				} return true;
			}
		}
	} return false;
}
}
