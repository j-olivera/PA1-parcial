package model;

import exception.DatosObligatoriosException;
import exception.EdadNoValidaException;

import java.time.LocalDate;
import java.util.UUID;

public class Piloto {

    private UUID licencia;
    private String nombre;
    private String documento;
    private LocalDate fechaNacimiento;

    private Piloto(UUID licencia, String nombre, String documento, LocalDate fechaNacimiento) {
        this.licencia = licencia;
        this.nombre = nombre;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;
    }

    public static Piloto crearPiloto(UUID licencia,String nombre, String documento, LocalDate fechaNacimiento){
        validarDatosObligatoriosDelPiloto(nombre, documento, fechaNacimiento);
        validarEdadPiloto(fechaNacimiento);
        return new Piloto(licencia, nombre, documento, fechaNacimiento);
    }

    private static void validarEdadPiloto(LocalDate fechaNacimiento) {
        if(fechaNacimiento.isAfter(LocalDate.now().minusYears(18))){
            throw new EdadNoValidaException("La edad debe al menos 18 años");
        }
    }

    private static void validarDatosObligatoriosDelPiloto(String nombre, String documento, LocalDate fechaNacimiento) {
        if(nombre == null || documento == null || fechaNacimiento == null || nombre.isEmpty() || documento.isEmpty()){
            throw new DatosObligatoriosException("Los datos son obligatorios");
        }
    }

    public UUID getLicencia() {
        return licencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
}
