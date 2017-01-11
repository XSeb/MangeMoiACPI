package simulation;

import org.junit.jupiter.api.*;

import simulation.Map;
import static org.junit.jupiter.api.Assertions.*;

class MapTest {

	@BeforeEach
	public void setUp() throws Exception
	{
		Map map = new Map(4, 50, 50, 4000, 500, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100);
	}

    @Test
    public void testAuDemarrage() {
    	
    }
	
    @Test
    void name() {
        fail("test");
    }
	
    @AfterEach
    public void tearDown() throws Exception {
    }

}


