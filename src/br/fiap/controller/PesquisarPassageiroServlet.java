package br.fiap.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import br.fiap.dao.UsuarioDAO;

public class PesquisarPassageiroServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");

        try {
            UsuarioDAO dao = new UsuarioDAO();
            boolean encontrado = dao.existe(email);
            
            req.setAttribute("encontrado", encontrado);
            req.getRequestDispatcher("resultadoPesquisaPassageiro.jsp").forward(req, resp);

        } catch (Exception e) {
            resp.getWriter().println("Erro: " + e.getMessage());
        }
    }
}

