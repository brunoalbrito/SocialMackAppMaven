package br.com.mack.persistence;

import br.com.mack.persistence.entities.Interesse;
import br.com.mack.singletonconnection.SingletonConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.ArrayList;
import java.util.List;

public class InteresseDAO implements GenericDAO<Interesse> {

    public static Connection connection = SingletonConnection.getInstance().getConnection();

    @Override
    public void create(Interesse interesse) {
        String sql = "insert into interesse(descricao)values(?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, interesse.getDescricao());
            ps.execute();            
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PalestraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<Interesse> readAll() {
        List<Interesse> interesses = new ArrayList<Interesse>();

        //Declarar String de busca
        String sql = "SELECT * FROM palestra";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Interesse interesse = new Interesse();
                interesse.setDescricao(rs.getString("descricao"));
                interesses.add(interesse);
            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(PalestraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return interesses;
    }

    @Override
    public Interesse readById(long id) {
        return null;
    }

    @Override
    public void update(Interesse interesse) {
        String sql = "UPDATE interesse SET descricao = ? WHERE id = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, interesse.getDescricao());
            ps.setLong(2, interesse.getId());
            ps.execute();
        }catch(SQLException ex){
            Logger.getLogger(PalestraDAO.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }

    @Override
    public void delete(Interesse interesse) {
        String sql = "DELETE FROM interesse WHERE id = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, interesse.getId());
            ps.execute();
        }catch(SQLException ex){
            Logger.getLogger(PalestraDAO.class.getName()).log(Level.SEVERE, null, ex);            
        } 
    }
    
    public void registrarInteresseByPalestra(long idInteresse, long idPalestra){
        String sql = "INSERT INTO interesse_palestra(id_interesse, id_palestra) VALUES(?,?);";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, idInteresse);
            ps.setLong(2, idPalestra);
        }catch(SQLException ex){
            Logger.getLogger(PalestraDAO.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }
    
    public void registrarInteresseByInscricao(long idInteresse, long idInscricao){
        String sql = "INSERT INTO interesse_inscricao(id_interesse, id_inscricao) VALUES(?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, idInteresse);
            ps.setLong(2, idInscricao);
        }catch(SQLException ex){
            Logger.getLogger(PalestraDAO.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }
}