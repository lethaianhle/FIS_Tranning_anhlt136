package fis.java.bigexample.dao.imp;

import fis.java.bigexample.dao.IDetectiveDAO;
import fis.java.bigexample.model.Detective;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class DetectiveDAO implements IDetectiveDAO {
    private List<Detective> detectiveList = new ArrayList<>();
    private static DetectiveDAO detectiveDAO = null;

    private DetectiveDAO() {

    }

    public static DetectiveDAO getInstance() {
        return detectiveDAO == null ? new DetectiveDAO() : detectiveDAO;
    }

    @Override
    public void add(Detective detective) {
        this.detectiveList.add(detective);
    }

    @Override
    public Detective get(long id) {
        Optional<Detective> optionalDetective = this.detectiveList.stream()
                .filter(detective -> detective.getId() == id)
                .findFirst();

        return optionalDetective.orElse(null);
    }

    @Override
    public List<Detective> getAll() {
        return this.detectiveList;
    }

    @Override
    public Detective update(Detective detective) {
        if (detective.getId() == null) {
            return null;
        }

        int index = IntStream.range(0, this.detectiveList.size())
                .filter(i -> this.detectiveList.get(i).getId() == detective.getId())
                .findFirst()
                .orElse(-1);

        this.detectiveList.set(index, detective);

        return this.detectiveList.get(index);
    }

    @Override
    public Detective remove(long id) {
        Optional<Detective> decOptional = this.detectiveList.stream()
                .filter(d -> d.getId() == id)
                .findFirst();

        if (decOptional.isPresent()) {
            this.detectiveList.remove(decOptional.get());
        }

        return decOptional.orElse(null);
    }
}
