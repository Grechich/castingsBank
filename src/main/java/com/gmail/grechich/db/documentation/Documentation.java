package com.gmail.grechich.db.documentation;

import com.gmail.grechich.db.casting.Casting;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Documentation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String detailDrawing;

    @OneToOne(mappedBy = "documentation", cascade = CascadeType.ALL)
    private Casting casting;

//    private String detailDrawing3D;
//    private String castingDrawing;
//    private String castingDrawing3D;
//    private String installationDrawing;
//    private String passportBlank;


    public Documentation(String detailDrawing) {
        this.detailDrawing = detailDrawing;
    }



}
