package sample.Objects.Magics;

public class Thunder implements Magic {
    private final String magicName = "サンダー";
    private int baseDamage = 20;
    private int decreaseMpAmount = 10;

    public String getMagicName() {
        return this.magicName;
    }
   
    public int getBaseDamage() {
        return baseDamage;
    }

    public int getDecreaseMpAmount() {
        return this.decreaseMpAmount;
    }

}
