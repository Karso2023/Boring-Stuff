import tkinter as tk

class Notepad:
    def __init__(self, root):
        self.root = root
        self.root.title("Notepad For PseudoCode")
        self.root.geometry("800x600")
        self.text_area = tk.Text(self.root, font=("Arial", 23), bg="white")
        self.text_area.pack(fill="both", expand=True)

root = tk.Tk()
notepad = Notepad(root)
root.mainloop()