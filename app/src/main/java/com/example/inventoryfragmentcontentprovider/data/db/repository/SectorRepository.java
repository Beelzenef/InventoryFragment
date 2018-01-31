package com.example.inventoryfragmentcontentprovider.data.db.repository;

import com.example.inventoryfragmentcontentprovider.data.db.InteractorCallback;
import com.example.inventoryfragmentcontentprovider.data.db.dao.SectorDao;
import com.example.inventoryfragmentcontentprovider.data.db.model.Sector;

import java.util.ArrayList;

/**
 * Clase que almacenará diferentes sectores.
 * @author Carlos Cruz Domínguez
 */

public class SectorRepository {
    private ArrayList<Sector> sectors;

    private static SectorRepository sectorRepository;

    private SectorDao sectorDao;

    static {
        sectorRepository = new SectorRepository();
    }

    public SectorRepository() {
        this.sectors = new ArrayList();
        this.sectorDao = new SectorDao();
    }

    public void addSector (Sector sector) {
        sectors.add(sector);
    }

    public static SectorRepository getInstance() {
        //Otra opción para inicializar es esta.
        if (sectorRepository == null)
            sectorRepository = new SectorRepository();
        return sectorRepository;
    }

    public ArrayList<Sector> getSectors() {

        sectors = sectorDao.loadAll();
        return sectors;
    }

    public long addSector (Sector s, InteractorCallback c) {
        try {
            long resultado = sectorDao.save(s);
            if (resultado == 0) {
                c.onError(new Exception("Error al agregar sector"));
            } else {
                c.onSuccess();
            }
        } catch (Exception e) {
            c.onError(new Exception("Error: " + e.getMessage(), e));
        }

        return 0;
    }

    public long deleteSector (Sector s, InteractorCallback c) {
        try {
            long resultado = sectorDao.delete(s);
            if (resultado == 0) {
                c.onError(new Exception("Error al eliminar sector"));
            } else {
                c.onSuccess();
            }
        } catch (Exception e) {
            c.onError(new Exception("Error: " + e.getMessage(), e));
        }

        return 0;
    }

    public long updateSector (Sector s, InteractorCallback c) {
        try {
            long resultado = sectorDao.update(s);
            if (resultado == 0) {
                c.onError(new Exception("Error al actualizar sector"));
            } else {
                c.onSuccess();
            }
        } catch (Exception e) {
            c.onError(new Exception("Error: " + e.getMessage(), e));
        }

        return 0;
    }
}
