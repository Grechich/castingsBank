package com.gmail.grechich.db.model;

import com.gmail.grechich.db.casting.Casting;
import com.gmail.grechich.db.enums.ModelMaterial;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class ModelCasting {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
    @Column(name = "modelId", nullable = false)
    private Long modelId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="casting_id", referencedColumnName = "id")
    private Casting casting;

    private Enum <ModelMaterial> modelMaterialEnum;
    private String modelYear;
    private String modelDrawing3D;

    public ModelCasting(String drawing, int count) {
        this.modelMaterialEnum = ModelMaterial.OTHER;
        this.modelYear = "0";
        this.modelDrawing3D = "../../docs/drawings/" + drawing + "/model3d_" + drawing + "_" + count + ".zip";
    }

}
