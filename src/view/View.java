package view;

import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
	    public void printMenu()
		{
			System.out.println("1. Carga la fuente de datos de los videos a una lista encadenada");
			System.out.println("2. Carga la fuente de datos de los videos a un arreglo dinamico");
			System.out.println("3. Exit");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}
	    
	    public void printMenu2()
		{
			System.out.println("Ingrese la muestra de los videos cargados");
			System.out.println("0. Exit");
			System.out.println("Dar un número mayor a cero para el tamaño de la lista de la muestra de videos cargada, teclear 0 si quiere exit , luego oprimir tecla Return: (e.g., 135):");		
		}
	    
	    public void printMenu3()
		{
			System.out.println("El algoritmo a aplicar en la muestra de los videos es:");
			System.out.println("1. Isertion sort");
			System.out.println("2. Shell sort");
			System.out.println("3. Merge sort");
			System.out.println("4. Quick sort");
			System.out.println("5. Exit");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");		
		}


		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(Modelo modelo)
		{
			System.out.println(modelo);
			// TODO implementar
		}
}
