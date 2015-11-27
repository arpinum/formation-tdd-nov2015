import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PartieTest {

    @Before
    public void before() throws Exception {
        partie = new Partie();
    }

    @Test
    public void leScoreDUnePartieGoutiereEstZéro() {
        nouveauxLancers(20, 0);

        assertThat(partie.score()).isEqualTo(0);
    }

    @Test
    public void leScoreDUnePartieModesteEstAussiModeste() {
        partie.nouveauLancer(1);
        nouveauxLancers(19, 0);

        assertThat(partie.score()).isEqualTo(1);
    }

    @Test
    public void leScorePrendEnCompteUnSpare() {
        nouveauSpare();
        partie.nouveauLancer(1);
        nouveauxLancers(17, 0);

        assertThat(partie.score()).isEqualTo(12);
    }

    @Test
    public void leScorePrendEnCompteUnStrike() {
        partie.nouveauLancer(10);
        partie.nouveauLancer(1);
        partie.nouveauLancer(2);
        nouveauxLancers(16, 0);

        assertThat(partie.score()).isEqualTo(16);
    }

    @Test
    public void leScoreMaximalEst300() {
        nouveauxLancers(12, 10);

        assertThat(partie.score()).isEqualTo(300);
    }

    private void nouveauSpare() {
        partie.nouveauLancer(3);
        partie.nouveauLancer(7);
    }

    private void nouveauxLancers(int nombre, int quilles) {
        for (int i = 0; i < nombre; i++) {
            partie.nouveauLancer(quilles);
        }
    }

    private Partie partie;
}
