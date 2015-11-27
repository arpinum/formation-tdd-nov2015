import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PartieTest {

    @Before
    public void before() {
        partie = new Partie();
    }

    @Test
    public void siUnJoueurFaitTomberUneQuilleIlMarqueLaValeurDeLaQuille() {
        partie.metsAJourLePointageAvecLeLancer(3);

        assertThat(partie.pointage()).isEqualTo(3);
    }

    @Test
    public void siUnJoueurFaitTomberPlusieursQuillesIlMarqueLeNombreDeQuilles() {
        partie.metsAJourLePointageAvecLeLancer(1, 2);

        assertThat(partie.pointage()).isEqualTo(2);
    }

    @Test
    public void lePointageEstLeCumulDePlusieursLancers() {
        partie.metsAJourLePointageAvecLeLancer(1);
        partie.metsAJourLePointageAvecLeLancer(1);

        assertThat(partie.pointage()).isEqualTo(2);
    }

    @Test
    public void siUnJoueurAtteint50PointsIlAGagnéLaPartie() {
        partie.metsAJourLePointageAvecLeLancer(50);

        assertThat(partie.gagnée()).isTrue();
    }

    @Test
    public void siUnJoueurAMoinsDe50PointsIlNAPasGagné() {
        partie.metsAJourLePointageAvecLeLancer(1);

        assertThat(partie.gagnée()).isFalse();
    }

    @Test
    public void siUnJoueurDépasse50PointsIlRedescendA25() {
        partie.metsAJourLePointageAvecLeLancer(51);

        assertThat(partie.pointage()).isEqualTo(25);
    }

    private Partie partie;
}
