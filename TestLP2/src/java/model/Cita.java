/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Elvin
 */
public class Cita {
    private int codigo;
    private Medico codigomed;
    private Especialidad codesp;
    private Date fechacita;
    private double costo;

    public Cita() {
    }

    public Cita(int codigo, Medico codigomed, Especialidad codesp, Date fechacita, double costo) {
        this.codigo = codigo;
        this.codigomed = codigomed;
        this.codesp = codesp;
        this.fechacita = fechacita;
        this.costo = costo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Medico getCodigomed() {
        return codigomed;
    }

    public void setCodigomed(Medico codigomed) {
        this.codigomed = codigomed;
    }

    public Especialidad getCodesp() {
        return codesp;
    }

    public void setCodesp(Especialidad codesp) {
        this.codesp = codesp;
    }

    public Date getFechacita() {
        return fechacita;
    }

    public void setFechacita(Date fechacita) {
        this.fechacita = fechacita;
    }
    
    
}
