import tkinter as tk
from tkinter import font as tkfont
from tkinter import ttk
import tkinter.filedialog

class Notepad:
    def __init__(self, root):
        self.root = root
        self.root.title("Notepad For PseudoCode")
        self.root.geometry("800x600")

        # Font selector bar
        self.font_family_var = tk.StringVar()
        self.font_size_var = tk.IntVar()
        self.font_family_var.set("Arial")
        self.font_size_var.set(23)
        self.font_selector_frame = tk.Frame(self.root)
        self.font_selector_frame.pack(fill="x")
        self.font_family_label = tk.Label(self.font_selector_frame, text="Font Family:")
        self.font_family_label.pack(side="left")
        self.font_family_combobox = ttk.Combobox(self.font_selector_frame, textvariable=self.font_family_var)
        self.font_family_combobox['values'] = ["Arial", "Courier", "Times New Roman", "Helvetica"]
        self.font_family_combobox.pack(side="left")
        self.font_size_label = tk.Label(self.font_selector_frame, text="Font Size:")
        self.font_size_label.pack(side="left")
        self.font_size_spinbox = tk.Spinbox(self.font_selector_frame, from_=10, to=48, textvariable=self.font_size_var)
        self.font_size_spinbox.pack(side="left")
        self.font_button = tk.Button(self.font_selector_frame, text="Apply", command=self.change_font)
        self.font_button.pack(side="left")

        # Math symbols selector bar
        self.math_symbols_frame = tk.Frame(self.root)
        self.math_symbols_frame.pack(fill="x")
        self.math_symbols_label = tk.Label(self.math_symbols_frame, text="Math Symbols:")
        self.math_symbols_label.pack(side="left")
        self.math_symbols_combobox = ttk.Combobox(self.math_symbols_frame)
        self.math_symbols_combobox['values'] = ["∀", "∃", "∈", "∉", "⊆", "⊇", "∅", "∧", "∨", "¬", "←"]
        self.math_symbols_combobox.pack(side="left")
        self.math_symbols_button = tk.Button(self.math_symbols_frame, text="Insert", command=self.insert_math_symbol)
        self.math_symbols_button.pack(side="left")

        # Text area
        self.text_area = tk.Text(self.root, font=("Arial", 23), bg="white")
        self.text_area.pack(fill="both", expand=True)

        # Save function
        self.save_button = tk.Button(self.root, text="Save", command=self.save_file)
        self.save_button.pack(fill="x")

        # Undo/Redo functionality
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

    def save_file(self):
        file_name = tkinter.filedialog.asksaveasfilename(defaultextension=".txt")
        if file_name:
            with open(file_name, "w") as f:
                f.write(self.text_area.get('1.0', 'end-1c'))

    def insert_math_symbol(self):
        symbol = self.math_symbols_combobox.get()
        self.text_area.insert(tk.INSERT, symbol)

    def change_font(self):
        font_family = self.font_family_var.get()
        font_size = self.font_size_var.get()
        self.text_area.config(font=(font_family, font_size))

root = tk.Tk()
notepad = Notepad(root)
root.mainloop()
