import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PartieTest {

    @Before
    public void before() {
        partie = new Partie();
    }

    @Test
    public void laPartieCommenceAZéroZéro() {
        String score = partie.score();

        assertThat(score).isEqualTo("0 - 0");
    }

    @Test
    public void leJoueur1PeutMarquerUnPoint() {
        leJoueur1Marque(1);

        String score = partie.score();

        assertThat(score).isEqualTo("15 - 0");
    }

    @Test
    public void leJoueur1PeutMarquerDeuxPoints() {
        leJoueur1Marque(2);

        String score = partie.score();

        assertThat(score).isEqualTo("30 - 0");
    }

    @Test
    public void leJoueur1PeutMarquer3Points() {
        leJoueur1Marque(3);

        String score = partie.score();

        assertThat(score).isEqualTo("40 - 0");
    }

    @Test
    public void leJoueur1PeutGagnerLaPartie() {
        leJoueur1Marque(4);

        String score = partie.score();

        assertThat(score).isEqualTo("Joueur 1 vainqueur");
    }

    @Test
    public void leJoueur2PeutMarquerUnPoint() {
        leJoueur2Marque(1);

        String score = partie.score();

        assertThat(score).isEqualTo("0 - 15");
    }

    @Test
    public void leJoueur2PeutGagnerLaPartie() {
        leJoueur2Marque(4);

        String score = partie.score();

        assertThat(score).isEqualTo("Joueur 2 vainqueur");
    }

    @Test
    public void leJoueur1PeutAvoirLAvantage() {
        leJoueur2Marque(3);
        leJoueur1Marque(4);

        String score = partie.score();

        assertThat(score).isEqualTo("Avantage Joueur 1");
    }

    @Test
    public void leJoueur1PeutGagnerAprèsAvoirEuLAvantage() {
        leJoueur2Marque(3);
        leJoueur1Marque(5);

        String score = partie.score();

        assertThat(score).isEqualTo("Joueur 1 vainqueur");
    }

    @Test
    public void leJoueur2PeutAvoirLAvantage() {
        leJoueur1Marque(3);
        leJoueur2Marque(4);

        String score = partie.score();

        assertThat(score).isEqualTo("Avantage Joueur 2");
    }

    @Test
    public void leJoueur2PeutGagnerAprèsAvoirEuLAvantage() {
        leJoueur1Marque(3);
        leJoueur2Marque(5);

        String score = partie.score();

        assertThat(score).isEqualTo("Joueur 2 vainqueur");
    }

    @Test
    public void ilPeutYAvoirUneEgalité() {
        leJoueur1Marque(3);
        leJoueur2Marque(3);

        String score = partie.score();

        assertThat(score).isEqualTo("Egalité");
    }

    @Test
    public void siLesJoueursSontA30PartoutLeScoreNEstPasEgalité() {
        leJoueur1Marque(2);
        leJoueur2Marque(2);

        String score = partie.score();

        assertThat(score).isEqualTo("30 - 30");
    }

    private void leJoueur1Marque(int nombreDeFois) {
        for (int i = 0; i < nombreDeFois; i++) {
            partie.leJoueur1Marque();
        }
    }

    private void leJoueur2Marque(int nombreDeFois) {
        for (int i = 0; i < nombreDeFois; i++) {
            partie.leJoueur2Marque();
        }
    }

    private Partie partie;
}
