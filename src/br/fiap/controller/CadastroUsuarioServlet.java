package br.fiap.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import br.fiap.dao.UsuarioDAO;
import br.fiap.model.Usuario;

public class CadastroUsuarioServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Usuario usuario = new Usuario(
                0,
                req.getParameter("email"),
                req.getParameter("senha"),
                req.getParameter("nome"),
                "passageiro"
            );

            UsuarioDAO dao = new UsuarioDAO();
            dao.cadastrar(usuario);

            resp.sendRedirect("index.jsp");

        } catch (Exception e) {
            resp.getWriter().println("Erro ao cadastrar");
        }
    }
}

