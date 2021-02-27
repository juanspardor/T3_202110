package utils;

import java.util.Comparator;

import model.data_structures.ILista;

public class Ordenamiento<T extends Comparable<T>>
{

	public void ordenarInsecion(ILista<T> lista, Comparator<T> criterio, boolean ascendente)
	{
		for(int i = 2; i<=lista.size();i++)
		{
			boolean enPosicion = false;
			for(int j = i; j>1 && !enPosicion; j--)
			{
				int comparacion = (ascendente?1:-1)*criterio.compare(lista.getElement(j), lista.getElement(i));
				if(comparacion<0)
				{
					lista.exchange(j, j-1);
				}
				else
				{
					enPosicion = true;
				}
			}
		}
	}
	
	public void ordenarShell(ILista<T> lista, Comparator<T> criterio, boolean ascendente)
	{
		int n = lista.size();
		int h = 1;
		
		while(h<n/3)
		{
			h=3*1+1;
		}
		
		while(h>=1)
		{
			for(int i = h+1;i<n;i++)
			{
				boolean enPosicion = false;
				for(int j = i;j>h && !enPosicion; j++)
				{
					int comparacion = (ascendente?1:-1)* criterio.compare(lista.getElement(j), lista.getElement(i));
					if(comparacion<0)
					{
						lista.exchange(j, j-h);
					}
					else
					{
						enPosicion = true;
					}
				}
			}
			h/=3;
		}
	}
	
	
	public void ordenarQuickSort(ILista<T> lista, Comparator<T> criterio, boolean ascendente)
	{
		
	}
	
	public void ordenarMerge(ILista<T> lista, Comparator<T> criterio, boolean ascendente)
	{
		
	}
}
