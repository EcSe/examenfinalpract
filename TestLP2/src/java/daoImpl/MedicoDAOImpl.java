/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import dao.MedicoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Especialidad;
import model.Medico;
import util.BDConexion;

/**
 *
 * @author Elvin
 */
public class MedicoDAOImpl implements MedicoDAO{
        Connection cn = BDConexion.conectar();
        EspecialidadDAOImpl espDAO  = new EspecialidadDAOImpl();
    @Override
    public String agregar(Medico med) {
            String mensaje = "";
            try {
            String sql = "INSERT INTO TBMedico VALUES (null,?,?,?)";
                PreparedStatement pstm = cn.prepareStatement(sql);
                pstm.setInt(1, med.getCodigoesp().getCodigo());
                pstm.setString(2, med.getNombre());
                pstm.setString(3, med.getTurno());
                
                pstm.executeUpdate();
                mensaje = "MEDICO AGREGADO";
        } catch (Exception e) {
            mensaje = e + "";
        }
            return mensaje;
    }

    @Override
    public List<Medico> listar() {
            List<Medico> lstmed = new ArrayList<Medico>();
            try {
            String sql = "SELECT * FROM TBMedico";
            PreparedStatement pstm = cn.prepareStatement(sql);
                ResultSet rs = pstm.executeQuery();
                        
                while (rs.next()) {                    
                   int codigo = rs.getInt(1);
                   int  codesp = rs.getInt(2);
                   String nombre = rs.getString(3);
                   String turno = rs.getString(4);
                   
        Especialidad esp =  espDAO.buscar(codesp);
        Medico med = new Medico(codigo, esp, nombre, turno);
        lstmed.add(med);
                }
        } catch (Exception e) {
        }
            return lstmed;
    }

    @Override
    public Medico buscar(int cod) {
        Medico med = null;
        try {
            String sql = "SELECT * FROM TBMedico WHERE Codigo = ?";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, cod);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {                
                int codigo = rs.getInt(1);
                int codesp = rs.getInt(2);
                String nombre = rs.getString(3);
                String turno = rs.getString(4);
                
                Especialidad  esp = espDAO.buscar(codesp);
                med = new Medico(codigo, esp, nombre, turno);
                
                
            }
        } catch (Exception e) {
        }
        return med;
    }

    @Override
    public Medico buscarxEsp(int codespe) {
         Medico med = null;
        try {
            String sql = "SELECT * FROM TBMedico WHERE CodigoEspecialidad = ?";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, codespe);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {                
                int codigo = rs.getInt(1);
                int codesp = rs.getInt(2);
                String nombre = rs.getString(3);
                String turno = rs.getString(4);
                
                Especialidad  esp = espDAO.buscar(codesp);
                med = new Medico(codigo, esp, nombre, turno);
                
                
            }
        } catch (Exception e) {
        }
        return med;
    }
    
    
}
