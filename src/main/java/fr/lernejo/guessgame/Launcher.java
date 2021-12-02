package fr.lernejo.guessgame;
import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args)
    {
        if (args.length == 1 && args[0].equals("-interactive"))
        {
            Simulation simulation = new Simulation(new HumanPlayer());

            SecureRandom random = new SecureRandom();
            long randomNumber = random.nextInt(100);

            simulation.initialize(randomNumber);

            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
        }

        else if (args.length == 2 && args[0].equals("-auto"))
        {
            int nbIteration = Integer.parseInt(args[1]);

            Simulation simulation = new Simulation(new ComputerPlayer());

            SecureRandom random = new SecureRandom();
            long randomNumber = random.nextInt(100);

            simulation.initialize(randomNumber);

            simulation.loopUntilPlayerSucceed(nbIteration);
        }

        else
        {
            System.out.print("Argument error !\n");
            System.out.print("Use <-interactive> to play as player\n");
            System.out.print("Use <-auto> to play as robot\n");
        }
    }
}
