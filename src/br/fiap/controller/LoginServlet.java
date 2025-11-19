package br.fiap.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import br.fiap.dao.UsuarioDAO;
import br.fiap.model.Usuario;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        try {
            UsuarioDAO dao = new UsuarioDAO();
            Usuario usuario = dao.buscar(email, senha);

            if (usuario == null) {
                resp.getWriter().println("<h1>Usuário não encontrado!</h1>");
            } else {
                req.getSession().setAttribute("usuario", usuario);

                if (usuario.getTipo().equals("passageiro")) {
                    resp.sendRedirect("venda.jsp");
                } else {
                    resp.sendRedirect("admin.jsp");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Erro no login");
        }
    }
}

