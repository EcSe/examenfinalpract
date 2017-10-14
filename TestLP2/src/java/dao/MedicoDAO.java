/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Medico;

/**
 *
 * @author Elvin
 */
public interface MedicoDAO {
    public String  agregar(Medico med);
    public List<Medico> listar();
    public Medico buscar(int cod);
    public Medico buscarxEsp(int codesp);
}
