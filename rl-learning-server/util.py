import pymongo
from action import *
from secret import *
from model import *


cluster = pymongo.MongoClient(CONNECT_STRING)
db = cluster["minecraft"]
collection = db["state"]

def action_selector(index):
    if index == 0:
        center_cursor()
        walk_forward_one_block()
    elif index == 1:
        center_cursor()
        short_jump()
    elif index == 2:
        center_cursor()
        long_jump()
    elif index == 3:
        center_cursor()
        turn_left()
        time.sleep(0.01)
        walk_forward_one_block()
    elif index == 4:
        center_cursor()
        turn_right()
        time.sleep(0.01)
        walk_forward_one_block()
    elif index == 5:
        center_cursor()
        turn_left()
        time.sleep(0.01)
        short_jump()
    elif index == 6:
        center_cursor()
        turn_right()
        time.sleep(0.01)
        short_jump()
    elif index == 7:
        center_cursor()
        turn_left()
        time.sleep(0.01)
        long_jump()
    elif index == 8:
        center_cursor()
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


def find_max_column_index(arr):
    max_value = -10000
    max_index = -1
    for i in range(len(arr)):
        if arr[i] > max_value:
            max_value = arr[i]
            max_index = i
    return max_index
