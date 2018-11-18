package models;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/


import java.util.*;

// line 1 "Umple_v0.0.ump"
// line 34 "Umple_v0.0.ump"
public class User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //User Attributes
  private String name;

  //User Associations
  private List<Route> routes;
  private Manager manager;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public User(String aName)
  {
    name = aName;
    routes = new ArrayList<Route>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }
  /* Code from template association_GetMany */
  public Route getRoute(int index)
  {
    Route aRoute = routes.get(index);
    return aRoute;
  }

  public List<Route> getRoutes()
  {
    List<Route> newRoutes = Collections.unmodifiableList(routes);
    return newRoutes;
  }

  public int numberOfRoutes()
  {
    int number = routes.size();
    return number;
  }

  public boolean hasRoutes()
  {
    boolean has = routes.size() > 0;
    return has;
  }

  public int indexOfRoute(Route aRoute)
  {
    int index = routes.indexOf(aRoute);
    return index;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfRoutes()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Route addRoute()
  {
    return new Route(this);
  }

  public boolean addRoute(Route aRoute)
  {
    boolean wasAdded = false;
    if (routes.contains(aRoute)) { return false; }
    User existingUser = aRoute.getUser();
    boolean isNewUser = existingUser != null && !this.equals(existingUser);
    if (isNewUser)
    {
      aRoute.setUser(this);
    }
    else
    {
      routes.add(aRoute);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRoute(Route aRoute)
  {
    boolean wasRemoved = false;
    //Unable to remove aRoute, as it must always have a user
    if (!this.equals(aRoute.getUser()))
    {
      routes.remove(aRoute);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addRouteAt(Route aRoute, int index)
  {  
    boolean wasAdded = false;
    if(addRoute(aRoute))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRoutes()) { index = numberOfRoutes() - 1; }
      routes.remove(aRoute);
      routes.add(index, aRoute);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRouteAt(Route aRoute, int index)
  {
    boolean wasAdded = false;
    if(routes.contains(aRoute))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRoutes()) { index = numberOfRoutes() - 1; }
      routes.remove(aRoute);
      routes.add(index, aRoute);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRouteAt(aRoute, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOptionalOneToMany */
  public boolean setManager(Manager aManager)
  {
    boolean wasSet = false;
    Manager existingManager = manager;
    manager = aManager;
    if (existingManager != null && !existingManager.equals(aManager))
    {
      existingManager.removeUser(this);
    }
    if (aManager != null)
    {
      aManager.addUser(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=routes.size(); i > 0; i--)
    {
      Route aRoute = routes.get(i - 1);
      aRoute.delete();
    }
    if (manager != null)
    {
      Manager placeholderManager = manager;
      this.manager = null;
      placeholderManager.removeUser(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "manager = "+(getManager()!=null?Integer.toHexString(System.identityHashCode(getManager())):"null");
  }
}