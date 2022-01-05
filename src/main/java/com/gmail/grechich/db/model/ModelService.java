package com.gmail.grechich.db.model;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModelService {

    private final ModelRepository modelRepository;

    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Transactional
    public boolean addModel(ModelCasting modelCasting) {
        modelRepository.save(modelCasting);
        return true;
    }


}
