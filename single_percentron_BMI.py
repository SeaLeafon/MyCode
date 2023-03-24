import numpy as np
from matplotlib import pyplot as plt


def plot(data, weights):
    OWlist = []
    OHlist = []
    UWlist = []
    UHlist = []

    for i in data:
        if i[3] == 1:
            OHlist.append(i[1])
            OWlist.append(i[2])
        else:
            UHlist.append(i[1])
            UWlist.append(i[2])

    plt.ylabel("height (cm)")
    plt.xlabel("weight (kg)")

    x = np.linspace(0, 200, 100)
    y = (-weights[0] - weights[2] * x) / weights[1]
    plt.plot(x, y, "-r")

    plt.plot(OWlist, OHlist, "ro", UWlist, UHlist, "bo")
    plt.axis([0, 200, -50, 200])
    plt.show()
    return


def predict(data, weights):
    dotlist = []
    for i in data:
        dot = weights[0] + i[1] * weights[1] + i[2] * weights[2]
        if dot > 0:
            dotlist.append(1)
        else:
            dotlist.append(0)
    return dotlist


def accuracy(data, dotlist):
    correct = 0
    index = 0
    index_contain = []
    for i in data:
        if i[3] == dotlist[index]:
            correct += 1
        else:
            index_contain.append(index)
        index += 1
    accuracy = correct / index
    print(f"current accuracy: {accuracy * 100} %")
    return index_contain


def update(w, lr, d, x):
    new_w = w + lr * d * x
    return new_w


def train(data, weights, lr):
    new_weights = []

    dotlist = predict(data, weights)
    index_contain = accuracy(data, dotlist)

    if len(index_contain) > 0:
        x0 = data[index_contain[0]][0]
        x1 = data[index_contain[0]][1]
        x2 = data[index_contain[0]][2]
        d = data[index_contain[0]][3]
        if d == 0:
            d = -1
        new_weights.append(update(weights[0], lr, d, x0))
        new_weights.append(update(weights[1], lr, d, x1))
        new_weights.append(update(weights[2], lr, d, x2))
        return new_weights
    else:
        weights.append(0)
        return weights


## using i = 1 for over and i = 0 for under
## bias height weight i
def main():
    data = [[1, 150, 80, 1], [1, 170, 60, 0], [1, 130, 70, 1], [1, 178, 50, 0]]
    weights = [0.2, 0.4, 0.8]
    learning_rate = 0.2

    n_weights = []

    while True:
        n_weights = train(data, weights, learning_rate)
        if len(n_weights) > 3:
            break
        else:
            weights = n_weights

    plot(data, n_weights)


main()
