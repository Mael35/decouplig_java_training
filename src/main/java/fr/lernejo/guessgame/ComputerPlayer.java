package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player {

    Logger logger = LoggerFactory.getLogger("computer");

    private long high = Long.MAX_VALUE;
    private long low = 0;
    private long current;

    @Override
    public long askNextGuess() {
        return this.current = (this.high + this.low)/2;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater)
        {
            this.low = this.current;
        }

        else
        {
            this.high = this.current;
        }

        logger.log(this.current + "\n");
    }

}

