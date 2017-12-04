package com.example.inventoryfragment.data.db.repo;

import com.example.inventoryfragment.data.db.model.Section;

import java.util.ArrayList;

/**
 * @author Elena G (Beelzenef)
 */

public class SectionRepository {

    ArrayList<Section> sections;
    static SectionRepository sectionRepository;

    static {
        sectionRepository = new SectionRepository();
    }

    void inicializarSections()
    {
        addSection(new Section(1, "Sector 1", "S1", "Description 1", 1, true, true ));
        addSection(new Section(2, "Sector 2", "S2", "Description 2", 2, true, false ));
        addSection(new Section(3, "Sector 3", "S3", "Description 3", 3, true, false ));
        addSection(new Section(4, "Sector 1", "S1", "Description 1", 1, true, true ));
        addSection(new Section(5, "Sector 2", "S2", "Description 2", 2, true, false ));
        addSection(new Section(6, "Sector 3", "S3", "Description 3", 3, true, false ));
        addSection(new Section(7, "Sector 1", "S1", "Description 1", 1, true, true ));
        addSection(new Section(8, "Sector 2", "S2", "Description 2", 2, true, false ));
        addSection(new Section(9, "Sector 3", "S3", "Description 3", 3, true, false ));
        addSection(new Section(10, "Sector 1", "S1", "Description 1", 1, true, true ));
        addSection(new Section(11, "Sector 2", "S2", "Description 2", 2, true, false ));
        addSection(new Section(12, "Sector 3", "S3", "Description 3", 3, true, false ));
    }

    private SectionRepository()
    {
        this.sections = new ArrayList<>();
        inicializarSections();
    }

    void addSection(Section s)
    {
        sections.add(s);
    }

    public static SectionRepository getInstance()
    {
        return sectionRepository;
    }

    public ArrayList<Section> getSections()
    {
        return sections;
    }
}
