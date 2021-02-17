package model.logic;

import java.io.File;
import java.io.Reader;
import java.lang.Object;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import model.data_structures.ILista;
import model.data_structures.ListaEncadenada;
import model.data_structures.YoutubeVideo;


/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo  
{

	/**
	 * Atributos del modelo del mundo
	 */
	private ILista<YoutubeVideo> datos;


	public Modelo()
	{
		
	}

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo(int opcion)
	{
		if (opcion==1)
		{
			datos= new ListaEncadenada<YoutubeVideo>(null) ;
		}
		else
		{
			datos = new ArregloDinamico<YoutubeVideo>(7);
		}
		try
		{
		cargarDatos();
		}
		
		catch(Exception e)
		{
			System.out.println("No se pudieron subir los datos");
		}

	}


	public YoutubeVideo getFirst()
	{
		return datos.firstElement();
	}
	
	public YoutubeVideo getLast()
	{
		return datos.lastElement();
	}
	
	
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.size();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(YoutubeVideo dato)
	{	
		datos.addLast(dato);
	}

	




	public void cargarDatos() throws Exception
	{
		final Reader lector = new InputStreamReader (new FileInputStream(new File("./data/videos-small.csv")),"UTF-8");
		final CSVParser parser = new CSVParser(lector, CSVFormat.EXCEL.withFirstRecordAsHeader().withDelimiter(','));
		
		
		try
		{
			for(final CSVRecord record : parser)
			{
				
				String id = record.get("video_id");
			
				
				String trendingString = record.get("trending_date");
				Date fechaTrending = new SimpleDateFormat("yy:dd:mm").parse(trendingString);				
				String titulo = record.get("title");
				String canal = record.get("channel_title");
				int categoria = Integer.parseInt(record.get("category_id"));
				String publishString = record.get("publis_time");
				String[] fechas = publishString.split("T");
				String[] horas = fechas[1].split(".");
				String finalPublish = fechas[1]+" "+horas[0];
				Date publicacion = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(finalPublish);
				Long vistas = Long.parseLong(record.get("views"));
				String tageados = record.get("tags");
				Long likes = Long.parseLong(record.get("likes"));
				Long dislikes = Long.parseLong(record.get("dislikes"));
				Long comentarios = Long.parseLong(record.get("comment_count"));
				String url = record.get("thumnbnail_link");
				String comentariosEnabled = record.get("comments_disabled");
				String ratingsEnabled = record.get("ratings_disabled");
				String erorPosible = record.get("video_error");
				String descrip = record.get("description");
				String pais = record.get("country");

				YoutubeVideo nuevo = new YoutubeVideo(id, fechaTrending, titulo, canal, categoria, publicacion, tageados, vistas, likes, dislikes, comentarios, url, comentariosEnabled, ratingsEnabled, erorPosible, descrip, pais);
				datos.addLast(nuevo); 
			}
		}
		finally
		{
			lector.close();
			parser.close();
		}
	}


}
