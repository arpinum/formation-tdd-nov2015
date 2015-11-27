import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class CellulesVivantesTest {

    @Before
    public void before() throws Exception {
        vivantes = new CellulesVivantes();
    }

    @Test
    public void lesVoisinesThéoriquesSontSituéesAuxPositionsAutourDeLaCelluleDeRéférence() {
        Set<Position> positions = vivantes.positionsVoisinesThéoriques(new Position(5, 5));

        assertThat(positions).hasSize(8);
        assertThat(positions).contains(new Position(4, 4));
        assertThat(positions).contains(new Position(5, 4));
        assertThat(positions).contains(new Position(6, 4));
        assertThat(positions).contains(new Position(4, 5));
        assertThat(positions).contains(new Position(6, 5));
        assertThat(positions).contains(new Position(4, 6));
        assertThat(positions).contains(new Position(5, 6));
        assertThat(positions).contains(new Position(6, 6));
    }

    @Test
    public void peutFournirLeNombreDeVoisinesVivantes() {
        vivantes.ajoute(new Position(-1, 0));
        vivantes.ajoute(new Position(0, 0));
        vivantes.ajoute(new Position(1, 0));

        assertThat(vivantes.nombreVoisines(new Position(-1, 0))).isEqualTo(1);
        assertThat(vivantes.nombreVoisines(new Position(0, 0))).isEqualTo(2);
        assertThat(vivantes.nombreVoisines(new Position(0, 1))).isEqualTo(3);
    }

    private CellulesVivantes vivantes;
}
