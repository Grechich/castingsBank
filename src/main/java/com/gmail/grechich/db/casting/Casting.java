package com.gmail.grechich.db.casting;

import com.gmail.grechich.db.documentation.Documentation;
import com.gmail.grechich.db.enums.SteelGrade;
import com.gmail.grechich.db.model.ModelCasting;
import com.gmail.grechich.db.enums.CastingType;
import com.gmail.grechich.db.enums.Rail;
import com.gmail.grechich.db.enums.Shop;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "casting")
@Data
@NoArgsConstructor
public class Casting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String drawingNumber;

    private double castingWeight;
    private Enum<SteelGrade> steelGrade;
    private Enum<CastingType> castingTypeEnum;
    private Enum<Rail> castingRailEnum;
    private Enum<Shop> castingShopEnum;

    @OneToMany(mappedBy = "casting", cascade = CascadeType.ALL)
    private List<ModelCasting> modls = new ArrayList<>();

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn (name="documentation_id")
    private Documentation documentation;

    public Casting(String name, String drawingNumber, double castingWeight, Enum<SteelGrade> steelGrade,
                   Enum<CastingType> castingTypeEnum, Enum<Rail> castingRailEnum, Enum<Shop> castingShopEnum,
                   List<ModelCasting> modls, Documentation documentation) {
        this.name = name;
        this.drawingNumber = drawingNumber;
        this.castingWeight = castingWeight;
        this.steelGrade = steelGrade;
        this.castingTypeEnum = castingTypeEnum;
        this.castingRailEnum = castingRailEnum;
        this.castingShopEnum = castingShopEnum;
        this.modls = modls;
        this.documentation = documentation;
    }
}
