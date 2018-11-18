package models;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/



// line 18 "Umple_v0.0.ump"
// line 46 "Umple_v0.0.ump"
public class Hotspot
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Hotspot Attributes
  private double longtitude;
  private double latitude;
  private double weight;

  //Hotspot Associations
  private Manager manager;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Hotspot(double aLongtitude, double aLatitude, double aWeight)
  {
    longtitude = aLongtitude;
    latitude = aLatitude;
    weight = aWeight;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLongtitude(double aLongtitude)
  {
    boolean wasSet = false;
    longtitude = aLongtitude;
    wasSet = true;
    return wasSet;
  }

  public boolean setLatitude(double aLatitude)
  {
    boolean wasSet = false;
    latitude = aLatitude;
    wasSet = true;
    return wasSet;
  }

  public boolean setWeight(double aWeight)
  {
    boolean wasSet = false;
    weight = aWeight;
    wasSet = true;
    return wasSet;
  }

  public double getLongtitude()
  {
    return longtitude;
  }

  public double getLatitude()
  {
    return latitude;
  }

  public double getWeight()
  {
    return weight;
  }
  /* Code from template association_GetOne */
  public Manager getManager()
  {
    return manager;
  }

  public boolean hasManager()
  {
    boolean has = manager != null;
    return has;
  }
  /* Code from template association_SetOptionalOneToMany */
  public boolean setManager(Manager aManager)
  {
    boolean wasSet = false;
    Manager existingManager = manager;
    manager = aManager;
    if (existingManager != null && !existingManager.equals(aManager))
    {
      existingManager.removeHotspot(this);
    }
    if (aManager != null)
    {
      aManager.addHotspot(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (manager != null)
    {
      Manager placeholderManager = manager;
      this.manager = null;
      placeholderManager.removeHotspot(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "longtitude" + ":" + getLongtitude()+ "," +
            "latitude" + ":" + getLatitude()+ "," +
            "weight" + ":" + getWeight()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "manager = "+(getManager()!=null?Integer.toHexString(System.identityHashCode(getManager())):"null");
  }
}