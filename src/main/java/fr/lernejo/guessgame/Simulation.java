package fr.lernejo.guessgame;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import java.text.SimpleDateFormat;
import java.util.Date;

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
            logger.log("BRAVO\n");

            return true;
        }

        else player.respond(number < numberToGuess);

        return false;
    }

    public void loopUntilPlayerSucceed(long nbmax) {
        int count = 1;
        boolean failed = false;
        long beforeTime = System.currentTimeMillis();

        while(!nextRound())
        {
            count++;

            if (count == nbmax)
            {
                logger.log("No more try ...\n");
                failed = true;
                break;
            }

            if ((count + 1) != nbmax){
                logger.log("Try again !\n");
            }
        }

        if (!failed)
        {
            logger.log("You founds in " + count + " round(s) !\n");
        }

        else
        {
            logger.log("Perdu !\n");
            logger.log("The number was " + numberToGuess + " !\n");
        }

        long currentTime = System.currentTimeMillis();

        long timeUsed = currentTime - beforeTime;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss:SSS");
        Date date = new Date(timeUsed);
        String time = simpleDateFormat.format(date);
        logger.log(time);
    }
}
