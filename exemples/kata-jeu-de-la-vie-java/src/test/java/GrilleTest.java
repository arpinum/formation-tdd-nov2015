import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GrilleTest {

    @Test
    public void uneGrilleVideNeContientQueDesCellulesMortes() {
        CellulesVivantes cellules = new CellulesVivantes();
        Grille grille = new Grille(cellules);

        Grille suivante = grille.suivante();

        CellulesVivantes suivantes = suivante.cellules();
        assertThat(contient(suivantes, new Position(0, 0))).isFalse();
        assertThat(contient(suivantes, new Position(-12, 23))).isFalse();
    }

    @Test
    public void uneGrillePeutResterEnVie() {
        CellulesVivantes cellules = new CellulesVivantes();
        cellules.ajoute(new Position(0, 0));
        cellules.ajoute(new Position(0, 1));
        cellules.ajoute(new Position(1, 0));
        cellules.ajoute(new Position(1, 1));
        Grille grille = new Grille(cellules);

        Grille suivante = grille.suivante();

        CellulesVivantes suivantes = suivante.cellules();
        assertThat(contient(suivantes, new Position(0, 0))).isTrue();
        assertThat(contient(suivantes, new Position(0, 1))).isTrue();
        assertThat(contient(suivantes, new Position(1, 0))).isTrue();
        assertThat(contient(suivantes, new Position(1, 1))).isTrue();
    }

    @Test
    public void uneGrillePeutMourir() {
        CellulesVivantes cellules = new CellulesVivantes();
        cellules.ajoute(new Position(0, 0));
        Grille grille = new Grille(cellules);

        Grille suivante = grille.suivante();

        CellulesVivantes suivantes = suivante.cellules();
        assertThat(contient(suivantes, new Position(0, 0))).isFalse();
    }

    @Test
    public void uneGrillePeutEvoluer() {
        CellulesVivantes cellules = new CellulesVivantes();
        cellules.ajoute(new Position(0, 0));
        cellules.ajoute(new Position(1, 0));
        cellules.ajoute(new Position(2, 0));
        Grille grille = new Grille(cellules);

        Grille suivante = grille.suivante();

        CellulesVivantes suivantes = suivante.cellules();
        assertThat(contient(suivantes, new Position(1, 1))).isTrue();
        assertThat(contient(suivantes, new Position(1, 0))).isTrue();
        assertThat(contient(suivantes, new Position(1, -1))).isTrue();
        assertThat(contient(suivantes, new Position(0, 0))).isFalse();
        assertThat(contient(suivantes, new Position(2, 0))).isFalse();
    }

    private boolean contient(CellulesVivantes cellulesVivantes, Position position) {
        return cellulesVivantes.stream().anyMatch(position::equals);
    }
}
