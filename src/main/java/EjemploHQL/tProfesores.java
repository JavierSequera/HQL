package EjemploHQL;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="tProfesores")
@NamedQuery(name = "listaProfesores", query = "from tProfesores")
public class tProfesores implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name = "idProf")
    private int idProf;
    @Column (name = "nombre")
    private String nombre;
    @Column (name = "ape1")
    private String ape1;
    @Column (name = "ape2")
    private String ape2;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "idProf")
    private List<tAsignatura> asignatura;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="idDpto")
    private tDpto dpto;

    public tProfesores(String nombre, String ape1, String ape2) {
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
    }

    public tProfesores() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    @Override
    public String toString() {
        return getNombre()+", "+getApe1()+", "+getApe2();
    }

    public List<tAsignatura> getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(List<tAsignatura> asignatura) {
        this.asignatura = asignatura;
    }

    public tDpto getDpto() {
        return dpto;
    }

    public void setDpto(tDpto dpto) {
        this.dpto = dpto;
    }
}
