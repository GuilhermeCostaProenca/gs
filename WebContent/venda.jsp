<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="br.fiap.model.Usuario" %>
<%
    Usuario u = (Usuario) session.getAttribute("usuario");
    if (u == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Comprar Passagens</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <div class="user-info">
            <h2>Bem-vindo, <%= u.getNome() %>!</h2>
            <p>Email: <%= u.getEmail() %></p>
        </div>

        <div class="card">
            <div class="card-header">
                <h1>Comprar Passagem</h1>
                <p>Escolha seu destino e personalize sua viagem</p>
            </div>

            <form action="comprar" method="post">
                <div class="form-group">
                    <label for="destino">Destino</label>
                    <select id="destino" name="destino" class="form-control" required>
                        <option value="">Selecione um destino</option>
                        <option value="Norte">Norte</option>
                        <option value="Nordeste">Nordeste</option>
                        <option value="Centro-Oeste">Centro-Oeste</option>
                        <option value="Sul">Sul</option>
                        <option value="Sudeste">Sudeste</option>
                    </select>
                </div>

                <div class="form-group">
                    <label>Tipo de Viagem</label>
                    <div class="radio-group">
                        <label>
                            <input type="radio" name="tipo" value="ida" checked>
                            Ida
                        </label>
                        <label>
                            <input type="radio" name="tipo" value="ida-e-volta">
                            Ida e Volta
                        </label>
                    </div>
                </div>

                <div class="form-group">
                    <label>
                        <div class="checkbox-group">
                            <input type="checkbox" name="seguro" id="seguro">
                            <span>Adicionar seguro viagem</span>
                        </div>
                    </label>
                </div>

                <button type="submit" class="btn btn-primary btn-block">Comprar Passagem</button>
            </form>
        </div>
    </div>
</body>
</html>

