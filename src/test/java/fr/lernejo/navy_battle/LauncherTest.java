package fr.lernejo.navy_battle;

import org.testng.annotations.Test;

import java.io.IOException;

class LauncherTest {
    @Test

    void Launcher1() {
        Launcher launch2 = new Launcher();
        String[] argmt = new String[1];
        argmt[0] = "9876";

        try {
            Launcher.main(argmt);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
