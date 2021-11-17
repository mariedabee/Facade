package app;

public class HomeTheaterFacade {
        public Amplifier amplifier;
        public Tuner tuner;
        public DvdPlayer dvd;
        public CdPlayer cd;
        public Projector projector;
        public TheaterLights lights;
        public Screen screen;
        public PopcornPopper popper;

        public HomeTheaterFacade(Amplifier amplifier,
                                 Tuner tuner,
                                 DvdPlayer dvd,
                                 CdPlayer cd,
                                 Projector projector,
                                 Screen screen,
                                 TheaterLights lights,
                                 PopcornPopper popper) {

            this.amplifier = amplifier;
            this.tuner = tuner;
            this.dvd = dvd;
            this.cd = cd;
            this.projector = projector;
            this.screen = screen;
            this.lights = lights;
            this.popper = popper;
        }

        public void watchMovie(String movie) {
            System.out.println("Get ready to watch a movie...");
            popper.on();
            popper.pop();
            lights.dim(10);
            screen.down();
            projector.on();
            projector.wideScreenMode();
            amplifier.on();
            amplifier.setDvd(dvd);
            amplifier.setSurroundSound();
            amplifier.setVolume(5);
            dvd.on();
            dvd.play(movie);
        }


        public void endMovie() {
            System.out.println("Shutting movie theater down...");
            popper.off();
            lights.on();
            screen.up();
            projector.off();
            amplifier.off();
            dvd.stop();
            dvd.eject();
            dvd.off();
        }

        public void listenToCd(String cdTitle) {
            System.out.println("Get ready for an audiopile experience...");
            lights.on();
            amplifier.on();
            amplifier.setVolume(5);
            amplifier.setCd(cd);
            amplifier.setStereoSound();
            cd.on();
            cd.play(cdTitle);
        }

        public void endCd() {
            System.out.println("Shutting down CD...");
            amplifier.off();
            amplifier.setCd(cd);
            cd.eject();
            cd.off();
        }

        public void listenToRadio(double frequency) {
            System.out.println("Tuning in the airwaves...");
            tuner.on();
            tuner.setFrequency(frequency);
            amplifier.on();
            amplifier.setVolume(5);
            amplifier.setTuner(tuner);
        }

        public void endRadio() {
            System.out.println("Shutting down the tuner...");
            tuner.off();
            amplifier.off();
        }

}
