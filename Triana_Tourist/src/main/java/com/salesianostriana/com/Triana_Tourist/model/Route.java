package com.salesianostriana.com.Triana_Tourist.model;


import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Route implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Builder.Default
    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "poi_id",
            foreignKey = @ForeignKey(name = "FK_ROUTE_POI")),
            inverseJoinColumns = @JoinColumn(name = "route_id",
                    foreignKey = @ForeignKey(name = "FK_POI_ROUTE")),
            name = "ruta")
    @UniqueElements
    private List<POI> puntosInteres = new ArrayList<>();

    public Route(String name) {
        this.name = name;
    }

    //// HELPERS ////

    public void addPOI (POI poi){
        this.puntosInteres.add(poi);
    }

    public void removePOI (POI poi){
        this.puntosInteres.remove(poi);
    }

}
