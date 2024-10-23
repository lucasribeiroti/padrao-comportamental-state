package src.main.java;

public class EstadoDesconectado extends EstadoConexao {

    private static EstadoDesconectado instance = new EstadoDesconectado();

    private EstadoDesconectado() {}

    public static EstadoDesconectado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Desconectado";
    }

    public boolean conectar(ConexaoRede conexao) {
        conexao.setEstado(EstadoConectado.getInstance());
        return true;
    }
}