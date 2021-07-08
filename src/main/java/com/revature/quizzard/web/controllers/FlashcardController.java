package com.revature.quizzard.web.controllers;

import com.revature.quizzard.entities.Category;
import com.revature.quizzard.entities.Flashcard;
import com.revature.quizzard.services.FlashcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flashcards")
public class FlashcardController {

    private FlashcardService cardService;

    @Autowired
    public FlashcardController(FlashcardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Flashcard> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping(value = "/creator/{creatorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Flashcard> getCardsByCreatorId(@PathVariable int creatorId) {
        return cardService.getCardsByCreatorId(creatorId);
    }

    @GetMapping(value = "/category/{category}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Flashcard> getCardsByCategory(@PathVariable String category) {
        return cardService.getCardsByCategory(Category.valueOf(category));
    }

    @GetMapping(value = "/id/{cardId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flashcard getCardById(@PathVariable int cardId) {
        return cardService.getCardById(cardId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createNewCard(@RequestBody Flashcard newCard) {
        cardService.saveNewCard(newCard);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateExistingCard(@RequestBody Flashcard updatedCard) {
        cardService.updateCard(updatedCard);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteCardById(@PathVariable int cardId) {
        cardService.deleteCardById(cardId);
    }

}
