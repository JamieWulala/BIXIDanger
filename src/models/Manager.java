package models;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/


import java.security.InvalidParameterException;
import java.util.*;

// line 25 "Umple_v0.0.ump"
// line 52 "Umple_v0.0.ump"
public class Manager
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Manager Associations
  private List<User> users;
  private List<Route> routes;
  private List<Hotspot> hotspots;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Manager()
  {
    users = new ArrayList<User>();
    routes = new ArrayList<Route>();
    hotspots = new ArrayList<Hotspot>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public User getUser(int index)
  {
    User aUser = users.get(index);
    return aUser;
  }

  public List<User> getUsers()
  {
    List<User> newUsers = Collections.unmodifiableList(users);
    return newUsers;
  }

  public int numberOfUsers()
  {
    int number = users.size();
    return number;
  }

  public boolean hasUsers()
  {
    boolean has = users.size() > 0;
    return has;
  }

  public int indexOfUser(User aUser)
  {
    int index = users.indexOf(aUser);
    return index;
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
  /* Code from template association_GetMany */
  public Hotspot getHotspot(int index)
  {
    Hotspot aHotspot = hotspots.get(index);
    return aHotspot;
  }

  public List<Hotspot> getHotspots()
  {
    List<Hotspot> newHotspots = Collections.unmodifiableList(hotspots);
    return newHotspots;
  }

  public int numberOfHotspots()
  {
    int number = hotspots.size();
    return number;
  }

  public boolean hasHotspots()
  {
    boolean has = hotspots.size() > 0;
    return has;
  }

  public int indexOfHotspot(Hotspot aHotspot)
  {
    int index = hotspots.indexOf(aHotspot);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfUsers()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addUser(User aUser)
  {
    boolean wasAdded = false;
    if (users.contains(aUser)) { return false; }
    Manager existingManager = aUser.getManager();
    if (existingManager == null)
    {
      aUser.setManager(this);
    }
    else if (!this.equals(existingManager))
    {
      existingManager.removeUser(aUser);
      addUser(aUser);
    }
    else
    {
      users.add(aUser);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeUser(User aUser)
  {
    boolean wasRemoved = false;
    if (users.contains(aUser))
    {
      users.remove(aUser);
      aUser.setManager(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addUserAt(User aUser, int index)
  {  
    boolean wasAdded = false;
    if(addUser(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsers()) { index = numberOfUsers() - 1; }
      users.remove(aUser);
      users.add(index, aUser);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUserAt(User aUser, int index)
  {
    boolean wasAdded = false;
    if(users.contains(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsers()) { index = numberOfUsers() - 1; }
      users.remove(aUser);
      users.add(index, aUser);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUserAt(aUser, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfRoutes()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addRoute(Route aRoute)
  {
    boolean wasAdded = false;
    if (routes.contains(aRoute)) { return false; }
    Manager existingManager = aRoute.getManager();
    if (existingManager == null)
    {
      aRoute.setManager(this);
    }
    else if (!this.equals(existingManager))
    {
      existingManager.removeRoute(aRoute);
      addRoute(aRoute);
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
    if (routes.contains(aRoute))
    {
      routes.remove(aRoute);
      aRoute.setManager(null);
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfHotspots()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addHotspot(Hotspot aHotspot)
  {
    boolean wasAdded = false;
    if (hotspots.contains(aHotspot)) { return false; }
    Manager existingManager = aHotspot.getManager();
    if (existingManager == null)
    {
      aHotspot.setManager(this);
    }
    else if (!this.equals(existingManager))
    {
      existingManager.removeHotspot(aHotspot);
      addHotspot(aHotspot);
    }
    else
    {
      hotspots.add(aHotspot);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeHotspot(Hotspot aHotspot)
  {
    boolean wasRemoved = false;
    if (hotspots.contains(aHotspot))
    {
      hotspots.remove(aHotspot);
      aHotspot.setManager(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addHotspotAt(Hotspot aHotspot, int index)
  {  
    boolean wasAdded = false;
    if(addHotspot(aHotspot))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfHotspots()) { index = numberOfHotspots() - 1; }
      hotspots.remove(aHotspot);
      hotspots.add(index, aHotspot);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveHotspotAt(Hotspot aHotspot, int index)
  {
    boolean wasAdded = false;
    if(hotspots.contains(aHotspot))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfHotspots()) { index = numberOfHotspots() - 1; }
      hotspots.remove(aHotspot);
      hotspots.add(index, aHotspot);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addHotspotAt(aHotspot, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while( !users.isEmpty() )
    {
      users.get(0).setManager(null);
    }
    while( !routes.isEmpty() )
    {
      routes.get(0).setManager(null);
    }
    while( !hotspots.isEmpty() )
    {
      hotspots.get(0).setManager(null);
    }
  }
  


		
		public List<Route> showUserRoutes(String name) throws InvalidParameterException {
	    //getUserRoutes
	    //for each routes, show transparent line from a - b
			User ru = new User("idiot");
			for(User u: this.getUsers()) {
				if(u.getName().equals(name)) {
					ru = u;
				}
			}
			if(ru.getName().equals("idiot")) {
				throw new InvalidParameterException();
			}
			
			return ru.getRoutes();
			
			
		}
		public static boolean fallsInRange(Hotspot hs, Position x) {
			//1m = 0.000351817026308 /6
			//offset = 10m 0.0000904
			double offsetRange =  0.0000904 * hs.getWeight() * 0.1; //offset range based on weight
			double x1 = hs.getLongtitude();
			double y1 = hs.getLatitude();
			double x2 = x.getX();
			double y2 = x.getY();
			
//			System.out.println("x1: "+x1);
//			System.out.println("y1: "+y1);
//			System.out.println("x2: "+x2);
//			System.out.println("y2: "+y2);
			
			double distance =  Math.sqrt(Math.pow((x1-x2), 2)+(Math.pow(y1-y2, 2)));
			//System.out.println("distance: "+distance);
			//System.out.println("offset: "+offsetRange);
			if(distance < offsetRange) {
				return true;
			}
			
			return false;
		}
		
		public double pointIndex(Position x) {
			double index = 0;
			//1m = 0.00000904
			//offset = 10m 0.0000904
			double offsetRange = 0.0000904 * 1.5;
			
			List<Hotspot> lh = this.getHotspots();
			
			for (Hotspot hs: lh) {
				//if x falls in range
				if(fallsInRange(hs,x)) {
					index += hs.getWeight();
					//TODO divide by the distance
					//System.out.println("falls in range and weight is "+hs.getWeight());
				}//if(index != 0) {System.out.println(index);}
				
			}
			//
			
			return index;
		}
		
		
		public double routeIndex(Route route) {
			double index = 0;
			for(Position x: route.getPositions()) {
				
					index += pointIndex(x);
				
			}
			//if(index != 0) {System.out.println("route "+index);}
			return index;
		}
		

		public double showUserIndex (User user) {
	    //getUserRoutes
	    //calculate each routes's danger index
	    // calculate the average and show the result
			double index = 0;
			for(Route route: user.getRoutes()) {
				index += routeIndex(route);
			}
			return index/user.getRoutes().size();
		}

}