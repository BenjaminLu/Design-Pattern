package observer.jdk;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer {
    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay() {}

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    public void setObservable(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    public void deleteObservable() {
        observable.deleteObserver(this);
        this.observable = null;
    }

    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    public String display() {
        return "Current conditions: " + temperature + "F degrees and " + humidity + "% humidity";
    }
}
