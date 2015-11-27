import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

public class FacteursPremiersTest {

    @Test
    public void pasDeFacteurPremierPour1() {
        List<Integer> facteurs = new FacteursPremiers().pour(1);

        assertThat(facteurs).isEmpty();
    }

    @Test
    public void unNombrePremierEstSonSeulFacteurPremier() {
        assertThat(new FacteursPremiers().pour(2)).containsOnly(2);
        assertThat(new FacteursPremiers().pour(3)).containsOnly(3);
    }

    @Test
    public void ilEstPossibleDObtenirLesFacteursPremiersDUnNombreNonPremier() {
        assertThat(new FacteursPremiers().pour(4)).containsOnly(2, 2);
        assertThat(new FacteursPremiers().pour(9)).containsOnly(3, 3);
        assertThat(new FacteursPremiers().pour(100)).containsOnly(2, 2, 5, 5);
        assertThat(new FacteursPremiers().pour(1010021)).containsOnly(17, 19, 53, 59);
    }
}
