package com.launchcode.artgallery.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Artwork extends AbstractEntity {

    @NotBlank(message = "Title is required.")
    private String title;

    @ManyToOne
    @NotNull(message = "Artist is required.")
    private Artist artist;

    private Style style;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    private ArtworkDetails details;

    public Artwork() {}

    public Artwork(String title, Artist artist, Style style, ArtworkDetails details) {
        this.title = title;
        this.artist = artist;
        this.style = style;
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public ArtworkDetails getDetails() {
        return details;
    }

    public void setDetails(ArtworkDetails details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return title + " (" + artist + ", " + details.getYearCreated() + ")";
    }

}
