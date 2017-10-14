 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import dao.EspecialidadDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Especialidad;
import util.BDConexion;

/**
 *
 * @author Elvin
 */
public class EspecialidadDAOImpl implements EspecialidadDAO{
        Connection cn = BDConexion.conectar();
    @Override
    public String agregar(Especialidad esp) {
        String  mensaje = "";
        try {
            String sql = "INSERT INTO TBEspecialidad VALUES (null,?,?)";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1,esp.getDescripcion());
            pstm.setDouble(2, esp.getCosto());
            
            pstm.executeUpdate();
            mensaje = "ESPECIALIDAD AGREGADA";
        } catch (Exception e) {
            mensaje = e + "";
        }
        return mensaje;
    }

    @Override
    public List<Especialidad> listar() {
        List<Especialidad> lstesp = new ArrayList<Especialidad>();
        try {
            String  sql = "SELECT * FROM TBEspecialidad";
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {                
               int codigo = rs.getInt(1);
                String  descripcion = rs.getString(2);
                double costo = rs.getDouble(3);
                
                Especialidad esp = new Especialidad(codigo, descripcion, costo);
                lstesp.add(esp);
            }
            
        } catch (Exception e) {
        }
        return lstesp;
    }

    @Override
    public Especialidad buscar(int cod) {
        Especialidad esp = null;
        try {
            String sql = "SELECT*FROM TBEspecialidad WHERE Codigo = ?";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, cod);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {                
                int codigo = rs.getInt(1);
                String descripcion = rs.getString(2);
                double costo = rs.getDouble(3);
                
                esp = new Especialidad(codigo, descripcion, costo);
            }
           
        } catch (Exception e) {
        }
        return esp;
    }
    
}
