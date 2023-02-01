package be.bstorm.akimts.ciney.fakedb;

import be.bstorm.akimts.ciney.models.Plat;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlatFakeDB {

    private final List<Plat> plats = new ArrayList<>();

    public PlatFakeDB() {
        plats.add( new Plat(1, "curry", 12, List.of("lait de coco", "poivron", "curry"), true) );
        plats.add( new Plat(2, "quiche", 8, List.of("pate feuilleté", "champignon", "creme"), true) );
        plats.add( new Plat(3, "tartiflette", 5, List.of("oignon", "patate", "fromage"), false) );
    }

    public List<Plat> getAll(){
        return new ArrayList<>(plats);
    }

    public Plat getOne(long id){
        return plats.stream()
                .filter( p -> p.getId() == id )
                .findFirst()
                .orElseThrow( () -> new RuntimeException("plat not found") );
    }
}
