package br.com.mack.persistence;

import br.com.mack.persistence.entities.Organizador;
import br.com.mack.singletonconnection.SingletonConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class OrganizadorDAO implements GenericDAO<Organizador>{

    public static Connection connection = SingletonConnection.getInstance().getConnection();
    
    @Override
    public void create(Organizador e) {
    }

    @Override
    public List<Organizador> readAll() {
        return null;
    }

    @Override
    public Organizador readById(long id) {
        Organizador organizador = new Organizador();
        String sql = "select * from pessoa inner join "
                + "organizador on pessoa.id = organizador.id_pessoa "
                + "where pessoa.id = ? and id_tipo = 2";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                organizador.setId_pessoa(id);
                organizador.setNome(rs.getString("nome"));
                organizador.setEmail(rs.getString("email"));
                organizador.setCelular(rs.getString("celular"));
                organizador.setSenha(rs.getString("senha"));
                organizador.setTelefone(rs.getString("telefone"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrganizadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        return organizador;
    }

    @Override
    public void update(Organizador e) {
    }

    @Override
    public void delete(Organizador e) {
    }
    
}
