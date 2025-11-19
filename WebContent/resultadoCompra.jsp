<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Compra Realizada - Sistema de Passagens</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h1>Compra realizada com sucesso!</h1>
                <p>Sua passagem foi confirmada</p>
            </div>

            <div class="alert alert-success">
                <h2 style="margin: 0; font-size: 1.5rem;">
                    Valor Total: R$ <%= String.format("%.2f", request.getAttribute("valor") != null ? Double.parseDouble(request.getAttribute("valor").toString()) : 0.0) %>
                </h2>
            </div>

            <div class="alert alert-info">
                <p style="margin: 0;">Um email de confirmação será enviado em breve.</p>
                <p style="margin: 0.5rem 0 0 0;">Você pode acessar sua reserva no painel do passageiro.</p>
            </div>

            <div class="btn-group">
                <a href="venda.jsp" class="btn btn-primary">Comprar outra passagem</a>
                <a href="index.jsp" class="btn btn-secondary">Sair</a>
            </div>
        </div>
    </div>
</body>
</html>

