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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(mappedBy = "documentation", cascade = CascadeType.ALL)
    private Casting casting;

    private String detailDrawing;
    private String detailDrawing3D;
    private String castingDrawing;
    private String castingDrawing3D;
    private String installationDrawing;
    private String passportBlank;

    public Documentation(String drawing) {
        this.detailDrawing = "../../docs/drawings/" + drawing + "/detail_drawing_" + drawing + ".jpg";
        this.detailDrawing3D = "../../docs/drawings/" + drawing + "/detail_drawing_" + drawing + "3d.zip";
        this.castingDrawing = "../../docs/drawings/" + drawing + "/casting_drawing_" + drawing + ".jpg";
        this.castingDrawing3D = "../../docs/drawings/" + drawing + "/casting_drawing_" + drawing + "3d.zip";
        this.installationDrawing = "../../docs/drawings/" + drawing + "/installation_drawing_" + drawing + ".jpg";
        this.passportBlank = "../../docs/drawings/" + drawing + "/passport_" + drawing + ".jpg";
    }
}
