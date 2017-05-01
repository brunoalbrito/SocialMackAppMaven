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
        String sql = "INSERT INTO interesse(descricao) VALUES(?)";
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
        String sql = "SELECT * FROM interesse";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Interesse interesse = new Interesse();
                interesse.setId(rs.getLong("id"));
                interesse.setDescricao(rs.getString("descricao"));
                interesses.add(interesse);
            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(PalestraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return interesses;
    }

    public List<Interesse> readByIdPalestra(long id_palestra) {
        List<Interesse> interesses = new ArrayList<Interesse>();
        
        String sql = "SELECT descricao FROM interesse INNER JOIN palestra_interesse ON interesse.id = palestra_interesse.id_interesse WHERE id_palestra = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Interesse interessesInscricao = new Interesse();
                interessesInscricao.setId(rs.getLong("id_palestra"));
                interessesInscricao.setDescricao(rs.getString("descricao"));
                interesses.add(interessesInscricao);
            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(PalestraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return interesses;
    }

        @Override
        public Interesse readById(long id){
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
            ps.close();
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
            ps.close();
        }catch(SQLException ex){
            Logger.getLogger(PalestraDAO.class.getName()).log(Level.SEVERE, null, ex);            
        } 
    }
    
    public void registrarInteresseByPalestra(long idInteresse, long idPalestra){
        String sql = "insert into palestra_interesse values(?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, idPalestra);
            ps.setLong(2, idInteresse);
            ps.execute();            
            ps.close();
        }catch(SQLException ex){
            Logger.getLogger(PalestraDAO.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }
    
    public void registrarInteresseByInscricao(long idInteresse, long idInscricao){
        String sql = "INSERT INTO inscricao_interesse(id_Inscricao, id_Interesse) VALUES(?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, idInscricao);
            ps.setLong(2, idInteresse);
            ps.execute();            
            ps.close();
        }catch(SQLException ex){
            Logger.getLogger(PalestraDAO.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }
}