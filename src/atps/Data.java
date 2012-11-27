package atps;

import java.io.*;

// Dados para controle do Jogo
public class Data implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idJogo;
    public JogoVelha jogo;
    public boolean completo=false;

    public Data(int jogo) {
        this.setIdJogo(jogo);
    }

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int jogo) {
        this.idJogo = jogo;
    }
    
    public boolean getCompleto() {
        return this.completo;
    }
    
    public JogoVelha getJogo() {
        return this.jogo;
    }
}