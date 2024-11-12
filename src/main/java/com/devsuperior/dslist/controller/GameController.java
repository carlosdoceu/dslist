package com.devsuperior.dslist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.DTO.GameDTO;
import com.devsuperior.dslist.DTO.GameMinDTO;
import com.devsuperior.dslist.service.GameService;




@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;
    
   
    
    @GetMapping
    public List<GameMinDTO> getAllGames() throws Exception{
        try {
            List<GameMinDTO> listaGame = gameService.getAllGames();
            return listaGame;    
        } catch (Exception e) {
            throw new Exception(e);
        }
        
    }

    @GetMapping("/{id}")
    public GameDTO getByIdGame(@PathVariable Long id) {
        GameDTO game = gameService.findbyIdGame(id);
        return game;
    }
    

}
