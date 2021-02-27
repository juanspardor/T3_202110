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
		sort(lista, criterio, ascendente, 1, lista.size());
	}
	
	private void sort(ILista<T> lista, Comparator<T> criterio, boolean ascendente, int lo, int hi)
	{
		if(lo>=hi)
		{
			return;
		}
		int pivot = partition(lista,criterio,ascendente,lo,hi);
		sort(lista, criterio, ascendente, lo, pivot-1);
		sort(lista, criterio, ascendente, pivot+1, hi);
	}
	
	private int partition(ILista<T> lista, Comparator<T> criterio, boolean ascendente, int lo, int hi)
	{
		int follower = lo;
		int leader = lo;
		while(leader<hi)
		{
			int comparacion = (ascendente?1:-1)*criterio.compare(lista.getElement(leader), lista.getElement(hi));
			if(comparacion<0)
			{
				lista.exchange(follower, leader);
				follower++;
			}
			leader++;
		}
		lista.exchange(follower, hi);
		return follower;
	}
	
	public void ordenarMerge(ILista<T> lista, Comparator<T> criterio, boolean ascendente)
	{
		
	}
}
