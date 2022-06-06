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
    pyautogui.keyDown('w')
    time.sleep(0.145)
    pyautogui.keyUp('w')

def long_jump():
    pyautogui.press('w')
    pyautogui.keyDown('w')
    time.sleep(0.09)
    pyautogui.keyDown('space')
    time.sleep(0.01)
    pyautogui.keyUp('space')
    time.sleep(0.3)
    pyautogui.keyUp('w')

def short_jump():
    pyautogui.keyDown('w')
    time.sleep(0.03)
    pyautogui.keyDown('space')
    time.sleep(0.01)
    pyautogui.keyUp('space')
    time.sleep(0.1)
    pyautogui.keyUp('w')

def center_cursor():
    pyautogui.press('esc')
    time.sleep(0.001)
    pyautogui.press('esc')
