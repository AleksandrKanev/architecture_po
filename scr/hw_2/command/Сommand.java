package hw_2.command;

class Light {
    public Light(){

    }
    public void turnOn(){
        System.out.println("Лампа горит");
    }
    public void turnOff(){
        System.out.println("Лампа не горит");
    }
}

interface Command{
    void execute();
}

class TurnOnLightCommand implements Command{

    private Light theLight;
    public TurnOnLightCommand(Light theLight){
        this.theLight = theLight;
    }
    @Override
    public void execute() {
        theLight.turnOn();
    }
}

class TurnOffLightCommand implements Command{
    private Light theLight;

    public TurnOffLightCommand(Light light){
        this.theLight = light;
    }

    @Override
    public void execute() {
        theLight.turnOff();
    }
}

class Switch {
    private Command flipUpCommand;
    private Command flipOffCommand;

    public Switch(Command flipUpCommand, Command flipOffCommand) {
        this.flipUpCommand = flipUpCommand;
        this.flipOffCommand = flipOffCommand;
    }

    void flipUp(){
        flipUpCommand.execute();
    }
    void flipDown(){
        flipOffCommand.execute();
    }
}

class Main{
    public static void main(String[] args) {
        Light l = new Light();
        Command switchUp = new TurnOnLightCommand(l);
        Command switchDown = new TurnOffLightCommand(l);
        Switch s = new Switch(switchUp,switchDown);

        s.flipUp();
        s.flipDown();
    }
}