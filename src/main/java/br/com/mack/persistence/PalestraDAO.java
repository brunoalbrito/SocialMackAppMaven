package br.com.mack.persistence;

import br.com.mack.persistence.entities.Palestra;
import br.com.mack.persistence.entities.Participante;
import br.com.mack.persistence.entities.Pessoa;
import br.com.mack.singletonconnection.SingletonConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.ArrayList;
import java.util.List;

public class PalestraDAO implements GenericDAO<Palestra> {

    public static Connection connection = SingletonConnection.getInstance().getConnection();

    @Override
    public void create(Palestra p) {
        String sql = "insert into palestra(tema,codigo,id_organizador)values(?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getTema());
            ps.setInt(2, p.getCodigo());
            ps.setLong(3, p.getId_organizador());
            ps.execute();
            
            ResultSet keys = ps.getGeneratedKeys();
            keys.next();
            p.setId_palestra(keys.getInt(1));
            
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PalestraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<Palestra> readAll() {
        List<Palestra> palestras = new ArrayList<Palestra>();

        //Declarar String de busca
        String sql = "SELECT * FROM palestra";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Palestra palestra = new Palestra();
                palestra.setId_palestra(rs.getLong("id"));
                palestra.setTema(rs.getString("tema"));
                palestra.setCodigo(rs.getInt("codigo"));
                palestra.setId_organizador(rs.getLong("id_organizador"));
                palestras.add(palestra);
            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(PalestraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return palestras;
    }

    @Override
    public Palestra readById(long id) {
        return null;
    }

    public List<Palestra> readByIdParticipante(long id) {
        List<Palestra> palestras = new ArrayList();
        String sql = "select p.id,p.tema,p.codigo "
                + "from palestra p inner join inscricao i on "
                + "p.id = i.id_palestra where i.id_participante = ?";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Palestra p = new Palestra();
                p.setId_palestra(rs.getLong("id"));
                p.setTema(rs.getString("tema"));
                p.setCodigo(rs.getInt("codigo"));
                palestras.add(p);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PalestraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return palestras;
    }

    @Override
    public void update(Palestra p) {

    }

    @Override
    public void delete(Palestra p) {

    }

    public List<Participante> readUsersPalestra(long id_palestra) {
        
        List<Participante> participantes = new ArrayList();
        
        String sql = "select pessoa.nome from inscricao inner join participante on inscricao.id_participante = participante.id_pessoa inner join pessoa on participante.id_pessoa = pessoa.id where inscricao.id_palestra = ?";
        
        PreparedStatement ps;
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id_palestra);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Participante pessoa = new Participante();
                pessoa.setNome(rs.getString("nome"));
                participantes.add(pessoa);
            }
            rs.close();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(PalestraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return participantes;
    }
    
    
    public long registerInPalestra(long id_participante, long id_palestra) {

        String sql = "INSERT INTO inscricao VALUES(?,?)";
        
        int teste = -1;
        try {
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setLong(1, id_participante);
            ps.setLong(2, id_palestra);
            ps.execute();
            
            ResultSet keys = ps.getGeneratedKeys();
            keys.next();
            
            ps.close();
            teste = keys.getInt(1);
            System.out.println("************************************Passou pelo teste dentro do try");
        } catch (SQLException ex) {
            Logger.getLogger(PalestraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("*************************************TESTEEEE" + teste);
        return teste;
    }
    
    
    public void cancelRegisterInPalestra(long id_participante, long id_palestra) {

        String sql = "DELETE FROM inscricao WHERE id_participante=? AND id_palestra=?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id_participante);
            ps.setLong(2, id_palestra);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PalestraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}