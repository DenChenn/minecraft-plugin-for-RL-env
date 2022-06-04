import pyautogui
import time
import os

def turn_left():
    cmd=""" osascript -e '
    repeat 603 times
        delay 0.001
        tell application "System Events" to key code 86 --right
    end repeat'
    """
    os.system(cmd)


def turn_right():
    cmd=""" osascript -e '
    repeat 603 times
        delay 0.001
        tell application "System Events" to key code 88 --right
    end repeat'
    """
    os.system(cmd)

def walk_forward_one_block():


time.sleep(5)

while True:
    time.sleep(2)
    turn_right()
    time.sleep(2)
    turn_left()

