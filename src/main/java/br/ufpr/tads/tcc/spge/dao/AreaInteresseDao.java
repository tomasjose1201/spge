/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.dao;

import br.ufpr.tads.tcc.spge.model.AreaInteresse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public class AreaInteresseDao {
    private final String stmtSelectAll = "select * from area_interesse";
    private final String stmtSelectAreasUsuario = "select * from usuario_area_interesse where idUsuario = ?";
    private Connection con;

    public AreaInteresseDao() throws SQLException {
        this.con = ConnectionFactory.getConnection();
    }
    
    public ArrayList<AreaInteresse> selectAll() throws SQLException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        ArrayList<AreaInteresse> lista = new ArrayList();
        try {
            AreaInteresse novo = null;
            stmt = con.prepareStatement(stmtSelectAll);
            rs = stmt.executeQuery();
            while (rs.next()) {
                novo = new AreaInteresse();
                novo.setIdAreaInteresse(rs.getInt("idAreaInteresse"));
                novo.setNome(rs.getString("nome"));              
                lista.add(novo);
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            stmt.close();
            rs.close();
            con.close();
        }
    }
    
    public ArrayList<Integer> selectAreasUsuario(int id) throws SQLException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        ArrayList<Integer> lista = new ArrayList();
        try {
            stmt = con.prepareStatement(stmtSelectAreasUsuario);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {           
                lista.add(rs.getInt("idAreaInteresse"));
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            stmt.close();
            rs.close();
            con.close();
        }
    }
}
