package edu.upc.eetac.dsa.dao;

import edu.upc.eetac.dsa.models.Game;

import java.beans.IntrospectionException;
import java.util.List;

public interface GameDAO {
    public Game saveGame(Game game);
    public Game updateGame(Game game, String username) throws IntrospectionException;
    public List<Game> getUserGames(String username);
    public Game getActiveUserGame(String username);
}
