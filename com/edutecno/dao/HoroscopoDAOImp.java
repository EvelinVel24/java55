package com.edutecno.dao;

import com.edutecno.modelo.Horoscopo;
import com.edutecno.procesaconexion.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoroscopoDAOImp extends ConexionDB {
    public List<Horoscopo> obtenerHoroscopo() {
        List<Horoscopo> horoscopos = new ArrayList<>();
        String consultaSql = "SELECT * FROM horoscopo";
        Connection conn = generaConexion();

        try (PreparedStatement pstm = conn.prepareStatement(consultaSql);
             ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                Horoscopo h = new Horoscopo(rs.getString("animal"),
                                             rs.getDate("fecha_inicio"),
                                             rs.getDate("fecha_fin"));
                horoscopos.add(h);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return horoscopos;
    }
}
