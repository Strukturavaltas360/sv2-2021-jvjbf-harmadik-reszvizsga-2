package movietheatres;

import java.nio.file.Path;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class MovieTheatreService {
    private Map<String, List<Movie>> shows;

    public void readFromFile(Path path) {

    }

    public Map<String, List<Movie>> getShows() {
        return shows;
    }

    public List<String> findMovie(String title) {
        return null;
    }

    public LocalTime findLatestShow(String title) {
        throw new IllegalArgumentException("");
    }
}
