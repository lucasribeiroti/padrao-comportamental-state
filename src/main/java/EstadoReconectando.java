package src.main.java;

public class EstadoReconectando extends EstadoConexao {

    private static EstadoReconectando instance = new EstadoReconectando();

    private EstadoReconectando() {}

    public static EstadoReconectando getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Reconectando";
    }

    public boolean falhaConexao(ConexaoRede conexao) {
        conexao.setEstado(EstadoFalhaConexao.getInstance());
        return true;
    }

    public boolean conectar(ConexaoRede conexao) {
        conexao.setEstado(EstadoConectado.getInstance());
        return true;
    }
}
