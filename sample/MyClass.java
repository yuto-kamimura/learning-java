package sample;

import sample.Characters.Enemy;
import sample.Characters.Player;
import sample.Characters.SuperPlayer;
import sample.Objects.CharacterParameter;
import sample.Utils.CommandScaner;
import sample.Utils.Common;

public class MyClass {
    public static void main(String args[]) {
        CharacterParameter playerParams = new CharacterParameter(100, 16, 5, 30, 0);
        CharacterParameter enemyParams = new CharacterParameter(80, 23, 8, 10, 30);

        Enemy enemy = new Enemy("ENEMY", enemyParams);
        Player player = new Player("PLAYER", playerParams);
        battle(player, enemy);
    }

    static void battle(Player player, Enemy enemy) {
        loop: while (true) {
            System.out.println("\nプレイヤーのターン");
            int command = CommandScaner.ScanCommandNumber();

            switch (command) {
                case Common.powerUpCommand:
                    System.out.println("変身!!");
                    System.out.println("プレイヤーはスーパープレイヤーとなった");
                    player = new SuperPlayer("スーパープレイヤー", player.params);
                    break;
                case Common.attackCommand:
                    System.out.println(player.getName() + "の攻撃!");
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

            System.out.println("\n敵のターン");
            System.out.println(enemy.getName() + "の攻撃!");
            enemy.attack(player);
            if (player.isElemenated()) {
                System.out.println(player.getName() + "は倒れた");
                break;
            } else {
                printPlayerInfo(player);
            }

            Time.timeSleep(2000);
        }
        System.out.println("戦闘が終了した。");
    }

    static void printPlayerInfo(Player player) {
        System.out.printf("プレイヤーの残りHP: %d", player.params.hp);
        System.out.printf("プレイヤーの残りMP: %d", player.params.mp);
    }

    static void printEnemyInfo(Enemy enemy) {
        System.out.printf("敵の残りHP: %d", enemy.params.hp);
        System.out.printf("敵の残りMP: %d", enemy.params.mp);
    }
}

