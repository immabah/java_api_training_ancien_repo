package fr.lernejo.navy_battle;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LauncherTest {
    @Test
    void Launcher1() {
        Launcher launch1 = new Launcher();
        launch1.main(new String[]{"8750"});
    }

    void Launcher2() {
        Launcher launch2 = new Launcher();
        String[] argmt = new String[1];
        arg[0] = "9876";

        try {
            Launcher.main(argmt);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}


