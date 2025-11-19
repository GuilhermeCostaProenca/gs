package br.fiap.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import br.fiap.dao.ReservaDAO;
import br.fiap.model.Reserva;
import br.fiap.model.Usuario;

public class ComprarServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Usuario u = (Usuario) req.getSession().getAttribute("usuario");

            String destino = req.getParameter("destino");
            String tipo = req.getParameter("tipo");
            boolean seguro = req.getParameter("seguro") != null;

            double valor = 0;

            if (destino.equals("Norte")) valor = tipo.equals("ida") ? 500 : 900;
            if (destino.equals("Nordeste")) valor = tipo.equals("ida") ? 350 : 650;
            if (destino.equals("Centro-Oeste")) valor = tipo.equals("ida") ? 350 : 600;
            if (destino.equals("Sul")) valor = tipo.equals("ida") ? 300 : 550;
            if (destino.equals("Sudeste")) valor = tipo.equals("ida") ? 600 : 1100;

            if (seguro) valor *= 1.15;

            Reserva r = new Reserva(0, u.getId(), destino, tipo, seguro ? "Sim" : "Não", valor);

            new ReservaDAO().inserir(r);

            req.setAttribute("valor", valor);
            req.getRequestDispatcher("resultadoCompra.jsp").forward(req, resp);

        } catch (Exception e) {
            resp.getWriter().println("Erro ao comprar");
        }
    }
}

