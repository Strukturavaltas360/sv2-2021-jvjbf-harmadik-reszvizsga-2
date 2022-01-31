package streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SongService {
    private List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        validateSong(song);
        songs.add(song);
    }

    public Optional<Song> shortestSong() {
        return songs.stream()
                .min(Comparator.comparingInt(Song::getLength));
    }

    public List<Song> findSongByTitle(String title) {
        validateSongs();
        validateString(title, "Title");
        return songs.stream()
                .filter(song -> title.equals(song.getTitle()))
                .toList();
    }

    public boolean isPerformerInSong(Song song, String performer) {
        validateSong(song);
        validateString(performer, "Performer");
        return song.getPerformers().stream()
                .anyMatch(performer::equals);
    }

    public List<String> titlesBeforeDate(LocalDate date) {
        validateDate(date);
        return songs.stream()
                .filter(song -> date.isAfter(song.getRelease()))
                .map(Song::getTitle)
                .toList();
    }

    private void validateSong(Song song) {
        if (song == null) {
            throw new IllegalArgumentException("Song must not be null!");
        }
    }

    private void validateSongs() {
        if (songs.isEmpty()) {
            throw new IllegalStateException("Song must be added before any operation!");
        }
    }

    private void validateString(String st, String title) {
        if (st == null || st.isBlank()) {
            throw new IllegalArgumentException(String.format("%s should be not null or blank!", title));
        }
    }

    private void validateDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date must not be null!");
        }
    }
}
