/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zuulenumgui.gui.javafx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import zuulenumgui.bll.Command;
import zuulenumgui.bll.CommandWord;
import zuulenumgui.bll.Game;

/**
 * FXML Controller class
 *
 * @author pgn
 */
public class ZuulController implements Initializable
{

    @FXML
    private ListView<CommandWord> lstCommands;
    @FXML
    private TextField txtSecondCommand;
    @FXML
    private Label lblRoomHeader;
    @FXML
    private TextArea txtAreaOutput;

    private Game game;

    public ZuulController()
    {
        game = new Game();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        txtAreaOutput.setText(game.getLongDescription());
        ObservableList<CommandWord> cmdWords = FXCollections.observableArrayList(CommandWord.values());
        lstCommands.setItems(cmdWords);
        lblRoomHeader.setText(game.getCurrentRoom().getShortDescription());
    }

    @FXML
    private void handleExecuteCommand(ActionEvent event)
    {
        CommandWord cmdWord = lstCommands.getSelectionModel().getSelectedItem();
        String secondWord = txtSecondCommand.getText().trim().toLowerCase();
        
        Command cmd = new Command(cmdWord, secondWord);

        try
        {
            if (cmdWord == CommandWord.HELP)
            {
                txtAreaOutput.setText("Choose a valid command from the list to the left.\n"
                        + "If you need to input a direction type it into the textfield below to the left."  
                        + game.getCurrentRoom().getExits());
            } else if (game.processCommand(cmd))
            {
                txtAreaOutput.setText("Press the red cross in the upper right corner to quit...");
            } else
            {
                txtAreaOutput.setText(game.getLongDescription());
                lblRoomHeader.setText(game.getCurrentRoom().getShortDescription());
            }
        } catch (Exception e)
        {
            txtAreaOutput.setText(e.getMessage());
            e.printStackTrace();
        }
    }

}
