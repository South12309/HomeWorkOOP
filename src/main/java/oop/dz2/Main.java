package oop.dz2;

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

        public void open() {
            System.out.println(name + " is open");
        }
        @Override
        public void move() {
            System.out.println(name + " is moving");
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

        public LightWeightCar() {
            super.setName("LightWeightCar");
        }

    }
    class Lorry extends Car {
        public Lorry() {
            super.setName("Lorry");
        }

    }

}
