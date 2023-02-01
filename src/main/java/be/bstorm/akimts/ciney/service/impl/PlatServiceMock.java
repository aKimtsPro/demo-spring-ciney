package be.bstorm.akimts.ciney.service.impl;

import be.bstorm.akimts.ciney.models.Plat;
import be.bstorm.akimts.ciney.models.PlatCreateForm;
import be.bstorm.akimts.ciney.service.PlatService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatServiceMock implements PlatService {

    private final List<Plat> plats = new ArrayList<>();
    private int nextId = 1;

    public PlatServiceMock() {
        plats.add( new Plat(nextId++, "curry", 12, List.of("lait de coco", "poivron", "curry"), true) );
        plats.add( new Plat(nextId++, "quiche", 8, List.of("pate feuilleté", "champignon", "creme"), true) );
        plats.add( new Plat(nextId++, "tartiflette", 5, List.of("oignon", "patate", "fromage"), false) );
    }

    @Override
    public List<Plat> getAll(){
        return new ArrayList<>(plats);
    }

    @Override
    public Plat getOne(long id){
        return plats.stream()
                .filter( p -> p.getId() == id )
                .findFirst()
                .orElseThrow( () -> new RuntimeException("plat not found") );
    }

    @Override
    public void create(PlatCreateForm form) {
        Plat plat = new Plat(
                nextId++,
                form.getNom(),
                form.getPrix(),
                new ArrayList<>(),
                true
        );
        plats.add( plat );
    }
}
