package com.syntj.skyrim

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.syntj.skyrim.SkyrimAlchemyConstants.JSON_PATH
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

class IngredientsJsonImporter {

    companion object {
        val objectMapper = ObjectMapper().registerModule(KotlinModule())
        val logger : Logger = LoggerFactory.getLogger(IngredientsJsonImporter::class.java)
    }

    fun readIngredientsJson(path: String = JSON_PATH): List<Ingredient> {

        return objectMapper.readValue(File(path), IngredientList::class.java).ingredients
    }
}
