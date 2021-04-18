public class StormTrooper extends Trooper {

    private String name = "";
    private static int soldierCount=0;
    double marchModifier;

    public StormTrooper(String name, int count) {
        super(name,count);
        this.name=name;
        setSoldierCount(count +1);
        setTrooperKind("StormTrooper");
        marchModifier = 1.10;

    }



    public double march(double duration){
        duration = duration * marchModifier * marchSpeed;
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

    public static void setSoldierCount(int soldierCount) {
        StormTrooper.soldierCount = soldierCount;
    }

    @Override
    public String toString() {
        return name +"("+ super.toString()+ ") a " + getTrooperKind();
    }

    //public static void main(String args[]){
//
//    }
}
