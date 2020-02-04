package observerPatterHeadFirst.pattern.observer;

public interface Subject {
    public void registerObserver(Observer register);
    public void removeObserver(Observer remove);
    public void notifyObserver();
}
