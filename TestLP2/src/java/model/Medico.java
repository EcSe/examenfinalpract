/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Elvin
 */
public class Medico {
    private int codigo;
    private Especialidad codigoesp;
    private String nombre;
    private String turno;

    public Medico() {
    }

    public Medico(int codigo, Especialidad codigoesp, String nombre, String turno) {
        this.codigo = codigo;
        this.codigoesp = codigoesp;
        this.nombre = nombre;
        this.turno = turno;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Especialidad getCodigoesp() {
        return codigoesp;
    }

    public void setCodigoesp(Especialidad codigoesp) {
        this.codigoesp = codigoesp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
