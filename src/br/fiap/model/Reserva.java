package br.fiap.model;

public class Reserva {

    private int id;
    private int idUsuario;
    private String destino;
    private String tipo;
    private String seguro;
    private double valor;

    public Reserva(int id, int idUsuario, String destino, String tipo, String seguro, double valor) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.destino = destino;
        this.tipo = tipo;
        this.seguro = seguro;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getDestino() {
        return destino;
    }

    public String getTipo() {
        return tipo;
    }

    public String getSeguro() {
        return seguro;
    }

    public double getValor() {
        return valor;
    }
}

