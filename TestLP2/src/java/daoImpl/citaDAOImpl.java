/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import dao.CitaDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.Cita;
import model.Especialidad;
import model.Medico;
import util.BDConexion;

/**
 *
 * @author Elvin
 */
public class citaDAOImpl implements CitaDAO{
            Connection cn = BDConexion.conectar();
            MedicoDAOImpl medDAO = new MedicoDAOImpl();
            EspecialidadDAOImpl espDAO = new EspecialidadDAOImpl();
    @Override
    public String agregar(Cita cita) {
        String mensaje = "";
        try {
            String sql = "{call sp_reservarCita}";
            CallableStatement cstm = cn.prepareCall(sql);
            cstm.setInt(1, cita.getCodigomed().getCodigo());
            cstm.setDate(2, cita.getFechacita());
            cstm.registerOutParameter(3, Types.VARCHAR);
            
            cstm.executeUpdate();
            mensaje = cstm.getString(4);
        } catch (Exception e) {
            mensaje = e + "";
        }
        return mensaje;
    }

    @Override
    public List<Cita> listar() {
            List<Cita> lstcita = new ArrayList<Cita>();
            try {
            String sql = "SELECT * FROM TBCita";
            PreparedStatement pstm = cn.prepareStatement(sql);
                ResultSet rs = pstm.executeQuery();
                
                while (rs.next()) {                    
                    int codigo = rs.getInt(1);
                    int codmed = rs.getInt(2);
                    int codesp = rs.getInt(3);
                    Date fechacita = rs.getDate(4);
                    double costo = rs.getDouble(5);
                    
                    Medico med =medDAO.buscar(codmed);
                    Especialidad esp = espDAO.buscar(codesp);
                    
                    Cita cita = new Cita(codigo, med, esp, fechacita, costo);
                    
                    lstcita.add(cita);
               }
        } catch (Exception e) {
        }
            return lstcita;
    }
    
}
