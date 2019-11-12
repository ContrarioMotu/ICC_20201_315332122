import java.util.Iterator;
import java.util.NoSuchElementException;

/**
*Clase que modela una matriz
*@author Ayala Morales Mauricio
*/
public class Matrix implements Iterable <Double>{

    private int a;
    private int b;
    private double[][] x;

    public int getA(){
	return this.a;
    }

    public int getB(){
      return this.b;
    }

    public Matrix(int n, int m){
	this.a = n;
	this.b = m;
	this.x = new double[a][b];
    }

    public Matrix(double[][] array){
	this.x = array;
    }

    public void scalarProduct(double scalar){
        for (int a = 0;a < getA(); a++){
		for (int b = 0; b < getB(); b++){
			this.x[a][b] = this.x[a][b] * scalar;
			}
        }
    }

    public void add(Matrix m){
	for(int i = 0; i < getA(); i++){
	    for(int j = 0; j < getB(); j++){
		this.x[i][j] = this.x[i][j] + m.getElement(i, j);
	    }
	}
    }

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

    public double getElement(int i, int j){
	return this.x[i][j];
    }

    public void setElement(int i, int j,double e){
	x[i][j] = e;
    }

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

    @Override
    public Iterator <Double> iterator() {

        return new MatrixIterator();
    }

    private class MatrixIterator implements Iterator <Double>{

    private int column=1;
    private int rank= 0;

    private boolean hasNextColumn(){

        return (column < x[0].length-1)?true:false;
        }

    private boolean hasNextRank(){

        return (rank < x.length-1)?true:false;
      }

    public boolean hasNext(){

        if (this.hasNextColumn()){
            return true;
        }else return (this.hasNextRank())?true:false;
    }

     @Override
     public Double next(){

        if (hasNext()){
            if(hasNextColumn()){
                column++;
            }
            else{
                column=0;
                if(hasNextRank()){
                    rank++;
                }
            }
            return Matrix.this.x[this.rank][this.column];
        }
        return null;
      }
    }
}
