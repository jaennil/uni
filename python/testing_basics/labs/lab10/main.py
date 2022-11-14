import tkinter as tk
from PIL import ImageTk, Image
import math


class PlaceholderEntry(tk.Entry):
    def __init__(self, placeholder: str, default: str = "", validation: str = "none", *args, **kwargs):
        tk.Entry.__init__(self, *args, **kwargs)
        self.placeholder = placeholder
        self.default = default
        self.string_var = tk.StringVar(
            value=placeholder if placeholder else default)
        self.config(textvariable=self.string_var)
        self.string_var.set(placeholder if placeholder else default)

        if validation == "number":
            self.validCommand = self.register(self.number_only_validation)

            self.config(validate="all", validatecommand=(
                self.validCommand, "%d", "%i", "%P"))
        elif validation == "float":
            self.validComannd = self.register(self.float_only_validation)

            self.config(validate="all", validatecommand=(
                self.validComannd, "%d", "%i", "%P"))
        elif validation == "none":
            pass
        else:
            raise ValueError("Validation can't be " + validation)

        self.bind(
            "<FocusIn>", lambda e: self.placeholder_erase(self))
        self.bind(
            "<FocusOut>", lambda e: self.placeholder_add(self))

    @staticmethod
    def number(string):
        return string.isdigit()

    @staticmethod
    def float_number(string: str):
        for char in string:
            if not char.isdigit() and not char == "." and not char == "-":
                return False

        if string.count(".") > 1 or string.count("-") > 1:
            return False
        return True

    def placeholder_erase(self, event=None):
        if self.string_var.get() == self.placeholder:
            self.string_var.set("")

    def placeholder_add(self, event=None):
        if self.string_var.get() == "":
            self.string_var.set(self.placeholder)

    def number_only_validation(self, why, where, what: str):
        if self.number(what) or what == self.placeholder:
            return True
        return False

    def float_only_validation(self, why, where, what: str):
        if self.float_number(what) or what == self.placeholder:
            return True
        return False

    def empty(self):
        val = self.string_var.get()
        return val in ("", self.placeholder, self.default)


class Frame1(tk.Frame):
    def __init__(self, parent, *args, **kwargs):
        tk.Frame.__init__(self, parent, *args, **kwargs)

        self.formula_img = ImageTk.PhotoImage(Image.open("1.png"))
        self.img_canvas = tk.Canvas(
            master=self, width=self.formula_img.width(), height=self.formula_img.height())
        self.img_canvas.grid(row=0, column=0, sticky="nsew")
        self.img_canvas.create_image(
            0, 0, image=self.formula_img, anchor=tk.NW)

        self.x_input = PlaceholderEntry(
            master=self, placeholder="x", validation="float")
        self.x_input.grid(row=1, column=0)

        self.y_input = PlaceholderEntry(
            master=self, placeholder="y", validation="float")
        self.y_input.grid(row=2, column=0)

        self.z_input = PlaceholderEntry(
            master=self, placeholder="z", validation="float")
        self.z_input.grid(row=3, column=0)

        self.string_vars = (self.x_input.string_var,
                            self.y_input.string_var, self.z_input.string_var)

        for sv in self.string_vars:
            sv.trace_add("write", lambda name, index,
                         mode: self.trace_entry(sv))
        self.t_output = tk.Label(master=self)
        self.t_output.grid(row=4, column=0)

    def trace_entry(self, sv):
        if any((self.x_input.empty(), self.y_input.empty(), self.z_input.empty())):
            self.t_output.config(text="")
            return

        x = float(self.x_input.get())
        y = float(self.y_input.get())
        z = float(self.z_input.get())
        pi = math.pi
        formula = 2*math.cos(x - pi/6) * (1 + z**2/(3-z **
                                          2/5)) / (0.5 + math.sin(y) ** 2)
        self.t_output.config(text="t = " + formula)


