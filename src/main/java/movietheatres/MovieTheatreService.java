package movietheatres;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.*;

public class MovieTheatreService {
    private Map<String, Set<Movie>> shows = new LinkedHashMap<>();

    public void readFromFile(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                processLine(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!");
        }
    }

    private void processLine(String line) {
        String[] parts = line.split("-");
        String name = parts[0];
        String[] movieParts = parts[1].split(";");
        Movie movie = new Movie(movieParts[0], LocalTime.parse(movieParts[1]));
        addToShows(name, movie);
    }

    private void addToShows(String name, Movie movie) {
        Set<Movie> movies = shows.computeIfAbsent(name, s -> new TreeSet<>());
        movies.add(movie);
    }

    public Map<String, Set<Movie>> getShows() {
        return shows;
    }

    public List<String> findMovie(String title) {
        validateTitle(title);
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Set<Movie>> entry: shows.entrySet()) {
            if (entry.getValue().stream()
                    .map(Movie::getTitle)
                    .anyMatch(title::equals)) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public LocalTime findLatestShow(String title) {
        validateTitle(title);
        return shows.entrySet().stream()
                .flatMap(stringSetEntry -> stringSetEntry.getValue().stream())
                .filter(movie -> title.equals(movie.getTitle()))
                .max(Comparator.comparing(Movie::getStartTime))
                .orElseThrow(() -> new IllegalArgumentException("Can not find such title!"))
                .getStartTime();
    }

    private void validateTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title must not be null or blank!");
        }
    }
}
