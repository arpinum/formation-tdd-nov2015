import java.util.Set;
import java.util.stream.Collectors;

public class Grille {
    public Grille(CellulesVivantes cellulesVivantes) {
        this.cellulesVivantes = cellulesVivantes;
    }

    public Grille suivante() {
        CellulesVivantes suivantes = new CellulesVivantes();
        for (Position position : cellulesVivantesEtVoisines()) {
            ajouteSiLaCelluleDevientVivante(position, suivantes);
        }
        return new Grille(suivantes);
    }

    private void ajouteSiLaCelluleDevientVivante(Position position, CellulesVivantes suivantes) {
        long voisines = cellulesVivantes.nombreVoisines(position);
        if (new CelluleVivante().resteEnVie(voisines)) {
            suivantes.ajoute(position);
        }
    }

    private Set<Position> cellulesVivantesEtVoisines() {
        return cellulesVivantes.stream()
                .map(p -> cellulesVivantes.positionsVoisinesThéoriques(p))
                .flatMap(l -> l.stream())
                .collect(Collectors.toSet());
    }

    public CellulesVivantes cellules() {
        return cellulesVivantes;
    }

    private CellulesVivantes cellulesVivantes;
}
