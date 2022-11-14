# Import the required libraries
from tkinter import *
from PIL import Image, ImageTk

# Create an instance of tkinter frame or window
win = Tk()

# Set the size of the window
win.geometry("700x600")

# Create a canvas widget
canvas = Canvas(win, bg="red")
canvas.grid(row=0, column=0, sticky="nsew")

# Load the image
img = ImageTk.PhotoImage(file="1.png")

# Add the image in the canvas
canvas.create_image(img.width(), 0, image=img, anchor="ne")

win.mainloop()
