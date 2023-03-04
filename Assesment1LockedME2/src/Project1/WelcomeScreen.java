package Project1;

import Project1.Directory;
import Project1.ScreenService;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public interface WelcomeScreen {
     String welcomeText = "Welcome to VirtualKey!";
     String developerText = "Developer: Melvin Wu";
     
     ArrayList<String> options = new ArrayList<>();
    public default void WelcomeScreen() {
        options.add("1. Show Files");
        options.add("2. Show File Options Menu");
        options.add("3. Quit");
    }
    
    public void introWS() {
    	System.out.println(welcomeText);
        System.out.println(developerText);

        System.out.println("\n");
        Show();
    }

    
    
  
    public default void Show() {
    	System.out.println("Main Menu");
        for (String s : options)  {
            System.out.println(s);
        }
    }
    public default void GetUserInput() {
        int selectedOption  = 0;
        while ((selectedOption = this.getOption()) != 3) {
            this.NavigateOption(selectedOption);
        }
    }
    public default void NavigateOption(int option) {
    	Object ScreenService;
    	switch(option) {
    	case 1: // Show Files in Directory
    
        
                this.ShowFiles();
                
                this.Show();
                
                break;
                
            case 2: // Show File Options menu
            	ScreenService.setCurrentScreen(ScreenService.FileOptionsScreen);
            	((Object ScreenService).getCurrentScreen().Show();
            	((Object ScreenService).getCurrentScreen().GetUserInput
                
                this.Show();
                
                break;
                
            default:
                System.out.println("Invalid Option");
                break;
        }
        
    }
    public default void ShowFiles() {
        //TODO: Get the files from the Directory
    	
    	//Finished TODO Task
        System.out.println("List of Files: ");
    	Directory directory = new Directory();
    	directory.getFiles();
    }
    
    private int getOption() {
        Scanner in = new Scanner(System.in);
        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {
        }
        return returnOption;
    }
}