class Position:
    def __init__(self, x, y, z):
        self.x = x
        self.y = y
        self.z = z

    def equal(self, x, y, z):
        if self.x == x and self.y == y and self.z == z:
            return True
        else:
            return False

    def get_state_index(self):
        if self.equal(100, 65, 109):
            return 0
        elif self.equal(99, 65, 109):
            return 1
        elif self.equal(99, 65, 110):
            return 2
        elif self.equal(99, 65, 111):
            return 3
        elif self.equal(99, 65, 112):
            return 4
        elif self.equal(99, 65, 113):
            return 5
        elif self.equal(98, 65, 113):
            return 6
        elif self.equal(97, 65, 113):
            return 7
        elif self.equal(96, 65, 113):
            return 8
        elif self.equal(96, 65, 114):
            return 9
        elif self.equal(96, 65, 115):
            return 10
        elif self.equal(96, 65, 116):
            return 11
        elif self.equal(96, 65, 117):
            return 12
        elif self.equal(96, 65, 118):
            return 13
        elif self.equal(97, 65, 118):
            return 14
        elif self.equal(98, 65, 118):
            return 15
        elif self.equal(99, 65, 118):
            return 16
        elif self.equal(99, 65, 119):
            return 17
        elif self.equal(99, 65, 122):
            return 18
        elif self.equal(99, 65, 123):
            return 19
        elif self.equal(99, 65, 124):
            return 20
        elif self.equal(99, 65, 125):
            return 21
        elif self.equal(100, 65, 125):
            return 22
        elif self.equal(101, 65, 125):
            return 23
        elif self.equal(102, 65, 125):
            return 24
        elif self.equal(102, 65, 126):
            return 25
        elif self.equal(102, 65, 128):
            return 26
        elif self.equal(102, 65, 130):
            return 27
        elif self.equal(102, 65, 131):
            return 28
        elif self.equal(101, 65, 131):
            return 29
        elif self.equal(100, 65, 131):
            return 30
        elif self.equal(99, 65, 131):
            return 31
        elif self.equal(98, 65, 131):
            return 32
        elif self.equal(97, 65, 131):
            return 33
        elif self.equal(97, 65, 132):
            return 34
        elif self.equal(97, 65, 135):
            return 35
        elif self.equal(97, 65, 136):
            return 36
        elif self.equal(97, 65, 137):
            return 37
        elif self.equal(97, 65, 138):
            return 38
        elif self.equal(97, 65, 139):
            return 39
