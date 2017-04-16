package br.com.mack.persistence;

import br.com.mack.persistence.entities.Organizador;
import br.com.mack.persistence.entities.Participante;
import br.com.mack.persistence.entities.Pessoa;
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
public class PessoaDAO implements GenericDAO<Pessoa>{
    
    public static Connection connection = SingletonConnection.getInstance().getConnection();

    @Override
    public void create(Pessoa e) {
        
    }

    @Override
    public List<Pessoa> readAll() {
        return null;
    }

    @Override
    public Pessoa readById(long id) {
        return null;
    }

    @Override
    public void update(Pessoa e) {
        
    }

    @Override
    public void delete(Pessoa e) {
        
    }
    
    public Pessoa readByEmail(String email,String senha) {
        String sql = "select id,id_tipo from pessoa where email = ? and senha = ?";
        Pessoa pessoa = new Participante();
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            int tipo = 0;
            while (rs.next()) {                
                pessoa.setId_pessoa(rs.getLong("id"));
                tipo = rs.getInt("id_tipo");
            }
            GenericDAO gdao = null;
            if(tipo == 1){
                gdao = new ParticipanteDAO();
                pessoa =(Participante) gdao.readById(pessoa.getId_pessoa());
            }else if(tipo == 2){
                gdao = new OrganizadorDAO();
                pessoa =(Organizador) gdao.readById(pessoa.getId_pessoa());
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pessoa;
    }
}