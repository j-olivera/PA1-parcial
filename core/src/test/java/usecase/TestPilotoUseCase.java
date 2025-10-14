package usecase;

import exception.DniYaExisteException;
import model.Piloto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import output.PilotoRepository;

import java.time.LocalDate;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestPilotoUseCase {

    @Mock
    PilotoRepository pilotoRepository;
    @InjectMocks
    PilotoUseCase pilotoUseCase;

    @Test
    void testRegistrarPiloto() {
        //Arrange
        String nombre = "Franco Colapinto";
        String dni = "123456ABC";
        LocalDate fecha_nacimiento = LocalDate.of(2000, 12, 12);
        UUID licencia = UUID.randomUUID();
        Piloto esperado = Piloto.crearPiloto(licencia,nombre,dni,fecha_nacimiento);
        when(pilotoRepository.save(any(Piloto.class))).thenReturn(esperado.getLicencia());
        when(pilotoRepository.existePorDni(dni)).thenReturn(false);
        //Act
        UUID resultado = pilotoUseCase.guardarPiloto(nombre,dni,fecha_nacimiento);
        //Assert
        Assertions.assertEquals(resultado,esperado.getLicencia());
        verify(pilotoRepository,times(1)).save(any(Piloto.class));
        verify(pilotoRepository,times(1)).existePorDni(dni);
    }
    @Test
    void testDniYaRegistrado(){
        //Arrange
        String nombre = "Franco Colapinto";
        String dni = "123456ABC";
        LocalDate fecha_nacimiento = LocalDate.of(2000, 12, 12);
        when(pilotoRepository.existePorDni("123456ABC")).thenReturn(true);
        //Act y Assert
        Assertions.assertThrows(DniYaExisteException.class, () -> pilotoUseCase.guardarPiloto(nombre,dni,fecha_nacimiento));
        verify(pilotoRepository,never()).save(any(Piloto.class));
    }
}

