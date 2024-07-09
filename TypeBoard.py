import tkinter as tk

class Notepad:
    def __init__(self, root):
        self.root = root
        self.root.title("Notepad For PseudoCode")
        self.root.geometry("800x600")
        self.text_area = tk.Text(self.root, font=("Arial", 23), bg="white")
        self.text_area.pack(fill="both", expand=True)
        self.history = []
        self.history_index = -1

        self.text_area.bind('<Key>', self.track_changes)

        self.root.bind('<Control-z>', self.undo)

    def track_changes(self, event):
        if event.keysym!= 'z' or not event.ctrl:
            self.history = self.history[:self.history_index + 1]
            self.history.append(self.text_area.get('1.0', 'end-1c'))
            self.history_index += 1

    def undo(self, event):
        if self.history_index > 0:
            self.history_index -= 1
            self.text_area.delete('1.0', 'end')
            self.text_area.insert('1.0', self.history[self.history_index])

root = tk.Tk()
notepad = Notepad(root)
root.mainloop()
