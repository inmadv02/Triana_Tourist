package com.salesianostriana.com.Triana_Tourist.model;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Builder
public class POI implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String location;

    private String description;
    private LocalDate date;

    @ManyToOne
    @Nullable
    private Category category;

    private String coverPhoto;

    private String photo2, photo3;

    public POI(String name, String location, String description, LocalDate date, String coverPhoto, String photo2, String photo3) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.date = date;
        this.coverPhoto = coverPhoto;
        this.photo2 = photo2;
        this.photo3 = photo3;
    }


    public POI(String name, String location, String description, LocalDate date, String coverPhoto, String photo2, String photo3, String category) {
    }
}
