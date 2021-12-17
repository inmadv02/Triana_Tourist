package com.salesianostriana.com.Triana_Tourist.model;

import lombok.*;

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

    private String location;

    private String description;
    private LocalDate date;

    @ManyToOne
    private Category category;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "poi_id"),
            inverseJoinColumns = @JoinColumn(name = "route_id")
    )
    private List<Route> routes = new ArrayList<>();

    private String coverPhoto;

    private String photo2, photo3;


    ////// HELPERS //////


    public void addToRoute(Route r){
        this.routes.add(r);
        r.getPuntosInteres().add(this);

    }

    public void removeFromRoute(Route r){
        this.routes.remove(r);
        r.getPuntosInteres().remove(this);
    }



}
