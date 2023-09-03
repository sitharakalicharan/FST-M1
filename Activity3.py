player1 = input("Please enter name of player 1")
player2 = input("Please enter name of player 2")

player1_move = input("Please enter {}'s move".format(player1)).lower()
player2_move = input("Please enter {}'s move".format(player2)).lower()

if player1_move== player2_move:
    print("It's a tie")
elif player1_move== "rock":
    if player2_move== "scissors":
        print("{} wins".format(player1))
    elif player2_move== "paper":
        print("{} wins".format(player2))
elif player1_move == "paper":
    if player2_move== "scissors":
        print("{} wins".format(player2))
    elif player2_move== "rock":
        print("{} wins".format(player1))
elif player1_move== "scissors":
    if player2_move== "paper":
        print("{} wins".format(player1))
    elif player2_move== "rock":
        print("{} wins".format(player1))
else:
    print("Invalid input, please enter rock, paper or scissors")
        
            
        
    


