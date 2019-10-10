import java.util.ArrayList;
import java.util.Arrays;

/**
 *Práctica 05
 *@author Ayala Morales Mauricio
 */
public class Control{

    /**
     *Saber si una palabra es palíndromo
     *@param palabra - Palabra que se analizará
     *@return true si la palabra e un palíndromo, false en otro caso
     */
    public static boolean problema1(String palabra){
	int inicio = 0;
	int fin = palabra.length() - 1;
	boolean pal = true;
	while(inicio < fin){
	    if(palabra.charAt(inicio) != palabra.charAt(fin)){
		pal = false;
	    }
	    inicio++;
	    fin--;
	} return pal;
    }

    /**
     *Determina si hay 2 números en el arreglo que sumen
     *un número deseado.
     *@param arreglo - Arreglo del que se evaluarán sus valores
     *@param k - Número que se desea obtener
     *@return true si existen los números que sumados el número deseado, false en otro caso
     */
    public static boolean problema2(int[] arreglo, int k){
	boolean suma = false;
	for(int i = 0; i < arreglo.length; i++){
	    for(int j = 1; j < arreglo.length; j++){
	        if(arreglo[i] + arreglo[j] == k){
		    suma = true;
	        }
	    }
	} return suma;
    }

    /**
     *Ordena los valores de un arreglo
     *@param arreglo - areglo que se desea ordenar
     *@return El arreglo con sus valores ordenados
     */
    public static void problema3(int[] arreglo){
        boolean intercambio = true;
        int j = 0;
        int temp;
        while (intercambio) {
            intercambio = false;
            j++;
            for (int i = 0; i < arreglo.length - j; i++) {
                if (arreglo[i] > arreglo[i + 1]) {
                    temp = arreglo[i];
                    arreglo[i] = arreglo[i + 1];
                    arreglo[i + 1] = temp;
                    intercambio = true;
                }
            }
        }
    }

    /**
     *Busca un número deseado dentro de un arreglo
     *@param arreglo - Arreglo en el que se desea buscar
     *@param buscando - Número que se está buscando
     *@return true si e número deseado se encuentra en el arreglo, false en otro caso
     */
    public static boolean problema4(int[] arreglo, int buscando){
	boolean busqueda = false;
	for(int a = 0; a < arreglo.length; a++){
	    if(arreglo[a] == buscando){
		busqueda = true;
	    }
        } return busqueda;
    }

    /**
     *Saber si un número es primo
     *@param n - Número que se desea evaluar
     *@return true si el número es primo, false en otro caso
     */
    public static boolean problema5(int n){
	boolean primo = true;
	switch(n){
	case 0 | 1:
	    primo = false;
	    break;
	case 2:
	    primo = true;
	    break;
	default:
	    for(int c = 2; c < n; c++){
		if(n % c == 0){
		    primo = false;
		}
	    }
	} return primo;
    }
    /**
     *Regresa un Array con los números primos menores a un número deseado
     *@param n - Número mayor a todos los primos del array
     *@return Array con los números primos menores a n
     */
    public static int[] problema6(int n){
	int cont = 0;
	for(int i = 1; i <= n; i++){
	    if(problema5(i)){
		cont++;
	    }
	}
	int[] primos = new int[cont];
	int cont2 = 0;
	for(int j = 1; j < n; j++){
	    if(problema5(j)){
		primos[cont2] = j;
		cont2++;
		    }
	} return primos;
    }

    public static void main(String[] args) {
        String resultado = "";
        int[] desordenado = {9,8,7,6,5,4,3,2,1};
        int[] ordenado    = {1,2,3,4,5,6,7,8,9};
        int[] primos10 = {2,3,5,7};
        if(problema1("oso")==true && problema1("palabra")==false)resultado+="P1 bien\n";else resultado+="P1 mal\n";
        if(problema2(desordenado, 17)==true) resultado+="P2 bien\n";else resultado+="P2 mal\n";
        problema3(desordenado);
        if(Arrays.equals(desordenado,ordenado) == true)resultado+="P3 bien\n";else resultado+="P3 mal\n";
        if(problema4(desordenado,2) == true && problema4(desordenado,18) == false) resultado+="P4 bien\n";else resultado+="P4 mal\n";
        if(problema5(7)==true && problema5(6)==false)resultado+="P5 bien\n";else resultado+="P5 mal\n";
        if(Arrays.equals(problema6(10), primos10) == true)resultado+="P6 bien\n";else resultado+="P6 mal\n";
        System.out.println(resultado);   
    }

}
