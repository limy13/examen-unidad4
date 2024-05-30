import java.util.ArrayList;

public class Semestre {
    private int numero;
    private ArrayList<Materia> materias;
    private Carreras carrera;

    public Semestre(int numero) {
        this.numero = numero;
        this.materias = asignarMaterias(numero);
        this.carrera = Sistema.carrera;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<Materia> materias) {
        this.materias = materias;
    }

    public static Materia asignarMaestro(Materias mater) { //le asigna un maestro a la materia y devuelve dicha mateia ya con el maestro asignado
        for(Usuario usuario : Sistema.usuarios.get(Sistema.carrera).get(Rol.PROFESOR)) {
            Profesor profesor = (Profesor) usuario;
            for(Materias nombreMateria : profesor.getMateriasImparte()) {
                if(mater == nombreMateria) {
                    Materia materia = new Materia(mater, profesor.getNombre().concat(" ").concat(profesor.getApellidos()), Sistema.carrera);
                    return materia;
                }
            }
        }
        return null;
    }

    public static ArrayList<Materia> asignarMaterias(int numero) {
        ArrayList<Materia> materias = null;
        if(Sistema.carrera == Carreras.SISTEMAS) {
            if(numero == 1) {
                materias.add(asignarMaestro(Materias.PROGRAMACION_1));
                materias.add(asignarMaestro(Materias.CALCULO_1));
                materias.add(asignarMaestro(Materias.PROBABILIDAD_1));
            }
            else if(numero == 2) {
                materias.add(asignarMaestro(Materias.PROGRAMACION_2));
                materias.add(asignarMaestro(Materias.CALCULO_2));
                materias.add(asignarMaestro(Materias.PROBABILIDAD_2));
            }
            else {
                materias.add(asignarMaestro(Materias.PROGRAMACION_3));
                materias.add(asignarMaestro(Materias.CALCULO_3));
                materias.add(asignarMaestro(Materias.PROBABILIDAD_3));
            }
        }
        else if(Sistema.carrera == Carreras.ELECTRONICA) {
            if(numero == 1) {
                materias.add(asignarMaestro(Materias.REDES_1));
                materias.add(asignarMaestro(Materias.CIRCUITOS_1));
                materias.add(asignarMaestro(Materias.CALCULO_1));
            }
            else if(numero == 2) {
                materias.add(asignarMaestro(Materias.REDES_2));
                materias.add(asignarMaestro(Materias.CIRCUITOS_2));
                materias.add(asignarMaestro(Materias.CALCULO_2));
            }
            else {
                materias.add(asignarMaestro(Materias.REDES_3));
                materias.add(asignarMaestro(Materias.CIRCUITOS_2));
                materias.add(asignarMaestro(Materias.CALCULO_3));
            }
        }
        else {
            if(numero == 1) {
                materias.add(asignarMaestro(Materias.ESTADISTICA_1));
                materias.add(asignarMaestro(Materias.CONTABILIDAD_1));
                materias.add(asignarMaestro(Materias.CALCULO_1));
            }
            else if(numero == 2) {
                materias.add(asignarMaestro(Materias.ESTADISTICA_2));
                materias.add(asignarMaestro(Materias.CONTABILIDAD_2));
                materias.add(asignarMaestro(Materias.CALCULO_2));
            }
            else {
                materias.add(asignarMaestro(Materias.ESTADISTICA_3));
                materias.add(asignarMaestro(Materias.CONTABILIDAD_3));
                materias.add(asignarMaestro(Materias.CALCULO_3));
            }
        }
        return materias;
    }
}
