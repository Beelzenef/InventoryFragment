package com.example.inventoryfragment.db.repo;

import com.example.inventoryfragment.db.model.Dependency;

import java.util.ArrayList;
import java.util.Collections;

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
    private void inicializar()
    {
        addDependency(new Dependency(1, "1º CF Grado superior", "1CFGS", "Ciclos superiores, primer año, la locura"));
        addDependency(new Dependency(2, "2º CF Grado superior", "2CFGS", "Ciclos superiores, segundo año, la muerte"));
        addDependency(new Dependency(3, "1º CF Grado superior", "1CFGS", "Ciclos superiores, primer año, la locura"));
        addDependency(new Dependency(4, "2º CF Grado superior", "2CFGS", "Ciclos superiores, segundo año, la muerte"));
        addDependency(new Dependency(5, "1º CF Grado superior", "1CFGS", "Ciclos superiores, primer año, la locura"));
        addDependency(new Dependency(6, "2º CF Grado superior", "2CFGS", "Ciclos superiores, segundo año, la muerte"));
        addDependency(new Dependency(7, "1º CF Grado superior", "1CFGS", "Ciclos superiores, primer año, la locura"));
        addDependency(new Dependency(8, "2º CF Grado superior", "2CFGS", "Ciclos superiores, segundo año, la muerte"));
        addDependency(new Dependency(9, "1º CF Grado superior", "1CFGS", "Ciclos superiores, primer año, la locura"));
        addDependency(new Dependency(10, "2º CF Grado superior", "2CFGS", "Ciclos superiores, segundo año, la muerte"));
        addDependency(new Dependency(11, "1º CF Grado superior", "1CFGS", "Ciclos superiores, primer año, la locura"));
        addDependency(new Dependency(12, "1ESO", "1ESO", "Primero de ESO"));
    }

    /**
     * Metodo para agregar Dependencias a la lista
     * @param d
     */
    public void addDependency(Dependency d)
    {
        dependencies.add(d);
    }

    /**
     * Método para obtener la instancia de la Clase
     */
    public static DependencyRepository getInstance()
    {
        // Bloque IF que insta el patron Singleton
        /* if (dependencyRepository == null)
            dependencyRepository = new DependencyRepository(); */
        return dependencyRepository;
    }

    /**
     * ArrayList ordenado según el criterio compareTo de la interfaz Comparable
     */
    public ArrayList<Dependency> getDependencies()
    {
        Collections.sort(dependencies, new Dependency.DependencyOrderBySortName());
        return dependencies;
    }


}
