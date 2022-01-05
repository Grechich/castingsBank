package com.gmail.grechich.db.casting;

import com.gmail.grechich.db.enums.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CastingRepository extends JpaRepository<Casting, Long> {
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false " +
            "END FROM Casting u WHERE u.drawingNumber = :drawingNumber")
    boolean existsByDrawingNumber(@Param("drawingNumber") String drawingNumber);

    List<Casting> findByCastingShopEnum(Enum<Shop> castingShopEnum);

    List<Casting> findByNameContaining(String name);

    List<Casting> findByDrawingNumberContaining(String drawingNumber);


//    @Query("SELECT u FROM Casting u WHERE u.name LIKE :search OR u.drawingNumber LIKE :search")
//    List<Casting> getCastingsBySearch(@Param("search") String search);


}
