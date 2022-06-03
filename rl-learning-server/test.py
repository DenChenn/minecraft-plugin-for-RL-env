import pyautogui
import time

swap = 0

while True:
    time.sleep(2)
    if swap == 0:
        print("swap == 0")
        swap = (swap + 1) % 2
        currentX, currentY = pyautogui.position()
        print("X: " + str(currentX) + ", Y: " + str(currentY))
        # pyautogui.keyDown('e')
        # pyautogui.keyUp('e')
        # pyautogui.keyDown('e')
        # pyautogui.keyUp('e')
        pyautogui.moveRel(300, 0)
    else:
        print("swap == 1")
        swap = (swap + 1) % 2
        currentX, currentY = pyautogui.position()
        print("X: " + str(currentX) + ", Y: " + str(currentY))
        # pyautogui.keyDown('e')
        # pyautogui.keyUp('e')
        # pyautogui.keyDown('e')
        # pyautogui.keyUp('e')
        pyautogui.moveRel(- 300, 0)
