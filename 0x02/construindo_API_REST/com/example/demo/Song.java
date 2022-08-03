package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class Song {
    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private String artista;
    private String album;
    private String anoLancamento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song song = (Song) o;
        return Objects.equals(id, song.id) && Objects.equals(nome, song.nome) && Objects.equals(artista, song.artista) && Objects.equals(album, song.album) && Objects.equals(anoLancamento, song.anoLancamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, artista, album, anoLancamento);
    }

    @Override
    public String toString() {
        return "Song{" +
                "Id=" + id +
                ", Nome='" + nome + '\'' +
                ", Artista='" + artista + '\'' +
                ", Album='" + album + '\'' +
                ", Ano Lancamento='" + anoLancamento + '\'' +
                '}';
    }
}
