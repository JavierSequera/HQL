package EjemploHQL;

import EjemploHQL.tProfesores;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="tDpto")
public class tDpto implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name = "idDpto")
    private int idDpto;

    @Column (name = "Nombre")
    private String Nombre;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "idDpto")
    private List<tProfesores> listaProfesores;

    public tDpto(String nombre) {
        Nombre = nombre;
    }

    public tDpto() {

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public List<tProfesores> getListaProfesores() {
        return listaProfesores;
    }

    public void setListaProfesores(List<tProfesores> listaProfesores) {
        this.listaProfesores = listaProfesores;
    }
}
