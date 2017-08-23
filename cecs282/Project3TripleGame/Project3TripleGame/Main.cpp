//#include "OthelloExceptions.h"
#include "GameBoard.h"
#include "GameMove.h"
#include "GameView.h"
#include "OthelloBoard.h"
#include "OthelloView.h"
#include "OthelloMove.h"
#include <iostream>
#include <string>
#include <sstream>
#include <vector>

using namespace std;


int ma12312312412412in(int argc, char* argv[]) {
   // Initialization
   GameBoard *board = new OthelloBoard(); // the state of the game board
   GameView *v= new OthelloView(board); // a View for outputting the board via operator<<
   string userInput; // a string to hold the user's command choice
   vector<GameMove *> possMoves; // a holder for possible moves

   /*
   // Start with this DEBUGGING CODE to make sure your basic GameMove and
   // GameBoard classes work, then remove it when you are ready to work
   // on the real main.
   cout << "Initial board:" << endl;
   cout << v << endl;
   GameMove *m = board.CreateMove();
   *m = "(3, 2)";
   cout << "Applying the move " << (string)(*m) << endl;
   board.ApplyMove(m);
   cout << endl << v << endl; // should show a changed board.
   board.GetPossibleMoves(&possMoves);
   for (GameMove *moves : possMoves){
   cout << (string)(*moves) << " ";
   }
   cout << endl<<board.GetValue() << endl;
   cout << "\n";
   m = board.CreateMove();
   *m = "(4, 2)";
   cout << "Applying the move " << (string)(*m) << endl;
   board.ApplyMove(m);
   board.GetPossibleMoves(&possMoves);
   cout << endl<< board.GetValue() << endl;
   cout << endl << v << endl;
   const vector<GameMove *>* history = board.GetMoveHistory();
   m = board.CreateMove();
   *m = "(5, 2)";
   cout << "Applying the move " << (string)(*m) << endl;
   board.ApplyMove(m);
   cout << endl << v << endl;
   board.UndoLastMove();
   cout << endl << v << endl;
   cout << board.GetValue();
   // END OF DEBUGGING CODE
   */



   bool quit = false;
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
            //while (isPossible){
            GameMove *m = board->CreateMove();
            try{
               *m = values;
               for (GameMove *moves : possMoves){
                  if (values == (string)*moves && isPossible){
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
               cout << e.what() << "WHAT" << endl;
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
            quit = true;
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
   } while (!board->IsFinished() && !quit);
   if (board->GetValue() > 0){
      cout << endl << "BLACK WINS!" << endl;
   }
   else if (board->GetValue() < 0){
      cout << endl << "WHITE WINS!" << endl;
   }
   else
      cout << "TIE!" << endl;
   delete board;
   system("pause");
   return 0;
}