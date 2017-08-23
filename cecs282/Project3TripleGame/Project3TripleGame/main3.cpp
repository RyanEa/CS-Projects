#include "GameExceptions.h"
#include "GameBoard.h"
#include "GameView.h"
#include "GameMove.h"
#include "OthelloBoard.h"
#include "OthelloView.h"
#include "OthelloMove.h"
#include "TicTacToeBoard.h"
#include "TicTacToeMove.h"
#include "TicTacToeView.h"
#include "ConnectFourBoard.h"
#include "ConnectFourMove.h"
#include "ConnectFourView.h"
#include <iostream>
#include <string>
#include <sstream>
#include <vector>

using namespace std;
void aMenu();

int main(int argc, char* argv[]) {
   GameView *v = nullptr; // a View for outputting the board via operator<<
   vector<GameMove *> possMoves; // a holder for possible moves
   int gameInput;
   do{
      aMenu();
      GameBoard *board = nullptr; // the state of the game board
      do{
         cin >> gameInput;
         if (gameInput > 4 || gameInput < 1)
            cout << "Enter again" << endl;
         if (gameInput == 4)
            return 0;
         board = (gameInput == 1) ? new OthelloBoard() : board;
         board = (gameInput == 2) ? new TicTacToeBoard() : board;
         board = (gameInput == 3) ? new ConnectFourBoard() : board;
         v = (gameInput == 1) ? new OthelloView(board) : v;
         v = (gameInput == 2) ? new TicTacToeView(board) : v;
         v = (gameInput == 3) ? new ConnectFourView(board) : v;
      } while (gameInput>4 || gameInput<1);
      do{
         string userInput, values;
         cout << *v << endl;
         cout << board->GetPlayerString(board->GetNextPlayer()) << "'s turn"
            << endl;
         board->GetPossibleMoves(&possMoves);
         cout << "Possible moves:" << endl;
         for (GameMove *moves : possMoves){
            cout << static_cast<string>(*moves) << " ";
         }
         cout << endl << "Enter a command:" << endl;
         cin >> userInput;
         getline(cin, values);
         string temp = userInput.substr(0, userInput.find(" "));
         values = values.substr(values.find(" ") + 1);
         if (userInput == "move"){
            GameMove *m = board->CreateMove();
            try{
               *m = values;
               bool isAdded = true;
               for (GameMove *moves : possMoves){
                  if (m->Equals(*moves)){
                     board->ApplyMove(m);
                     isAdded = true;
                     break;
                  }
                  else
                     isAdded = false;
               }
               if (!isAdded){
                  cout << "Invalid Move!" << endl;
                  delete m;
               }
            }
            catch (GameException &e){
               delete m;
            }
         }
         else if (userInput == "undo"){
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
         else if (userInput == "showHistory"){
            const vector<GameMove *>* history = board->GetMoveHistory();
            string cPlayer=board->GetPlayerString(board->GetNextPlayer());
            for (vector<GameMove *>::const_reverse_iterator
               i = history->rbegin(); i != history->rend(); i++) {
               cPlayer = board->SwitchPlayer(cPlayer);
               cout << cPlayer << static_cast<string>(**i) << endl;
            }
         }
         else if (userInput == "showValue"){
            cout << "BOARD VALUE:" << board->GetValue() << endl;
         }
         else if (userInput == "quit"){
            break;
         }
         else
            cout << "INVALID COMMAND" << endl;
         for (GameMove *moves : possMoves) {
            delete moves;
         }
         possMoves.clear();
      } while (!board->IsFinished());
      cout << *v << endl;
      if (board->GetValue() > 0)
         cout << board->SwitchPlayer(board->GetPlayerString(board->
         GetNextPlayer())) << " Wins!" << endl;
      else if (board->GetValue() < 0){
         if (gameInput == 2)
            cout << "TIE!" << endl;
         else
            cout << board->SwitchPlayer(board->GetPlayerString(
            board->GetNextPlayer())) << " Wins!" << endl;
      }
      else{
         if (gameInput == 2)
            cout << "O " << "Wins!" << endl;
         else
            cout << "TIE!" << endl;
      }
      for (GameMove *moves : possMoves) {
         delete moves;
      }
      possMoves.clear();
      delete board;      
   } while (true);
}

void aMenu() {
   cout << "Menu" << "\n1.Othello" << "\n2.TicTacToe" << "\n3.Connect 4"
      << "\n4.Quit" << "\nChoice:";
}