package simulation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import simulation.Map;
import simulation.Nourriture;

import static org.junit.jupiter.api.Assertions.*;


class NourritureTest {
	

	@BeforeEach
	public void setUp() throws Exception
	{
		Nourriture [][] nourriture = Map.GenererPatch(4, 100f);
	}
	
}