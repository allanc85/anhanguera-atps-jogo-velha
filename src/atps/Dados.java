package atps;

import java.io.*;

// Dados para controle do Jogo
public class Dados implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idJogo;
    public JogoVelha jogo;
    public boolean completo=false;

    // Construtor
    public Dados(int jogo) {
        this.setIdJogo(jogo);
    }

    // Recebe ID do Jogo
    public int getIdJogo() {
        return idJogo;
    }

    // Seta ID do Jogo
    public void setIdJogo(int jogo) {
        this.idJogo = jogo;
    }

    // Verifica se jogo está completo
    public boolean getCompleto() {
        return this.completo;
    }

    // Recebe dados do Jogo
    public JogoVelha getJogo() {
        return this.jogo;
    }
}