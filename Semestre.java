import java.util.List;

public class Semestre {
    private int numero;
    private List<Materia> materias;

    public Semestre(int numero, List<Materia> materias) {
        this.numero = numero;
        this.materias = materias;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
}
