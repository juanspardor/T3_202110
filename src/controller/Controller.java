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
					modelo.sublista(opcion2);
					int respuesta2= modelo.darTamano();
					if(opcion2<modelo.darTamano())
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
					long stop_time = start_time+600000;
					long elapsed_time= 0;
					Comparator <YoutubeVideo> comparadorXlikes =new YoutubeVideo.ComparadorXLikes();
					Ordenamiento <YoutubeVideo> algsOrdenamientoVideos =new Ordenamiento<YoutubeVideo>();
					while (System.currentTimeMillis()<stop_time)
					{
						algsOrdenamientoVideos.ordenarInsecion((ILista<YoutubeVideo>) modelo, comparadorXlikes, true);
						stop_time = System.currentTimeMillis();
					}
					elapsed_time=start_time-stop_time;


					view.printMessage("Tiempo que tomo el proceso de carga en milisegundos del algoritmo de ordenamiento Insertion sort es: "+ (elapsed_time));
					view.printMessage("Informacion basica de los primeros 10 videos:");
					int i=1;
					while (i<=10&& i<=modelo.darTamano())
					{	
						view.printMessage("Titulo: "+ modelo.getElement(i).darTitulo() +". Numero de likes: "+String.valueOf(modelo.getElement(i).darLikes()));
						i++;
					}
					view.printMessage("Informacion basica de los ultimos 10 videos:");
					int j=modelo.darTamano();

					while (j>(modelo.darTamano()-10)&&modelo.getElement(j)!=null)
					{
						view.printMessage("Titulo: "+modelo.getElement(j).darTitulo()+ ". Numero de likes: "+String.valueOf(modelo.getElement(j).darLikes()));
						j--;
					}

					break;
				case 2:
					long start_time2 = System.currentTimeMillis();
					long stop_time2 = start_time2+600000;
					long elapsed_time2= 0;
					while (System.currentTimeMillis()<stop_time2)
					{
						ordenador.ordenarShell((ILista<YoutubeVideo>) modelo, criterio, true);
						stop_time2 = System.currentTimeMillis();
					}
					elapsed_time2=start_time2-stop_time2;


					view.printMessage("Tiempo que tomo el proceso de carga en milisegundos del algoritmo de ordenamiento es Shell sort: "+ (elapsed_time2));
					view.printMessage("Informacion basica de los primeros 10 videos:");
					int k=1;
					while (k<=10&& k<=modelo.darTamano())
					{	
						view.printMessage("Titulo: "+ modelo.getElement(k).darTitulo() +". Canal: "+modelo.getElement(k).darTrending());
						k++;
					}
					view.printMessage("Informacion basica de los ultimos 10 videos:");
					int h=modelo.darTamano();

					while (h>(modelo.darTamano()-10)&&modelo.getElement(h)!=null)
					{
						view.printMessage("Titulo: "+modelo.getElement(h).darTitulo()+ ". Canal: "+modelo.getElement(h).darTrending());
						h--;
					}

					break;
				case 3:
					long start_time3 = System.currentTimeMillis();
					long stop_time3 = start_time3+600000;
					long elapsed_time3= 0;
					while (System.currentTimeMillis()<stop_time3)
					{
						ordenador.ordenarMerge((ILista<YoutubeVideo>) modelo, criterio, true);
						stop_time3 = System.currentTimeMillis();
					}
					elapsed_time3=start_time3-stop_time3;

					view.printMessage("Tiempo que tomo el proceso de carga en milisegundos del algoritmo de ordenamiento es Merge sort: "+ (elapsed_time3));
					view.printMessage("Informacion basica de los primeros 10 videos:");
					int f=1;
					while (f<=10&& f<=modelo.darTamano())
					{	
						view.printMessage("Titulo: "+ modelo.getElement(f).darTitulo() +". Canal: "+modelo.getElement(f).darTrending());
						f++;
					}
					view.printMessage("Informacion basica de los ultimos 10 videos:");
					int g=modelo.darTamano();

					while (g>(modelo.darTamano()-10)&&modelo.getElement(g)!=null)
					{
						view.printMessage("Titulo: "+modelo.getElement(g).darTitulo()+ ". Canal: "+modelo.getElement(g).darTrending());
						g--;
					}

					break;

				case 4:
					long start_time4 = System.currentTimeMillis();
					ordenador.ordenarQuickSort((ILista<YoutubeVideo>) modelo, criterio, true);
					long stop_time4 = System.currentTimeMillis();
					view.printMessage("Tiempo que tomo el proceso de carga en milisegundos del algoritmo de ordenamiento es Quick sort: "+ (start_time4-stop_time4));
					view.printMessage("Informacion basica de los primeros 10 videos:");
					int m=1;
					while (m<=10&& m<=modelo.darTamano())
					{	
						view.printMessage("Titulo: "+ modelo.getElement(m).darTitulo() +". Canal: "+modelo.getElement(m).darTrending());
						m++;
					}
					view.printMessage("Informacion basica de los ultimos 10 videos:");
					int n=modelo.darTamano();

					while (n>(modelo.darTamano()-10)&&modelo.getElement(n)!=null)
					{
						view.printMessage("Titulo: "+modelo.getElement(n).darTitulo()+ ". Canal: "+modelo.getElement(n).darTrending());
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
					modelo.sublista(opcion_2);
					int respuesta2= modelo.darTamano();
					if(opcion_2<modelo.darTamano())
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
					ordenador.ordenarInsecion((ILista<YoutubeVideo>) modelo, criterio, true);
					long stop_time = System.currentTimeMillis();
					view.printMessage("Tiempo que tomo el proceso de carga en milisegundos del algoritmo de ordenamiento Insertion sort es: "+ (start_time-stop_time));
					view.printMessage("Informacion basica de los primeros 10 videos:");
					int i=1;
					while (i<=10&& i<=modelo.darTamano())
					{	
						view.printMessage("Titulo: "+ modelo.getElement(i).darTitulo() +". Canal: "+modelo.getElement(i).darTrending());
						i++;
					}
					view.printMessage("Informacion basica de los ultimos 10 videos:");
					int j=modelo.darTamano();

					while (j>(modelo.darTamano()-10)&&modelo.getElement(j)!=null)
					{
						view.printMessage("Titulo: "+modelo.getElement(j).darTitulo()+ ". Canal: "+modelo.getElement(j).darTrending());
						j--;
					}

					break;
				case 2:
					long start_time2 = System.currentTimeMillis();
					ordenador.ordenarShell((ILista<YoutubeVideo>) modelo, criterio, true);
					long stop_time2 = System.currentTimeMillis();
					view.printMessage("Tiempo que tomo el proceso de carga en milisegundos del algoritmo de ordenamiento es Shell sort: "+ (start_time2-stop_time2));
					view.printMessage("Informacion basica de los primeros 10 videos:");
					int k=1;
					while (k<=10&& k<=modelo.darTamano())
					{	
						view.printMessage("Titulo: "+ modelo.getElement(k).darTitulo() +". Canal: "+modelo.getElement(k).darTrending());
						k++;
					}
					view.printMessage("Informacion basica de los ultimos 10 videos:");
					int h=modelo.darTamano();

					while (h>(modelo.darTamano()-10)&&modelo.getElement(h)!=null)
					{
						view.printMessage("Titulo: "+modelo.getElement(h).darTitulo()+ ". Canal: "+modelo.getElement(h).darTrending());
						h--;
					}

					break;
				case 3:
					long start_time3 = System.currentTimeMillis();
					ordenador.ordenarMerge((ILista<YoutubeVideo>) modelo, criterio, true);
					long stop_time3 = System.currentTimeMillis();
					view.printMessage("Tiempo que tomo el proceso de carga en milisegundos del algoritmo de ordenamiento es Merge sort: "+ (start_time3-stop_time3));
					view.printMessage("Informacion basica de los primeros 10 videos:");
					int f=1;
					while (f<=10&& f<=modelo.darTamano())
					{	
						view.printMessage("Titulo: "+ modelo.getElement(f).darTitulo() +". Canal: "+modelo.getElement(f).darTrending());
						f++;
					}
					view.printMessage("Informacion basica de los ultimos 10 videos:");
					int g=modelo.darTamano();

					while (g>(modelo.darTamano()-10)&&modelo.getElement(g)!=null)
					{
						view.printMessage("Titulo: "+modelo.getElement(g).darTitulo()+ ". Canal: "+modelo.getElement(g).darTrending());
						g--;
					}

					break;

				case 4:
					long start_time4 = System.currentTimeMillis();
					ordenador.ordenarQuickSort((ILista<YoutubeVideo>) modelo, criterio, true);
					long stop_time4 = System.currentTimeMillis();
					view.printMessage("Tiempo que tomo el proceso de carga en milisegundos del algoritmo de ordenamiento es Quick sort: "+ (start_time4-stop_time4));
					view.printMessage("Informacion basica de los primeros 10 videos:");
					int m=1;
					while (m<=10&& m<=modelo.darTamano())
					{	
						view.printMessage("Titulo: "+ modelo.getElement(m).darTitulo() +". Canal: "+modelo.getElement(m).darTrending());
						m++;
					}
					view.printMessage("Informacion basica de los ultimos 10 videos:");
					int n=modelo.darTamano();

					while (n>(modelo.darTamano()-10)&&modelo.getElement(n)!=null)
					{
						view.printMessage("Titulo: "+modelo.getElement(n).darTitulo()+ ". Canal: "+modelo.getElement(n).darTrending());
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
