package models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class miniCalcModel
{
	DoubleProperty result = new SimpleDoubleProperty();
	DoubleProperty numOne= new SimpleDoubleProperty();
	DoubleProperty numTwo = new SimpleDoubleProperty();
	
	/**
	 * @return the result
	 */
	public DoubleProperty getResult()
	{
		return result;
	}

	public DoubleProperty getNumOne()
	{
		return numOne;
	}
	
	public DoubleProperty getNumTwo()
	{
		return numTwo;
	}
	
	public void add()
	{
		result.set(0); 
		result.set(numOne.get()+numTwo.get());
	}
	
	public void subtract()
	{
		result.set(0); 
		result.set(numOne.get()+-1*numTwo.get());
	}
	
	public void multiply()
	{
		result.set(0); 
		result.set(numOne.get()*numTwo.get());
	}	
	public void divide()
	{
		result.set(0); 
		result.set(numOne.get()/numTwo.get());
	}

}
