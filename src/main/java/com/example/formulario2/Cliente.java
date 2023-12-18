package com.example.formulario2;

public class Cliente {
    final private String nombre;
    final private String apellidos;
    final private String fechaNacimiento;
    final private String sexo;
    final private boolean consentimientoNewsletter;

    // Constructor
    public Cliente(String nombre, String apellidos, String fechaNacimiento, String sexo, boolean consentimientoNewsletter) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.consentimientoNewsletter = consentimientoNewsletter;
    }

    // Métodos getter y setter para cada campo

    @Override
    public String toString() {
        return "\n* Nombre: " + nombre + ", Apellidos: " + apellidos + ", Fecha de Nacimiento: " + fechaNacimiento
                + ", Sexo: " + sexo + ", Consentimiento Newsletter: " + (consentimientoNewsletter ? "Sí" : "No");
    }
}
