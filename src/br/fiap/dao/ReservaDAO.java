package br.fiap.dao;

import br.fiap.model.Reserva;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    public void inserir(Reserva r) throws Exception {
        Connection con = Conexao.conectar();

        PreparedStatement psId = con.prepareStatement(
                "SELECT NVL(MAX(id_reserva), 99) + 1 AS id FROM gs_reserva"
        );
        ResultSet rs = psId.executeQuery();
        rs.next();
        int idGerado = rs.getInt("id");

        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO gs_reserva VALUES (?, ?, ?, ?, ?, ?)"
        );
        ps.setInt(1, idGerado);
        ps.setInt(2, r.getIdUsuario());
        ps.setString(3, r.getDestino());
        ps.setString(4, r.getTipo());
        ps.setString(5, r.getSeguro());
        ps.setDouble(6, r.getValor());

        ps.execute();
    }

    public List<Reserva> listarPorRegiao(String destino) throws Exception {
        Connection con = Conexao.conectar();

        PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM gs_reserva WHERE destino=?"
        );
        ps.setString(1, destino);

        ResultSet rs = ps.executeQuery();
        List<Reserva> lista = new ArrayList<>();

        while (rs.next()) {
            lista.add(new Reserva(
                    rs.getInt("id_reserva"),
                    rs.getInt("id_usuario"),
                    rs.getString("destino"),
                    rs.getString("tipo_de_viagem"),
                    rs.getString("seguro"),
                    rs.getDouble("valor")
            ));
        }
        return lista;
    }

    public List<Reserva> listarTodas() throws Exception {
        Connection con = Conexao.conectar();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM gs_reserva");

        List<Reserva> lista = new ArrayList<>();

        while (rs.next()) {
            lista.add(new Reserva(
                    rs.getInt("id_reserva"),
                    rs.getInt("id_usuario"),
                    rs.getString("destino"),
                    rs.getString("tipo_de_viagem"),
                    rs.getString("seguro"),
                    rs.getDouble("valor")
            ));
        }
        return lista;
    }
}

