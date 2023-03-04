package Project1;


	import java.io.File;
	import java.io.IOException;
	import java.nio.file.FileSystems;
	import java.nio.file.Path;
	import java.util.ArrayList;
	import java.util.InputMismatchException;
	import java.util.Scanner;
	import Project1.Directory;
	import Project1.FileOptionsScreen;
	public interface FileOptionsScreen  {
		
		public Directory dir = new Directory();

		public ArrayList<String> options = new ArrayList<>();
	
	    public static void  FileOptionsScreen(Directory dir) {
	    }
	    public static void FileOptionsScreen() {

	    	options.add("1. Add a File");
	        options.add("2. Delete A File");
	        options.add("3. Search A File");
	        options.add("4. Return to Menu");}
	    
	    
	    
	    
	    public default void Show() {
	    	System.out.println("File Options Menu");
	        for (String s : options) {
	            System.out.println(s);
	        }
	    }

	    public default void GetUserInput() {
	        int selectedOption;
	        while ((selectedOption = this.getOption()) != 5) {
	        while ((selectedOption = this.getOption()) != 4) {
	            this.NavigateOption(selectedOption);
	        }
	    }
	    }
	    public default void NavigateOption(int option) {
	        
	    	switch(option) {
	            case 1: // Add File
	                this.AddFile();
	                
	                this.Show();
	                break;
	            case 2: // Delete File
	                this.DeleteFile();
	                
	                this.Show();
	                break;
	            case 3: // Search File
	                this.SearchFile();
	                this.Show();
	                break;

	                /*
	            case 4: // Return to Menu
	            	
	            	ScreenService.setCurrentScreen(ScreenService.WelcomeScreen);
	                ScreenService.getCurrentScreen().Show();
	                ScreenService.getCurrentScreen().GetUserInput();
	                
	                break;
	                */
	            default:
	                System.out.println("Invalid Option");
	                break;
	                
	                
	        }
	    }
	    
	    //TODO: Add functionality to all 
	    
	   	    public default void AddFile() {
	        System.out.println("Please Enter the Filename:");
	        String fileName = this.getInputString();
	        System.out.println("You are adding a file named: " + fileName);
	        
			try {
				Path path = FileSystems.getDefault().getPath(Directory.name + fileName).toAbsolutePath();
				File file = new File(dir.getName() + fileName);
				
			      if (file.createNewFile()) {
			    	  System.out.println("File created: " + file.getName());
			    	  dir.getFiles().add(file);
			    	  
			      } else {
			        System.out.println("This File Already Exits, no need to add another");
			      }
			}catch (IOException e){
				System.out.println(e);
			}
		}
	        
	    
	    
	    public default void DeleteFile() {
	    	
	    	System.out.println("Please Enter the Filename:");
	        String fileName = this.getInputString();
	        System.out.println("You are deleting a file named: " + fileName);
	        
	        
		    //TODO: Delete file
	        // Finished TODO
	        
			Path path = FileSystems.getDefault().getPath(Directory.name + fileName).toAbsolutePath();
			File file = path.toFile();
		      if (file.delete()) {
		    	  System.out.println("Deleted File: " + file.getName());
		    	  dir.getFiles().remove(file);
		      } else {
		        System.out.println("Failed to delete file:" + fileName);
		        System.out.println("Failed to delete file:" + fileName + ", file was not found.");
		      }
	    }

	    public default void SearchFile() {
	    	
	    	Boolean found = false;
	    	
	    	System.out.println("Please Enter the Filename:");
	        String fileName = this.getInputString();
	        System.out.println("You are searching for a file named: " + fileName);
	        
	        //TODO Fix it so ArrayList obtains files
	        //Finished TODO

	        ArrayList<File> files = dir.getFiles();


	        for(int i = 0; i < files.size(); i++) {
				if(files.get(i).getName().equals(fileName)) {
					System.out.println("Found " + fileName);
					found = true;
				}
	        }
	        if (found == false) {
	        	System.out.println("File not found");
	        }
	    }
	    
	    private String getInputString() {
	        Scanner in = new Scanner(System.in);
	        return(in.nextLine());
	    }
	    
	    private int getOption() {
	        Scanner in = new Scanner(System.in);
	        int returnOption = 0;
	        try {
	            returnOption = in.nextInt();
	        }
	        catch (InputMismatchException ex) {
	        	System.out.println("Invalid input");
	        }
	        return returnOption;
	    }
	}