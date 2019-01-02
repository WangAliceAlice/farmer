package com.feidian.farmer.dao.mapper;

import com.feidian.farmer.dao.entity.Fertilizer;
import com.feidian.farmer.dao.entity.FertilizerIngredient;
import com.feidian.farmer.dao.entity.Ingredient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FertilizerMapper {

    List<FertilizerIngredient> selectAllFI();

    List<Fertilizer> selectAllFertilizers();

    List<Ingredient> selectAllIngredients();

    List<Ingredient> selectIngredientsByFertilizer(long fId);

    int deleteOne(@Param("fId") long fId);

    int insertFertilizer(@Param("fertilizer")Fertilizer fertilizer);

    int insertFIs(@Param("fertilizerIngredients")List<FertilizerIngredient> fertilizerIngredients);

}
