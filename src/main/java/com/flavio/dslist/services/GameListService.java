package com.flavio.dslist.services;

import com.flavio.dslist.dto.GameListDTO;
import com.flavio.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        var result = gameListRepository.findAll();

        return result.stream().map(x -> new GameListDTO(x)).toList();
    }
}
