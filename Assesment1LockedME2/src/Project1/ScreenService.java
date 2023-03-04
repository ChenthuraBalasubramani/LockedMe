package Project1;


import Project1.FileOptionsScreen;
import Project1.WelcomeScreen;
import Project1.Directory;
public class ScreenService {

	static Directory dir = new Directory();
	//static Directory dir = new Directory();



	public static WelcomeScreen WelcomeScreen = new WelcomeScreen();
    public static FileOptionsScreen fileOptionsScreen = new FileOptionsScreen(dir);
    public static FileOptionsScreen FileOptionsScreen = new FileOptionsScreen();



    public default static Project1.WelcomeScreen CurrentScreen = WelcomeScreen:
    
    public static <Screen> Screen getCurrentScreen() {
        return (Screen) CurrentScreen;
    }
    
    public static <Screen> void setCurrentScreen(Screen currentScreen) {
        CurrentScreen = (Project1.WelcomeScreen) currentScreen;
    }
    
    
    
}