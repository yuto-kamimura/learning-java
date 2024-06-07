package sample.Objects.Magics;

public class Fire implements Magic{
    private final String magicName = "ファイア";
    private final int baseDamage = 10;
    private final int decreaseMpAmount = 5;

    public String getMagicName() {
        return magicName;
    }

    public int getBaseDamage() {
        return this.baseDamage;
    }

    public int getDecreaseMpAmount() {
        return this.decreaseMpAmount;
    }
}
