package model.logic;

public class Cronometro 
{
	
	    private long tiempo;

	    public Cronometro()
	    {
	        tiempo= System.nanoTime();
	    }

	    public double elapsedTime()
	    {
	        return (System.nanoTime() - tiempo) / 1e9;
	    }
	
}
