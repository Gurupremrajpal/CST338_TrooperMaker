import java.util.*;


public abstract class Trooper{
    private String unit;
    private int number;
    String trooperKind;
    double marchSpeed;
    double marchModifier;

    Trooper(){
        this.unit="AA";
        this.number=0;
    }

    public Trooper(String unit,int number){
        setUnit(unit);
        setNumber(number);
        marchSpeed=5;

    }

    public static void addToUnit(HashMap<String, List<Trooper>> units, Trooper t){
        boolean value=false;
        Set<Map.Entry<String, List<Trooper>>> troop = units.entrySet();
        Iterator<Map.Entry<String, List<Trooper>>> trooper = troop.iterator();
        while(trooper.hasNext())
        {
            Map.Entry<String, List<Trooper>> unit =  (Map.Entry<String, List<Trooper>>) trooper.next();
            String key = unit.getKey();
            if(t.getUnit().equals(key))
            {
                value = true;
                List<Trooper> values = unit.getValue();
                values.add(t);
                unit.setValue(values);
            }
        }
        if(value==false)
        {
            List<Trooper> m=new ArrayList<Trooper>();
            m.add(t);
            units.put(t.getUnit(), m);
        }
    }

    public abstract double march(double duration);

    public boolean attack(Trooper target, int roll){
        //System.out.println(toString() + " is attacking " + target + "\n" + toString() + " rolled a " + roll);

        if (this == target || roll == 1) {
            System.out.println(toString()+" is attacking "+getUnit()+toString());
            System.out.println(toString()+" rolled a "+roll);
            System.out.println(toString() + " a pilot is targeting itself... ");
            System.out.println(toString() + " rolled a " + roll + " and hurt itself in the confusion");
            return true;
        }
        if (getTrooperKind().equals("StormTrooper") && target.getTrooperKind().equals("pilot")) {
            System.out.println("rolled out " + roll + " against the rebel scum.");
            if (roll > 10 && roll % 2 == 0) {
                return true;
            }
        }
        else if (getTrooperKind().equals("StormTrooper") && target.getTrooperKind().equals("StormTrooper")) {
            System.out.println("No treason in the ranks!");
            return false;
        }
        else if (getTrooperKind().equals("StormTrooper")) {
            System.out.println("Acceptable Collateral Damage!");
            if (roll > 10 && roll % 2 == 0) {
                return true;
            }
        }
        if (getTrooperKind().equals("pilot") && target.getTrooperKind().equals("pilot")) {
            System.out.println("Imperial Spy! ");
            return false;
        }
        else if (getTrooperKind().equals("pilot") && target.getTrooperKind().equals("StormTrooper")) {
            System.out.println("rolled a " + roll + "  against the imperial scum. ");
            if (roll > 5 || roll % 2 != 0) {
                return true;
            }
        }
        else if (getTrooperKind().equals("pilot") ){
            System.out.println("Rebels target an innocent bystander");
            if (roll > 18 && roll % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTrooperKind() {
        return trooperKind;
    }

    public void setTrooperKind(String trooperKind) {
        this.trooperKind = trooperKind;
    }

    public double getMarchSpeed() {
        return marchSpeed;
    }

    public void setMarchSpeed(double marchSpeed) {
        this.marchSpeed = marchSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trooper trooper = (Trooper) o;
        return getNumber() == trooper.getNumber() && Double.compare(trooper.getMarchSpeed(), getMarchSpeed()) == 0 && Double.compare(trooper.marchModifier, marchModifier) == 0 && Objects.equals(getUnit(), trooper.getUnit()) && Objects.equals(getTrooperKind(), trooper.getTrooperKind());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUnit(), getNumber(), getTrooperKind(), getMarchSpeed(), marchModifier);
    }

    @Override
    public String toString() {
        return getUnit()+getNumber()+":";
    }

//    public static void main(String args[]){
//
//    }

}
