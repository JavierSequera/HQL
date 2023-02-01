package EjemploHQL;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tAsignatura")
public class tAsignatura implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name = "idAsig")
    private int idAsig;
    @Column (name = "curso")
    private int curso;
    @Column (name = "horas")
    private int horas;
    @Column (name = "nombre")
    private String nombre;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="idProf")
    private tProfesores Prof;

    public tAsignatura(int curso, int horas, String nombre, tProfesores profesor) {
        this.curso = curso;
        this.horas = horas;
        this.nombre = nombre;
        this.Prof = profesor;
    }


    public tAsignatura() {

    }

    public int getIdAsig() {
        return idAsig;
    }

    public void setIdAsig(int idAsig) {
        this.idAsig = idAsig;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public tProfesores getIdProf() {
        return Prof;
    }

    public void setIdProf(tProfesores idProf) {
        this.Prof = idProf;
    }
}
