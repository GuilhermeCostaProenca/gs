package br.fiap.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import br.fiap.dao.ReservaDAO;

public class PesquisarVendaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String destino = req.getParameter("destino");

        try {
            req.setAttribute("lista", new ReservaDAO().listarPorRegiao(destino));
            req.getRequestDispatcher("listarVendas.jsp").forward(req, resp);

        } catch (Exception e) {
            resp.getWriter().println("Erro");
        }
    }
}

