package servicios;

import java.util.ArrayList;
import java.util.List;
import entidades.Reserva;

/**
 * @author Alejandro Martín
 * @version 1.0
 * @date 2025-03-26
 */
public class SistemaReservasDeportivas {

    private List<Reserva> reservas;
    private boolean[] iluminacion;
    private static final int MAX_PISTAS = 10; // El máximo de pistas disponibles es 10

    /**
     * Constructor del sistema de reservas.
     * Inicializa la lista de reservas .
     */
    public SistemaReservasDeportivas() {
        reservas = new ArrayList<>();
        iluminacion = new boolean[MAX_PISTAS];
    }

    /**
     * Permite hacer una reserva en una pista específica en una fecha y duración indicada.
     * 
     * @param idPista: El ID de la pista que quieres reservar.
     * @param fecha: La fecha en la que quieres reservar la pista.
     * @param duracion: La duración de la reserva en minutos.
     * @return true: si la reserva fue exitosa, false si la pista ya está ocupada o el ID es incorrecto.
     */
    public boolean reservarPista(int idPista, String fecha, int duracion) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // Si el ID de pista no es válido, retorna false
        }

        // Revisa si la pista ya está reservada en la fecha indicada
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false; // La pista ya está ocupada en esa fecha
            }
        }

        // Si todo está bien, añade la reserva
        reservas.add(new Reserva(idPista, fecha, duracion));
        return true;
    }

    /**
     * Cancela una reserva existente.
     * 
     * @param idReserva El ID de la reserva que quieres cancelar.
     * @return true si la reserva fue cancelada, false si no se encontró la reserva.
     */
    public boolean cancelarReserva(int idReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getIdPista() == idReserva) {
                reservas.remove(i); // Elimina la reserva
                return true;
            }
        }

        return false; // Si no se encuentra la reserva, retorna false
    }

    /**
     * Activa la iluminación de una pista.
     * 
     * @param idPista El ID de la pista donde se quiere activar la iluminación.
     * @return true si la iluminación se activó correctamente, false si el ID es inválido.
     */
    public boolean activarIluminacion(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // Si el ID de pista no es válido, retorna false
        }

        iluminacion[idPista] = true; // Activa la luz en la pista indicada
        return true;
    }

    /**
     * Desactiva la iluminación de una pista.
     * 
     * @param idPista El ID de la pista donde se quiere apagar la luz.
     * @return true si la iluminación se desactivó correctamente, false si el ID es inválido.
     */
    public boolean desactivarIluminacion(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // Si el ID de pista no es válido, retorna false
        }

        iluminacion[idPista] = false; // Apaga la luz en la pista indicada
        return true;
    }

    /**
     * Verifica si una pista está disponible en una fecha y hora determinadas.
     * 
     * @param idPista El ID de la pista que quieres comprobar.
     * @param fecha La fecha en la que quieres saber si la pista está libre.
     * @param hora La hora en la que quieres saber si la pista está libre.
     * @return true si la pista está libre en esa fecha y hora, false si ya está reservada.
     */
    public boolean verificarDisponibilidad(int idPista, String fecha, String hora) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // Si el ID de pista no es válido, retorna false
        }

        // Revisa si la pista ya está reservada en la fecha
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false; // La pista ya está ocupada en esa fecha
            }
        }

        return true; // Si no está reservada, la pista está libre
    }
}
