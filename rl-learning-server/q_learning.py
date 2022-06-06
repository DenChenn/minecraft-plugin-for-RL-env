import numpy as np
from action import *
import random
from util import *

# initial a q table with 40 states and 9 kinds of action
q_table = np.zeros((40, 9))

# number of episode we will run
n_episodes = 1

# maximum of iteration per episode
max_iter_episode = 1000

q_exp_table = [0.1 for i in range(40)]

# minimum of exploration proba
min_exploration_proba = 0.001

# discounted factor
gamma = 0.5

# learning rate
lr = 0.3

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
            print("Action index: " + str(action_index))
            print(q_exp_table)
            print("####################")
        else:
            # map current position to its state index (column index), and get the max option
            action_index = find_max_column_index(q_table[current_state_index, :])
            action_selector(action_index)
            print("####################")
            print("技術判斷")
            print("Action index: " + str(action_index))
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
            q_exp_table[current_state_index] = max(min_exploration_proba, q_exp_table[current_state_index] - 0.6)
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

# save the training result
np.save('q_table.npy', q_table)


