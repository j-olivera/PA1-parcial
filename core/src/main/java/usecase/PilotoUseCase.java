package usecase;

import exception.DniYaExisteException;
import input.RegistrarPiloto;
import input.VerificarSiExistePorDni;
import model.Piloto;
import output.PilotoRepository;

import java.time.LocalDate;
import java.util.UUID;

public class PilotoUseCase implements RegistrarPiloto, VerificarSiExistePorDni {

    private final PilotoRepository pilotoRepository;

    public PilotoUseCase(PilotoRepository pilotoRepository) {
        this.pilotoRepository = pilotoRepository;
    }

    @Override
    public UUID guardarPiloto(String nombre, String dni, LocalDate fechaNacimiento) {
        if(pilotoRepository.existePorDni(dni)){
            throw new DniYaExisteException("Este DNI ya ha sido registrado");
        }
        UUID licencia = UUID.randomUUID();
        Piloto piloto = Piloto.crearPiloto(licencia,nombre, dni, fechaNacimiento);
        return pilotoRepository.save(piloto);
    }

    @Override
    public boolean existePorDni(String dni) {
        return pilotoRepository.existePorDni(dni);
    }
}
