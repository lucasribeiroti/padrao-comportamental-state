package src.main.java.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.*;

import static org.junit.jupiter.api.Assertions.*;

public class ConexaoRedeTest {

    ConexaoRede conexao;

    @BeforeEach
    public void setUp() {
        conexao = new ConexaoRede();
    }

    // Estado Desconectado

    @Test
    public void deveConectarQuandoDesconectado() {
        conexao.setEstado(EstadoDesconectado.getInstance());
        assertTrue(conexao.conectar());
        assertEquals(EstadoConectado.getInstance(), conexao.getEstado());
    }

    @Test
    public void naoDeveDesconectarQuandoDesconectado() {
        conexao.setEstado(EstadoDesconectado.getInstance());
        assertFalse(conexao.desconectar());
        assertEquals(EstadoDesconectado.getInstance(), conexao.getEstado());
    }

    @Test
    public void naoDeveFalharConexaoQuandoDesconectado() {
        conexao.setEstado(EstadoDesconectado.getInstance());
        assertFalse(conexao.falhaConexao());
        assertEquals(EstadoDesconectado.getInstance(), conexao.getEstado());
    }

    @Test
    public void naoDeveReconectarQuandoDesconectado() {
        conexao.setEstado(EstadoDesconectado.getInstance());
        assertFalse(conexao.reconectar());
        assertEquals(EstadoDesconectado.getInstance(), conexao.getEstado());
    }

    // Estado Conectado

    @Test
    public void deveDesconectarQuandoConectado() {
        conexao.setEstado(EstadoConectado.getInstance());
        assertTrue(conexao.desconectar());
        assertEquals(EstadoDesconectado.getInstance(), conexao.getEstado());
    }

    @Test
    public void deveFalharConexaoQuandoConectado() {
        conexao.setEstado(EstadoConectado.getInstance());
        assertTrue(conexao.falhaConexao());
        assertEquals(EstadoFalhaConexao.getInstance(), conexao.getEstado());
    }

    @Test
    public void naoDeveConectarQuandoConectado() {
        conexao.setEstado(EstadoConectado.getInstance());
        assertFalse(conexao.conectar());
        assertEquals(EstadoConectado.getInstance(), conexao.getEstado());
    }

    @Test
    public void naoDeveReconectarQuandoConectado() {
        conexao.setEstado(EstadoConectado.getInstance());
        assertFalse(conexao.reconectar());
        assertEquals(EstadoConectado.getInstance(), conexao.getEstado());
    }

    // Estado Falha de Conexão

    @Test
    public void deveReconectarQuandoFalhaConexao() {
        conexao.setEstado(EstadoFalhaConexao.getInstance());
        assertTrue(conexao.reconectar());
        assertEquals(EstadoReconectando.getInstance(), conexao.getEstado());
    }

    @Test
    public void deveConectarQuandoFalhaConexao() {
        conexao.setEstado(EstadoFalhaConexao.getInstance());
        assertTrue(conexao.conectar());
        assertEquals(EstadoConectado.getInstance(), conexao.getEstado());
    }

    @Test
    public void naoDeveFalharConexaoQuandoFalhaConexao() {
        conexao.setEstado(EstadoFalhaConexao.getInstance());
        assertFalse(conexao.falhaConexao());
        assertEquals(EstadoFalhaConexao.getInstance(), conexao.getEstado());
    }

    @Test
    public void naoDeveDesconectarQuandoFalhaConexao() {
        conexao.setEstado(EstadoFalhaConexao.getInstance());
        assertFalse(conexao.desconectar());
        assertEquals(EstadoFalhaConexao.getInstance(), conexao.getEstado());
    }

    // Estado Reconectando

    @Test
    public void deveConectarQuandoReconectando() {
        conexao.setEstado(EstadoReconectando.getInstance());
        assertTrue(conexao.conectar());
        assertEquals(EstadoConectado.getInstance(), conexao.getEstado());
    }

    @Test
    public void deveFalharConexaoQuandoReconectando() {
        conexao.setEstado(EstadoReconectando.getInstance());
        assertTrue(conexao.falhaConexao());
        assertEquals(EstadoFalhaConexao.getInstance(), conexao.getEstado());
    }

    @Test
    public void naoDeveReconectarQuandoReconectando() {
        conexao.setEstado(EstadoReconectando.getInstance());
        assertFalse(conexao.reconectar());
        assertEquals(EstadoReconectando.getInstance(), conexao.getEstado());
    }

    @Test
    public void naoDeveDesconectarQuandoReconectando() {
        conexao.setEstado(EstadoReconectando.getInstance());
        assertFalse(conexao.desconectar());
        assertEquals(EstadoReconectando.getInstance(), conexao.getEstado());
    }
}
