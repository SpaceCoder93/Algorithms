import matplotlib.pyplot as plt # Python Library to create 2D and 3D Graphs

def prime(num):
    for i in range(2, num):
        if num % i == 0:
            return("n")
            break
    else:
        return("y")

step_size = 1
num_step = 1
number = 1
state = 0
x, y = 0,0
turn_counter = 0

while number <= 1000:
    x0 = x
    y0 = y
    if state == 0:
        x += step_size
    elif state == 1:
        y -= step_size
    elif state == 2:
        x -= step_size
    else:
        y += step_size

    if number % num_step == 0:
        state = (state + 1) % 4
        turn_counter = turn_counter + 1
        if turn_counter % 2 == 0:
            num_step = num_step + 1
    number = number + 1
    pnp = prime(number)
    if pnp == "y":
        plt.plot(x, y, "o", color="red")
    else:
        pass
    print(number)

plt.show()