class Frame2(tk.Frame):
    def __init__(self, parent, *args, **kwargs):
        tk.Frame.__init__(self, parent, *args, **kwargs)

        self.formula_img = ImageTk.PhotoImage(Image.open("2.png"))
        self.img_canvas = tk.Canvas(
            master=self, width=self.formula_img.width(), height=self.formula_img.height())
        self.img_canvas.grid(row=0, column=0, sticky="nsew")
        self.img_canvas.create_image(
            0, 0, image=self.formula_img, anchor=tk.NW)

        self.x_input = PlaceholderEntry(
            master=self, placeholder="x", validation="float")
        self.x_input.grid(row=1, column=0)

        self.y_input = PlaceholderEntry(
            master=self, placeholder="y", validation="float")
        self.y_input.grid(row=2, column=0)

        self.z_input = PlaceholderEntry(
            master=self, placeholder="z", validation="float")
        self.z_input.grid(row=3, column=0)

        self.string_vars = (self.x_input.string_var,
                            self.y_input.string_var, self.z_input.string_var)

        for sv in self.string_vars:
            sv.trace_add("write", lambda name, index,
                         mode: self.trace_entry(sv))
        self.t_output = tk.Label(master=self)
        self.t_output.grid(row=4, column=0)

    def trace_entry(self, sv):
        if any((self.x_input.empty(), self.y_input.empty(), self.z_input.empty())):
            self.t_output.config(text="")
            return

        x = float(self.x_input.get())
        y = float(self.y_input.get())
        z = float(self.z_input.get())
        pi = math.pi
        formula = (((8 + (abs(x-y))**2 + 1)**(1/3)) / (x**2 + y**2 + 2)
                   ) - math.exp(abs(x-y)) * (math.tan(z)**2 + 1)**x
        self.t_output.config(text="u = " + str(formula))


class Frame3(tk.Frame):
    def __init__(self, parent, *args, **kwargs):
        tk.Frame.__init__(self, parent, *args, **kwargs)

        self.formula_img = ImageTk.PhotoImage(Image.open("3.png"))
        self.img_canvas = tk.Canvas(
            master=self, width=self.formula_img.width(), height=self.formula_img.height())
        self.img_canvas.grid(row=0, column=0, sticky="nsew")
        self.img_canvas.create_image(
            0, 0, image=self.formula_img, anchor=tk.NW)

        self.x_input = PlaceholderEntry(
            master=self, placeholder="x", validation="float")
        self.x_input.grid(row=1, column=0)

        self.y_input = PlaceholderEntry(
            master=self, placeholder="y", validation="float")
        self.y_input.grid(row=2, column=0)

        self.z_input = PlaceholderEntry(
            master=self, placeholder="z", validation="float")
        self.z_input.grid(row=3, column=0)

        self.string_vars = (self.x_input.string_var,
                            self.y_input.string_var, self.z_input.string_var)

        for sv in self.string_vars:
            sv.trace_add("write", lambda name, index,
                         mode: self.trace_entry(sv))
        self.t_output = tk.Label(master=self)
        self.t_output.grid(row=4, column=0)

    def trace_entry(self, sv):
        if any((self.x_input.empty(), self.y_input.empty(), self.z_input.empty())):
            self.t_output.config(text="")
            return

        x = float(self.x_input.get())
        y = float(self.y_input.get())
        z = float(self.z_input.get())
        pi = math.pi
        formula = (1 + math.sin(x+y)**2) * x**abs(y) / abs(x - 2 *
                                                           y/(1+(x**2)*(y**2))) + math.cos(math.atan(1/z)) ** 2
        self.t_output.config(text="v = " + str(formula))


class Frame4(tk.Frame):
    def __init__(self, parent, *args, **kwargs):
        tk.Frame.__init__(self, parent, *args, **kwargs)

        self.formula_img = ImageTk.PhotoImage(Image.open("4.png"))
        self.img_canvas = tk.Canvas(
            master=self, width=self.formula_img.width(), height=self.formula_img.height())
        self.img_canvas.grid(row=0, column=0, sticky="nsew")
        self.img_canvas.create_image(
            0, 0, image=self.formula_img, anchor=tk.NW)

        self.x_input = PlaceholderEntry(
            master=self, placeholder="x", validation="float")
        self.x_input.grid(row=1, column=0)

        self.y_input = PlaceholderEntry(
            master=self, placeholder="y", validation="float")
        self.y_input.grid(row=2, column=0)

        self.string_vars = (self.x_input.string_var,
                            self.y_input.string_var)

        for sv in self.string_vars:
            sv.trace_add("write", lambda name, index,
                         mode: self.trace_entry(sv))
        self.t_output = tk.Label(master=self)
        self.t_output.grid(row=4, column=0)

    def trace_entry(self, sv):
        if any((self.x_input.empty(), self.y_input.empty())):
            self.t_output.config(text="")
            return

        x = float(self.x_input.get())
        y = float(self.y_input.get())
        pi = math.pi
        if 1 <= x < 5:
            formula = math.sin(x)**2 + math.atan(math.sin(x))
        elif y > x:
            formula = (y - math.sin(x) ** 2) + math.atan(math.sin(x))
        else:
            formula = (y + math.sin(x)) ** 3 + 0.5
        self.t_output.config(text="l = " + str(formula))


