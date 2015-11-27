import com.google.common.collect.Sets;

import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CellulesVivantes {
    public Stream<Position> stream() {
        return positions.stream();
    }

    public void ajoute(Position position) {
        positions.add(position);
    }

    public long nombreVoisines(Position position) {
        Set<Position> positionsVoisinesThéoriques = positionsVoisinesThéoriques(position);
        return Sets.intersection(positionsVoisinesThéoriques, this.positions).size();
    }

    public Set<Position> positionsVoisinesThéoriques(Position position) {
        Set<Position> positions = Sets.newHashSet();
        for (int i = position.x() - 1; i < position.x() + 2; i++) {
            for (int j = position.y() - 1; j < position.y() + 2; j++) {
                positions.add(new Position(i, j));
            }
        }
        positions.remove(position);
        return positions;
    }

    private Set<Position> positions = Sets.newHashSet();
}
