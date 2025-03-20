package servicios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

    class SistemaReservasDeportivasTest {
    static SistemaReservasDeportivas sistemaReservas;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        sistemaReservas = new SistemaReservasDeportivas();
    }
    
    @Test
    void testReservarPista() {
        assertTrue(sistemaReservas.reservarPista(1, "21-03-2025 12:00", 60));
        assertFalse(sistemaReservas.reservarPista(1, "21-03-2025 12:00", 60));
    }
    
    
    void testCancelarReserva() {
    	
        assertTrue(sistemaReservas.cancelarReserva(1));
        assertTrue(sistemaReservas.cancelarReserva(2));
        assertTrue(sistemaReservas.cancelarReserva(3));
        assertTrue(sistemaReservas.cancelarReserva(4));
    }
    
    
    
}
