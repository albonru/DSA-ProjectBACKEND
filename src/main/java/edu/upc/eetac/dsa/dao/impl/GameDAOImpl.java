package edu.upc.eetac.dsa.dao.impl;

import edu.upc.eetac.dsa.dao.GameDAO;
import edu.upc.eetac.dsa.models.Game;
import edu.upc.eetac.dsa.models.User;

import java.beans.IntrospectionException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class GameDAOImpl implements GameDAO {
    static final Logger logger = Logger.getLogger(GameDAOImpl.class.getName());
    private static GameDAOImpl manager;
    private static UserDAOImpl userManager = UserDAOImpl.getInstance();
    private SessionImpl session;

    GameDAOImpl() {
        this.session = SessionImpl.getInstance();
    }

    public static GameDAOImpl getInstance() {

        if(manager == null) {

            manager = new GameDAOImpl();
        }
        return manager;
    }

    @Override
    public Game saveGame(Game game) {
        logger.info("Game to save: " + game.toString());
        this.session.save(game);
        return game;
    }

    @Override
    public Game updateGame(Game game, String username) throws IntrospectionException {
        logger.info("Game to update: " + game.toString());

        this.userManager.updateCoins(username, game.getCoins());
        this.userManager.updatePoints(username, game.getPoints());

        this.session.update(game);
        return game;
    }

    @Override
    public List<Game> getUserGames(String username) {
        List<Game> gameList = this.session.getAll(Game.class);
        List<Game> userGames = new LinkedList<>();
        User user = (User) this.session.getByName(User.class, username);

        for (Game g : gameList) {
            if (g.getUserId().equals(user.getId())) {
                userGames.add(g);
            }
        }

        return userGames;
    }

    @Override
    public Game getActiveUserGame(String username) {
        List<Game> userGames = this.getUserGames(username);
        User user = (User) this.session.getByName(User.class, username);

        for (Game g : userGames) {
            if (!g.isFinished()) {
                return g;
            }
        }

        // if no active game -> initiate one
        Game game = new Game(user.getId());
        this.saveGame(game);
        return game;
    }
}
