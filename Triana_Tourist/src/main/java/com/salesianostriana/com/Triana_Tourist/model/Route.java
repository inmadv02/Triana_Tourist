package com.salesianostriana.com.Triana_Tourist.model;


import lombok.*;

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

    @Builder.Default
    @OneToMany(mappedBy = "routes")
    private List<POI> puntosInteres = new ArrayList<POI>();
}
