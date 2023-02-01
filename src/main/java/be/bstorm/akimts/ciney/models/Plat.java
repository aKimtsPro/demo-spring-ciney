package be.bstorm.akimts.ciney.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class Plat {
    private long id;
    private String nom;
    private double prix;
    private List<String> ingredients;
    private boolean dispo;
}
