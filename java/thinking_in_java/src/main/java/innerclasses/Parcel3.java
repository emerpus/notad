package innerclasses;

public class Parcel3 {
    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        public String readLabel() {
            return label;
        }
    }

    public static void main(String[] args) {
        Parcel3 p3 = new Parcel3();

        Parcel3.Contents pc = p3.new Contents();
        Parcel3.Destination pd = p3.new Destination("Tasmania");
    }
}
