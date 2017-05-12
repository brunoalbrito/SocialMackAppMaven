package br.com.mack.persistence;

import br.com.mack.persistence.entities.Participante;
import br.com.mack.singletonconnection.SingletonConnection;
import java.io.ByteArrayInputStream;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParticipanteDAO implements GenericDAO<Participante> {

    private static Connection connection = SingletonConnection.getInstance().getConnection();

    @Override
    public void create(Participante part) {

        try {
            String sql = "INSERT INTO pessoa(nome,email,id_tipo,senha)VALUES(?,?,1,?)";

            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, part.getNome());
            ps.setString(2, part.getEmail());
            ps.setString(3, part.getSenha());
            ps.execute();
            ResultSet keys = ps.getGeneratedKeys();
            keys.next();
            part.setId_pessoa(keys.getInt(1));

            String sql2 = "INSERT INTO participante(id_pessoa)VALUES(?)";
            PreparedStatement ps2 = connection.prepareStatement(sql2);
            ps2.setLong(1, part.getId_pessoa());
            ps2.execute();

            ps.close();
            ps2.close();

            System.out.println("************* FUNCIONOU *****************");
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Participante> readAll() {
        return null;
    }

    @Override
    public Participante readById(long id) {
        Participante p = new Participante();
        String sql = "select * from "
                + "pessoa inner join "
                + "participante on pessoa.id = participante.id_pessoa where pessoa.id = ? and id_tipo = 1";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p.setId_pessoa(id);
                p.setNome(rs.getString("nome"));
                p.setEmail(rs.getString("email"));
                p.setCelular(rs.getString("celular"));
                p.setSenha(rs.getString("senha"));
                p.setCurso(rs.getString("curso"));
                p.setFoto(rs.getBytes("foto"));
            }

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p;
    }

    @Override
    public void update(Participante participante) {

        try {
            String sql = "update pessoa set nome = ?, email = ?, celular = ?, senha = ? where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, participante.getNome());
            ps.setString(2, participante.getEmail());
            ps.setString(3, participante.getCelular());
            ps.setString(4, participante.getSenha());
            ps.setLong(5, participante.getId_pessoa());
            ps.execute();

            String sql2 = "update participante set curso = ?, foto = ? where id_pessoa = ?";
            PreparedStatement ps2 = connection.prepareStatement(sql2);
            ps2.setString(1, participante.getCurso());
            ps2.setBinaryStream(2, new ByteArrayInputStream(participante.getFoto()), participante.getFoto().length);
            ps2.setLong(3, participante.getId_pessoa());
            ps2.execute();

            ps.close();
            ps2.close();
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Participante participante) {

    }
    
    public List<Participante> searchMeatch(long id) {
        String sql = "SELECT pessoa.id, nome,email,celular,curso,COUNT(pessoa.id) qtd\n"
                + "	FROM inscricao \n"
                + "		INNER JOIN pessoa \n"
                + "		ON \n"
                + "pessoa.id = inscricao.id_participante \n"
                + "	INNER JOIN participante\n"
                + "		ON\n"
                + "	participante.id_pessoa = pessoa.id\n"
                + "	WHERE id_palestra \n"
                + "	IN (SELECT id_palestra FROM inscricao WHERE id_participante = ?) \n"
                + "	AND pessoa.id <> ? \n"
                + "	GROUP BY pessoa.id,nome,curso ORDER BY qtd DESC LIMIT 5;";
        List<Participante> participantes = new ArrayList();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ps.setLong(2, 1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Participante p = new Participante();
                p.setId_pessoa(rs.getLong("id"));
                p.setNome(rs.getString("nome"));
                p.setEmail(rs.getString("email"));
                p.setCurso(rs.getString("curso"));
                p.setCelular(rs.getString("celular"));
                participantes.add(p);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return participantes;
    }
}