package model.data_structures;

public interface ILista<T extends Comparable<T>>
{
	/**
	 * Agrega un elemento al principio de la lista
	 * @param elemento a agregar
	 */
	public void addFirst(T elemento);

	/**
	 * Agrega un elemento al final de la lista
	 * @param elemento a agregar
	 */
	public void addLast(T elemento);

	/**
	 * Inserta un elemento a la lista en la posicion recibida por parametro
	 * @param elemento a agregar
	 * @param posicion en la que se debe agregar el elemento
	 */
	public void insertElement(T elemento, int posicion);

	/**
	 * Elimina el primer elemento de la lista
	 * @return
	 */
	public T removeFirst();
	
	/**
	 * Elimina el ultimo elemento de la lista
	 * @return
	 */
	public T removeLast();

	/**
	 * Elimina el elemento que esta en la posicion recibida del parametro
	 * @param posicion en la que esta el elemento a eliminar
	 * @return el elemento eliminado. Null si no se elimino ningun elemento
	 */
	public T deleteElement(int posicion);

	/**
	 * Da el primer elemento de la lista
	 * @return primer elemento de la lista
	 */
	public T firstElement();

	/**
	 * Da el ultimo elemento de la lista
	 * @return ulitmo elemento de la lista
	 */
	public T lastElement();

	/**
	 * Da el elemento en la posicion recibida por parametro
	 * @param posicion del elemento que se quiere recibir
	 * @return elemento en la posicion recibida por parametro. Null si no se retorna nada
	 */
	public T getElement(int pos);
	
	/**
	 * Da el tamanho actual de la lista
	 * @return tamanho de la lista
	 */
	public int size();
	
	/**
	 * Revisa si el arreglo esta vacio o no
	 * @return true si el arreglo no tiene datos, false de lo contrario
	 */
	public boolean isEmpty();
	
	/**
	 * Retorna la posicion valida de un elemento
	 * @param element a valida
	 * @return -1 si no se encuentra el elemento
	 */
	public int isPresent(T element);
	
	/**
	 * Intercambia la informacion de dos elementos en dos posiciones validas
	 * @param pos1 posicion 1
	 * @param pos2 posicion 2
	 */
	public void exchange(int pos1, int pos2);
	
	/**
	 * Cambia la informacion del elemento en la posicion recibida por parametro
	 * @param pos posicion del elemento a cambiar
	 * @param elemento con la informacion actualizada
	 */
	public void changeInfo(int pos, T elemento);
	

}
