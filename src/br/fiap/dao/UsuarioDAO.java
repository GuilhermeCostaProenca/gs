package br.fiap.dao;

import br.fiap.model.Usuario;
import java.sql.*;

public class UsuarioDAO {

    public Usuario buscar(String email, String senha) throws Exception {
        Connection con = Conexao.conectar();

        PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM gs_usuario WHERE email=? AND senha=?"
        );
        ps.setString(1, email);
        ps.setString(2, senha);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("nome"),
                    rs.getString("tipo_usuario")
            );
        }
        return null;
    }

    public boolean existe(String email) throws Exception {
        Connection con = Conexao.conectar();

        PreparedStatement ps = con.prepareStatement(
                "SELECT 1 FROM gs_usuario WHERE email=?"
        );
        ps.setString(1, email);

        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    public void cadastrar(Usuario u) throws Exception {
        Connection con = Conexao.conectar();

        PreparedStatement psId = con.prepareStatement(
                "SELECT NVL(MAX(id_usuario), 999) + 1 AS id FROM gs_usuario"
        );
        ResultSet rs = psId.executeQuery();
        rs.next();
        int idGerado = rs.getInt("id");

        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO gs_usuario VALUES (?, ?, ?, ?, ?)"
        );
        ps.setInt(1, idGerado);
        ps.setString(2, u.getEmail());
        ps.setString(3, u.getSenha());
        ps.setString(4, u.getNome());
        ps.setString(5, "passageiro");

        ps.execute();
    }
}

