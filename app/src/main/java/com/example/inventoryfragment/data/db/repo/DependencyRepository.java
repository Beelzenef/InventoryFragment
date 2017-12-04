package com.example.inventoryfragment.data.db.repo;

import com.example.inventoryfragment.data.db.model.Dependency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author Elena G (Beelzenef)
 */

public class DependencyRepository {

    // Atributos
    private ArrayList<Dependency> dependencies;
    private static DependencyRepository dependencyRepository;

    // Inicializacion
    // Inicializar cada atributo de ambito estatico o de Clase */
    static {
        dependencyRepository = new DependencyRepository();
    }

    // Constructor

    /**
     * El metodo ha de ser privado para garantizar una instancia única de la Clase
     */
    private DependencyRepository() {
        this.dependencies = new ArrayList<>();
        inicializar();
    }

    // Metodos

    /**
     * Inicializar la lista con dos dependencias
     */
    private void inicializar() {
        addDependency(new Dependency(1, "1º CF Grado superior", "1CFGS", "Ciclos superiores, primer año, la locura"));
        addDependency(new Dependency(2, "2º CF Grado superior", "2CFGS", "Ciclos superiores, segundo año, la muerte"));
        addDependency(new Dependency(3, "1ºROL", "1ROL", "El primer y único curso de rolerística"));
        addDependency(new Dependency(4, "3º ETSI", "3ETSI", "La ETSI mola mazo, pero es muy fea"));
        addDependency(new Dependency(5, "1º ETSI", "1ETSI", "La ETSI mola mazo, pero es muy fea"));
        addDependency(new Dependency(6, "3ESO", "3ESO", "Tercer curso de ESO"));
        addDependency(new Dependency(7, "1ESO", "1ESO", "Primero de ESO"));
    }

    /**
     * Metodo para agregar Dependencias a la lista
     *
     * @param d
     */
    public void addDependency(Dependency d) {
        dependencies.add(d);
    }

    /**
     * Método para obtener la instancia de la Clase
     */
    public static DependencyRepository getInstance() {
        // Bloque IF que insta el patron Singleton
        /* if (dependencyRepository == null)
            dependencyRepository = new DependencyRepository(); */
        return dependencyRepository;
    }

    /**
     * ArrayList ordenado según el criterio compareTo de la interfaz Comparable
     */
    public ArrayList<Dependency> getDependencies() {
        Collections.sort(dependencies, new Dependency.DependencyOrderBySortName());
        return dependencies;
    }

    public void editDependency(Dependency d) {
        for (Dependency dependencia : dependencies) {
            if (dependencia.getName().equals(d.getName())) {
                dependencia.setDescription(d.getDescription());
            }
        }
    }

    public void deleteDependency(Dependency d) {
        Iterator<Dependency> iterator = dependencies.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().getName().equals(d.getName())) {
                iterator.remove();
                break;
            }
        }
    }
}
