package sample.Objects.Magics;

public class Thunder implements Magic {
    private int baseDamage = 10;
    private int decreaseMpAmount = 5;

    public int getBaseDamage() {
        return baseDamage;
    }

    public int getDecreaseMpAmount() {
        return this.decreaseMpAmount;
    }

}
