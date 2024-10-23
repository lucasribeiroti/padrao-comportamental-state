package src.main.java;

public class ConexaoRede {
    private EstadoConexao estado;

    public ConexaoRede() {
        this.estado = EstadoDesconectado.getInstance();
    }

    public void setEstado(EstadoConexao estado) {
        this.estado = estado;
    }

    public boolean conectar() {
        return estado.conectar(this);
    }

    public boolean desconectar() {
        return estado.desconectar(this);
    }

    public boolean falhaConexao() {
        return estado.falhaConexao(this);
    }

    public boolean reconectar() {
        return estado.reconectar(this);
    }

    public String getEstado() {
        return estado.getEstado();
    }
}
