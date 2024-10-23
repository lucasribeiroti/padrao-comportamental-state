package src.main.java;

public class EstadoConectado extends EstadoConexao {

    private EstadoConectado() {}
    private static EstadoConectado instance = new EstadoConectado();
    public static EstadoConectado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Conectado";
    }

    public boolean desconectar(ConexaoRede conexao) {
        conexao.setEstado(EstadoDesconectado.getInstance());
        return true;
    }

    public boolean falhaConexao(ConexaoRede conexao) {
        return true;
    }
}