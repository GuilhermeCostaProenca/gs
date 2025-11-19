<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="br.fiap.model.Usuario" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultado da Pesquisa</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h1>Resultado da Pesquisa</h1>
                <p>Busca de passageiro</p>
            </div>

            <%
                Boolean encontrado = (Boolean) request.getAttribute("encontrado");
                if (encontrado != null && encontrado) {
            %>
                    <div class="alert alert-success">
                        <h2 style="margin: 0;">Passageiro encontrado!</h2>
                        <p style="margin: 0.5rem 0 0 0;">O passageiro com o email pesquisado está cadastrado no sistema.</p>
                    </div>
            <%
                } else {
            %>
                    <div class="alert alert-info">
                        <h2 style="margin: 0;">Passageiro não encontrado</h2>
                        <p style="margin: 0.5rem 0 0 0;">Não foi encontrado nenhum passageiro com o email informado.</p>
                    </div>
            <%
                }
            %>

            <a href="admin.jsp" class="back-link">← Voltar ao painel administrativo</a>
        </div>
    </div>
</body>
</html>

