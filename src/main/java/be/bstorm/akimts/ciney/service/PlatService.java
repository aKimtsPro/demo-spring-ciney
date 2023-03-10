package be.bstorm.akimts.ciney.service;

import be.bstorm.akimts.ciney.models.Plat;
import be.bstorm.akimts.ciney.models.PlatCreateForm;
import be.bstorm.akimts.ciney.models.PlatUpdateForm;

import java.util.List;

public interface PlatService {

    List<Plat> getAll();
    Plat getOne(long id);
    void create(PlatCreateForm form);
    void update(long id, PlatUpdateForm form);

}
