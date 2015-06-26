# game-seed
all you need to create a small game with java<br/>

contains<br/>

there are 4 classes:<br/>

<strong>Start:</strong> it starts the game. i separated this one for one purpose - it can be used for smaller and biger games without many changes.
<br/>
<strong>StartInFullscreen:</strong> the same as Start only it starts your game in fullscreen.<br/>
you need to implement a way to exit your game.
<br/><br/>

<strong>GamePanel:</strong> contains 3 methods for your code:<br/>
init() initiates your game (sets all fields to its start value)<br/>
update() for your game logic. it will be called every 20 miliseconds - so no "main loop" needet<br/>
paint() for your grafics. <br/>
<br/>

<strong>Glob:</strong> "Graphic Loader Object" it contains only static methods and fields so no instance needet. 
all methods there are for loading graphic from files. Image, BufferedImage, Image[] for tiles, Image[direction][step/action] for hero and NPC.
<br/><br/>
how to use:<br/>

-copy all 3 classes into your project<br/>
-change packet if needed<br/>
-put your code in methods in GamePanel<br/>
-?<br/>
-have fun<br/>
