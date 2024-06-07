package sample.Objects.Magics;

public class Fire implements Magic{
    private int baseDamage = 10;
    private int decreaseMpAmount = 5;

    public int getBaseDamage() {
        return this.baseDamage;
    }

    public int getDecreaseMpAmount() {
        return this.decreaseMpAmount;
    }
}
