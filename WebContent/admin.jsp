<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="br.fiap.model.Usuario" %>
<%
    Usuario u = (Usuario) session.getAttribute("usuario");
    if (u == null || !u.getTipo().equals("admin")) {
        response.sendRedirect("index.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Painel Administrativo</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <div class="user-info">
            <h2>Painel Administrativo</h2>
            <p>Administrador: <%= u.getNome() %> | Email: <%= u.getEmail() %></p>
        </div>

        <div class="card">
            <h3 class="section-title">Pesquisar Passageiro</h3>
            <form action="pesquisarPassageiro" method="post">
                <div class="form-group">
                    <label for="email">Email do Passageiro</label>
                    <input type="email" id="email" name="email" class="form-control" placeholder="passageiro@email.com" required>
                </div>
                <button type="submit" class="btn btn-primary">Pesquisar</button>
            </form>
        </div>

        <div class="card">
            <h3 class="section-title">Pesquisar Vendas por Região</h3>
            <form action="pesquisarVenda" method="post">
                <div class="form-group">
                    <label for="destino">Região</label>
                    <select id="destino" name="destino" class="form-control" required>
                        <option value="">Selecione uma região</option>
                        <option value="Norte">Norte</option>
                        <option value="Nordeste">Nordeste</option>
                        <option value="Centro-Oeste">Centro-Oeste</option>
                        <option value="Sul">Sul</option>
                        <option value="Sudeste">Sudeste</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Pesquisar Vendas</button>
            </form>
        </div>

        <div class="card">
            <h3 class="section-title">Listar Todas as Vendas</h3>
            <form action="listar" method="get">
                <button type="submit" class="btn btn-success btn-block">Ver Todas as Vendas</button>
            </form>
        </div>
    </div>
</body>
</html>

