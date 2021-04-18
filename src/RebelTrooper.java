public class RebelTrooper extends Trooper {

    private String name = "Rebel";
    private static int soldierCount= 0;


    public RebelTrooper(String trooperKind, int counter, String name) {
        setSoldierCount(counter +1);
        setTrooperKind("pilot");
        this.marchModifier= 0.75;
        this.name = trooperKind;

    }

    public double march(double duration){
        duration= duration * marchModifier * marchSpeed;
        return duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getSoldierCount() {
        return soldierCount;
    }

    public void setSoldierCount(int soldierCount) {
        this.soldierCount = soldierCount;
    }

    @Override
    public String toString() {
        return name + "("+super.toString()+") a "+ getTrooperKind();
    }
}
