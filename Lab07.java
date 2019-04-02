/*
*	File	   :	Lab07.java
*	Name	   :	Joe Ingenito
*	Date	   :	3/28/19
*	Description:	Simulation of the 100 cards problem - I position the cards in a square so the amount of cards must be a perfect square.
*					Face Up - White, Face Down - Black
*	Commands   :	javac -cp doodlepad.jar Lab07.java
*					java -cp doodlepad.jar.; Lab07
*/

import doodlepad.*;
import java.lang.Math;

public class Lab07
{
	//originally made this enum when I was setting up the card class becasue I assumed I was going to need to reference the Card's State from the actual program
	//but now I don't feel like changing the logic
	public enum CardState
	{
		FaceUp, FaceDown;
	}
	
	//assuming all structures of cards will be a perfect square in the code
	private static final int CardCount = 100;
	
	public static void main(String[] args)
	{
		Card[] cards = GetCardArray();
		PerformCardRule(cards);
	}
	
	private static Card[] GetCardArray()
	{
		Card[] arr = new Card[CardCount];
		int dim = (int)Math.sqrt(CardCount); //this assumes card count is a perfect square 
		int spacing = 50;
		for(int y = 0; y < dim; ++y)
		{
			for(int x = 0; x < dim; ++x)
			{
				int index = (y * dim) + x; //maps a 2d coord to 1d index
				arr[index] = new Card(x * spacing, y * spacing, spacing - 10, spacing - 10); 
				//x and y coords are multiplied by a spacing factor
				//width and height leave a margin of 10 pixels
			}
		}
		
		return arr;
	}
	
	private static void PerformCardRule(Card[] cards)
	{
		//step interval loop
		for(int step = 1; step <= CardCount; step++)
		{
			//card index loop
			for(int i = 0; i < CardCount; i += step)
			{
				cards[i].flip();
			}
		}
	}
	
	private static class Card extends Rectangle
	{
		private CardState state;
		
		public Card()
		{
			super();
			state = CardState.FaceDown;
			this.setFillColor(0);
		}
		
		public Card(double x, double y, double width, double height) 
		{
			super(x, y, width, height);
			state = CardState.FaceDown;
			this.setFillColor(0);
		}
		
		public Card(double x, double y, double width, double height, Layer layer) 
		{
			super(x, y, width, height, layer);
			state = CardState.FaceDown;
			this.setFillColor(0);
		}
		
		//Not useful for this assignment but I used it for debugging
		@Override
		public String toString() 
		{
			return String.format("Card State=%s, x=%s, y=%s, Width=%s, Height=%s, Layer=%s", state.toString(), x, y, width, height, layer);
		}
		
		//incase the program needs to reference the Card's state
		public CardState getState()
		{
			return state;
		}
		
		public void flip()
		{
			if(state == CardState.FaceDown)
			{
				state = CardState.FaceUp;
				this.setFillColor(255);
			}else 
			{
				state = CardState.FaceDown;
				this.setFillColor(0);
			}
		}
	}
}











