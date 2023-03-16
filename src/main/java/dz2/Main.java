package dz2;

public class Main {
    interface Moveable {
        void move();
    }
    interface Stopable {
        void stop();
    }
    interface Startable {
        void start();
    }
    interface IEngine {
        void startEngine();
        void stopEngine();
    }
    abstract class Car implements Moveable, Stopable, Startable{
        private IEngine engine;
        private String color;
        private String name;

        abstract void open();
        public IEngine getEngine() {
            return engine;
        }
        @Override
        public void start() {
            getEngine().startEngine();
            System.out.println(name + " is start");
        }

        @Override
        public void stop() {
            System.out.println(name + " is stop");
            getEngine().stopEngine();
        }
        public void setEngine(IEngine engine) {
            this.engine = engine;
        }
        public String getColor() {
            return color;
        }
        public void setColor(String color) {
            this.color = color;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
    class LightWeightCar extends Car {


        @Override
        void open() {
            System.out.println("LightWeightCar is open");
        }
        @Override
        public void move() {
            System.out.println("LightWeightCar is moving");
        }

    }
    class Lorry extends Car {

        @Override
        void open() {
            System.out.println("Lorry is open");
        }
        @Override
        public void move() {
            System.out.println("Lorry is moving");
        }

    }

}
