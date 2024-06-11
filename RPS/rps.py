import random
import tkinter as tk

class RockPaperScissors:
    def __init__(self):
        self.root = tk.Tk()
        self.root.title("Rock Paper Scissors")
        self.root.geometry("400x120")

        self.choices = ["Rock", "Paper", "Scissors"]

        self.top_bar= tk.Label(self.root, text="------------------------------------------------------------------------------")
        self.top_bar.grid(row=0, column=0, columnspan=3)

        self.bot_bar= tk.Label(self.root, text="------------------------------------------------------------------------------")
        self.bot_bar.grid(row=4, column=0, columnspan=3)

        self.choice_label = tk.Label(self.root, text="Choose your play:")
        self.choice_label.grid(row=1, column=0, columnspan=3)

        self.rock_button = tk.Button(self.root, text="Rock", command=lambda: self.play("Rock"))
        self.rock_button.grid(row=2, column=0)

        self.paper_button = tk.Button(self.root, text="Paper", command=lambda: self.play("Paper"))
        self.paper_button.grid(row=2, column=1)

        self.scissors_button = tk.Button(self.root, text="Scissors", command=lambda: self.play("Scissors"))
        self.scissors_button.grid(row=2, column=2)

        self.result_label = tk.Label(self.root, text="")
        self.result_label.grid(row=2, column=0, columnspan=3)

        self.root.mainloop()

    def play(self, player_choice):
        computer_choice = random.choice(self.choices)
        result = self.determine_winner(player_choice, computer_choice)
        self.result_label.config(text="")  # Clear the label
        self.result_label.config(text=f"You chose {player_choice}, Computer chose {computer_choice}. {result}")
        self.result_label.grid(row=3,column=0, columnspan=3)

    def determine_winner(self, player_choice, computer_choice):
        if player_choice == computer_choice:
            return "It's a tie!"
        elif (player_choice == "Rock" and computer_choice == "Scissors") or \
             (player_choice == "Paper" and computer_choice == "Rock") or \
             (player_choice == "Scissors" and computer_choice == "Paper"):
            return "You win!"
        else:
            return "Computer wins!"


if __name__ == "__main__":
    game = RockPaperScissors()
