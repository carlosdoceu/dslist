package com.devsuperior.dslist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.DTO.GameDTO;
import com.devsuperior.dslist.DTO.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {

  @Autowired
  private GameRepository gameRepository;



  @Transactional(readOnly = true)
  public GameDTO findbyIdGame(Long id) {
    Game game = gameRepository.findById(id).get();
    GameDTO dto = new GameDTO(game);
    return dto;
  }

  public List<GameMinDTO> getAllGames() {
    List<Game> listaGames = gameRepository.findAll();
    List<GameMinDTO> dto = listaGames.stream().map(x -> new GameMinDTO(x)).toList();
    return dto;
  }

  @Transactional(readOnly = true)
  public List<GameMinDTO> findByList(Long listId) {
    List<GameMinProjection> result = gameRepository.searchByList(listId);
    return result.stream().map(x->new GameMinDTO(x)).toList();

  }

}
