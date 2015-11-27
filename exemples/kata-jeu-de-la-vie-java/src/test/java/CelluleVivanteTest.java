import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CelluleVivanteTest {

    @Before
    public void before() throws Exception {
        vivante = new CelluleVivante();
    }

    @Test
    public void uneCelluleVivanteAvec2VoisinesVivantesResteVivante() {
        assertThat(vivante.resteEnVie(2)).isTrue();
    }

    @Test
    public void uneCelluleVivanteAvec3VoisinesVivantesResteVivante() {
        assertThat(vivante.resteEnVie(3)).isTrue();
    }

    @Test
    public void uneCelluleVivanteAvecMoinsDe2VoisinesVivantesMeurt() {
        assertThat(vivante.resteEnVie(1)).isFalse();
    }

    @Test
    public void uneCelluleVivanteAvecPlusDe3VoisinesVivantesMeurt() {
        assertThat(vivante.resteEnVie(4)).isFalse();
    }

    private CelluleVivante vivante;
}
