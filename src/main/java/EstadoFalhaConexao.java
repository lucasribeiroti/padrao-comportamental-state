package src.main.java;

public class EstadoFalhaConexao extends EstadoConexao {

    private static EstadoFalhaConexao instance = new EstadoFalhaConexao();

    private EstadoFalhaConexao() {}

    public static EstadoFalhaConexao getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Falha de Conexão";
    }

    public boolean reconectar(ConexaoRede conexao) {
        conexao.setEstado(EstadoReconectando.getInstance());
        return true;
    }

    public boolean conectar(ConexaoRede conexao) {
        conexao.setEstado(EstadoConectado.getInstance());
        return true;
    }
}
