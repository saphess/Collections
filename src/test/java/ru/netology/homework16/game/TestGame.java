package ru.netology.homework16.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGame {
    Player player1;
    Player player2;
    Player player3;
    Player player4;
    Player player5;
    Player player6;

    Game game = new Game();

    @BeforeEach
    public void setup() {
        player1 = new Player(101, "saphess", 5005);
        player2 = new Player(999, "george", 5005);
        player3 = new Player(502, "Versus", 99);
        player4 = new Player(78, "Polina228", 1000);
        player5 = new Player(38, "Versus", 15_000_000);
        player6 = new Player(88, "Vika", 98);

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
    }

    @Test
    public void shouldRegisterPlayers() {
        Player[] actual = game.getPlayers();
        Player[] expected = {player1, player2, player3, player4, player5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByNameIfThereAreRepetitions() {
        int actual = game.findByName(player5.getName());
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundIfWinPlayer1() {
        int actual = game.round("saphess", "Versus");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundIfWinPlayer2() {
        int actual = game.round("Versus", "Polina228");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundIfNobodyWin() {
        int actual = game.round("george", "saphess");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowRoundIfPlayer1NotRegister() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Vika", "Vika");
        });
    }

    @Test
    public void shouldThrowRoundIfPlayer2NotRegister() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("saphess", "Vika");
        });
    }
}
