package com.homework.pm1_p1_h3.procesos;

public class Persona {
    private Integer id;
    private String nombre;
    private String apellidos;
    private Integer edad;
    private String correo;
    private String direccion;

    public Persona() {
        // void constructor
    }

    public Persona(Integer id, String nombre, String apellidos, Integer edad, String correo, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.correo = correo;
        this.direccion = direccion;
    }

    public Integer getId() { return this.id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return this.nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return this.apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public Integer getEdad() { return this.edad; }
    public void setEdad(Integer edad) { this.edad = edad; }

    public String getCorreo() { return this.correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getDireccion() { return this.direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
}
