public class Q2c_2024S1 {
    public static void main(String[] args) {
        Playable[] instruments = {new Guitar(), new Piano()};

        for (Playable instrument : instruments) {
            instrument.play();
        }
    }

    interface Playable {
        void play();
    }

    static class Guitar implements Playable {
        @Override
        public void play() {
            System.out.println("Playing guitar...");
        }
    }

    static class Piano implements Playable {
        @Override
        public void play() {
            System.out.println("Playing piano...");
        }
    }
}
