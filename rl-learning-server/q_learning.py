import pymongo
import numpy as np
from action import *
import random
from model import *
from secret import *

cluster = pymongo.MongoClient(CONNECT_STRING)
db = cluster["minecraft"]
collection = db["state"]

def action_selector(index):
    if index == 0:
        walk_forward_one_block()
    elif index == 1:
        short_jump()
    elif index == 2:
        long_jump()
    elif index == 3:
        turn_left()
        time.sleep(0.01)
        walk_forward_one_block()
    elif index == 4:
        turn_right()
        time.sleep(0.01)
        walk_forward_one_block()
    elif index == 5:
        turn_left()
        time.sleep(0.01)
        short_jump()
    elif index == 6:
        turn_right()
        time.sleep(0.01)
        short_jump()
    elif index == 7:
        turn_left()
        time.sleep(0.01)
        long_jump()
    elif index == 8:
        turn_right()
        time.sleep(0.01)
        long_jump()


def get_current_state():
    data_cursor = collection.find().sort('create_at', pymongo.DESCENDING).limit(1)
    state = {}
    for d in data_cursor:
        state = d

    position = Position(state['x'], state['y'], state['z'])
    this_player_state = state['player_state']
    return position, this_player_state


# initial a q table with 40 states and 9 kinds of action
q_table = np.zeros((40, 9))

# number of episode we will run
n_episodes = 2

# maximum of iteration per episode
max_iter_episode = 100

# initialize the exploration probability to 1
q_exp_table = [1.0 for i in range(40)]

# exploration decreasing decay for exponential decreasing
exploration_decreasing_decay = 0.001

# minimum of exploration proba
min_exploration_proba = 0.01

# discounted factor
gamma = 0.99

# learning rate
lr = 0.1

# wait for start
for i in range(5):
    print(i)
    time.sleep(1)

# we iterate over episodes, which means how many times we play game
for e in range(n_episodes):
    # we initialize the first state of the episode
    current_position, _ = get_current_state()
    done = False
    print(current_position)

    # In one game, how many times we take action
    for i in range(max_iter_episode):
        action_index = -1
        current_state_index = current_position.get_state_index()

        # we sample a float from a uniform distribution over 0 and 1
        # if the sampled float is less than the exploration proba
        #     the agent selects a random action
        # else
        #     he exploits his knowledge using the bellman equation

        if np.random.uniform(0,1) < q_exp_table[current_state_index]:
            action_index = random.randint(0, 8)
            action_selector(action_index)
            print("####################")
            print("用賽的")
            print(q_exp_table)
            print("####################")
        else:
            # map current position to its state index (column index), and get the max option
            action_index = np.argmax(q_table[current_state_index, :])
            action_selector(action_index)
            print("####################")
            print("技術判斷")
            print(q_exp_table)
            print("####################")

        # Wait for database writing process and action to work
        time.sleep(7)

        # Get the next state
        next_position, player_state = get_current_state()
        next_state_index = next_position.get_state_index()

        if player_state == "ALIVE":
            reward = 1
            # if we get it, decrease the guessing probability
            q_exp_table[current_state_index] = max(min_exploration_proba, q_exp_table[current_state_index] - 0.4)
        else:
            reward = -1

        # We update our Q-table using the Q-learning iteration
        q_table[current_state_index, action_index] = (1 - lr) * q_table[current_state_index, action_index] + lr * (
                reward + gamma * max(q_table[next_state_index, :]))

        print("-----------------------------------------------------")
        print("Iteration: " + str(i))
        print("Current position: " + str(current_position.x) + " " + str(current_position.y) + " " + str(
            current_position.z))
        print(q_table)
        print("-----------------------------------------------------")

        if next_position.equal(97, 65, 139):
            # if we reach the final block, walk forward a little to dead and leave the loop
            action_selector(0)
            time.sleep(0.5)
            break

        current_position = next_position

    # We update the exploration proba using exponential decay formula



