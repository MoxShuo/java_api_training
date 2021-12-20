package fr.lernejo.navy_battle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;


public class LauncherTest {
    private final Launcher launcher = new Launcher();
    @Test
    void mainTest1(){
        org.assertj.core.api.Assertions.assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> Launcher.main(new String[] {})).withMessage("il doit y avoir 1 ou 2 arguments pour foncitionner");
    }
    @Test
    void mainTest2(){
        org.assertj.core.api.Assertions.assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> Launcher.main(new String[] {"9786","ok","ok"})).withMessage("il doit y avoir 1 ou 2 arguments");
    }
    @Test
    void mainTest3(){
        org.assertj.core.api.Assertions.assertThatNoException().isThrownBy(() -> Launcher.main(new String[] {"9786"}));
    }
    @Test
    void mainTest4(){
        org.assertj.core.api.Assertions.assertThatNoException().isThrownBy(() -> Launcher.main(new String[] {"9786", "http://localhost:9786"}));

    }
}
