package model;

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

    public static Piloto crearPiloto(String nombre, String documento, LocalDate fechaNacimiento){
        validarDatosObligatoriosDelPiloto(nombre, documento, fechaNacimiento);
        validarEdadPiloto(fechaNacimiento);
        return new Piloto(UUID.randomUUID(), nombre, documento, fechaNacimiento);
    }

    private static void validarEdadPiloto(LocalDate fechaNacimiento) {
    }

    private static void validarDatosObligatoriosDelPiloto(String nombre, String documento, LocalDate fechaNacimiento) {

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
