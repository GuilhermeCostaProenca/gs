<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, br.fiap.model.Reserva" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Vendas</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h1>Vendas Encontradas</h1>
                <p>Listagem de todas as vendas do sistema</p>
            </div>

            <%
                List<Reserva> lista = (List<Reserva>) request.getAttribute("lista");

                if (lista == null || lista.size() == 0) {
            %>
                    <div class="alert alert-info">
                        <strong>Nenhuma venda encontrada.</strong>
                    </div>
            <%
                } else {
            %>
                    <table>
                        <thead>
                            <tr>
                                <th>ID Reserva</th>
                                <th>ID Usuário</th>
                                <th>Destino</th>
                                <th>Tipo</th>
                                <th>Seguro</th>
                                <th>Valor</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (Reserva r : lista) {
                            %>
                                    <tr>
                                        <td><%= r.getId() %></td>
                                        <td><%= r.getIdUsuario() %></td>
                                        <td><strong><%= r.getDestino() %></strong></td>
                                        <td><%= r.getTipo() %></td>
                                        <td><%= r.getSeguro() %></td>
                                        <td><strong style="color: var(--secondary-color);">R$ <%= String.format("%.2f", r.getValor()) %></strong></td>
                                    </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>

                    <div class="alert alert-info">
                        <strong>Total de vendas: <%= lista.size() %></strong>
                    </div>
            <%
                }
            %>

            <a href="admin.jsp" class="back-link">← Voltar ao painel administrativo</a>
        </div>
    </div>
</body>
</html>

