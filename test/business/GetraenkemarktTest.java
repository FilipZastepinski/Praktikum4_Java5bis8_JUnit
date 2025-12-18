package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GetraenkemarktTest {
	
	private Getraenkemarkt getraenkemarkt;

	@BeforeEach
	void setUp() throws Exception {
		// Erzeuge Instanz von Getraenkemarkt
		this.getraenkemarkt = new Getraenkemarkt(null, 0, 0, null, null);
	}

	@AfterEach
	void tearDown() throws Exception {
		// Setze Instanz Null
		this.getraenkemarkt = null;
	}

	@Test
	void test() {
		fail("Not yet implemented");
		
		//assertTrue
		//assertTrue(boolean condition, String message);
		assertTrue(this.getraenkemarkt.getEinkaufspreis() <= 0.0, "Preis ist falsch angegeben worden");
		//assertTrue (BooleanSupplier booleanSupplier, String message)
		assertTrue(() -> this.getraenkemarkt.getEinkaufspreis() <= 0.0, "Preis ist falsch angegeben worden");
		//assertTrue (BooleanSupplier booleanSupplier, Supplier <String> messageSupplier)
		assertTrue(() -> this.getraenkemarkt.getEinkaufspreis() <= 0.0, () -> "Preis ist falsch angegeben worden");
	}

}
