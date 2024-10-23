package src.main.java;

public abstract class EstadoConexao {

    public abstract String getEstado();

    public boolean conectar(ConexaoRede conexao) {
        return false;
    }

    public boolean desconectar(ConexaoRede conexao) {
        return false;
    }

    public boolean falhaConexao(ConexaoRede conexao) {
        return false;
    }

    public boolean reconectar(ConexaoRede conexao) {
        return false;
    }
}
