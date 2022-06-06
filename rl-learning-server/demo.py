import numpy as np
from util import *

q_table = np.load('q_table.npy')

current_position, _ = get_current_state()

# wait for start
for i in range(5):
    print(i + 1)
    time.sleep(1)

while True:
    current_state_index = current_position.get_state_index()
    action_index = find_max_column_index(q_table[current_state_index, :])
    action_selector(action_index)

    # Wait for database writing process and action to work
    time.sleep(2)

    # Get the next state
    next_position, player_state = get_current_state()

    if next_position.equal(97, 65, 139):
        break

    current_position = next_position