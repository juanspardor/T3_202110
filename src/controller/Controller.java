package controller;

import java.util.Scanner;

import model.logic.Cronometro;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo(0);
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option)
			{

			case 1:
				view.printMessage("Realiza carga de datos de los videos a una lista encadenada\n");
				Cronometro cronometroTimer1= new Cronometro();
				modelo = new Modelo(1); 
				view.printMessage("Informacion basica del primer video:");
				view.printMessage("Titulo:"+ modelo.getFirst().darTitulo() +"canal"+modelo.getFirst().darCanal());
				view.printMessage("Informacion basica del ultimo video:");
				view.printMessage("Titulo:"+modelo.getLast().darTitulo()+ "canal"+modelo.getLast().darCanal());
				view.printMessage("Cantidad total de videos encotrados:"+ modelo.darTamano());
				view.printMessage("Tiempo que tomo el proceso de carga en segundos:"+cronometroTimer1.elapsedTime());

				break;

			case 2:
				view.printMessage("Realiza carga de datos de los videos a un arreglo dinamico\n");
				Cronometro cronometroTimer2= new Cronometro();
				modelo = new Modelo(2); 
				view.printMessage("Informacion basica del primer video:");
				view.printMessage("Titulo:"+ modelo.getFirst().darTitulo() +"canal"+modelo.getFirst().darCanal());
				view.printMessage("Informacion basica del ultimo video:");
				view.printMessage("Titulo:"+modelo.getLast().darTitulo()+ "canal"+modelo.getLast().darCanal());
				view.printMessage("Cantidad total de videos encotrados:"+ modelo.darTamano());
				view.printMessage("Tiempo que tomo el proceso de carga en segundos:"+cronometroTimer2.elapsedTime());



				break;


			case 3: 
				view.printMessage("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;	

			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;


			}
		}
	}
}
