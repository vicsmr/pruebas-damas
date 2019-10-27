# 1.ADCS.pruebas

- Diseño Modelo/Vista/Controlador con Presentador del Modelo/Vista/Controlador

class LasDamas {
+ play()
}
LasDamas *-down-> Logic
LasDamas *-down-> View

class View {
+ interact(Contorller)
}

class StartView #orange {
+ interact(StartController)
}

class PlayView  #orange {
+ interact(PllayController)
}

class ResumeView  #orange {
+ interact(ResumeController)
}

StartView ..> StartController
PlayView ..> PlayController
ResumeView ..> ResumeController

View *-down-> StartView
View *-down-> PlayView
View *-down-> ResumeView
StartView *-down-> BoardView
PlayView *-down-> BoardView
BoardView ..> SquareView
SquareView ..> PieceView

View ..> AcceptController

class Logic{
+ getController()
}
Logic *--> State
Logic *--> Game
Logic *-down-> AcceptController

class Controller{
}

class AcceptController{
}

Controller <|-down- AcceptController
AcceptController <|-down- StartController
AcceptController <|-down- PlayController
Controller <|-down- MoveController
Controller <|-down- CancelController
AcceptController <|-down- ResumeController
Controller o--> Game

class StartController{
}

class MoveController{
}

class CancelController{
}

class ResumeController{
}

class PlayController{
+ move(Coordinate origin, Coordinate target);
}
PlayController ..> Coordinate

PlayView ..> Coordinate

class Coordinate{
}

PlayController *-down-> CancelController
PlayController *-down-> MoveController


class Game{
}
Game *-down-> Board
Game *-down-> Turno
Game ..> Error

class Board{
}
Board *-down-> "8x8" Square
Board *-down-> "1..2x12" Piece
Board ..> Error

class Square{
}
Square  --> "0..1" Piece
Square *--> Color

class Piece{
}
Piece <|-down- Peon
Piece <|-down- Dama
Piece *--> Color 

class Peon{
}

class Dama{
}

class Color{
}

class Turno{
}
Turno *--> Color

class State{
}

class Error{
}