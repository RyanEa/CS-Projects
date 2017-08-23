//#include "OthelloExceptions.h"
#include "OthelloBoard.h"
#include "OthelloView.h"
#include "OthelloMove.h"
#include "TicTacToeBoard.h"
#include "TicTacToeMove.h"
#include "TicTacToeView.h"
#include <iostream>
#include <string>
#include <sstream>
#include <vector>

using namespace std;
void Menu();

int maisn(int argc, char* argv[]) {
   // Initialization
   GameBoard *board; // the state of the game board
   GameView *v; // a View for outputting the board via operator<<
   int gameInput;
   bool input = false;
   Menu();
   cin >> gameInput;
   while (!input){
      try{
         if (gameInput > 4 || gameInput < 1){
            throw invalid_argument("ERROR");
         }
         else
            input = true;
      }
      catch (invalid_argument e){
         cout << "Invalid Input";
         cin >> gameInput;
      }
   }
   if (gameInput == 1){
      board = new OthelloBoard();
      v = new OthelloView(board);
      string userInput; // a string to hold the user's command choice
      vector<GameMove *> possMoves; // a holder for possible moves
      // Main loop
      do {
         // Print the game board using the GameView object
         cout << *v << endl;
         // Print all possible moves
         string player = board->GetNextPlayer() == 'B' ? "Black" : "White";
         cout << player << "'s turn" << endl;
         board->GetPossibleMoves(&possMoves);
         cout << "Possible moves:" << endl;
         for (GameMove *moves : possMoves){
            cout << (string)(*moves) << " ";
         }
         bool validCommand = true;
         // Ask to input a command
         do{
            validCommand = true;
            cout << endl << "Enter a command:" << endl;
            getline(cin, userInput);
            string temp = userInput.substr(0, userInput.find(" "));
            string values = userInput.substr(userInput.find(" ") + 1);
            if (temp == "move"){
               bool isPossible = true;
               GameMove *m = board->CreateMove();
               try{
                  *m = values;
                  for (GameMove *moves : possMoves){
                     if (m->Equals(*moves) && isPossible){
                        board->ApplyMove(m);
                        isPossible = false;
                        break;
                     }
                  }
                  if (!isPossible)
                     break;
                  cout << "INVALID MOVE!" << endl;
                  delete m;
                  validCommand = false;
                  break;
               }
               catch (GameException &e){
                  delete m;
                  cout << e.what() << "ERROR" << endl;
               }
            }
            // undo n
            else if (temp == "undo"){
               std::istringstream number(values);
               int regret;
               number >> regret;
               if (regret > board->GetMoveHistory()->size() || regret > 1000){
                  regret = board->GetMoveHistory()->size();
               }
               for (int i = 0; i < regret; i++){
                  board->UndoLastMove();
               }
            }
            // showValue
            else if (temp == "showValue"){
               cout << "BOARD VALUE:" << board->GetValue() << endl;
            }
            // showHistory
            else if (temp == "showHistory"){
               const vector<GameMove *>* history = board->GetMoveHistory();
               string currentPlayer = board->GetNextPlayer()
                  == 'W' ? "Black" : "White";
               for (vector<GameMove *>::const_reverse_iterator
                  i = history->rbegin(); i != history->rend(); i++) {
                  cout << currentPlayer << (string)(**i) << endl;
                  currentPlayer = (currentPlayer == "Black") ? "White" : "Black";
               }
            }
            // quit
            else if (temp == "quit") {
               break;
            }
            else{
               cout << "INVALID INPUT" << endl;
               validCommand = false;
            }
         } while (!validCommand);
         for (GameMove *moves : possMoves) {
            delete moves;
         }
         possMoves.clear();
      } while (!board->IsFinished());
      if (board->GetValue() > 0){
         cout << endl << "BLACK WINS!" << endl;
      }
      else if (board->GetValue() < 0){
         cout << endl << "WHITE WINS!" << endl;
      }
      else
         cout << "TIE!" << endl;
      for (int r = 0; r <= 64; r++)
         board->UndoLastMove();
      delete board;
   }
   if (gameInput == 2){
      board = new TicTacToeBoard();
      v = new TicTacToeView(board);
      string userInput; // a string to hold the user's command choice
      vector<GameMove *> possMoves; // a holder for possible moves
      // Main loop
      do{
         // Print the game board using the GameView object
         cout << *v << endl;
         // Print all possible moves
         string player = board->GetNextPlayer() == 'B' ? "Black" : "White";
         cout << player << "'s turn" << endl;
         board->GetPossibleMoves(&possMoves);
         cout << "Possible moves:" << endl;
         for (GameMove *moves : possMoves){
            cout << (string)(*moves) << " ";
         }
      } while (!board->IsFinished());
   }
}

void Menu() {
   cout << "Menu" << "\n1.Othello" << "\n2.TicTacToe" << "\n3.Connect 4"
      << "\n4.Quit" << "\nChoice:";
}