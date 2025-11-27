
package com.example.demo;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository {

    private List<Song> list = new ArrayList<>();

    public SongRepository() {
        list.add(new Song(1, "Bohemian Rhapsody", "Queen", "A Night at the Opera", "1975"));
        list.add(new Song(2, "Imagine", "John Lennon", "Imagine", "1971"));
    }

    public List<Song> getAllSongs() {
        return list;
    }

    public Song getSongById(Integer id) {
        return list.stream()
                .filter(song -> song.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addSong(Song s) {
        list.add(s);
    }

    public void updateSong(Song s) {
        Song existing = getSongById(s.getId());
        if (existing != null) {
            existing.setNome(s.getNome());
            existing.setArtista(s.getArtista());
            existing.setAlbum(s.getAlbum());
            existing.setAnoLancamento(s.getAnoLancamento());
        }
    }

    public void removeSong(Song s) {
        list.removeIf(song -> song.getId().equals(s.getId()));
    }
}
