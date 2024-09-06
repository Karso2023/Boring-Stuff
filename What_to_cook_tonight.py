import tkinter as tk
import random

dishes = [
    "蒸水蛋", "蒜蓉蒸排骨", "翠玉瓜炒雞柳", "清蒸魚",
    "家常豆腐", "番茄炒蛋", "青椒牛肉",
    "蒜蓉西蘭花", "香煎三文魚", "紅燒茄子", "蒸雞翼", "炒米粉",
    "牛肉炒麵", "蔥油餅", "豉汁蒸排骨",
    "魚香茄子", "蝦仁炒飯", "香菇青菜", "咖哩雞", "冬瓜湯",
    "蒸牛仔骨", "涼拌黃瓜", "香煎豆腐", "炒時蔬", "豬肉炒米粉", "清炒菠菜",
    "番茄牛腩", "椒鹽蝦", "香煎鱈魚", "魚香肉絲", "蚵仔粥", "蒜蓉菠菜", "香煎豬排", "雞絲涼麵",
    "紅燒豆腐", "蒜香蝦仁", "番茄炒蛋", "清蒸蝦",
    "鹽酥雞", "涼拌豆芽", "蒸肉餅", "蒸雞", "蒸鮮魚", "蒸蛋", "炒時蔜",
    "炒麵", "炒河粉", "炒通菜", "炒娃娃菜", "炒四季豆",
    "炒白菜"
]

def show_random_dish():
    random_dish = random.choice(dishes)
    dish_label.config(text=random_dish)

root = tk.Tk()
root.title("What to eat ar")

dish_label = tk.Label(root, text="", font=("Arial", 24), wraplength=300)
dish_label.pack(pady=20)


random_button = tk.Button(root, text="What to eat ar", command=show_random_dish, font=("Arial", 16))
random_button.pack(pady=20)

root.mainloop()