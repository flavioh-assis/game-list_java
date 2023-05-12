package com.flavio.dslist.controllers;

import com.flavio.dslist.dto.GameListDTO;
import com.flavio.dslist.dto.GameMinDTO;
import com.flavio.dslist.dto.ReplacementDTO;
import com.flavio.dslist.services.GameListService;
import com.flavio.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    @GetMapping("/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }

    @PostMapping("/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO dto) {
        gameListService.move(listId, dto.getSourceIndex(), dto.getDestinationIndex());
    }
}
