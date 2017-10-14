/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Especialidad;

/**
 *
 * @author Elvin
 */
public interface EspecialidadDAO {
    public String agregar(Especialidad esp);
    public List<Especialidad> listar();
    public Especialidad buscar(int cod);
}
