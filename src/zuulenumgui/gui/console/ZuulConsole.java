/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zuulenumgui.gui.console;

import zuulenumgui.bll.Command;
import zuulenumgui.bll.CommandWord;
import zuulenumgui.bll.Game;

/**
 *
 * @author Stegger
 */
public class ZuulConsole
{

    private Game game;
    private Parser parser;

    public ZuulConsole()
    {
        parser = new Parser();
    }

    public void playNewGame()
    {
        game = new Game();
        printWelcome();
        play();
    }

    /**
     * Main play routine. Loops until end of play.
     */
    private void play()
    {
        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
        boolean finished = false;
        while (!finished)
        {
            System.out.println(game.getLongDescription());
            Command command = parser.getCommand();
            if (command.getCommandWord() == CommandWord.HELP)
            {
                printHelp();
            }
            else
            {
                try
                {
                    finished = game.processCommand(command);
                } catch (IllegalArgumentException iae)
                {
                    System.out.println(iae.getMessage());
                }
            }
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    // implementations of user commands:
    /**
     * Print out some help information. Here we print some stupid, cryptic
     * message and a list of the command words.
     */
    private void printHelp()
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        //System.out.println(game.getLongDescription());
    }

}
