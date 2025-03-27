package entidades;

import java.time.LocalDateTime;

public class Reserva {
    private int idPista;
    private LocalDateTime fecha;
    private int duracion;
    /**
     * @author Alejandro Martín
     * @version 1.0
     * @date 2025-03-26
     */
    
    /**
     * Crea la clase de reserva
     * @param iguala los parametros 
     */
    public Reserva(int idPista, LocalDateTime fecha, int duracion) {
        this.idPista = idPista;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    /**
     * Crea el id de la pista
     * @return devuelve el id de la pista
     */
    public int getIdPista() {
        return idPista;
    }
    
    /**
     * Crea el string para obtener la fecha
     * @return devuelve la fecha
     */
    
    public LocalDateTime getFecha() {
        return fecha;
    }
    
    /**
     * Crea la duracion de la reserva
     * @return devuelve la duracion de la reserva
     */

    public int getDuracion() {
        return duracion;
    }
}