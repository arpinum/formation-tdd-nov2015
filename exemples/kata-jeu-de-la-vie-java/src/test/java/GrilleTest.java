import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GrilleTest {

    @Test
    public void une_grille_vide_ne_contient_que_des_cellules_mortes() {
        CellulesVivantes cellules = new CellulesVivantes();
        Grille grille = new Grille(cellules);

        Grille suivante = grille.suivante();

        CellulesVivantes suivantes = suivante.cellules();
        assertThat(contient(suivantes, new Position(0, 0))).isFalse();
        assertThat(contient(suivantes, new Position(-12, 23))).isFalse();
    }

    @Test
    public void une_grille_peut_rester_en_vie() {
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
    public void une_grille_peut_mourir() {
        CellulesVivantes cellules = new CellulesVivantes();
        cellules.ajoute(new Position(0, 0));
        Grille grille = new Grille(cellules);

        Grille suivante = grille.suivante();

        CellulesVivantes suivantes = suivante.cellules();
        assertThat(contient(suivantes, new Position(0, 0))).isFalse();
    }

    @Test
    public void une_grille_peut_evoluer() {
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
