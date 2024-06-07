package sample;

import sample.Characters.Enemy;
import sample.Characters.Player;
import sample.Characters.SuperPlayer;
import sample.Objects.CharacterParameter;
import sample.Utils.Color;
import sample.Utils.CommandScaner;
import sample.Utils.Common;

public class BattleGame {
    public static void main(String args[]) {
        CharacterParameter playerParams = new CharacterParameter(100, 16, 5, 30, 0);
        CharacterParameter enemyParams = new CharacterParameter(80, 23, 8, 10, 30);

        Enemy enemy = new Enemy("ENEMY", enemyParams);
        Player player = new Player("PLAYER", playerParams);
        battle(player, enemy);
    }

    static void battle(Player player, Enemy enemy) {
        printCharacterTurn("プレイヤー");

        loop: while (true) {
            System.out.println("コマンド [1. 攻撃 | 2. 逃げる | 3. 自己強化 | その他. さぼり]");
            int command = CommandScaner.ScanCommandNumber();

            switch (command) {
                case Common.powerUpCommand:
                    if (player.isSuperPlayer()) {
                        System.out.println("これ以上自己強化できない!");
                        continue loop;
                    } else {
                        System.out.println("プレイヤーはスーパープレイヤーとなった");
                        player = new SuperPlayer("スーパープレイヤー", player.params, 100);
                        break;
                    }
                case Common.attackCommand:
                    printAttackInfo(player.getName());
                    player.attack(enemy);
                    break;
                case Common.escapeCommand:
                    if (player.escape(enemy)) {
                        System.out.println(player.getName() + "は逃げることに成功した!");
                        break loop;
                    } else {
                        System.out.println(player.getName() + "は逃げきれなかった！");
                        break;
                    }
                default:
                    System.out.println("プレイヤーは何もしなかった!");
                    break;
            }
            printEnemyInfo(enemy);

            if (enemy.isElemenated()) {
                System.out.println(enemy.getName() + "は倒れた");
                break;
            }

            Time.timeSleep(2000);

            printCharacterTurn("敵");
            printAttackInfo(enemy.getName());
            enemy.attack(player);
            if (player.isElemenated()) {
                System.out.println(player.getName() + "は倒れた");
                break;
            } else {
                printPlayerInfo(player);
            }

            Time.timeSleep(2000);
            printCharacterTurn("プレイヤー");
        }
        System.out.println("戦闘が終了した。");
    }

    static void printPlayerInfo(Player player) {
        System.out.printf(Color.green + "プレイヤーの残り [HP: %d], [MP: %d] \n" + Color.end, player.params.hp,
                player.params.mp);
    }

    static void printEnemyInfo(Enemy enemy) {
        System.out.printf(Color.red + "敵の残り [HP: %d], [MP: %d] \n" + Color.end, enemy.params.hp, enemy.params.mp);
    }

    static void printAttackInfo(String name) {
        System.out.println(name + "の攻撃!");
    }

    static void printCharacterTurn(String character) {
        System.out.println("\n" + character + "のターン!");
    }

}
