package com.edutecno.dao;

import com.edutecno.modelo.Usuario;
import com.edutecno.procesaconexion.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImp extends ConexionDB {

    // Método para registrar un nuevo usuario
    public boolean registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO USUARIOS (ID, NOMBRE, USERNAME, EMAIL, FECHA_NACIMIENTO, PASSWORD, ANIMAL) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = generaConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, usuario.getId());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getUsername());
            ps.setString(4, usuario.getEmail());
            ps.setDate(5, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
            ps.setString(6, usuario.getPassword());
            ps.setString(7, usuario.getAnimal());
            
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para obtener un usuario por su nombre de usuario (username)
    public Usuario obtenerUsuarioPorUsername(String username) {
        String sql = "SELECT * FROM USUARIOS WHERE USERNAME = ?";
        Usuario usuario = null;

        try (Connection conn = generaConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuario(
                    rs.getInt("ID"),
                    rs.getString("NOMBRE"),
                    rs.getString("USERNAME"),
                    rs.getString("EMAIL"),
                    rs.getDate("FECHA_NACIMIENTO"),
                    rs.getString("PASSWORD"),
                    rs.getString("ANIMAL")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    // Método para actualizar los datos de un usuario
    public boolean actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE USUARIOS SET NOMBRE = ?, EMAIL = ?, FECHA_NACIMIENTO = ?, PASSWORD = ?, ANIMAL = ? " +
                     "WHERE USERNAME = ?";

        try (Connection conn = generaConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombre());
       
