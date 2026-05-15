package model.entity;

public class Reserva {

    private int id;
    private Usuario usuario;
    private Sala sala;
    private String data;
    private String horario;
    private String status;

    public Reserva(int id, Usuario usuario, Sala sala, String data, String horario) {
        this.id = id;
        this.usuario = usuario;
        this.sala = sala;
        this.data = data;
        this.horario = horario;
        this.status = "ATIVA";
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Sala getSala() { return sala; }
    public void setSala(Sala sala) { this.sala = sala; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public void exibirDados() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("  RESERVA #" + id);
        System.out.println("  Status  : " + status);
        System.out.println("  Data    : " + data + " às " + horario);
        System.out.println("  Usuário : " + usuario.getNome() + " (CPF: " + usuario.getCpf() + ")");
        System.out.println("  Sala    : " + sala.getNumero() + " | Capacidade: " + sala.getCapacidade());
        System.out.println("╚══════════════════════════════╝");
    }

    @Override
    public String toString() {
        return "Reserva{id=" + id +
                ", usuario=" + usuario.getNome() +
                ", sala=" + sala.getNumero() +
                ", data='" + data + "'" +
                ", horario='" + horario + "'" +
                ", status='" + status + "'}";
    }
}