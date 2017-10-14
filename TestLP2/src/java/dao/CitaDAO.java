/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Cita;

/**
 *
 * @author Elvin
 */
public interface CitaDAO {
    public String agregar(Cita cita);
    public List<Cita> listar();
}
