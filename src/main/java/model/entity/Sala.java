package model.entity;

public class Sala {

    private int id;
    private int numero;
    private int capacidade;
    private boolean disponivel = true;

    public Sala(int id,int numero, int capacidade, boolean disponivel) {
        this.id = id;
        this.numero = numero;
        this.capacidade = capacidade;
        this.disponivel = true;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public int getCapacidade() { return capacidade; }
    public void setCapacidade(int capacidade) { this.capacidade = capacidade; }

    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

    public void exibirDados() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("  SALA #" + id);
        System.out.println("  Número     : " + numero);
        System.out.println("  Capacidade : " + capacidade + " pessoas");
        System.out.println("  Status     : " + (disponivel ? " Disponível" : " Ocupada"));
        System.out.println("╚══════════════════════════════╝");
    }

    @Override
    public String toString() {
        return "Sala{id=" + id + ", numero='" + numero + "', capacidade=" + capacidade
                + ", disponivel=" + disponivel + "}";
    }




}
