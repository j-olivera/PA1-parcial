package input;

import java.time.LocalDate;
import java.util.UUID;

public interface RegistrarPiloto {
    UUID guardarPiloto(String nombre, String dni, LocalDate fechaNacimiento);
}
