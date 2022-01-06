package com.gmail.grechich.db.casting;

import com.gmail.grechich.db.enums.Shop;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CastingService {

    private final CastingRepository castingRepository;

    public CastingService(CastingRepository castingRepository) {
        this.castingRepository = castingRepository;
    }

    @Transactional
    public boolean addCasting(Casting casting) {
        if (castingRepository.existsByDrawingNumber(casting.getDrawingNumber()))
            return false;

        castingRepository.save(casting);
        return true;
    }

    @Transactional(readOnly = true)
    public List<Casting> getAllCastings() {
        return castingRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Casting> getCastingsByShop(String shop) {
        return castingRepository.findByCastingShopEnum(Shop.valueOf(shop));
    }

    @Transactional
    public void deleteCasting(Long id) {
        castingRepository.deleteById(id);
    }

    @Transactional
    public List<Casting> searchCastings(String search) {
        List<Casting> castings = castingRepository.findByNameContaining(search);
        castings.addAll(castingRepository.findByDrawingNumberContaining(search));
        return castings;
    }

    public Casting getCastingsByDrawing(String drawing) {
        return castingRepository.findByDrawingNumber(drawing);
    }

//    @Transactional
//    public List<Casting> getCastingsBySearch(String search) {
//        return castingRepository.getCastingsBySearch(search);
//    }
}
