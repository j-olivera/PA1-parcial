package model;

import exception.DatosObligatoriosException;
import exception.EdadNoValidaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

public class TestModelPiloto {
    @Test
    void testCrearPiloto(){
        //Arrange
        String nombre = "Fanco Colapinto";
        String dni = "123456ABC";
        LocalDate fecha_nacimiento = LocalDate.of(2000, 12, 12);
        UUID licencia = UUID.randomUUID();
        Piloto piloto = Piloto.crearPiloto(licencia,nombre,dni,fecha_nacimiento);
        // act y assert
        Assertions.assertNotNull(piloto);
        Assertions.assertEquals(nombre,piloto.getNombre());
    }

    @Test
    void testVerificarDatosObligatoriosException(){
        //Arrange
        String nombre = "";
        String dni = "123456ABC";
        LocalDate fecha_nacimiento = LocalDate.of(2000, 12, 12);
        //act y assert
        DatosObligatoriosException e = Assertions.assertThrows(DatosObligatoriosException.class, ()-> Piloto.crearPiloto(UUID.randomUUID(),nombre,dni,fecha_nacimiento));
        Assertions.assertEquals(e.getMessage(),"Los datos son obligatorios");
    }

    @Test
    void verificarEdadNoValidaException(){
        //Arrange
        String nombre = "Franco Colapinto";
        String dni = "123456ABC";
        LocalDate fecha_nacimiento = LocalDate.of(2020, 12, 12);
        //act y assert
        EdadNoValidaException e = Assertions.assertThrows(EdadNoValidaException.class, ()-> Piloto.crearPiloto(UUID.randomUUID(),nombre,dni,fecha_nacimiento));
        Assertions.assertEquals(e.getMessage(),"La edad debe ser mayor a 18 años");
    }

}

