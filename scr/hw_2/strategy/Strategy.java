package hw_2.strategy;

class Auto {

    FillStrategy fillStrategy;

    void fill(){
        fillStrategy.fill();
    }
    public void gas() {
        System.out.println("Едем!");
    }

    public void stop() {
        System.out.println("Тормозим!");
    }

}

interface FillStrategy{
    void fill();
}

class HybridFillStrategy implements FillStrategy{
    @Override
    public void fill() {
        System.out.println("Заправляем бензином или электричеством на выбор!");
    }
}

class StandardFillStrategy implements FillStrategy{
    @Override
    public void fill() {
        System.out.println("Просто заправляем бензин!");
    }
}

class F1PitstopStrategy implements FillStrategy{
    @Override
    public void fill() {
        System.out.println("Заправляем бензин только после всех остальных процедур пит-стопа!");
    }
}

class Sedan extends Auto{
    public Sedan() {
        this.fillStrategy = new StandardFillStrategy();
    }
}
class HybridAuto extends Auto{
    public HybridAuto() {
        this.fillStrategy = new HybridFillStrategy();
    }
}
class F1Car extends Auto{
    public F1Car() {
        this.fillStrategy = new F1PitstopStrategy();
    }
}

class Main{
    public static void main(String[] args) {
        Auto sedan = new Sedan();
        Auto hybrid = new HybridAuto();
        Auto f1car = new F1Car();

        sedan.fill();
        hybrid.fill();
        f1car.fill();
    }
}