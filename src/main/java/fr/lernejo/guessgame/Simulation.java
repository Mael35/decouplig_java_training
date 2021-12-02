package fr.lernejo.guessgame;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long number = player.askNextGuess();

        if (number == numberToGuess)
        {
            logger.log("Good answer !\n");

            return true;
        }

        else player.respond(number < numberToGuess);

        return false;
    }

    public void loopUntilPlayerSucceed() {
        while(!nextRound())
        {
            logger.log("Try again !\n");
        }

        logger.log("You founds it !\n");
    }
}
