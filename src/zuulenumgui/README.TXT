//STEGGER'S NOTES
Hi all

This is a complete and refactored version of World Of Zuul. 
It has partially been created by the authors of the chapter you have been working 
with, but I have added a user interface to the applikation so that it now can be
played in an awesome graphical environment. 

You can use this as an example on how you can implement your own JavaFX version.
You can add another package to the "gui" package and name it javafx, and there in 
you can add your controllers and views and then simply use the application in the 
"bll" package to run the game. Specifically a Game object is what your controller
should work with. Look at the ZuulGUI class for inspisration. It's a Swing class, 
and compared to JavaFX you can say that it's a fusion between a controller and a 
view.

I admit that some improvements must be made. For instance I have chosen to ignore
the help command, as I'm always displaying the possible commands. But you might
wan't to display some help, and you should figure out how to do that.

Have funz
Stegger

//AUTHORS NOTES BELOW:
Project: zuul-with-enums-v2
Authors: Michael Kölling and David J. Barnes

This project is part of the material for the book

   Objects First with Java - A Practical Introduction using BlueJ
   Fifth edition
   David J. Barnes and Michael Kölling
   Pearson Education, 2012
   
This project is a simple framework for an adventure game. In this version,
it has a few rooms and the ability for a player to walk between these rooms.
That's all.

To start this application, create an instance of class "Game" and call its
"play" method.

This project was written to illustrate the use of enums to support
language independence of the game logic.

Read chapter 7 of the book to get a detailed description of the project.
