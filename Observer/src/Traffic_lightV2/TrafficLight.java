package Traffic_lightV2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TrafficLight implements PropertyChangeSubject
{

  private String[] lights ={"GREEN","YELLOW","RED","YELLOW"};
  private int LightIndex =2;
  private String currentLight;

  private PropertyChangeSupport support;

  public TrafficLight(){
    currentLight =lights[LightIndex];
    support = new PropertyChangeSupport(this);
  }

  public void start() throws InterruptedException{
    String previous = "";
    for (int i = 0; i < 10; i++)
    {
      Thread.sleep(2000);
      LightIndex = (++LightIndex)%4;
      previous = currentLight;
      currentLight = lights[LightIndex];
      System.out.println("\n Light is"+ currentLight);

      support.firePropertyChange("LightChanged",previous,currentLight);
    }
  }

  @Override public void addPropertyChangeListener(String eventName,
      PropertyChangeListener listener)
  {
    if (eventName == null || "".equals(eventName))
    {
      addPropertyChangeListener(listener);
    }
    else
    {
      support.addPropertyChangeListener(eventName, listener);
    }
  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(String eventName,
      PropertyChangeListener listener)
  {
    if (eventName == null || "".equals(eventName))
    {
      removePropertyChangeListener(listener);
    }
    else
    {
      support.removePropertyChangeListener(eventName, listener);
    }
  }

  @Override public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
  support.removePropertyChangeListener(listener);
  }
}
