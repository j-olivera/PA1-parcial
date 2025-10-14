package output;

import model.Piloto;

import java.util.UUID;

public interface PilotoRepository {
    UUID save(Piloto piloto);
    boolean existePorDni(String dni);
}
