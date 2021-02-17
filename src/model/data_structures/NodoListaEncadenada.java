package model.data_structures;

public class NodoListaEncadenada < T extends Comparable <T>> 
{
	private T info;
	private NodoListaEncadenada<T> next;
	
	public NodoListaEncadenada(T informacion)
	{
		info=informacion;
		next=null;
	}
	
	public T getInfo()
	{
		return this.info;
	}
	
	
	public NodoListaEncadenada<T> getNext()
	{
		return this.next;
	}
	
	
	public void setNext(NodoListaEncadenada<T> elSiguiente)
	{
		
		this.next= elSiguiente;
	
	}
	
	public void cambiarInfo(T elemento)
	{
		info=elemento;
	}
	

}
