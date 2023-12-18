package com.example.formulario2;

public class Cliente {
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private String sexo;
    private boolean consentimientoNewsletter;

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
        return "Nombre: " + nombre + ", Apellidos: " + apellidos + ", Fecha de Nacimiento: " + fechaNacimiento
                + ", Sexo: " + sexo + ", Consentimiento Newsletter: " + (consentimientoNewsletter ? "Sí" : "No");
    }
}
