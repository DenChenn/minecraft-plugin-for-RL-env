package m1pro.parkour.god.rlenvironmentplugin;

public class IntegerLocation {
    int x;
    int y;
    int z;

    public IntegerLocation(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof IntegerLocation)) {
            return false;
        }

        IntegerLocation other = (IntegerLocation) obj;

        return x == other.x && y == other.y && z == other.z;
    }
}
