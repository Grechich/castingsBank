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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "modelId", nullable = false)
    private Long modelId;

    private Enum <ModelMaterial> modelMaterialEnum;
    private String modelYear;
    private String modelDrawing3D;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="casting_id", referencedColumnName = "id")
    private Casting casting;

    public ModelCasting(Enum<ModelMaterial> modelMaterialEnum, String modelYear, String modelDrawing3D) {
        this.modelMaterialEnum = modelMaterialEnum;
        this.modelYear = modelYear;
        this.modelDrawing3D = modelDrawing3D;
    }
}
