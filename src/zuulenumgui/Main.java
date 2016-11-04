/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zuulenumgui;

import zuulenumgui.bll.CommandWord;
import zuulenumgui.bll.Game;
import zuulenumgui.gui.console.ZuulConsole;
import zuulenumgui.gui.swing.ZuulGUI;

/**
 *
 * @author Stegger
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
       
        
        
//        Main.console();
        Main.graphical();
    }

    private static void console()
    {
        ZuulConsole zuulConsole = new ZuulConsole();
        zuulConsole.playNewGame();
    }

    private static void graphical()
    {
        /* Set the Nimbus look and feel */
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ZuulGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ZuulGUI().setVisible(true);
            }
        });
    }

}
