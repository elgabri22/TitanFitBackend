package com.titanfit.TitanFit.service;

import com.titanfit.TitanFit.model.Food;
import com.titanfit.TitanFit.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;

    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    public Food findById(String id) {
        Food alimento=null;
        Optional<Food> food = foodRepository.findById(id);
        if (food.isPresent()) {
            alimento = food.get();
        }
        return alimento;
    }

    public void save(Food food) {
        foodRepository.save(food);
    }

    public void delete(Food food) {
        foodRepository.delete(food);
    }
}
