package com.example.demo;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository {
    private List<Song> list = new ArrayList<Song>();

    public List<Song> getAllSongs() {
        return list;
    }

    public Song getSongById(Integer id) {
       Song song = list.stream()
               .filter(t -> id.equals(t.getId()))
               .findFirst()
               .orElse(null);
       return song;
    }

    public void addSong(Song s) {
        list.add(s);
    }

    public void updateSong(Song s) {
        Song song = list.stream()
                .filter(t -> s.getId().equals(t.getId()))
                .findFirst()
                .orElse(null);
        if(song != null){
            song.setAlbum(s.getAlbum());
        }
        if(song!= null){
            song.setAnoLancamento(s.getAnoLancamento());
        }
        if(song != null){
            song.setArtista(s.getArtista());
        }
        if(song != null){
            song.setNome(s.getNome());
        }
    }

    public void removeSong(Song s) {
       list.remove(s);
    }
}