class Frame5(tk.Frame):
    def __init__(self, parent, *args, **kwargs):
        tk.Frame.__init__(self, parent, *args, **kwargs)

        self.formula_img = ImageTk.PhotoImage(Image.open("5.png"))
        self.img_canvas = tk.Canvas(
            master=self, width=self.formula_img.width(), height=self.formula_img.height())
        self.img_canvas.grid(row=0, column=0, sticky="nsew")
        self.img_canvas.create_image(
            0, 0, image=self.formula_img, anchor=tk.NW)

        self.x_input = PlaceholderEntry(
            master=self, placeholder="x", validation="float")
        self.x_input.grid(row=1, column=0)

        self.y_input = PlaceholderEntry(
            master=self, placeholder="y", validation="float")
        self.y_input.grid(row=2, column=0)

        self.string_vars = (self.x_input.string_var,
                            self.y_input.string_var)

        for sv in self.string_vars:
            sv.trace_add("write", lambda name, index,
                         mode: self.trace_entry(sv))
        self.t_output = tk.Label(master=self)
        self.t_output.grid(row=4, column=0)

    def trace_entry(self, sv):
        if any((self.x_input.empty(), self.y_input.empty())):
            self.t_output.config(text="")
            return

        x = float(self.x_input.get())
        y = float(self.y_input.get())
        pi = math.pi
        sin = math.sin
        cos = math.cos

        def ctg(x):
            return math.cos(x) / math.sin(x)

        if x*y > 12:
            formula = sin(x)**3 + ctg(y)
        elif x*y < 7:
            formula = math.cosh(sin(x)**3) + y**2
        else:
            formula = cos(x-sin(x)**3)
        self.t_output.config(text="c = " + str(formula))


class App(tk.Tk):
    def __init__(self):
        tk.Tk.__init__(self)
        self.title("functions")
        self.geometry("1000x1000")
        frame1 = Frame1(self)
        frame1.grid(row=0, column=1, sticky="nsew")
        frame2 = Frame2(self)
        frame2.grid(row=0, column=1, sticky="nsew")
        frame3 = Frame3(self)
        frame3.grid(row=0, column=1, sticky="nsew")
        frame4 = Frame4(self)
        frame4.grid(row=0, column=1, sticky="nsew")
        frame5 = Frame5(self)
        frame5.grid(row=0, column=1, sticky="nsew")

        frame1.tkraise()

        self.var = tk.IntVar(self, 0)
        b1 = tk.Radiobutton(master=self, text="function 1",
                            command=frame1.tkraise, indicatoron=0, variable=self.var, value=0)
        b1.grid(row=0, column=0, sticky="nsew")
        b2 = tk.Radiobutton(master=self, text="function 2",
                            command=frame2.tkraise, indicatoron=0, variable=self.var, value=1)
        b2.grid(row=1, column=0, sticky="nsew")
        b3 = tk.Radiobutton(master=self, text="function 3",
                            command=frame3.tkraise, indicatoron=0, variable=self.var, value=2)
        b3.grid(row=2, column=0, sticky="nsew")
        b4 = tk.Radiobutton(master=self, text="function 4",
                            command=frame4.tkraise, indicatoron=0, variable=self.var, value=3)
        b4.grid(row=3, column=0, sticky="nsew")
        b5 = tk.Radiobutton(master=self, text="function 5",
                            command=frame5.tkraise, indicatoron=0, variable=self.var, value=4)
        b5.grid(row=4, column=0, sticky="nsew")


if __name__ == "__main__":
    app = App()
    app.mainloop()
