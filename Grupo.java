import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Grupo {
    private String id;
    private Carreras carrera;
    private TipoGrupo tipoGrupo;
    private Alumno[] alumnos = new Alumno[20];

    public Grupo(String id, Carreras carrera, TipoGrupo tipo, Alumno[] alumnos) {
        this.id = id;
        this.carrera = carrera;
        this.alumnos = alumnos;
    }

    public void anadirAlumno(Alumno alumno) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) {
                alumnos[i] = alumno;
                break;
            }
        }
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Carreras getCarrera() {
        return carrera;
    }
    public void setCarrera(Carreras carrera) {
        this.carrera = carrera;
    }
    public Alumno[] getAlumnos() {
        return alumnos;
    }
    public void setAlumnos(Alumno[] alumnos) {
        this.alumnos = alumnos;
    }
}

