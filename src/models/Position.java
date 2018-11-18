package models;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/



// line 7 "Umple_v0.0.ump"
public class Position
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Position Attributes
  private double x;
  private double y;

  //Position Associations
  private Route route;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Position(double aX, double aY)
  {
    x = aX;
    y = aY;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setX(double aX)
  {
    boolean wasSet = false;
    x = aX;
    wasSet = true;
    return wasSet;
  }

  public boolean setY(double aY)
  {
    boolean wasSet = false;
    y = aY;
    wasSet = true;
    return wasSet;
  }

  public double getX()
  {
    return x;
  }

  public double getY()
  {
    return y;
  }
  /* Code from template association_GetOne */
  public Route getRoute()
  {
    return route;
  }

  public boolean hasRoute()
  {
    boolean has = route != null;
    return has;
  }
  /* Code from template association_SetOptionalOneToMany */
  public boolean setRoute(Route aRoute)
  {
    boolean wasSet = false;
    Route existingRoute = route;
    route = aRoute;
    if (existingRoute != null && !existingRoute.equals(aRoute))
    {
      existingRoute.removePosition(this);
    }
    if (aRoute != null)
    {
      aRoute.addPosition(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (route != null)
    {
      Route placeholderRoute = route;
      this.route = null;
      placeholderRoute.removePosition(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "x" + ":" + getX()+ "," +
            "y" + ":" + getY()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "route = "+(getRoute()!=null?Integer.toHexString(System.identityHashCode(getRoute())):"null");
  }
}