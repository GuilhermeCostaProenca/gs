package br.fiap.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import br.fiap.dao.ReservaDAO;

public class ListarVendasServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setAttribute("lista", new ReservaDAO().listarTodas());
            req.getRequestDispatcher("listarVendas.jsp").forward(req, resp);

        } catch (Exception e) {
            resp.getWriter().println("Erro");
        }
    }
}
