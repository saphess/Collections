package ru.netology.homework16.game;

public class Game {
    Player[] players = new Player[0];

    public Player[] getPlayers() {
        return players;
    }

    private void addInArray(Player newPlayer) {
        Player[] temp = new Player[players.length + 1];
        int index = 0;
        for (Player player : players) {
            temp[index] = player;
            index++;
        }
        temp[temp.length - 1] = newPlayer;
        players = temp;
    }

    public void register(Player newPlayer) {
        addInArray(newPlayer);
    }

    public int findByName(String playerName) {
        int index = 0;
        for (Player player : players) {
            if (playerName.equals(player.getName())) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == -1) {
            NotRegisteredException e = new NotRegisteredException(
                    "Игрок " + playerName1 + " не является участником.");
            throw e;
        }
        if (findByName(playerName2) == -1) {
            NotRegisteredException e = new NotRegisteredException(
                    "Игрок " + playerName1 + " не является участником.");
            throw e;
        }

        if (players[findByName(playerName1)].getStrength() > players[findByName(playerName2)].getStrength()) {
            return 1;
        }
        if (players[findByName(playerName1)].getStrength() < players[findByName(playerName2)].getStrength()) {
            return 2;
        }
        return 0;
    }
}
