package controller;

import java.util.Comparator;
import java.util.Scanner;

import model.data_structures.ILista;
import model.data_structures.YoutubeVideo;
import model.logic.Cronometro;
import model.logic.Modelo;
import utils.Ordenamiento;
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
		modelo = new Modelo();
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";
		Ordenamiento<YoutubeVideo> ordenador = new Ordenamiento<YoutubeVideo>();
		Comparator<YoutubeVideo> criterio = new YoutubeVideo.ComparadorXLikes();
		ILista<YoutubeVideo> sub = null;

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option)
			{

			case 1:
				view.printMessage("Realiza carga de datos de los videos a una lista encadenada\n");
				modelo = new Modelo(1);
				view.printMessage("El total de videos cargado en la lista encadenada es: " +modelo.darTamano());

				view.printMenu2();
				int opcion2 = lector.nextInt();
				if(opcion2>0)
				{
					view.printMessage("Se obtiene la muestra de videos de la lista cargada del tamaño de :"+ opcion2);
					sub = modelo.sublista(opcion2);
					int respuesta2= sub.size();
					if(opcion2<sub.size())
					{
						respuesta2=opcion2;
					}
					view.printMessage("El número de videos que contiene la muestra es: "+ respuesta2);
				}

				else if (opcion2 ==0)
				{
					view.printMessage("-------------------- \n Hasta pronto !! \n--------------------"); 
					lector.close();
					fin = true;
					break;	
				}

				else
				{
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
				}


				view.printMenu3();
				int opcion3 = lector.nextInt();
				switch (opcion3)
				{
				case 1:
					long start_time = System.currentTimeMillis();
					ordenador.ordenarInsecion(sub, criterio, true);
					long stop_time = System.currentTimeMillis();
					view.printMessage("Tiempo que tomo el proceso de carga en milisegundos del algoritmo de ordenamiento Insertion sort es: "+ (start_time-stop_time)*-1);
					view.printMessage("Informacion basica de los primeros 10 videos:");
					int i=1;
					while (i<=10&& i<=sub.size())
					{	
						view.printMessage("Titulo: "+ sub.getElement(i).darTitulo() +". Numero Likes: "+sub.getElement(i).darLikes());
						i++;
					}
					view.printMessage("Informacion basica de los ultimos 10 videos:");
					int j=sub.size();

					while (j>(sub.size()-10)&&sub.getElement(j)!=null)
					{
						view.printMessage("Titulo: "+ sub.getElement(j).darTitulo() +". Numero Likes: "+sub.getElement(j).darLikes());
						j--;
					}

					break;
				case 2:
					long start_time2 = System.currentTimeMillis();
					ordenador.ordenarShell(sub, criterio, true);
					long stop_time2 = System.currentTimeMillis();
					view.printMessage("Tiempo que tomo el proceso de carga en milisegundos del algoritmo de ordenamiento es Shell sort: "+ (start_time2-stop_time2)*-1);
					view.printMessage("Informacion basica de los primeros 10 videos:");
					int k=1;
					while (k<=10&& k<=sub.size())
					{	
						view.printMessage("Titulo: "+ sub.getElement(k).darTitulo() +". Numero Likes: "+sub.getElement(k).darLikes());
						k++;
					}
					view.printMessage("Informacion basica de los ultimos 10 videos:");
					int l=sub.size();

					while (l>(sub.size()-10)&&sub.getElement(l)!=null)
					{
						view.printMessage("Titulo: "+ sub.getElement(l).darTitulo() +". Numero Likes: "+sub.getElement(l).darLikes());
						l--;
					}

					break;
				case 3:
					long start_time3 = System.currentTimeMillis();
					ordenador.ordenarMerge(sub, criterio, true);
					long stop_time3 = System.currentTimeMillis();
					view.printMessage("Tiempo que tomo el proceso de carga en milisegundos del algoritmo de ordenamiento es Merge sort: "+ (start_time3-stop_time3)*-1);
					view.printMessage("Informacion basica de los primeros 10 videos:");
					int f=1;
					while (f<=10&& f<=sub.size())
					{	
						view.printMessage("Titulo: "+ sub.getElement(f).darTitulo() +". Numero Likes: "+sub.getElement(f).darLikes());
						f++;
					}
					view.printMessage("Informacion basica de los ultimos 10 videos:");
					int g=sub.size();
					if(sub.size()>=20) {g=sub.size()-10;}
					else {g=11;}
		
					for(int y =g;y<=sub.size();y++)
					{
						view.printMessage("Titulo: "+ sub.getElement(y).darTitulo() +". Numero Likes: "+sub.getElement(y).darLikes());
					}

					break;

				case 4:
					long start_time4 = System.currentTimeMillis();
					ordenador.ordenarQuickSort(sub, criterio, true);
					long stop_time4 = System.currentTimeMillis();
					view.printMessage("Tiempo que tomo el proceso de carga en milisegundos del algoritmo de ordenamiento es Quick sort: "+ (start_time4-stop_time4)*-1);
					view.printMessage("Informacion basica de los primeros 10 videos:");
					int m=1;
					while (m<=10&& m<=sub.size())
					{	
						view.printMessage("Titulo: "+ sub.getElement(m).darTitulo() +". Numero Likes: "+sub.getElement(m).darLikes());
						m++;
					}
					view.printMessage("Informacion basica de los ultimos 10 videos:");
					int n=sub.size();

					while (n>(sub.size()-10)&&sub.getElement(n)!=null)
					{
						view.printMessage("Titulo: "+ sub.getElement(n).darTitulo() +". Numero Likes: "+sub.getElement(n).darLikes());
						n--;
					}

					break;
				case 5:
					view.printMessage("-------------------- \n Hasta pronto !! \n--------------------"); 
					lector.close();
					fin = true;
					break;
					
				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;


				}


			case 2:

				view.printMessage("Realiza carga de datos de los videos a una arreglo dinamico\n");
				modelo = new Modelo(2);
				view.printMessage("El total de videos cargado en el arreglo dinamico es: " +modelo.darTamano());

				view.printMenu2();
				int opcion_2 = lector.nextInt();
				if(opcion_2>0)
				{
					view.printMessage("Se obtiene la muestra de videos de la lista cargada del tamaño"+ opcion_2);
					sub = modelo.sublista(opcion_2);
					int respuesta2= modelo.darTamano();
					if(opcion_2<sub.size())
					{
						respuesta2=opcion_2;
					}
					view.printMessage("El número de videos que contiene la muestra es: "+ respuesta2);
				}

				else if (opcion_2 ==0)
				{
					view.printMessage("-------------------- \n Hasta pronto !! \n--------------------"); 
					lector.close();
					fin = true;
					break;	
				}

				else
				{
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
				}


				view.printMenu3();
				int opcion_3 = lector.nextInt();

				switch (opcion_3)
				{
				case 1:
					long start_time = System.currentTimeMillis();
					ordenador.ordenarInsecion(sub, criterio, true);
					long stop_time = System.currentTimeMillis();
					view.printMessage("Tiempo que tomo el proceso de carga en milisegundos del algoritmo de ordenamiento Insertion sort es: "+ (start_time-stop_time)*-1);
					view.printMessage("Informacion basica de los primeros 10 videos:");
					int i=1;
					while (i<=10&& i<=sub.size())
					{	
						view.printMessage("Titulo: "+ sub.getElement(i).darTitulo() +". Numero Likes: "+sub.getElement(i).darLikes());
						i++;
					}
					view.printMessage("Informacion basica de los ultimos 10 videos:");
					int j=sub.size();

					while (j>(sub.size()-10)&&sub.getElement(j)!=null)
					{
						view.printMessage("Titulo: "+ sub.getElement(j).darTitulo() +". Numero Likes: "+sub.getElement(j).darLikes());
						j--;
					}

					break;
				case 2:
					long start_time2 = System.currentTimeMillis();
					ordenador.ordenarShell(sub, criterio, true);
					long stop_time2 = System.currentTimeMillis();
					view.printMessage("Tiempo que tomo el proceso de carga en milisegundos del algoritmo de ordenamiento es Shell sort: "+ (start_time2-stop_time2)*-1);
					view.printMessage("Informacion basica de los primeros 10 videos:");
					int k=1;
					while (k<=10&& k<=sub.size())
					{	
						view.printMessage("Titulo: "+ sub.getElement(k).darTitulo() +". Numero Likes: "+sub.getElement(k).darLikes());
						k++;
					}
					view.printMessage("Informacion basica de los ultimos 10 videos:");
					int l=sub.size();

					while (l>(sub.size()-10)&&sub.getElement(l)!=null)
					{
						view.printMessage("Titulo: "+ sub.getElement(l).darTitulo() +". Numero Likes: "+sub.getElement(l).darLikes());
						l--;
					}

					break;
				case 3:
					long start_time3 = System.currentTimeMillis();
					ordenador.ordenarMerge(sub, criterio, true);
					long stop_time3 = System.currentTimeMillis();
					view.printMessage("Tiempo que tomo el proceso de carga en milisegundos del algoritmo de ordenamiento es Merge sort: "+ (start_time3-stop_time3)*-1);
					view.printMessage("Informacion basica de los primeros 10 videos:");
					int f=1;
					while (f<=10&& f<=sub.size())
					{	
						view.printMessage("Titulo: "+ sub.getElement(f).darTitulo() +". Numero Likes: "+sub.getElement(f).darLikes());
						f++;
					}
					view.printMessage("Informacion basica de los ultimos 10 videos:");
					int g=sub.size();

					while (g>(sub.size()-10)&&sub.getElement(g)!=null)
					{
						view.printMessage("Titulo: "+ sub.getElement(g).darTitulo() +". Numero Likes: "+sub.getElement(g).darLikes());
						g--;
					}

					break;

				case 4:
					long start_time4 = System.currentTimeMillis();
					ordenador.ordenarQuickSort(sub, criterio, true);
					long stop_time4 = System.currentTimeMillis();
					view.printMessage("Tiempo que tomo el proceso de carga en milisegundos del algoritmo de ordenamiento es Quick sort: "+ (start_time4-stop_time4)*-1);
					view.printMessage("Informacion basica de los primeros 10 videos:");
					int m=1;
					while (m<=10&& m<=sub.size())
					{	
						view.printMessage("Titulo: "+ sub.getElement(m).darTitulo() +". Numero Likes: "+sub.getElement(m).darLikes());
						m++;
					}
					view.printMessage("Informacion basica de los ultimos 10 videos:");
					int n=sub.size();

					while (n>(sub.size()-10)&&sub.getElement(n)!=null)
					{
						view.printMessage("Titulo: "+ sub.getElement(n).darTitulo() +". Numero Likes: "+sub.getElement(n).darLikes());
						n--;
					}

					break;
				case 5:
					view.printMessage("-------------------- \n Hasta pronto !! \n--------------------"); 
					lector.close();
					fin = true;
					break;
					
				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;

				}

			case 3: 
				view.printMessage("-------------------- \n Hasta pronto !! \n--------------------"); 
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
